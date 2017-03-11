package pt.ipb.esact.compgraf.tools.math;

import java.util.ArrayList;
import java.util.Vector;

import javax.media.opengl.GL2;
import javax.media.opengl.GLContext;
import javax.vecmath.Vector3f;

/**
 * A classe VectorList facilita o cálculo da normal de 3 vectores, ou do centróide
 * de um determinado polígono
 */
@SuppressWarnings("serial")
public class VectorList extends ArrayList<Vector3f> {

	/**
	 * Adiciona o {@link Vector} à lista atual
	 * @return A lista atual
	 */
	public VectorList append(Vector3f vector) {
		add(vector);
		return this;
	}
	
	/**
	 * @return O vector normal dos 3 primeiros vectores da lista actual
	 */
	Vector3f normalVector() {
		if(size() < 3)
			return Vectors.origin();

		Vector3f v1 = get(0);
		Vector3f v2 = get(1);
		Vector3f v3 = get(2);
		Vector3f vv1 = Vectors.sub(v2, v1);
		Vector3f vv2 = Vectors.sub(v3, v1);
		Vector3f n = Vectors.cross(vv1, vv2);
		n.normalize();
		return n;
	}

	/** 
	 * O ponto central do Triângulo definido pelos primeiros 3 Vector da lista
	 * 
	 * @return O centróide do polígono representado pelos 3 primeiros vectores da lista actual
	 */
	public Vector3f centroid() {
		if(size() < 3)
			return Vectors.origin();

		Vector3f v1 = get(0);
		Vector3f v2 = get(1);
		Vector3f v3 = get(2);

		float xx = v1.x + v2.x + v3.x; xx /= 3.0;
		float yy = v1.y + v2.y + v3.y; yy /= 3.0;
		float zz = v1.z + v2.z + v3.z; zz /= 3.0;

		return new Vector3f(xx, yy, zz);
	}	


	/**
	 * Desenha os vertices na lista actual
	 * 
	 * @param primitive É desenhada a lista de vectores com esta primitiva
	 */
	public void paintVertex(int primitive) {
		paintVertex(primitive, true, false);
	}
	
	/**
	 * Desenha os vertices na lista actual
	 * 
	 * @param primitive É desenhada a lista de vectores com esta primitiva
	 * @param normals Quando @c TRUE, são calculadas e definidas as normais
	 */
	public void paintVertex(int primitive, boolean normals) {
		paintVertex(primitive, normals, false);
	}
	
	/**
	 * Desenha os vertices na lista actual
	 * 
	 * @param primitive É desenhada a lista de vectores com esta primitiva
	 * @param normals Quando @c TRUE, são calculadas e definidas as normais
	 * @param paintNormals Quando @c TRUE, são representadas as normais com uma linha
	 */
	public void paintVertex(int primitive, boolean normals, boolean paintNormals) {
		GL2 gl = gl();
		
		if(normals) {
			Vector3f n = normalVector();
			if(Vectors.isOrigin(n))
				gl.glNormal3f(n.x, n.y, n.z);
			if(paintNormals) {
				n.scale(30.0f);
				Vectors.paint(n, centroid(), Colors.BLUE);
			}
		}
		
		gl.glBegin(primitive);
		for(int i=0; i<size(); i++) {
			Vector3f v = get(i);
			gl.glVertex3f(v.x, v.y, v.z);
		}
		gl.glEnd();
	}

	/**
	 * Define a normal do polígono representado pelos 3 vectores
	 * 
	 * @param one Um vector
	 * @param two Outro vector
	 * @param three Outro vector
	 */
	public static void normal(Vector3f one, Vector3f two, Vector3f three) {
		VectorList list = new VectorList();
		list.append(one);
		list.append(two);
		list.append(three);

		GL2 gl = gl();
		Vector3f n = list.normalVector();
		gl.glNormal3f(n.x, n.y, n.z);
	}

	private static GL2 gl() {
		return GLContext.getCurrentGL().getGL2();
	}

	/**
	 * Adiciona o vector definido pelas suas coordenadas à lista atual
	 * @param x Coordenada X do vector
	 * @param y Coordenada Y do vector
	 * @param z Coordenada > do vector
	 * @return O vector que foi adicionado
	 */
	public Vector3f append(float x, float y, float z) {
		Vector3f v = new Vector3f(x, y, z);
		append(v);
		return v;
	}
	
}
