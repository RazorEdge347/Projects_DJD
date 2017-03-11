package pt.ipb.esact.compgraf.tools;

import javax.media.opengl.GLContext;
import javax.vecmath.Vector3f;

import pt.ipb.esact.compgraf.tools.math.Colors;
import pt.ipb.esact.compgraf.tools.math.VectorList;

public class GLDemo extends GL2Wrapper {
	
	private void sync() {
		setCurrent(GLContext.getCurrentGL().getGL2());
	}
	
	public void drawPlane() {
		drawPlane(false);
	}
	
	public void drawPlane(boolean paintNormals) {
		sync();
		
		boolean calculateNormals = true;
		
		VectorList v = new VectorList();

		// Save the matrix state
		glPushMatrix();

			// Nose Piramid /////////////////////////////
			v.clear();
			v.append(0.0f, 0.0f, 60.0f);
			v.append(new Vector3f(-15.0f, 0.0f, 30.0f));
			v.append(new Vector3f(15.0f,0.0f,30.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector3f(15.0f,0.0f,30.0f));
			v.append(new Vector3f(0.0f, 15.0f, 30.0f));
			v.append(new Vector3f(0.0f, 0.0f, 60.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector3f(0.0f, 0.0f, 60.0f));
			v.append(new Vector3f(0.0f, 15.0f, 30.0f));
			v.append(new Vector3f(-15.0f,0.0f,30.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// Body of the Plane ////////////////////////
			v.clear();
			v.append(new Vector3f(-15.0f,0.0f,30.0f));
			v.append(new Vector3f(0.0f, 15.0f, 30.0f));
			v.append(new Vector3f(0.0f, 0.0f, -56.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector3f(0.0f, 0.0f, -56.0f));
			v.append(new Vector3f(0.0f, 15.0f, 30.0f));
			v.append(new Vector3f(15.0f,0.0f,30.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector3f(15.0f,0.0f,30.0f));
			v.append(new Vector3f(-15.0f, 0.0f, 30.0f));
			v.append(new Vector3f(0.0f, 0.0f, -56.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			///////////////////////////////////////////////
			// Left wing
			v.clear();
			v.append(new Vector3f(0.0f,2.0f,27.0f));
			v.append(new Vector3f(-60.0f, 2.0f, -8.0f));
			v.append(new Vector3f(60.0f, 2.0f, -8.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector3f(60.0f, 2.0f, -8.0f));
			v.append(new Vector3f(0.0f, 7.0f, -8.0f));
			v.append(new Vector3f(0.0f,2.0f,27.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector3f(60.0f, 2.0f, -8.0f));
			v.append(new Vector3f(-60.0f, 2.0f, -8.0f));
			v.append(new Vector3f(0.0f,7.0f,-8.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// Other wing top section
			v.clear();
			v.append(new Vector3f(0.0f,2.0f,27.0f));
			v.append(new Vector3f(0.0f, 7.0f, -8.0f));
			v.append(new Vector3f(-60.0f, 2.0f, -8.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// Tail section///////////////////////////////
			v.clear();
			v.append(new Vector3f(-30.0f, -0.50f, -57.0f));
			v.append(new Vector3f(30.0f, -0.50f, -57.0f));
			v.append(new Vector3f(0.0f,-0.50f,-40.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// top of left side
			v.clear();
			v.append(new Vector3f(0.0f,-0.5f,-40.0f));
			v.append(new Vector3f(30.0f, -0.5f, -57.0f));
			v.append(new Vector3f(0.0f, 4.0f, -57.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// top of right side
			v.clear();
			v.append(new Vector3f(0.0f, 4.0f, -57.0f));
			v.append(new Vector3f(-30.0f, -0.5f, -57.0f));
			v.append(new Vector3f(0.0f,-0.5f,-40.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// back of bottom of tail
			v.clear();
			v.append(new Vector3f(30.0f,-0.5f,-57.0f));
			v.append(new Vector3f(-30.0f, -0.5f, -57.0f));
			v.append(new Vector3f(0.0f, 4.0f, -57.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// Top of Tail section left
			v.clear();
			v.append(new Vector3f(0.0f,0.5f,-40.0f));
			v.append(new Vector3f(3.0f, 0.5f, -57.0f));
			v.append(new Vector3f(0.0f, 25.0f, -65.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector3f(0.0f, 25.0f, -65.0f));
			v.append(new Vector3f(-3.0f, 0.5f, -57.0f));
			v.append(new Vector3f(0.0f,0.5f,-40.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// Back of horizontal section
			v.clear();
			v.append(new Vector3f(3.0f,0.5f,-57.0f));
			v.append(new Vector3f(-3.0f, 0.5f, -57.0f));
			v.append(new Vector3f(0.0f, 25.0f, -65.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

		glPopMatrix();
	}

	public void drawGround(int mode, float extent, int cells, float texZoom) {
		sync();

		float y = 0.0f;
		float strip, run;
		float step = extent / (float) cells;

		float s = 0.0f;
		float t = 0.0f;

		float texStep = texZoom / (float) cells;

		glPushAttrib(GL_TEXTURE_BIT);
		
			glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
			glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
	
			for (strip = -extent; strip <= extent; strip += step) {
				t = 0.0f;
				glBegin(mode);
					for (run = extent; run >= -extent; run -= step) {
						glTexCoord2f(s, t);
						glNormal3f(0.0f, 1.0f, 0.0f);
						glVertex3f(strip, y, run);
	
						glTexCoord2f(s + texStep, t);
						glNormal3f(0.0f, 1.0f, 0.0f);
						glVertex3f(strip + step, y, run);
	
						t += texStep;
					}
				glEnd();
	
				s += texStep;
			}
			
		glPopAttrib();
	}
	
	public void drawFloor(float extent, int cells) {
		drawFloor(extent, cells, 1.0f, false);
	}
	
	public void drawFloor(float extent, int cells, float texZoom, boolean drawLines) {
		sync();
		
		// Desenhar em 2 passos

		// 1 Chão com polígonos
		drawGround(GL_TRIANGLE_STRIP, extent, cells, texZoom);

		if(!drawLines)
			return;

		// 2 Desenhar linhas para ver os polígonos
		glPushAttrib(GL_CURRENT_BIT | GL_ENABLE_BIT);
			glEnable(GL_LINE_SMOOTH);
			glDisable(GL_LIGHTING);
			Colors.color(0.6f, 0.6f, 0.6f, 0.5f).set();
			drawGround(GL_LINE_STRIP, extent, cells, texZoom);
		glPopAttrib();
	}

}
