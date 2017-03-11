import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.*;
import pt.ipb.esact.compgraf.tools.math.Vectors;
import pt.ipb.esact.compgraf.ObjectList.ObjectList;
import sun.java2d.pipe.TextRenderer;
import sun.security.provider.certpath.Vertex;

import javax.media.opengl.GL2;
import javax.vecmath.Vector3f;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.awt.Robot;
import java.util.Random;

//import pt.ipb.esact.compgraf.tools.Shader;

import static java.lang.Math.*;
import static pt.ipb.esact.compgraf.tools.math.GlMath.rotate;
//import javax.xml.bind.ValidationEvent;
//import org.lwjgl.glfw.*;


//ERROR: Exception in thread "main" java.lang.ClassNotFoundException

/**
 * Created by MateusBranco on 06/02/2017.
 */
public class Main extends DefaultGLWindow {
    //Shaders
    private Shader DiffNormSpecShader;

    private ObjectList ObjList;

    // skybox
    private Skybox skybox;
    private boolean getLantern = false;
    private boolean CampaStart = false;

    private boolean ToggleLantern = false;

    public Main() {
        super("Silent Hill 12", true);

    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void init() {

        Camera Camera1 = new Camera(0f, 1.5f, 0f);
        Cameras.setCurrent(Camera1);
        Camera1.at = new Vector3f(10, 15, 20);

        /*  select clearing (background) color  */
        //glClearColor(0.05f,0.03f,0.00f,1);//blackish color
        glClearColor(0.7f, 0.7f, 0.7f, 1.0f);
        //glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glClearDepth(1);
        glEnable(GL_DEPTH_TEST);

        //BLENDING 4 MIRRORS & TRANSPARENCY
        glEnable(GL_BLEND);
        glEnable(GL_SMOOTH);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);


        glEnable(GL_MULTISAMPLE);
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);

        glShadeModel(GL_SMOOTH);


        //Activate material
        configureLighting();

        //Activate light
        configureMaterials();

        //Activate Fog
        configureFog();

        configureShaders();

        skybox = new Skybox(this);
        skybox.load(
                "resources/models/skybox/right.png",
                "resources/models/skybox/up.png",
                "resources/models/skybox/right2.png",
                "resources/models/skybox/left.png",
                "resources/models/skybox/down.png",
                "resources/models/skybox/center.png"
        );
        ObjList = new ObjectList();


        ObjList.AddObject(this, "Lantern_bench", "resources/models/MAP/Lantern_bench.obj", "resources/models/MAP/Lantern_bench.mtl", 0, 0);

        ObjList.AddObject(this, "Campa", "resources/models/MAP/Campa.obj", "resources/models/MAP/Campa.mtl", 0, 0);

        ObjList.AddObject(this, "Cemetery", "resources/models/MAP/cemiterio.obj","resources/models/MAP/cemiterio.mtl",0, 0);

        ObjList.AddObject(this, "City", "resources/models/MAP/cidade.obj","resources/models/MAP/cidade.mtl",0, 0);

        ObjList.AddObject(this, "ObjPlayer", "resources/models/MAP/Player.obj", "resources/models/MAP/Player.mtl", 2.29f, 2.29f);

