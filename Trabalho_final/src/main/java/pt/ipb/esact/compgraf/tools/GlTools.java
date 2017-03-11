package pt.ipb.esact.compgraf.tools;

import com.google.common.base.Preconditions;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLContext;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.gl2.GLUgl2;
import java.awt.*;
import java.io.FileInputStream;
import java.nio.FloatBuffer;

public class GlTools {

    private static final Logger logger = LoggerFactory.getLogger(GlTools.class);

	private static boolean anisotropicAvailable = false;
	
	private static float maxAnisotropy = 0.0f;
	
	private static GLU glu;

	private static GLUT glut;

	static {
		// Verificar se a extensão está disponível
		anisotropicAvailable = isExtensionAvailable("GL_EXT_texture_filter_anisotropic");
		
		// Se não está disponível parar por aqui
		if(anisotropicAvailable) {
			// Obter o valor mínimo/máximo de anisotropia suportado
			FloatBuffer values = FloatBuffer.allocate(1);
			gl().glGetFloatv(GL2.GL_MAX_TEXTURE_MAX_ANISOTROPY_EXT, values);
			maxAnisotropy = values.get(0);
		}
		
		glu = new GLUgl2();
		glut = new GLUT();
	}

    public static Texture loadTexture(String path) {
        Preconditions.checkNotNull(path, "The path cannot be null");
        GL2 gl = gl();
        GLU glu = new GLU();

        String type = getImageType(path);
        try (FileInputStream stream = new FileInputStream(path)) {
            Texture tex = TextureIO.newTexture(stream, true, type);
            tex.setTexParameteri(gl, GL2.GL_TEXTURE_MAG_FILTER, GL2.GL_LINEAR);
            tex.setTexParameteri(gl, GL2.GL_TEXTURE_MIN_FILTER, GL2.GL_LINEAR_MIPMAP_LINEAR);
            tex.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_S, GL2.GL_CLAMP_TO_EDGE);
            tex.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_T, GL2.GL_CLAMP_TO_EDGE);
            if(isAnisotropicAvailable())
                tex.setTexParameterf(gl, GL2.GL_TEXTURE_MAX_ANISOTROPY_EXT, getMaxAnisotropy());

            int i = gl.glGetError();
            String s = glu.gluErrorString(i);
            if(i != GL.GL_NO_ERROR)
                logger.error(s);

            return tex;
        } catch (Exception e) {
            // Ocorreu um erro --> Terminar o programa
            exit("Foi impossivel carregar a imagem '" + path + "': " + e.getMessage());
            return null;
        }
    }

	/**
	 * Carrega uma textura a partir da package da classe do objeto reference
	 * @param reference O objeto que serve de referencia
	 * @param path A path dentro da package atual
	 * @param textureId O ID do Texture Object
	 * @return 
	 */
	public static Texture loadPackageTexture(Object reference, String path) {
		Preconditions.checkNotNull(reference, "The reference cannot be null");
		GL2 gl = gl();
		
		String type = getImageType(path);
		try {
			Texture tex = TextureIO.newTexture(reference.getClass().getResourceAsStream(path), true, type);
			tex.setTexParameteri(gl, GL2.GL_TEXTURE_MAG_FILTER, GL2.GL_LINEAR);
			tex.setTexParameteri(gl, GL2.GL_TEXTURE_MIN_FILTER, GL2.GL_LINEAR_MIPMAP_LINEAR);
			tex.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_S, GL2.GL_CLAMP_TO_EDGE);
			tex.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_T, GL2.GL_CLAMP_TO_EDGE);
			if(isAnisotropicAvailable())
				tex.setTexParameterf(gl, GL2.GL_TEXTURE_MAX_ANISOTROPY_EXT, getMaxAnisotropy());
			return tex;
		} catch (Exception e) {
			// Ocorreu um erro --> Terminar o programa
			exit("Foi impossivel carregar a imagem '" + path + "': " + e.getMessage());
			return null;
		}
	}

	private static String getImageType(String path) {
		String ext = path.substring(path.lastIndexOf('.') + 1).replace(".", "");
		switch (ext.toLowerCase()) {
		case "dds": return TextureIO.DDS;
		case "gis": return TextureIO.GIF;
		case "jpg": return TextureIO.JPG;
		case "pam": return TextureIO.PAM;
		case "ppm": return TextureIO.PPM;
		case "sgi": return TextureIO.SGI;
		case "tga": return TextureIO.TGA;
		case "tiff": case "tif": return TextureIO.TIFF;
		default:
		case "png": return TextureIO.PNG;
		}
	}

	public static float getMaxAnisotropy() {
		return maxAnisotropy;
	}

	private static GLU glu() {
		return glu;
	}

	public static boolean isAnisotropicAvailable() {
		return anisotropicAvailable;
	}

	private static boolean isExtensionAvailable(String extension) {
		return gl().isExtensionAvailable(extension);
	}

	public static void exit(String error) {
		logger.error(error);
		System.exit(0);		
	}

	public static GL2 gl() {
		return GLContext.getCurrentGL().getGL2();
	}

	public static GLUT glut() {
		return glut;
	}
	
	private static final TextRenderer TEXT_RENDERER = new TextRenderer(new Font("SansSerif", Font.PLAIN, 10));
	
	public static void render3DText(String text, float x, float y, float z, float scale) {
		GL2 gl = gl();
		gl.glPushAttrib(GL2.GL_ENABLE_BIT);
			gl.glDisable(GL2.GL_CULL_FACE);
			gl.glDisable(GL2.GL_TEXTURE_2D);
			TEXT_RENDERER.setColor(Color.white);
			TEXT_RENDERER.begin3DRendering();
			TEXT_RENDERER.draw3D(text, x, y, z, scale);
			TEXT_RENDERER.end3DRendering();
		gl.glPopAttrib();
	}
	

	


}
