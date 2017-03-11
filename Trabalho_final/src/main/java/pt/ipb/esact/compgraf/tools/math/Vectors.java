package pt.ipb.esact.compgraf.tools.math;

import javax.media.opengl.GL2;
import javax.media.opengl.GLContext;
import javax.vecmath.Color4f;
import javax.vecmath.Vector3f;

public class Vectors {

//	public static final Vector3f ZERO = new Vector3f();
//	public static final Vector3f ORIGIN = new Vector3f(0.0f, 0.0f, 0.0f);
//	public static final Vector3f UP = new Vector3f(0.0f, 1.0f, 0.0f);
//	public static final Vector3f LEFT = new Vector3f(-1.0f, 0.0f, 0.0f);
//	public static final Vector3f FORWARD = new Vector3f(0.0f, 0.0f, 1.0f);

	public static Vector3f add(Vector3f v1, Vector3f v2) {
		Vector3f v = new Vector3f(v1);
		v.add(v2);
		return v;
	}

	public static Vector3f sub(Vector3f v1, Vector3f v2) {
		Vector3f v = new Vector3f(v1);
		v.sub(v2);
		return v;
	}

	public static Vector3f cross(Vector3f v1, Vector3f v2) {
		Vector3f v = new Vector3f();
		v.cross(v1, v2);
		return v;
	}

	public static float dot(Vector3f v1, Vector3f v2) {
		return v1.dot(v2);
	}

	public static boolean isOrigin(Vector3f n) {
		return n.equals(zero());
	}

    public static Vector3f zero() {
        return new Vector3f();
    }

    public static void paint(Vector3f v) {
		paint(v, Vectors.zero(), Colors.WHITE);
	}

	public static void paint(Vector3f v, Color4f color) {
		paint(v, Vectors.zero(), color);
	}
	
	public static void mult(Vector3f v, float scalar) {
		v.x *= scalar;
		v.y *= scalar;
		v.z *= scalar;
	}

	public static void paint(Vector3f v, Vector3f at, Color4f color) {
		GL2 gl = GLContext.getCurrentGL().getGL2();
		if (v.lengthSquared() == 0)
			return;

		gl.glPushAttrib(GL2.GL_ENABLE_BIT);
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_LIGHTING);

		gl.glPushAttrib(GL2.GL_CURRENT_BIT | GL2.GL_LIGHTING_BIT);
		gl.glColor4f(color.x, color.y, color.z, color.w);
		gl.glPushMatrix();
		if (!Vectors.isOrigin(at))
			gl.glTranslatef(at.x, at.y, at.z);

		gl.glBegin(GL2.GL_LINES);
		gl.glVertex3f(0.0f, 0.0f, 0.0f);
		gl.glVertex3f(v.x, v.y, v.z);
		gl.glEnd();

		gl.glPushMatrix();
		gl.glTranslatef(v.x, v.y, v.z);
		GLPrimitives.drawSphere(0.05f, 10, 10);
		gl.glPopMatrix();
		gl.glPopMatrix();
		gl.glPopAttrib();
		gl.glPopAttrib();
	}

    public static Vector3f origin() {
        return zero();
    }

    public static Vector3f up() {
        return new Vector3f(0, 1, 0);
    }

    public static Vector3f forward() {
        return new Vector3f(0, 0, 1);
    }

    public static Vector3f down() {
        return new Vector3f(0, -1, 0);
    }
}
