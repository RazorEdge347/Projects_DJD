package pt.ipb.esact.compgraf.tools;

import com.jogamp.opengl.util.gl2.GLUT;

public class GLUTWrapper extends GLUWrapper {

	private GLUT glut = new GLUT();

	/**
	 * @param radius
	 * @param slices
	 * @param stacks
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutWireSphere(double, int, int)
	 */
	public void glutWireSphere(double radius, int slices, int stacks) {
		glut.glutWireSphere(radius, slices, stacks);
	}

	/**
	 * @param radius
	 * @param slices
	 * @param stacks
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutSolidSphere(double, int, int)
	 */
	public void glutSolidSphere(double radius, int slices, int stacks) {
		glut.glutSolidSphere(radius, slices, stacks);
	}

	/**
	 * @param base
	 * @param height
	 * @param slices
	 * @param stacks
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutWireCone(double, double, int, int)
	 */
	public void glutWireCone(double base, double height, int slices, int stacks) {
		glut.glutWireCone(base, height, slices, stacks);
	}

	/**
	 * @param base
	 * @param height
	 * @param slices
	 * @param stacks
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutSolidCone(double, double, int, int)
	 */
	public void glutSolidCone(double base, double height, int slices, int stacks) {
		glut.glutSolidCone(base, height, slices, stacks);
	}

	/**
	 * @param radius
	 * @param height
	 * @param slices
	 * @param stacks
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutWireCylinder(double, double, int, int)
	 */
	public void glutWireCylinder(double radius, double height, int slices, int stacks) {
		glut.glutWireCylinder(radius, height, slices, stacks);
	}

	/**
	 * @param radius
	 * @param height
	 * @param slices
	 * @param stacks
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutSolidCylinder(double, double, int, int)
	 */
	public void glutSolidCylinder(double radius, double height, int slices, int stacks) {
		glut.glutSolidCylinder(radius, height, slices, stacks);
	}

	/**
	 * @param size
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutWireCube(float)
	 */
	public void glutWireCube(float size) {
		glut.glutWireCube(size);
	}

	/**
	 * @param size
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutSolidCube(float)
	 */
	public void glutSolidCube(float size) {
		glut.glutSolidCube(size);
	}

	/**
	 * @param innerRadius
	 * @param outerRadius
	 * @param nsides
	 * @param rings
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutWireTorus(double, double, int, int)
	 */
	public void glutWireTorus(double innerRadius, double outerRadius, int nsides, int rings) {
		glut.glutWireTorus(innerRadius, outerRadius, nsides, rings);
	}

	/**
	 * @param innerRadius
	 * @param outerRadius
	 * @param nsides
	 * @param rings
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutSolidTorus(double, double, int, int)
	 */
	public void glutSolidTorus(double innerRadius, double outerRadius, int nsides, int rings) {
		glut.glutSolidTorus(innerRadius, outerRadius, nsides, rings);
	}

	/**
	 * 
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutWireDodecahedron()
	 */
	public void glutWireDodecahedron() {
		glut.glutWireDodecahedron();
	}

	/**
	 * 
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutSolidDodecahedron()
	 */
	public void glutSolidDodecahedron() {
		glut.glutSolidDodecahedron();
	}

	/**
	 * 
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutWireOctahedron()
	 */
	public void glutWireOctahedron() {
		glut.glutWireOctahedron();
	}

	/**
	 * 
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutSolidOctahedron()
	 */
	public void glutSolidOctahedron() {
		glut.glutSolidOctahedron();
	}

	/**
	 * 
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutWireIcosahedron()
	 */
	public void glutWireIcosahedron() {
		glut.glutWireIcosahedron();
	}

	/**
	 * 
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutSolidIcosahedron()
	 */
	public void glutSolidIcosahedron() {
		glut.glutSolidIcosahedron();
	}

	/**
	 * 
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutWireTetrahedron()
	 */
	public void glutWireTetrahedron() {
		glut.glutWireTetrahedron();
	}

	/**
	 * 
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutSolidTetrahedron()
	 */
	public void glutSolidTetrahedron() {
		glut.glutSolidTetrahedron();
	}

	/**
	 * @param scale
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutSolidTeapot(double)
	 */
	public void glutSolidTeapot(double scale) {
		glut.glutSolidTeapot(scale);
	}

	/**
	 * @param scale
	 * @param cStyle
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutSolidTeapot(double, boolean)
	 */
	public void glutSolidTeapot(double scale, boolean cStyle) {
		glut.glutSolidTeapot(scale, cStyle);
	}

	/**
	 * @param scale
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutWireTeapot(double)
	 */
	public void glutWireTeapot(double scale) {
		glut.glutWireTeapot(scale);
	}

	/**
	 * @param scale
	 * @param cStyle
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutWireTeapot(double, boolean)
	 */
	public void glutWireTeapot(double scale, boolean cStyle) {
		glut.glutWireTeapot(scale, cStyle);
	}

	/**
	 * @param font
	 * @param character
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutBitmapCharacter(int, char)
	 */
	public void glutBitmapCharacter(int font, char character) {
		glut.glutBitmapCharacter(font, character);
	}

	/**
	 * @param font
	 * @param string
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutBitmapString(int, java.lang.String)
	 */
	public void glutBitmapString(int font, String string) {
		glut.glutBitmapString(font, string);
	}

	/**
	 * @param font
	 * @param character
	 * @return
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutBitmapWidth(int, char)
	 */
	public int glutBitmapWidth(int font, char character) {
		return glut.glutBitmapWidth(font, character);
	}

	/**
	 * @param font
	 * @param character
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutStrokeCharacter(int, char)
	 */
	public void glutStrokeCharacter(int font, char character) {
		glut.glutStrokeCharacter(font, character);
	}

	/**
	 * @param font
	 * @param string
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutStrokeString(int, java.lang.String)
	 */
	public void glutStrokeString(int font, String string) {
		glut.glutStrokeString(font, string);
	}

	/**
	 * @param font
	 * @param character
	 * @return
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutStrokeWidth(int, char)
	 */
	public int glutStrokeWidth(int font, char character) {
		return glut.glutStrokeWidth(font, character);
	}

	/**
	 * @param font
	 * @param character
	 * @return
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutStrokeWidthf(int, char)
	 */
	public float glutStrokeWidthf(int font, char character) {
		return glut.glutStrokeWidthf(font, character);
	}

	/**
	 * @param font
	 * @param string
	 * @return
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutBitmapLength(int, java.lang.String)
	 */
	public int glutBitmapLength(int font, String string) {
		return glut.glutBitmapLength(font, string);
	}

	/**
	 * @param font
	 * @param string
	 * @return
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutStrokeLength(int, java.lang.String)
	 */
	public int glutStrokeLength(int font, String string) {
		return glut.glutStrokeLength(font, string);
	}

	/**
	 * @param font
	 * @param string
	 * @return
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutStrokeLengthf(int, java.lang.String)
	 */
	public float glutStrokeLengthf(int font, String string) {
		return glut.glutStrokeLengthf(font, string);
	}

	/**
	 * 
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutWireRhombicDodecahedron()
	 */
	public void glutWireRhombicDodecahedron() {
		glut.glutWireRhombicDodecahedron();
	}

	/**
	 * 
	 * @see com.jogamp.opengl.util.gl2.GLUT#glutSolidRhombicDodecahedron()
	 */
	public void glutSolidRhombicDodecahedron() {
		glut.glutSolidRhombicDodecahedron();
	}
	
}
