package pt.ipb.esact.compgraf.tools.math;

import javax.media.opengl.GL2;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

public class GlMath {

    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

    public static Vector3f rotate(float angle, Vector3f axis, Vector3f vector) {
        Quat4f q = new Quat4f();
        q.set(new AxisAngle4f(axis, (float) Math.toRadians(angle)));

        Matrix4f m = new Matrix4f();
        m.set(q);

        Vector3f result = new Vector3f(vector);
        m.transform(result);
        return result;
    }

    /**
     * https://en.wikipedia.org/wiki/Spherical_coordinate_system
     */
    public static Vector3f polarToVector(float radius, float theta, float phi) {
        // GL_PI / 2 offset (x -> z)
        theta += Math.PI / 2f;
        return new Vector3f(
                radius * (float) Math.sin(theta) * (float) Math.cos(phi),
                radius * (float) Math.sin(theta) * (float) Math.sin(phi),
                radius * (float) Math.cos(theta)
        );
    }

}