        ObjList.AddObject(this, "earth", "resources/models/MAP/terra.obj", "resources/models/MAP/terra.mtl", 0, 0);
        ObjList.AddObject(this, "mercury", "resources/models/MAP/mercury.obj", "resources/models/MAP/mercury.mtl", 0, 0);
        ObjList.AddObject(this, "sun", "resources/models/MAP/sol.obj", "resources/models/MAP/sol.mtl", 0, 0);
        ObjList.AddObject(this, "moon", "resources/models/MAP/moon.obj", "resources/models/MAP/moon.mtl", 0, 0);

    }

    public ObjectList getObjectList() {
        return ObjList;
    }

    private void configureMaterials() {
        //Color Tracking
        glEnable(GL_COLOR_MATERIAL);
        glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
        glMateriali(GL_FRONT, GL_SHININESS, 1);

        //material Specularity
        glMaterialfv(GL_FRONT, GL_SPECULAR, newFloatBuffer(1.0f, 1.0f, 1.0f, 1.0f));
    }

    private void configureLighting() {
        //enable light
        glEnable(GL_LIGHTING);

        // Ambient Light model
        float[] ambientLowLight = {0.6f, 0.6f, 0.6f, 1.0f};
        glLightModelfv(GL_LIGHT_MODEL_AMBIENT, ambientLowLight, 0);
        glLightModeli(GL_LIGHT_MODEL_COLOR_CONTROL, GL_SEPARATE_SPECULAR_COLOR);

        // Config Light0
        //glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        //glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(0.4f, 0.4f, 0.4f, 1.0f));
        //glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(0.2f, 0.2f, 0.2f, 1.0f));

        //activate light
        //glEnable(GL_LIGHT0);

        //glDisable(GL_LIGHTING);

        //Lantern Config
        //glLightfv(GL_LIGHT1, GL_AMBIENT,  newFloatBuffer( .4f, .4f, .4f, 1 ));
        glLightfv(GL_LIGHT1, GL_DIFFUSE, newFloatBuffer(2f, 2f, 2f, 2f));
        glLightfv(GL_LIGHT1, GL_SPECULAR, newFloatBuffer(1f, 1f, 1f, 1f));
        glLightf(GL_LIGHT1, GL_SPOT_CUTOFF, 30.0f);
        glLightf(GL_LIGHT1, GL_SPOT_EXPONENT, 20.0f);
        glEnable(GL_LIGHT1);

        //glLightfv(GL_LIGHT1, GL_AMBIENT,  newFloatBuffer( .4f, .4f, .4f, 1 ));
        glLightfv(GL_LIGHT2, GL_DIFFUSE, newFloatBuffer(3f, 3f, 3f, 3f));
        glLightfv(GL_LIGHT2, GL_SPECULAR, newFloatBuffer(1f, 1f, 1f, 1f));
        glLightf(GL_LIGHT2, GL_SPOT_CUTOFF, 15.0f);
        glLightf(GL_LIGHT2, GL_SPOT_EXPONENT, 10.0f);
        glEnable(GL_LIGHT2);
    }

    private Random random = new Random();

    /*public FloatBuffer randMult(FloatBuffer buffer) {
        FloatBuffer out = Buffers.copyFloatBuffer(buffer);
        boolean nextBoolean = random.nextBoolean();
        float nextFloat = nextBoolean ? random.nextFloat() : 0;
        for(int i=0; i<buffer.capacity(); i++) {
            out.put(i, nextFloat * buffer.get(i));
        }
        return out;
    }*/

   /* public FloatBuffer randMult(FloatBuffer buffer) {
        FloatBuffer out = Buffers.copyFloatBuffer(buffer);
        boolean nextBoolean = random.nextBoolean();
        float nextFloat = nextBoolean ? random.nextFloat() : 0;
        for(int i=0; i<buffer.capacity(); i++) {
            out.put(i, nextFloat * buffer.get(i));
        }
        return out;
    }
*/

    @Override
    protected void onKeyDown(KeyEvent e) {
        if (e.getKeyChar() == 'f') {
            //Lantern I/O
            ToggleLantern = !ToggleLantern;
            if (ToggleLantern) {
                ToggleLantern = false;
                glEnable(GL_LIGHT1);
                glEnable(GL_LIGHT2);
            } else {
                ToggleLantern = true;
                glDisable(GL_LIGHT1);
                glDisable(GL_LIGHT2);
            }

        }
    }

    // SOL
    private float sunRotSpeed = GL_PI / 10;
    private float sunRot = 0;

    // Terra
    private static final float EARTH_DISTANCE = 50f;

    private float earthRotSpeed = GL_PI / 5;
    private float earthRot = 0;

    private float earthTrlSpeed = GL_PI / 12;
    private float earthTrl = 0;

    // Terra
    private static final float EARTH_MOON_DISTANCE = 5f;

    private float moonRotSpeed = GL_PI / 5;
    private float moonRot = 0;

    private float moonTrlSpeed = GL_PI / 12;
    private float moonTrl = 0;

    // Mercúrio
    private static final float MERCURY_DISTANCE = 80f;

    private float mercuryRotSpeed = GL_PI / 5;
    private float mercuryRot = 0;

    private float mercuryTrlSpeed = GL_PI / 7;
    private float mercuryTrl = 0;


    private void updateRotations() {
        // Rotação do SOL
        sunRot += sunRotSpeed * timeElapsed();
        sunRot %= 2f * GL_PI;

        // Translação da Terra
        earthTrl += earthTrlSpeed * timeElapsed();
        earthTrl %= 2f * GL_PI;

        // Rotação da Terra/Clouds
        earthRot += earthRotSpeed * timeElapsed();
        earthRot %= 2f * GL_PI;

        // Translação da Lua
        moonTrl += moonTrlSpeed * timeElapsed();
        moonTrl %= 2f * GL_PI;

        // Rotação da Lua
        moonRot += moonRotSpeed * timeElapsed();
        moonRot %= 2f * GL_PI;

        // Translação de Mercury
        mercuryTrl += mercuryTrlSpeed * timeElapsed();
        mercuryTrl %= 2f * GL_PI;

        // Rotação de Mercury
        mercuryRot += mercuryRotSpeed * timeElapsed();
        mercuryRot %= 2f * GL_PI;
    }

    private void Lantern() {
        Camera camera = Cameras.getCurrent();
        Vector3f ForwardEYE = Vectors.sub(camera.at, camera.eye);
        ForwardEYE.normalize();

        //glLightfv(GL_LIGHT1, GL_DIFFUSE,  newFloatBuffer(1f,1f,1f,1f) /*randMult(lightDiffuse*/);
        glLightfv(GL_LIGHT1, GL_POSITION, newFloatBuffer(camera.eye.x, camera.eye.y, camera.eye.z, 1.0f));
        glLightfv(GL_LIGHT1, GL_SPOT_DIRECTION, newFloatBuffer(ForwardEYE.x, ForwardEYE.y, ForwardEYE.z));

        glLightfv(GL_LIGHT2, GL_POSITION, newFloatBuffer(camera.eye.x, camera.eye.y, camera.eye.z, 1.0f));
        glLightfv(GL_LIGHT2, GL_SPOT_DIRECTION, newFloatBuffer(ForwardEYE.x, ForwardEYE.y, ForwardEYE.z));

        /*glPushMatrix();
        {
            //glTranslatef(camera.eye.x, camera.eye.y, camera.eye.z);
            //ObjList.getObject("Lantern").render();

        }glPopMatrix();*/

    }

    private void configureShaders() {
        DiffNormSpecShader = new Shader();
        DiffNormSpecShader.load("src/main/java/pt/ipb/esact/compgraf/tools/shaders/diffuse_normal_specular.vert", "src/main/java/pt/ipb/esact/compgraf/tools/shaders/diffuse_normal_specular.frag");
    }

    /*private boolean FogWobling = false;
    private float FogWobleVal = 0;
    private float FogDensity = 0;*/
    private void configureFog() {
        glEnable(GL_FOG);

        FloatBuffer FOG_color = newFloatBuffer(0.7f, 0.7f, 0.7f, 1.0f);
        glFogfv(GL_FOG_COLOR, FOG_color);
        //glFogf(GL_FOG_START, 10.0f);
        //glFogf(GL_FOG_END, 25.0f);
        glFogf(GL_FOG_DENSITY, 0.20f);
        glFogi(GL_FOG_MODE, GL_EXP2);

        /*
            //System.out.println("?: " + FogWobling);
            System.out.println("Current: " + FogDensity);
        }*/
    }

   /* private float AngleClamp(float val,float min, float max){
        float angleclamp = val;
        if(angleclamp > max){
            angleclamp = min;
        }
        if(angleclamp < min){
            angleclamp = max;
        }
        return angleclamp;
    }*/

    /*private void FPSCameraKeyboard(){
        Camera camera = Cameras.getCurrent();
        Vector3f fw = Vectors.sub(camera.eye, camera.at);

        Vector3f up = camera.up;
        Vector3f sky = new Vector3f(0,1,0);
        Vector3f left = new Vector3f(rotate(90, sky, fw));

        if(isKeyPressed(KeyEvent.VK_LEFT)){
            Vector3f eye = new Vector3f(rotate(1*0.01f,sky,fw));
            camera.eye = Vectors.add(eye, camera.at);

            System.out.println("left");
            this.setupCamera();
        }
        if(isKeyPressed(KeyEvent.VK_RIGHT)){
            Vector3f eye = new Vector3f(rotate(-1*0.01f,sky,fw));
            camera.eye = Vectors.add(eye, camera.at);
            System.out.println("right");
            this.setupCamera();
        }
        if(isKeyPressed(KeyEvent.VK_UP)){
            Vector3f eye = new Vector3f(rotate(1*0.01f,left,fw));
            camera.eye = Vectors.add(eye, camera.at);
            System.out.println("up");
            this.setupCamera();
        }
        if(isKeyPressed(KeyEvent.VK_DOWN)){
            Vector3f eye = new Vector3f(rotate(-1*0.01f,left,fw));
            camera.eye = Vectors.add(eye, camera.at);
            System.out.println("down");
            this.setupCamera();
        }
    }*/

    private void PlayerController() {
        Lantern();
        CameraFPS();
        MovementController();
        Camera camera = Cameras.getCurrent();
        glPushMatrix();
        glTranslatef(camera.eye.x, camera.eye.y - 1.5f, camera.eye.z);

        // first rotation
        glRotatef((float)(-atan2(camera.at.z, camera.at.x) * 180 / PI), 0, 1, 0);
        glRotatef(-90,0,1,0);
// second rotation
       /* float d = (float)(sqrt(pow(PLeye.at.x,2) + pow(PLeye.at.y,2)));
        float pitch = (float)(atan2(PLeye.at.z, d));
        glRotatef((float)(pitch * 180 / PI), 0, 0, 1);*/

       //flyaway
       if(CampaStart && camera.eye.y < 50f){
           camera.eye.y += 0.05;
       }

        ObjList.getObject("ObjPlayer").render();
    glPopMatrix();
}
    private void checkPosLanCamp() {
        Camera posPL = Cameras.getCurrent();
        Vector3f posL= ObjList.getObject("Lantern_bench").getobjCenter();
        Vector3f trigl = Vectors.sub(posPL.eye,posL);

        Vector3f posC= ObjList.getObject("Campa").getobjCenter();
        Vector3f trigC = Vectors.sub(posPL.eye,posC);
        renderText("Lantern dist: "+ trigl.length(),10,60);
        renderText("Grave dist: "+ trigC.length(),10,80);

        if (isKeyPressed(KeyEvent.VK_E)) {
            System.out.println(trigl.length());
            if (trigl.length() <= 2.5f) {
                System.out.println("Catchit");
                getLantern = true;
            }
            if (trigC.length() <= 2.5f) {
                System.out.println("ToSpace!");
                CampaStart = true;
            }
        }
    }
    private void drawObj1() {

        glPopMatrix();

        glPushAttrib(GL_ENABLE_BIT | GL_FOG | GL_TEXTURE_BIT);
        glDisable(GL_FOG);

        glPushMatrix();
        {

            glScalef(-1.0f, 1.0f, 1.0f);
            glTranslatef(-59, 0, 0);
            glFrontFace(GL_CW);

            ObjList.getObject("City").render();


            glFrontFace(GL_CCW);
        }
        glPopMatrix();
        glPopAttrib();

        glPushMatrix();
        {
            //draw ground 50% alpha

            glTranslatef(29.5f, 0, 0);
            glRotatef(90f, 0, 1, 0);
            glBegin(GL_QUADS);
            {
                glColor4f(0.5f, 0.5f, 0.5f, 0.95f);
                glVertex3f(-40, 20, 0);
                glVertex3f(40, 20, 0);
                glVertex3f(40, -20, 0);
                glVertex3f(-40, -20, 0);
            }
            glEnd();

        }glPopMatrix();


        glPushMatrix();
        {
//Real World

               // ObjList.getObject("City").render();
            glDisable(GL_LIGHT1);
            glDisable(GL_LIGHT2);
            ObjList.getObject("City").render();
            if(getLantern != true){
                ObjList.getObject("Lantern_bench").render();
            }

            renderText("NO SHADERS + GL_FOG: GL_EXP2",10,20);
        }
        glPopMatrix();



    }

    private void drawObj2() {
        float [] ambientNight = {0.3f,0.3f,0.3f,1.0f};
        glLightModelfv(GL_LIGHT_MODEL_AMBIENT, ambientNight, 0);
        //skybox.render();

        DiffNormSpecShader.bind();
        glEnable(GL_LIGHT1);
        glEnable(GL_LIGHT2);
        glPushMatrix();
        {
            ObjList.getObject("Cemetery").render();
            ObjList.getObject("Campa").render();

        }glPopMatrix();

        DiffNormSpecShader.unbind();

    }

