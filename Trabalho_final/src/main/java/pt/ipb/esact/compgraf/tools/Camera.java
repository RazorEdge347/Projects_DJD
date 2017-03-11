package pt.ipb.esact.compgraf.tools;

import javax.vecmath.Vector3f;

import pt.ipb.esact.compgraf.tools.math.Vectors;

public class Camera {

	public Vector3f eye = new Vector3f(0.0f, 1.0f, 1.0f);
	
	public Vector3f at = Vectors.origin();
	
	public Vector3f up = Vectors.up();
	
	public Camera() {
	}
	
	public Camera(float eyeX, float eyeY, float eyeZ) {
		eye = new Vector3f(eyeX, eyeY, eyeZ);
	}
	
	public Vector3f forward() {
		return Vectors.sub(eye, at);
	}
	
}
