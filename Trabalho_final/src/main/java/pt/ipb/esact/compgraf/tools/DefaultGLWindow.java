package pt.ipb.esact.compgraf.tools;

import static pt.ipb.esact.compgraf.tools.math.GlMath.rotate;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.vecmath.Vector3f;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.ipb.esact.compgraf.tools.math.Vectors;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;

public abstract class DefaultGLWindow extends GLUTWrapper implements GLListener, GLWindow {

    private static final Logger logger = LoggerFactory.getLogger(DefaultGLWindow.class);

    private GLCanvas canvas;

    private GLContext context;

    private long elapsedTime = 0L;

    private long currentTime = 0L;

    private long lastTime = System.currentTimeMillis();

    private Set<Integer> keycodes = new HashSet<>();
    private Map<String, Integer> keymap = Maps.newHashMap();

    private GLDemo demo;

    private boolean mouseDown = false;

    private boolean mousePan = false;

    private boolean mouseZoom = false;

    private Point lastMouseLocation = null;

    private int zoom = 0;

    List<ReleaseListener> releaseListeners = Lists.newArrayList();

    private JFrame frame;

    private final GLEventListener eventProxy = new GLEventListener() {

        @Override
        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
            context = drawable.getContext();
            setCurrent(drawable.getGL().getGL2());
            resize(width, height);
        }

        @Override
        public void init(GLAutoDrawable drawable) {
            context = drawable.getContext();
            setCurrent(drawable.getGL().getGL2());
            DefaultGLWindow.this.init();
            currentTime = System.nanoTime();
        }

        @Override
        public void dispose(GLAutoDrawable drawable) {
            context = drawable.getContext();
            setCurrent(drawable.getGL().getGL2());
            DefaultGLWindow.this.dispose();
        }