private void drawObj3(){

    glPushMatrix();
    {
        glColor3f(3, 3, 3);
        glRotatef(toDegrees(sunRot), 0, 1, 0);
        glTranslatef(0, 40, 0);
        //glutSolidSphere(15.0f, 32, 32);
        ObjList.getObject("sun").render();
    }glPopMatrix();

    glPushMatrix();

    {
        glColor3f(1, 1, 1);
        // Movimento de translação
        glRotatef(toDegrees(earthTrl), 0, 1, 0);
        glTranslatef(EARTH_DISTANCE, 40, 0);

        // Movimento de rotação (terra)
        glPushMatrix();
        {
            glColor3f(3, 3, 3);
            glRotatef(toDegrees(earthRot), 0, 1, 0);
            //glutSolidSphere(5f, 15, 15);
            ObjList.getObject("earth").render();

            // Movimento de Translação da luap
            glRotatef(toDegrees(moonTrl), 0, 1, 0);
            glTranslatef(EARTH_MOON_DISTANCE, 5f, 0);

            // Movimento de Rotação da lua
            glPushMatrix();
            {
                glColor3f(3, 3, 3);
                glRotatef(toDegrees(moonRot), 0, 1, 0);
                //glutSolidSphere(3.0f, 10, 10);
                ObjList.getObject("moon").render();

            }
            glPopMatrix();
        }glPopMatrix();


    }glPopMatrix();


    glPushMatrix();

    {
        glColor3f(3, 3, 3);
        // Movimento de translação
        glRotatef(toDegrees(mercuryTrl), 0, 1, 0);
        glTranslatef(MERCURY_DISTANCE, 40, 0);

        // Movimento de rotação (terra)
        glPushMatrix();
        {
            glColor3f(3, 3, 3);
            glRotatef(toDegrees(mercuryRot), 0, 1, 0);
            //glutSolidSphere(8.0f, 20, 20);
            ObjList.getObject("mercury").render();
        }
        glPopMatrix();
    }glPopMatrix();

}
    private void CheckPosMirror(){
        Camera camera2 = Cameras.getCurrent();

        if(camera2.eye.x < 28.5f){
            drawObj1();
            glEnable(GL_FOG);
            glClearColor(0.7f, 0.7f, 0.7f, 1.0f);
        }
        else{
            drawObj2();
            glDisable(GL_FOG);
            glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        }

    }


    private void MovementController() {
        Camera camera = Cameras.getCurrent();
        float MovementSpeed = 0.1f;
        //renderText("Coliding?: " + isColiding,10,40);
        if(!CampaStart){
            if(isKeyPressed(KeyEvent.VK_SHIFT)){
                MovementSpeed = 0.1f;
            }else{
                MovementSpeed =  0.05f;
            }

            if(isKeyPressed(KeyEvent.VK_W)){
                //System.out.println("W PRESSED");
                Vector3f moveForward = Vectors.sub(camera.at, camera.eye);
                moveForward.normalize();
                moveForward.y = 0;
                //System.out.println(moveForward);

                Vectors.mult(moveForward,MovementSpeed);

                camera.eye = Vectors.add(camera.eye,moveForward);
                camera.at = Vectors.add(camera.at,moveForward);

                //System.out.println("Aim: " + WobleVal);


            /*if(updowInit){
                if(WobleVal < 0.5f) {
                    while (WobleVal <=0.5f) {
                        WobleVal += 0.001;
                    }
                }
                updowInit = false;
            }else{
                if (WobleVal >= -0.5f){
                    while(WobleVal > -0.5f){
                        WobleVal -= 0.001;
                    }
                }
                updowInit = true;
            }

            camera.eye.y += WobleVal;*/

                setupCamera();
            }

            if(isKeyPressed(KeyEvent.VK_S)){
                //System.out.println("S PRESSED");
                Vector3f moveForward = Vectors.sub(camera.eye,camera.at);
                moveForward.normalize();
                moveForward.y = 0;
                //System.out.println(moveForward);

                Vectors.mult(moveForward,MovementSpeed);

                camera.eye = Vectors.add(camera.eye,moveForward);
                camera.at = Vectors.add(camera.at,moveForward);

                setupCamera();
            }

            if(isKeyPressed(KeyEvent.VK_A)){
                //System.out.println("A PRESSED");
                Vector3f moveForward = new Vector3f(rotate(90.0f, camera.up, Vectors.sub(camera.at,camera.eye)));
                moveForward.normalize();
                moveForward.y = 0;
                //System.out.println(moveForward);

                Vectors.mult(moveForward,MovementSpeed);

                camera.eye = Vectors.add(camera.eye,moveForward);
                camera.at = Vectors.add(camera.at,moveForward);

                setupCamera();
            }

            if(isKeyPressed(KeyEvent.VK_D)){
                //System.out.println("D PRESSED");
                Vector3f moveForward = new Vector3f(rotate(90.0f, camera.up, Vectors.sub(camera.eye,camera.at)));
                moveForward.normalize();
                moveForward.y = 0;
                //System.out.println(moveForward);

                Vectors.mult(moveForward,MovementSpeed);

                camera.eye = Vectors.add(camera.eye,moveForward);
                camera.at = Vectors.add(camera.at,moveForward);

                setupCamera();
            }
        }
    }

    private void CameraFPS(){
        Point MouseFPos =  MouseInfo.getPointerInfo().getLocation();
        double mousexf = (this.getWidth()/2) - MouseFPos.getX() ;
        double mouseyf = (this.getHeight()/2)  - MouseFPos.getY();
        //System.out.println(mousexf + " " + mouseyf);
        UpdateFPSCamera(mousexf,mouseyf);

    }

    //private Vector3f position = new Vector3f(20f,10f,20f);
    //private Vector3f At = new Vector3f(0,0,0);

    /*private void LookatFPSCamera(double mXRot, double mYRot) {
        Vector3f posVal = position;
        Vector3f forward = Vectors.sub(At, posVal);
        Vector3f up = new Vector3f(0,1,0);
        Vector3f left = new Vector3f(rotate(90.0f, up, forward));
        left.y = 0;

        Vector3f eye = new Vector3f(rotate((float)mXRot, up, forward));
        eye = new Vector3f(rotate((float)mYRot, left, At));

        At = eye;


        gluLookAt(position.x,position.y,position.z,At.x,At.y,At.z,0,1,0);
        System.out.println(At + ", " + position);
    }*/

    private void UpdateFPSCamera(double mXRot, double mYRot) {
        Camera camera = Cameras.getCurrent();

        Vector3f camEye = camera.eye;
        Vector3f camAt = camera.at;

        Vector3f fw = Vectors.sub(camAt,camEye);
        Vector3f up = camera.up;
        Vector3f left =  new Vector3f(rotate(90.0f, up, fw));
        left.y = 0;

        Vector3f eye = new Vector3f(rotate((float)mXRot*0.1f, up, fw ));
        eye = new Vector3f(rotate((float)-mYRot*0.1f, left, eye));

        camera.at = Vectors.add(eye, camera.eye);

        //System.out.println(camera.at+","+eye+","+left);

        try {
            Robot r = new Robot();
            r.mouseMove(this.getWidth()/2,this.getHeight()/2);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        setupCamera();

   }

   private int ValueWoblier(int minVal, int maxVal){
       Random rand = new Random();
       int Val = rand.nextInt(maxVal) + minVal;
       return Val;
   }

   private int colisionIndex = 0;
   private boolean isColiding = false;
   private void colisionIteration(){
       while(colisionIndex < ObjList.getMaxIndex()){
           isColiding = ObjList.checkColisions("ObjPlayer", ObjList.getObjNameByIndex(colisionIndex));
           colisionIndex++;
       }
       colisionIndex = 0;
   }


   /*private void drawColisionBox(String name){
       Vector3f Center = ObjList.drawColisionBox(ObjList.getObjectBox(name),5);
       glPushAttrib(GL2.GL_CURRENT_BIT | GL2.GL_ENABLE_BIT);
       glDisable(GL2.GL_TEXTURE_2D);
       glDisable(GL2.GL_DEPTH_TEST);
       glDisable(GL2.GL_LIGHTING);
       glDisable(GL2.GL_BLEND);
       glPushMatrix();
       //glTranslatef(Center.x, Center.y, Center.z);
       //gl.glScalef(xSize, ySize, zSize);
       glBegin(GL_QUADS);
       {
           glColor4f(0, 1f, 0f, .7f);
           glVertex3f(ObjList.drawColisionBox(ObjList.getObjectBox(name),1).x,ObjList.drawColisionBox(ObjList.getObjectBox(name),1).y,ObjList.drawColisionBox(ObjList.getObjectBox(name),1).z);
           glVertex3f(ObjList.drawColisionBox(ObjList.getObjectBox(name),1).x,ObjList.drawColisionBox(ObjList.getObjectBox(name),1).y,ObjList.drawColisionBox(ObjList.getObjectBox(name),2).z);
           glVertex3f(ObjList.drawColisionBox(ObjList.getObjectBox(name),1).x,ObjList.drawColisionBox(ObjList.getObjectBox(name),1).y,ObjList.drawColisionBox(ObjList.getObjectBox(name),3).z);
           glVertex3f(ObjList.drawColisionBox(ObjList.getObjectBox(name),1).x,ObjList.drawColisionBox(ObjList.getObjectBox(name),1).y,ObjList.drawColisionBox(ObjList.getObjectBox(name),4).z);
       }
       glEnd();
       glPopMatrix();
       glPopAttrib();
   }*/

    @Override
    public void resize(int width, int height) {
        setProjectionPerspective(width, height, 71.0f, 0.001f, 200f);

    }

    @Override
    public void render(int width, int height) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        //colisionIteration();
        PlayerController();
        checkPosLanCamp();
        drawObj3();
        //light Pos
        //glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(Cameras.getCurrent().eye.x, Cameras.getCurrent().eye.y, Cameras.getCurrent().eye.z, 1.0f));


        updateRotations();


        CheckPosMirror();


        glFlush();

    }



    @Override
    public void release() {

    }


    /*//DiffNormSpecShader.bind();
    //glTranslatef(0f, 0f, 0f);
            ObjList.getObject("Ground").render();
    //ObjList.getObject("City").render();
            ObjList.getObject("Lantern").render();
    //glutSolidSphere(5f,64,32);
    //phongShader.unbind();
    //DiffNormSpecShader.unbind();
    //fogShader.unbind();
    */
}