        @Override
        public void display(GLAutoDrawable drawable) {
            context = drawable.getContext();
            setCurrent(drawable.getGL().getGL2());
            render();
        }
    };

    private Animator animator;

    protected boolean controlDown;

    protected boolean shiftDown;

    protected boolean altDown;

    private KeyListener keyProxy = new KeyAdapter() {

        @Override
        public void keyReleased(KeyEvent e) {
            keycodes.remove(e.getKeyCode());
            altDown = e.isAltDown();
            controlDown = e.isControlDown();
            shiftDown = e.isShiftDown();
            context.makeCurrent();
            onKeyUp(e);
            context.release();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (!keycodes.contains(e.getKeyCode()))
                keycodes.add(e.getKeyCode());
            altDown = e.isAltDown();
            controlDown = e.isControlDown();
            shiftDown = e.isShiftDown();
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                exit();

            context.makeCurrent();
            onKeyDown(e);
            context.release();
        }
    };

    private MouseListener mouseProxy = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            if (menu != null && e.isPopupTrigger()) {
                menu.show(e.getComponent(), e.getX(), e.getY());
                return;
            }
            mouseDown = true;
            lastMouseLocation = MouseInfo.getPointerInfo().getLocation();
            altDown = e.isAltDown();
            controlDown = e.isControlDown();
            shiftDown = e.isShiftDown();
            onMouseDown(e);
        }

        ;

        public void mouseReleased(MouseEvent e) {
            if (menu != null && e.isPopupTrigger()) {
                menu.show(e.getComponent(), e.getX(), e.getY());
                return;
            }
            mouseDown = false;
            altDown = e.isAltDown();
            controlDown = e.isControlDown();
            shiftDown = e.isShiftDown();
            onMouseUp(e);
        }

        ;

    };

    private MouseWheelListener scrollProxy = new MouseWheelListener() {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            zoom = e.getWheelRotation();
        }
    };

    private JPopupMenu menu;

    public DefaultGLWindow(String caption, boolean continuous) {
        frame = new JFrame(caption);

        GLProfile profile = GLProfile.getDefault();
        GLCapabilities capabilities = new GLCapabilities(profile);

        capabilities.setDepthBits(24);
        capabilities.setDoubleBuffered(true);
        capabilities.setNumSamples(2);

        canvas = new GLCanvas(capabilities);

        canvas.addGLEventListener(eventProxy);
        canvas.addKeyListener(keyProxy);
        canvas.addMouseListener(mouseProxy);
        canvas.addMouseWheelListener(scrollProxy);

        frame.setLayout(new BorderLayout());
        canvas.setSize(800, 600);
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // dispose();
            }
        });

        animator = new Animator();
        animator.setRunAsFastAsPossible(true);
        animator.add(canvas);

        // Setup initial camera
        Cameras.addDefaultCamera();

        // Tools
        demo = new GLDemo();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        canvas.requestFocus();
        animator.start();

        fillKeyMap();
    }

    public void setPopupMenu(JPopupMenu menu) {
        this.menu = menu;
    }

    /**
     * Obter uma stream de dados do ficheiro relativamente ao package da classe atual
     *
     * @param filename O nome relativo do ficheiro
     * @return A stream de dados
     */
    public InputStream fileStream(String filename) throws FileNotFoundException {
        return new FileInputStream(filename);
//		return getClass().getResourceAsStream(filename);

    }

    public int getWidth() {
        return frame.getWidth();
    }

    public int getHeight() {
        return frame.getHeight();
    }

    private void fillKeyMap() {
        keymap.put("left", KeyEvent.VK_LEFT);
        keymap.put("right", KeyEvent.VK_RIGHT);
        keymap.put("up", KeyEvent.VK_UP);
        keymap.put("down", KeyEvent.VK_DOWN);
        keymap.put("space", KeyEvent.VK_SPACE);
    }

    public void addReleaseListener(ReleaseListener listener) {
        releaseListeners.add(listener);
    }

    public void removeReleaseListener(ReleaseListener listener) {
        releaseListeners.remove(listener);
    }

    /**
     * Carrega uma textura a partir da package da classe atual
     *
     * @param path A path dentro da package atual
     * @return The texture
     */
    public Texture loadPackageTexture(String path) {
        return GlTools.loadPackageTexture(this, path);
    }

    public Texture loadTexture(String path) {
        return GlTools.loadTexture(path);
    }


    protected void internalInit() {

    }

    public float getMaxAnisotropy() {
        return GlTools.getMaxAnisotropy();
    }

    public boolean isAnisotropicAvailable() {
        return GlTools.isAnisotropicAvailable();
    }

    public void exit() {
        System.exit(0);
    }

    public void exit(String error) {
        GlTools.exit(error);
    }

    protected void onMouseDown(MouseEvent e) {

    }

    protected void onMouseUp(MouseEvent e) {

    }

    public void setMousePan(boolean mousePan) {
        this.mousePan = mousePan;
    }

    public void setMouseZoom(boolean mouseZoom) {
        this.mouseZoom = mouseZoom;
    }

    public void setProjectionPerspective(int width, int height, float fovy, float near, float far) {
        if (height == 0)
            height = 1;
        glViewport(0, 0, width, height);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        float aspect = (float) width / (float) height;
        gluPerspective(90.0f, aspect, near, far);
    }

    public void setProjectionOrtho(int width, int height, float volume, float near, float far) {
        if (height == 0)
            height = 1;
        glViewport(0, 0, width, height);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        float aspect = (float) width / (float) height;
        glOrtho(-volume, volume, -volume / aspect, volume / aspect, near, far);
    }

    public void setProjectionOrtho2D(int width, int height) {
        if (height == 0)
            height = 1;
        glViewport(0, 0, width, height);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluOrtho2D(0, width, 0, height);
    }

    public void setupCamera() {
        // Use the current camera
        Camera camera = Cameras.getCurrent();

        // Mudar para a matriz de MODELVIEW
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        gluLookAt(
                camera.eye.x, camera.eye.y, camera.eye.z,
                camera.at.x, camera.at.y, camera.at.z,
                camera.up.x, camera.up.y, camera.up.z
        );
    }

    protected GLDemo demo() {
        return demo;
    }

    protected void onKeyUp(KeyEvent e) {

    }

    protected void onKeyDown(KeyEvent e) {

    }

    /**
     * Draw the selected text at the position described by left ant top
     *
     * @param text The text to draw
     * @param left The distance to the left
     * @param top  The distance to the top
     */
    public void renderText(String text, int left, int top) {
        renderText(text, GLUT.BITMAP_8_BY_13, left, top);
//		renderText(text, GLUT.BITMAP_9_BY_15, left, top);
//		renderText(text, GLUT.BITMAP_HELVETICA_10, left, top);
//		renderText(text, GLUT.BITMAP_HELVETICA_12, left, top);
//		renderText(text, GLUT.BITMAP_HELVETICA_18, left, top);
//		renderText(text, GLUT.BITMAP_TIMES_ROMAN_10, left, top);
//		renderText(text, GLUT.BITMAP_TIMES_ROMAN_24, left, top);
    }

    public void render3DText(String text, float x, float y, float z) {
        render3DText(text, x, y, z, 0.1f);
    }

    public void render3DText(String text, float x, float y, float z, float scale) {
        GlTools.render3DText(text, x, y, z, scale);
    }

    public void renderText(String text, int bitmap, int left, int top) {
        Iterable<String> lines = Splitter.on('\n').split(text);

        int height = canvas.getSize().height;
        int width = canvas.getSize().width;

        // Set up 2D mode
        glMatrixMode(GL_PROJECTION);
        glPushMatrix();
        {
            glLoadIdentity();
            glOrtho(0, width, 0, height, -1, 1);

            glMatrixMode(GL_MODELVIEW);
            glPushMatrix();
            {
                glLoadIdentity();

                // Render the text
                int i = 0;

                glPushAttrib(GL_LIGHTING_BIT | GL_ENABLE_BIT);
                {
                    glDisable(GL_TEXTURE_2D);
                    glDisable(GL_LIGHTING);
                    for (String line : lines) {
                        glRasterPos2i(left, height - (top + i * 15));
                        for (char c : line.toCharArray())
                            glutBitmapCharacter(bitmap, c);
                        i++;
                    }
                }
                glPopAttrib();

                // Break down 2D mode
                glMatrixMode(GL_PROJECTION);
            }
            glPopMatrix();
            glMatrixMode(GL_MODELVIEW);
        }
        glPopMatrix();
    }

    @Override
    public void dispose() {
        release();
        for (ReleaseListener l : releaseListeners)
            l.release(getCurrent());
    }

    protected void render() {
        Rectangle rectangle = canvas.getBounds();
        setCurrent(context.getGL().getGL2());

        currentTime = System.currentTimeMillis();
        elapsedTime = currentTime - lastTime;
        lastTime = currentTime;

        Point location = null;
        if (mousePan && mouseDown) {
            location = MouseInfo.getPointerInfo().getLocation();

            float xdiff = lastMouseLocation.x - location.x;
            float ydiff = lastMouseLocation.y - location.y;
            if (xdiff != 0 || ydiff != 0)
                rotateOrPanScene(xdiff * 0.1f, ydiff * 0.1f);

        }

        if (mouseZoom && zoom != 0) {
            zoomScene(zoom);
            zoom = 0;
        }

        render(rectangle.width, rectangle.height);

        if (mousePan && mouseDown)
            lastMouseLocation = location;
    }

    private void zoomScene(int zoom) {
        float d = zoom;
        float signal = d / Math.abs(d);
        float percent = 0.1f * signal;

        Camera c = Cameras.getCurrent();
        Vector3f inc = Vectors.sub(c.at, c.eye);
        inc.scale(percent);
        c.eye = Vectors.add(c.eye, inc);
        setupCamera();
    }

    public void rotateOrPanScene(float hrot, float vrot) {
        Camera camera = Cameras.getCurrent();
        Vector3f fw = Vectors.sub(camera.eye, camera.at);
        Vector3f up = camera.up;
        Vector3f left = new Vector3f(rotate(90, up, fw));
        left.y = 0.0f;

        if (isShiftPressed()) {
            hrot *= 0.1f;
            vrot *= 0.1f;

            left.scale(hrot);
            camera.eye = Vectors.add(camera.eye, left);
            camera.at = Vectors.add(camera.at, left);

            fw.scale(vrot);
            if (!isCtrlPressed()) {
                fw.y = 0.0f;
            } else {
                fw.x = 0.0f;
                fw.z = 0.0f;
                fw.y *= -1.0f;
            }
            camera.eye = Vectors.add(camera.eye, fw);
            camera.at = Vectors.add(camera.at, fw);
        } else {
            Vector3f eye = new Vector3f(rotate(hrot, up, fw));
            eye = new Vector3f(rotate(vrot, left, eye));
            camera.eye = Vectors.add(eye, camera.at);
        }

        setupCamera();
    }

    public boolean isAltPressed() {
        return altDown;
    }

    public boolean isShiftPressed() {
        return shiftDown;
    }

    public boolean isCtrlPressed() {
        return controlDown;
    }

    public GLCanvas getCanvas() {
        return canvas;
    }

    /**
     * @return O tempo que passou desde que a última frame foi desenhada
     */
    public float timeElapsed() {
        return (float) elapsedTime / (1000.0f); // para segundos
    }

    /**
     * Verifica se uma tecla foi premida
     *
     * @param keyCode O 'code' da tecla a verificar
     * @return @c TRUE caso a tecla tenha sido premida
     * @see KeyEvent
     */
    public boolean isKeyPressed(int keyCode) {
        return keycodes.contains(keyCode);
    }

    public boolean isKeyPressed(char c) {
        return keycodes.contains((int) Character.toUpperCase(c));
    }

    public boolean isKeyPressed(String name) {
        if (!keymap.containsKey(name))
            return false;
        return keycodes.contains(keymap.get(name));
    }

    protected static FloatBuffer newFloatBuffer(float... values) {
        return FloatBuffer.wrap(values);
    }

    protected static IntBuffer newIntBuffer(int... values) {
        return IntBuffer.wrap(values);
    }

    protected static FloatBuffer newDirectFloatBuffer(float... values) {
        return Buffers.newDirectFloatBuffer(values);
    }

    protected static IntBuffer newDirectIntBuffer(int... values) {
        return Buffers.newDirectIntBuffer(values);
    }

}
