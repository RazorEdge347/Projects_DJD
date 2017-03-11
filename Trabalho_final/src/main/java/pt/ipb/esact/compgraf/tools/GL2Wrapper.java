package pt.ipb.esact.compgraf.tools;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GL2ES2;
import javax.media.opengl.GL2ES3;
import javax.media.opengl.GL2GL3;
import javax.media.opengl.GL3;
import javax.media.opengl.GL3ES3;
import javax.media.opengl.GL3bc;
import javax.media.opengl.GL4;
import javax.media.opengl.GL4ES3;
import javax.media.opengl.GL4bc;
import javax.media.opengl.GLArrayData;
import javax.media.opengl.GLBufferStorage;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLES1;
import javax.media.opengl.GLES2;
import javax.media.opengl.GLES3;
import javax.media.opengl.GLException;
import javax.media.opengl.GLProfile;
import javax.media.opengl.GLUniformData;

import com.jogamp.common.nio.PointerBuffer;

public class GL2Wrapper implements GL2 {

	public static final float GL_PI = (float) Math.PI;
	
	private GL2 current;
	
	protected void setCurrent(GL2 current) {
		this.current = current;
	}

	public GL2 getCurrent() {
		if(current == null)
			throw new RuntimeException("Current GL2 is null, did you forget to invoke setCurrent()?");
		return current;
	}

	public void glEnableClientState(int arrayName) {
		current.glEnableClientState(arrayName);
	}

	public void glDisableClientState(int arrayName) {
		current.glDisableClientState(arrayName);
	}

	public void glVertexPointer(GLArrayData array) {
		current.glVertexPointer(array);
	}

	public void glVertexPointer(int size, int type, int stride, Buffer pointer) {
		current.glVertexPointer(size, type, stride, pointer);
	}

	public void glVertexPointer(int size, int type, int stride, long pointer_buffer_offset) {
		current.glVertexPointer(size, type, stride, pointer_buffer_offset);
	}

	public void glColorPointer(GLArrayData array) {
		current.glColorPointer(array);
	}

	public void glColorPointer(int size, int type, int stride, Buffer pointer) {
		current.glColorPointer(size, type, stride, pointer);
	}

	public void glColorPointer(int size, int type, int stride, long pointer_buffer_offset) {
		current.glColorPointer(size, type, stride, pointer_buffer_offset);
	}

	public void glColor4f(float red, float green, float blue, float alpha) {
		current.glColor4f(red, green, blue, alpha);
	}

	public void glNormalPointer(GLArrayData array) {
		current.glNormalPointer(array);
	}

	public void glNormalPointer(int type, int stride, Buffer pointer) {
		current.glNormalPointer(type, stride, pointer);
	}

	public void glNormalPointer(int type, int stride, long pointer_buffer_offset) {
		current.glNormalPointer(type, stride, pointer_buffer_offset);
	}

	public void glTexCoordPointer(GLArrayData array) {
		current.glTexCoordPointer(array);
	}

	public void glTexCoordPointer(int size, int type, int stride, Buffer pointer) {
		current.glTexCoordPointer(size, type, stride, pointer);
	}

	public void glTexCoordPointer(int size, int type, int stride, long pointer_buffer_offset) {
		current.glTexCoordPointer(size, type, stride, pointer_buffer_offset);
	}

	public void glLightfv(int light, int pname, FloatBuffer params) {
		current.glLightfv(light, pname, params);
	}

	public void glLightfv(int light, int pname, float[] params, int params_offset) {
		current.glLightfv(light, pname, params, params_offset);
	}

	public void glMaterialf(int face, int pname, float param) {
		current.glMaterialf(face, pname, param);
	}

	public void glMaterialfv(int face, int pname, FloatBuffer params) {
		current.glMaterialfv(face, pname, params);
	}

	public void glMaterialfv(int face, int pname, float[] params, int params_offset) {
		current.glMaterialfv(face, pname, params, params_offset);
	}

	public void glShadeModel(int mode) {
		current.glShadeModel(mode);
	}

	public void glMatrixMode(int mode) {
		current.glMatrixMode(mode);
	}

	public void glPushMatrix() {
		current.glPushMatrix();
	}

	public boolean isGL() {
		return current.isGL();
	}

	public void glPopMatrix() {
		current.glPopMatrix();
	}

	public boolean isGL4bc() {
		return current.isGL4bc();
	}

	public void glLoadIdentity() {
		current.glLoadIdentity();
	}

	public void glLoadMatrixf(FloatBuffer m) {
		current.glLoadMatrixf(m);
	}

	public boolean isGL4() {
		return current.isGL4();
	}

	public void glLoadMatrixf(float[] m, int m_offset) {
		current.glLoadMatrixf(m, m_offset);
	}

	public boolean isGL3bc() {
		return current.isGL3bc();
	}

	public void glMultMatrixf(FloatBuffer m) {
		current.glMultMatrixf(m);
	}

	public boolean isGL3() {
		return current.isGL3();
	}

	public void glMultMatrixf(float[] m, int m_offset) {
		current.glMultMatrixf(m, m_offset);
	}

	public void glTranslatef(float x, float y, float z) {
		current.glTranslatef(x, y, z);
	}

	public boolean isGL2() {
		return current.isGL2();
	}

	public void glRotatef(float angle, float x, float y, float z) {
		current.glRotatef(angle, x, y, z);
	}

	public void glScalef(float x, float y, float z) {
		current.glScalef(x, y, z);
	}

	public boolean isGLES1() {
		return current.isGLES1();
	}

	public void glOrthof(float left, float right, float bottom, float top, float zNear, float zFar) {
		current.glOrthof(left, right, bottom, top, zNear, zFar);
	}

	public boolean isGLES2() {
		return current.isGLES2();
	}

	public void glFrustumf(float left, float right, float bottom, float top, float zNear, float zFar) {
		current.glFrustumf(left, right, bottom, top, zNear, zFar);
	}

	public boolean isGLES3() {
		return current.isGLES3();
	}

	public boolean isGLES() {
		return current.isGLES();
	}

	public boolean isGL2ES1() {
		return current.isGL2ES1();
	}

	public boolean isGL2ES2() {
		return current.isGL2ES2();
	}

	public boolean isGL2ES3() {
		return current.isGL2ES3();
	}

	public boolean isGL3ES3() {
		return current.isGL3ES3();
	}

	public boolean isGL4ES3() {
		return current.isGL4ES3();
	}

	public boolean isGL2GL3() {
		return current.isGL2GL3();
	}

	public boolean isGL4core() {
		return current.isGL4core();
	}

	public boolean isGL3core() {
		return current.isGL3core();
	}

	public boolean isGLcore() {
		return current.isGLcore();
	}

	public boolean isGLES2Compatible() {
		return current.isGLES2Compatible();
	}

	public boolean isGLES3Compatible() {
		return current.isGLES3Compatible();
	}

	public boolean hasGLSL() {
		return current.hasGLSL();
	}

	public GL getDownstreamGL() throws GLException {
		return current.getDownstreamGL();
	}

	public GL getRootGL() throws GLException {
		return current.getRootGL();
	}

	public GL getGL() throws GLException {
		return current.getGL();
	}

	public GL4bc getGL4bc() throws GLException {
		return current.getGL4bc();
	}

	public GL4 getGL4() throws GLException {
		return current.getGL4();
	}

	public GL3bc getGL3bc() throws GLException {
		return current.getGL3bc();
	}

	public GL3 getGL3() throws GLException {
		return current.getGL3();
	}

	public GL2 getGL2() throws GLException {
		return current.getGL2();
	}

	public GLES1 getGLES1() throws GLException {
		return current.getGLES1();
	}

	public GLES2 getGLES2() throws GLException {
		return current.getGLES2();
	}

	public GLES3 getGLES3() throws GLException {
		return current.getGLES3();
	}

	public GL2ES1 getGL2ES1() throws GLException {
		return current.getGL2ES1();
	}

	public GL2ES2 getGL2ES2() throws GLException {
		return current.getGL2ES2();
	}

	public GL2ES3 getGL2ES3() throws GLException {
		return current.getGL2ES3();
	}

	public GL3ES3 getGL3ES3() throws GLException {
		return current.getGL3ES3();
	}

	public GL4ES3 getGL4ES3() throws GLException {
		return current.getGL4ES3();
	}

	public GL2GL3 getGL2GL3() throws GLException {
		return current.getGL2GL3();
	}

	public GLProfile getGLProfile() {
		return current.getGLProfile();
	}

	public GLContext getContext() {
		return current.getContext();
	}

	public boolean isFunctionAvailable(String glFunctionName) {
		return current.isFunctionAvailable(glFunctionName);
	}

	public boolean isExtensionAvailable(String glExtensionName) {
		return current.isExtensionAvailable(glExtensionName);
	}

	public boolean hasBasicFBOSupport() {
		return current.hasBasicFBOSupport();
	}

	public boolean hasFullFBOSupport() {
		return current.hasFullFBOSupport();
	}

	public int getMaxRenderbufferSamples() {
		return current.getMaxRenderbufferSamples();
	}

	public boolean isNPOTTextureAvailable() {
		return current.isNPOTTextureAvailable();
	}

	public boolean isTextureFormatBGRA8888Available() {
		return current.isTextureFormatBGRA8888Available();
	}

	public void setSwapInterval(int interval) {
		current.setSwapInterval(interval);
	}

	public void glAlphaFunc(int func, float ref) {
		current.glAlphaFunc(func, ref);
	}

	public void glClientActiveTexture(int texture) {
		current.glClientActiveTexture(texture);
	}

	public int getSwapInterval() {
		return current.getSwapInterval();
	}

	public void glColor4ub(byte red, byte green, byte blue, byte alpha) {
		current.glColor4ub(red, green, blue, alpha);
	}

	public void glFogf(int pname, float param) {
		current.glFogf(pname, param);
	}

	public Object getPlatformGLExtensions() {
		return current.getPlatformGLExtensions();
	}

	public void glFogfv(int pname, FloatBuffer params) {
		current.glFogfv(pname, params);
	}

	public void glFogfv(int pname, float[] params, int params_offset) {
		current.glFogfv(pname, params, params_offset);
	}

	public Object getExtension(String extensionName) {
		return current.getExtension(extensionName);
	}

	public void glGetLightfv(int light, int pname, FloatBuffer params) {
		current.glGetLightfv(light, pname, params);
	}

	public void glGetLightfv(int light, int pname, float[] params, int params_offset) {
		current.glGetLightfv(light, pname, params, params_offset);
	}

	public void glGetMaterialfv(int face, int pname, FloatBuffer params) {
		current.glGetMaterialfv(face, pname, params);
	}

	public void glClearDepth(double depth) {
		current.glClearDepth(depth);
	}

	public void glDepthRange(double zNear, double zFar) {
		current.glDepthRange(zNear, zFar);
	}

	public void glGetMaterialfv(int face, int pname, float[] params, int params_offset) {
		current.glGetMaterialfv(face, pname, params, params_offset);
	}

	public int getBoundBuffer(int target) {
		return current.getBoundBuffer(target);
	}

	public void glGetTexEnvfv(int tenv, int pname, FloatBuffer params) {
		current.glGetTexEnvfv(tenv, pname, params);
	}

	public GLBufferStorage getBufferStorage(int bufferName) {
		return current.getBufferStorage(bufferName);
	}

	public void glGetTexEnvfv(int tenv, int pname, float[] params, int params_offset) {
		current.glGetTexEnvfv(tenv, pname, params, params_offset);
	}

	public void glGetTexEnviv(int tenv, int pname, IntBuffer params) {
		current.glGetTexEnviv(tenv, pname, params);
	}

	public GLBufferStorage mapBuffer(int target, int access) throws GLException {
		return current.mapBuffer(target, access);
	}

	public void glGetTexEnviv(int tenv, int pname, int[] params, int params_offset) {
		current.glGetTexEnviv(tenv, pname, params, params_offset);
	}

	public void glGetTexGenfv(int coord, int pname, FloatBuffer params) {
		current.glGetTexGenfv(coord, pname, params);
	}

	public void glGetTexGenfv(int coord, int pname, float[] params, int params_offset) {
		current.glGetTexGenfv(coord, pname, params, params_offset);
	}

	public GLBufferStorage mapBufferRange(int target, long offset, long length, int access) throws GLException {
		return current.mapBufferRange(target, offset, length, access);
	}

	public void glGetTexGeniv(int coord, int pname, IntBuffer params) {
		current.glGetTexGeniv(coord, pname, params);
	}

	public void glGetTexGeniv(int coord, int pname, int[] params, int params_offset) {
		current.glGetTexGeniv(coord, pname, params, params_offset);
	}

	public void glLightModelf(int pname, float param) {
		current.glLightModelf(pname, param);
	}

	public void glLightModelfv(int pname, FloatBuffer params) {
		current.glLightModelfv(pname, params);
	}

	public void glLightModelfv(int pname, float[] params, int params_offset) {
		current.glLightModelfv(pname, params, params_offset);
	}

	public boolean isVBOArrayBound() {
		return current.isVBOArrayBound();
	}

	public void glLightf(int light, int pname, float param) {
		current.glLightf(light, pname, param);
	}

	public boolean isVBOElementArrayBound() {
		return current.isVBOElementArrayBound();
	}

	public int getBoundFramebuffer(int target) {
		return current.getBoundFramebuffer(target);
	}

	public void glLogicOp(int opcode) {
		current.glLogicOp(opcode);
	}

	public int getDefaultDrawFramebuffer() {
		return current.getDefaultDrawFramebuffer();
	}

	public void glMultiTexCoord4f(int target, float s, float t, float r, float q) {
		current.glMultiTexCoord4f(target, s, t, r, q);
	}

	public int getDefaultReadFramebuffer() {
		return current.getDefaultReadFramebuffer();
	}

	public void glNormal3f(float nx, float ny, float nz) {
		current.glNormal3f(nx, ny, nz);
	}

	public int getDefaultReadBuffer() {
		return current.getDefaultReadBuffer();
	}

	public void glPointParameterf(int pname, float param) {
		current.glPointParameterf(pname, param);
	}

	public void glPointParameterfv(int pname, FloatBuffer params) {
		current.glPointParameterfv(pname, params);
	}

	public void glPointParameterfv(int pname, float[] params, int params_offset) {
		current.glPointParameterfv(pname, params, params_offset);
	}

	public void glPointSize(float size) {
		current.glPointSize(size);
	}

	public void glTexEnvf(int target, int pname, float param) {
		current.glTexEnvf(target, pname, param);
	}

	public void glTexEnvfv(int target, int pname, FloatBuffer params) {
		current.glTexEnvfv(target, pname, params);
	}

	public void glTexEnvfv(int target, int pname, float[] params, int params_offset) {
		current.glTexEnvfv(target, pname, params, params_offset);
	}

	public void glTexEnvi(int target, int pname, int param) {
		current.glTexEnvi(target, pname, param);
	}

	public void glTexEnviv(int target, int pname, IntBuffer params) {
		current.glTexEnviv(target, pname, params);
	}

	public void glTexEnviv(int target, int pname, int[] params, int params_offset) {
		current.glTexEnviv(target, pname, params, params_offset);
	}

	public void glTexGenf(int coord, int pname, float param) {
		current.glTexGenf(coord, pname, param);
	}

	public void glTexGenfv(int coord, int pname, FloatBuffer params) {
		current.glTexGenfv(coord, pname, params);
	}

	public void glTexGenfv(int coord, int pname, float[] params, int params_offset) {
		current.glTexGenfv(coord, pname, params, params_offset);
	}

	public void glTexGeni(int coord, int pname, int param) {
		current.glTexGeni(coord, pname, param);
	}

	public void glTexGeniv(int coord, int pname, IntBuffer params) {
		current.glTexGeniv(coord, pname, params);
	}

	public void glTexGeniv(int coord, int pname, int[] params, int params_offset) {
		current.glTexGeniv(coord, pname, params, params_offset);
	}

	public void glOrtho(double left, double right, double bottom, double top, double near_val, double far_val) {
		current.glOrtho(left, right, bottom, top, near_val, far_val);
	}

	public void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar) {
		current.glFrustum(left, right, bottom, top, zNear, zFar);
	}

	public void glDrawElements(int mode, int count, int type, Buffer indices) {
		current.glDrawElements(mode, count, type, indices);
	}

	public void glBeginTransformFeedback(int primitiveMode) {
		current.glBeginTransformFeedback(primitiveMode);
	}

	public void glBindBufferBase(int target, int index, int buffer) {
		current.glBindBufferBase(target, index, buffer);
	}

	public void glBindBufferRange(int target, int index, int buffer, long offset, long size) {
		current.glBindBufferRange(target, index, buffer, offset, size);
	}

	public void glBindVertexArray(int array) {
		current.glBindVertexArray(array);
	}

	public void glBeginConditionalRender(int id, int mode) {
		current.glBeginConditionalRender(id, mode);
	}

	public void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
		current.glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
	}

	public void glBindFragDataLocation(int program, int color, String name) {
		current.glBindFragDataLocation(program, color, name);
	}

	public void glBufferAddressRangeNV(int pname, int index, long address, long length) {
		current.glBufferAddressRangeNV(pname, index, address, length);
	}

	public void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil) {
		current.glClearBufferfi(buffer, drawbuffer, depth, stencil);
	}

	public void glClampColor(int target, int clamp) {
		current.glClampColor(target, clamp);
	}

	public void glClearBufferfv(int buffer, int drawbuffer, FloatBuffer value) {
		current.glClearBufferfv(buffer, drawbuffer, value);
	}

	public void glClearNamedBufferDataEXT(int buffer, int internalformat, int format, int type, Buffer data) {
		current.glClearNamedBufferDataEXT(buffer, internalformat, format, type, data);
	}

	public void glAttachShader(int program, int shader) {
		current.glAttachShader(program, shader);
	}

	public void glClearBufferfv(int buffer, int drawbuffer, float[] value, int value_offset) {
		current.glClearBufferfv(buffer, drawbuffer, value, value_offset);
	}

	public void glBeginQuery(int target, int id) {
		current.glBeginQuery(target, id);
	}

	public void glClearNamedBufferSubDataEXT(int buffer, int internalformat, int format, int type, long offset, long size, Buffer data) {
		current.glClearNamedBufferSubDataEXT(buffer, internalformat, format, type, offset, size, data);
	}

	public void glClearBufferiv(int buffer, int drawbuffer, IntBuffer value) {
		current.glClearBufferiv(buffer, drawbuffer, value);
	}

	public void glBindAttribLocation(int program, int index, String name) {
		current.glBindAttribLocation(program, index, name);
	}

	public void glColorFormatNV(int size, int type, int stride) {
		current.glColorFormatNV(size, type, stride);
	}

	public void glClearBufferiv(int buffer, int drawbuffer, int[] value, int value_offset) {
		current.glClearBufferiv(buffer, drawbuffer, value, value_offset);
	}

	public void glBlendColor(float red, float green, float blue, float alpha) {
		current.glBlendColor(red, green, blue, alpha);
	}

	public void glColorMaski(int index, boolean r, boolean g, boolean b, boolean a) {
		current.glColorMaski(index, r, g, b, a);
	}

	public void glClearBufferuiv(int buffer, int drawbuffer, IntBuffer value) {
		current.glClearBufferuiv(buffer, drawbuffer, value);
	}

	public void glCompileShader(int shader) {
		current.glCompileShader(shader);
	}

	public void glCompileShaderIncludeARB(int shader, int count, String[] path, IntBuffer length) {
		current.glCompileShaderIncludeARB(shader, count, path, length);
	}

	public void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Buffer data) {
		current.glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, imageSize, data);
	}

	public void glClearBufferuiv(int buffer, int drawbuffer, int[] value, int value_offset) {
		current.glClearBufferuiv(buffer, drawbuffer, value, value_offset);
	}

	public void glCompileShaderIncludeARB(int shader, int count, String[] path, int[] length, int length_offset) {
		current.glCompileShaderIncludeARB(shader, count, path, length, length_offset);
	}

	public void glCopyBufferSubData(int readTarget, int writeTarget, long readOffset, long writeOffset, long size) {
		current.glCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size);
	}

	public void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, long data_buffer_offset) {
		current.glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, imageSize, data_buffer_offset);
	}

	public void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, Buffer data) {
		current.glCompressedTexImage1D(target, level, internalformat, width, border, imageSize, data);
	}

	public void glDeleteVertexArrays(int n, IntBuffer arrays) {
		current.glDeleteVertexArrays(n, arrays);
	}

	public void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, long data_buffer_offset) {
		current.glCompressedTexImage1D(target, level, internalformat, width, border, imageSize, data_buffer_offset);
	}

	public void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Buffer data) {
		current.glCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
	}

	public void glDeleteVertexArrays(int n, int[] arrays, int arrays_offset) {
		current.glDeleteVertexArrays(n, arrays, arrays_offset);
	}

	public void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, Buffer data) {
		current.glCompressedTexSubImage1D(target, level, xoffset, width, format, imageSize, data);
	}

	public void glDrawArraysInstanced(int mode, int first, int count, int instancecount) {
		current.glDrawArraysInstanced(mode, first, count, instancecount);
	}

	public void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize,
			long data_buffer_offset) {
		current.glCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data_buffer_offset);
	}

	public void glDrawBuffers(int n, IntBuffer bufs) {
		current.glDrawBuffers(n, bufs);
	}

	public void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, long data_buffer_offset) {
		current.glCompressedTexSubImage1D(target, level, xoffset, width, format, imageSize, data_buffer_offset);
	}

	public void glDrawBuffers(int n, int[] bufs, int bufs_offset) {
		current.glDrawBuffers(n, bufs, bufs_offset);
	}

	public void glCopyTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
		current.glCopyTexSubImage3D(target, level, xoffset, yoffset, zoffset, x, y, width, height);
	}

	public void glCopyTexImage1D(int target, int level, int internalformat, int x, int y, int width, int border) {
		current.glCopyTexImage1D(target, level, internalformat, x, y, width, border);
	}

	public void glDrawElementsInstanced(int mode, int count, int type, long indices_buffer_offset, int instancecount) {
		current.glDrawElementsInstanced(mode, count, type, indices_buffer_offset, instancecount);
	}

	public void glCopyTexSubImage1D(int target, int level, int xoffset, int x, int y, int width) {
		current.glCopyTexSubImage1D(target, level, xoffset, x, y, width);
	}

	public int glCreateProgram() {
		return current.glCreateProgram();
	}

	public int glCreateShader(int type) {
		return current.glCreateShader(type);
	}

	public long glCreateSyncFromCLeventARB(long context, long event, int flags) {
		return current.glCreateSyncFromCLeventARB(context, event, flags);
	}

	public void glDrawRangeElements(int mode, int start, int end, int count, int type, long indices_buffer_offset) {
		current.glDrawRangeElements(mode, start, end, count, type, indices_buffer_offset);
	}

	public void glDebugMessageControl(int source, int type, int severity, int count, IntBuffer ids, boolean enabled) {
		current.glDebugMessageControl(source, type, severity, count, ids, enabled);
	}

	public void glDebugMessageEnableAMD(int category, int severity, int count, IntBuffer ids, boolean enabled) {
		current.glDebugMessageEnableAMD(category, severity, count, ids, enabled);
	}

	public void glEndTransformFeedback() {
		current.glEndTransformFeedback();
	}

	public void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) {
		current.glFramebufferTextureLayer(target, attachment, texture, level, layer);
	}

	public void glDebugMessageControl(int source, int type, int severity, int count, int[] ids, int ids_offset, boolean enabled) {
		current.glDebugMessageControl(source, type, severity, count, ids, ids_offset, enabled);
	}

	public void glDebugMessageEnableAMD(int category, int severity, int count, int[] ids, int ids_offset, boolean enabled) {
		current.glDebugMessageEnableAMD(category, severity, count, ids, ids_offset, enabled);
	}

	public void glGenVertexArrays(int n, IntBuffer arrays) {
		current.glGenVertexArrays(n, arrays);
	}

	public void glDebugMessageInsertAMD(int category, int severity, int id, int length, String buf) {
		current.glDebugMessageInsertAMD(category, severity, id, length, buf);
	}

	public void glDebugMessageInsert(int source, int type, int id, int severity, int length, String buf) {
		current.glDebugMessageInsert(source, type, id, severity, length, buf);
	}

	public void glDeleteNamedStringARB(int namelen, String name) {
		current.glDeleteNamedStringARB(namelen, name);
	}

	public void glGenVertexArrays(int n, int[] arrays, int arrays_offset) {
		current.glGenVertexArrays(n, arrays, arrays_offset);
	}

	public void glDeleteProgram(int program) {
		current.glDeleteProgram(program);
	}

	public void glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, IntBuffer length, ByteBuffer uniformBlockName) {
		current.glGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, length, uniformBlockName);
	}

	public void glDeleteQueries(int n, IntBuffer ids) {
		current.glDeleteQueries(n, ids);
	}

	public void glDisablei(int target, int index) {
		current.glDisablei(target, index);
	}

	public void glDrawBuffer(int mode) {
		current.glDrawBuffer(mode);
	}

	public void glDeleteQueries(int n, int[] ids, int ids_offset) {
		current.glDeleteQueries(n, ids, ids_offset);
	}

	public void glEdgeFlagFormatNV(int stride) {
		current.glEdgeFlagFormatNV(stride);
	}

	public void glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, int[] length, int length_offset, byte[] uniformBlockName, int uniformBlockName_offset) {
		current.glGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, length, length_offset, uniformBlockName, uniformBlockName_offset);
	}

	public void glDeleteShader(int shader) {
		current.glDeleteShader(shader);
	}

	public void glDetachShader(int program, int shader) {
		current.glDetachShader(program, shader);
	}

	public void glEnablei(int target, int index) {
		current.glEnablei(target, index);
	}

	public void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, IntBuffer params) {
		current.glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params);
	}

	public void glEndConditionalRender() {
		current.glEndConditionalRender();
	}

	public void glDisableVertexAttribArray(int index) {
		current.glDisableVertexAttribArray(index);
	}

	public void glFogCoordFormatNV(int type, int stride) {
		current.glFogCoordFormatNV(type, stride);
	}

	public void glEnableVertexAttribArray(int index) {
		current.glEnableVertexAttribArray(index);
	}

	public void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, int[] params, int params_offset) {
		current.glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params, params_offset);
	}

	public void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level) {
		current.glFramebufferTexture1D(target, attachment, textarget, texture, level);
	}

	public void glEndQuery(int target) {
		current.glEndQuery(target);
	}

	public void glGetActiveUniformsiv(int program, int uniformCount, IntBuffer uniformIndices, int pname, IntBuffer params) {
		current.glGetActiveUniformsiv(program, uniformCount, uniformIndices, pname, params);
	}

	public void glFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int zoffset) {
		current.glFramebufferTexture3D(target, attachment, textarget, texture, level, zoffset);
	}

	public void glFramebufferTextureARB(int target, int attachment, int texture, int level) {
		current.glFramebufferTextureARB(target, attachment, texture, level);
	}

	public void glFramebufferTextureFaceARB(int target, int attachment, int texture, int level, int face) {
		current.glFramebufferTextureFaceARB(target, attachment, texture, level, face);
	}

	public void glGenQueries(int n, IntBuffer ids) {
		current.glGenQueries(n, ids);
	}

	public void glGetActiveUniformsiv(int program, int uniformCount, int[] uniformIndices, int uniformIndices_offset, int pname, int[] params, int params_offset) {
		current.glGetActiveUniformsiv(program, uniformCount, uniformIndices, uniformIndices_offset, pname, params, params_offset);
	}

	public void glFramebufferTextureLayerARB(int target, int attachment, int texture, int level, int layer) {
		current.glFramebufferTextureLayerARB(target, attachment, texture, level, layer);
	}

	public void glGenQueries(int n, int[] ids, int ids_offset) {
		current.glGenQueries(n, ids, ids_offset);
	}

	public int glGetFragDataLocation(int program, String name) {
		return current.glGetFragDataLocation(program, name);
	}

	public void glGetActiveUniformName(int program, int uniformIndex, int bufSize, IntBuffer length, ByteBuffer uniformName) {
		current.glGetActiveUniformName(program, uniformIndex, bufSize, length, uniformName);
	}

	public void glGetActiveAttrib(int program, int index, int bufsize, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
		current.glGetActiveAttrib(program, index, bufsize, length, size, type, name);
	}

	public void glGetIntegeri_v(int target, int index, IntBuffer data) {
		current.glGetIntegeri_v(target, index, data);
	}

	public void glGetActiveUniformName(int program, int uniformIndex, int bufSize, int[] length, int length_offset, byte[] uniformName, int uniformName_offset) {
		current.glGetActiveUniformName(program, uniformIndex, bufSize, length, length_offset, uniformName, uniformName_offset);
	}

	public void glGetIntegeri_v(int target, int index, int[] data, int data_offset) {
		current.glGetIntegeri_v(target, index, data, data_offset);
	}

	public void glGetActiveAttrib(int program, int index, int bufsize, int[] length, int length_offset, int[] size, int size_offset, int[] type, int type_offset, byte[] name,
			int name_offset) {
		current.glGetActiveAttrib(program, index, bufsize, length, length_offset, size, size_offset, type, type_offset, name, name_offset);
	}

	public void glGetInternalformativ(int target, int internalformat, int pname, int bufSize, IntBuffer params) {
		current.glGetInternalformativ(target, internalformat, pname, bufSize, params);
	}

	public void glGetBooleani_v(int target, int index, ByteBuffer data) {
		current.glGetBooleani_v(target, index, data);
	}

	public void glGetBooleani_v(int target, int index, byte[] data, int data_offset) {
		current.glGetBooleani_v(target, index, data, data_offset);
	}

	public void glGetActiveUniform(int program, int index, int bufsize, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
		current.glGetActiveUniform(program, index, bufsize, length, size, type, name);
	}

	public void glGetInternalformativ(int target, int internalformat, int pname, int bufSize, int[] params, int params_offset) {
		current.glGetInternalformativ(target, internalformat, pname, bufSize, params, params_offset);
	}

	public void glGetBufferParameterui64vNV(int target, int pname, LongBuffer params) {
		current.glGetBufferParameterui64vNV(target, pname, params);
	}

	public String glGetStringi(int name, int index) {
		return current.glGetStringi(name, index);
	}

	public void glGetBufferParameterui64vNV(int target, int pname, long[] params, int params_offset) {
		current.glGetBufferParameterui64vNV(target, pname, params, params_offset);
	}

	public void glGetTransformFeedbackVarying(int program, int index, int bufSize, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
		current.glGetTransformFeedbackVarying(program, index, bufSize, length, size, type, name);
	}

	public void glGetActiveUniform(int program, int index, int bufsize, int[] length, int length_offset, int[] size, int size_offset, int[] type, int type_offset, byte[] name,
			int name_offset) {
		current.glGetActiveUniform(program, index, bufsize, length, length_offset, size, size_offset, type, type_offset, name, name_offset);
	}

	public void glGetBufferSubData(int target, long offset, long size, Buffer data) {
		current.glGetBufferSubData(target, offset, size, data);
	}

	public void glGetAttachedShaders(int program, int maxcount, IntBuffer count, IntBuffer shaders) {
		current.glGetAttachedShaders(program, maxcount, count, shaders);
	}

	public void glGetCompressedTexImage(int target, int level, Buffer img) {
		current.glGetCompressedTexImage(target, level, img);
	}

	public void glGetTransformFeedbackVarying(int program, int index, int bufSize, int[] length, int length_offset, int[] size, int size_offset, int[] type, int type_offset,
			byte[] name, int name_offset) {
		current.glGetTransformFeedbackVarying(program, index, bufSize, length, length_offset, size, size_offset, type, type_offset, name, name_offset);
	}

	public void glGetCompressedTexImage(int target, int level, long img_buffer_offset) {
		current.glGetCompressedTexImage(target, level, img_buffer_offset);
	}

	public void glGetAttachedShaders(int program, int maxcount, int[] count, int count_offset, int[] shaders, int shaders_offset) {
		current.glGetAttachedShaders(program, maxcount, count, count_offset, shaders, shaders_offset);
	}

	public int glGetDebugMessageLogAMD(int count, int bufsize, IntBuffer categories, IntBuffer severities, IntBuffer ids, IntBuffer lengths, ByteBuffer message) {
		return current.glGetDebugMessageLogAMD(count, bufsize, categories, severities, ids, lengths, message);
	}

	public int glGetUniformBlockIndex(int program, String uniformBlockName) {
		return current.glGetUniformBlockIndex(program, uniformBlockName);
	}

	public int glGetAttribLocation(int program, String name) {
		return current.glGetAttribLocation(program, name);
	}

	public void glGetUniformIndices(int program, int uniformCount, String[] uniformNames, IntBuffer uniformIndices) {
		current.glGetUniformIndices(program, uniformCount, uniformNames, uniformIndices);
	}

	public int glGetDebugMessageLog(int count, int bufsize, IntBuffer sources, IntBuffer types, IntBuffer ids, IntBuffer severities, IntBuffer lengths, ByteBuffer messageLog) {
		return current.glGetDebugMessageLog(count, bufsize, sources, types, ids, severities, lengths, messageLog);
	}

	public int glGetDebugMessageLogAMD(int count, int bufsize, int[] categories, int categories_offset, int[] severities, int severities_offset, int[] ids, int ids_offset,
			int[] lengths, int lengths_offset, byte[] message, int message_offset) {
		return current.glGetDebugMessageLogAMD(count, bufsize, categories, categories_offset, severities, severities_offset, ids, ids_offset, lengths, lengths_offset, message,
				message_offset);
	}

	public void glGetUniformIndices(int program, int uniformCount, String[] uniformNames, int[] uniformIndices, int uniformIndices_offset) {
		current.glGetUniformIndices(program, uniformCount, uniformNames, uniformIndices, uniformIndices_offset);
	}

	public void glGetDoublev(int pname, DoubleBuffer params) {
		current.glGetDoublev(pname, params);
	}

	public void glGetUniformuiv(int program, int location, IntBuffer params) {
		current.glGetUniformuiv(program, location, params);
	}

	public int glGetDebugMessageLog(int count, int bufsize, int[] sources, int sources_offset, int[] types, int types_offset, int[] ids, int ids_offset, int[] severities,
			int severities_offset, int[] lengths, int lengths_offset, byte[] messageLog, int messageLog_offset) {
		return current.glGetDebugMessageLog(count, bufsize, sources, sources_offset, types, types_offset, ids, ids_offset, severities, severities_offset, lengths, lengths_offset,
				messageLog, messageLog_offset);
	}

	public void glGetDoublev(int pname, double[] params, int params_offset) {
		current.glGetDoublev(pname, params, params_offset);
	}

	public void glGetUniformuiv(int program, int location, int[] params, int params_offset) {
		current.glGetUniformuiv(program, location, params, params_offset);
	}

	public void glGetIntegerui64i_vNV(int value, int index, LongBuffer result) {
		current.glGetIntegerui64i_vNV(value, index, result);
	}

	public void glGetObjectLabel(int identifier, int name, int bufSize, IntBuffer length, ByteBuffer label) {
		current.glGetObjectLabel(identifier, name, bufSize, length, label);
	}

	public void glGetVertexAttribIiv(int index, int pname, IntBuffer params) {
		current.glGetVertexAttribIiv(index, pname, params);
	}

	public void glGetIntegerui64i_vNV(int value, int index, long[] result, int result_offset) {
		current.glGetIntegerui64i_vNV(value, index, result, result_offset);
	}

	public void glGetVertexAttribIiv(int index, int pname, int[] params, int params_offset) {
		current.glGetVertexAttribIiv(index, pname, params, params_offset);
	}

	public void glGetIntegerui64vNV(int value, LongBuffer result) {
		current.glGetIntegerui64vNV(value, result);
	}

	public void glGetObjectLabel(int identifier, int name, int bufSize, int[] length, int length_offset, byte[] label, int label_offset) {
		current.glGetObjectLabel(identifier, name, bufSize, length, length_offset, label, label_offset);
	}

	public void glGetVertexAttribIuiv(int index, int pname, IntBuffer params) {
		current.glGetVertexAttribIuiv(index, pname, params);
	}

	public void glGetIntegerui64vNV(int value, long[] result, int result_offset) {
		current.glGetIntegerui64vNV(value, result, result_offset);
	}

	public void glGetObjectPtrLabel(Buffer ptr, int bufSize, IntBuffer length, ByteBuffer label) {
		current.glGetObjectPtrLabel(ptr, bufSize, length, label);
	}

	public void glGetNamedBufferParameterui64vNV(int buffer, int pname, LongBuffer params) {
		current.glGetNamedBufferParameterui64vNV(buffer, pname, params);
	}

	public void glGetVertexAttribIuiv(int index, int pname, int[] params, int params_offset) {
		current.glGetVertexAttribIuiv(index, pname, params, params_offset);
	}

	public boolean glIsVertexArray(int array) {
		return current.glIsVertexArray(array);
	}

	public void glGetNamedBufferParameterui64vNV(int buffer, int pname, long[] params, int params_offset) {
		current.glGetNamedBufferParameterui64vNV(buffer, pname, params, params_offset);
	}

	public void glGetObjectPtrLabel(Buffer ptr, int bufSize, int[] length, int length_offset, byte[] label, int label_offset) {
		current.glGetObjectPtrLabel(ptr, bufSize, length, length_offset, label, label_offset);
	}

	public void glReadBuffer(int mode) {
		current.glReadBuffer(mode);
	}

	public void glGetNamedFramebufferParameterivEXT(int framebuffer, int pname, IntBuffer params) {
		current.glGetNamedFramebufferParameterivEXT(framebuffer, pname, params);
	}

	public void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height) {
		current.glRenderbufferStorageMultisample(target, samples, internalformat, width, height);
	}

	public void glGetProgramBinary(int program, int bufSize, IntBuffer length, IntBuffer binaryFormat, Buffer binary) {
		current.glGetProgramBinary(program, bufSize, length, binaryFormat, binary);
	}

	public void glGetNamedFramebufferParameterivEXT(int framebuffer, int pname, int[] params, int params_offset) {
		current.glGetNamedFramebufferParameterivEXT(framebuffer, pname, params, params_offset);
	}

	public void glTransformFeedbackVaryings(int program, int count, String[] varyings, int bufferMode) {
		current.glTransformFeedbackVaryings(program, count, varyings, bufferMode);
	}

	public void glGetNamedStringARB(int namelen, String name, int bufSize, IntBuffer stringlen, ByteBuffer string) {
		current.glGetNamedStringARB(namelen, name, bufSize, stringlen, string);
	}

	public void glGetProgramBinary(int program, int bufSize, int[] length, int length_offset, int[] binaryFormat, int binaryFormat_offset, Buffer binary) {
		current.glGetProgramBinary(program, bufSize, length, length_offset, binaryFormat, binaryFormat_offset, binary);
	}

	public void glUniform1ui(int location, int v0) {
		current.glUniform1ui(location, v0);
	}

	public void glUniform1uiv(int location, int count, IntBuffer value) {
		current.glUniform1uiv(location, count, value);
	}

	public void glGetNamedStringARB(int namelen, String name, int bufSize, int[] stringlen, int stringlen_offset, byte[] string, int string_offset) {
		current.glGetNamedStringARB(namelen, name, bufSize, stringlen, stringlen_offset, string, string_offset);
	}

	public void glGetProgramInfoLog(int program, int bufsize, IntBuffer length, ByteBuffer infolog) {
		current.glGetProgramInfoLog(program, bufsize, length, infolog);
	}

	public void glUniform1uiv(int location, int count, int[] value, int value_offset) {
		current.glUniform1uiv(location, count, value, value_offset);
	}

	public void glGetNamedStringivARB(int namelen, String name, int pname, IntBuffer params) {
		current.glGetNamedStringivARB(namelen, name, pname, params);
	}

	public void glUniform2ui(int location, int v0, int v1) {
		current.glUniform2ui(location, v0, v1);
	}

	public void glGetProgramInfoLog(int program, int bufsize, int[] length, int length_offset, byte[] infolog, int infolog_offset) {
		current.glGetProgramInfoLog(program, bufsize, length, length_offset, infolog, infolog_offset);
	}

	public void glGetNamedStringivARB(int namelen, String name, int pname, int[] params, int params_offset) {
		current.glGetNamedStringivARB(namelen, name, pname, params, params_offset);
	}

	public void glUniform2uiv(int location, int count, IntBuffer value) {
		current.glUniform2uiv(location, count, value);
	}

	public void glGetProgramiv(int program, int pname, IntBuffer params) {
		current.glGetProgramiv(program, pname, params);
	}

	public void glGetQueryObjectiv(int id, int pname, IntBuffer params) {
		current.glGetQueryObjectiv(id, pname, params);
	}

	public void glUniform2uiv(int location, int count, int[] value, int value_offset) {
		current.glUniform2uiv(location, count, value, value_offset);
	}

	public void glGetProgramiv(int program, int pname, int[] params, int params_offset) {
		current.glGetProgramiv(program, pname, params, params_offset);
	}

	public void glGetQueryObjectiv(int id, int pname, int[] params, int params_offset) {
		current.glGetQueryObjectiv(id, pname, params, params_offset);
	}

	public void glUniform3ui(int location, int v0, int v1, int v2) {
		current.glUniform3ui(location, v0, v1, v2);
	}

	public void glGetTexImage(int target, int level, int format, int type, Buffer pixels) {
		current.glGetTexImage(target, level, format, type, pixels);
	}

	public void glGetQueryObjectuiv(int id, int pname, IntBuffer params) {
		current.glGetQueryObjectuiv(id, pname, params);
	}

	public void glActiveTexture(int texture) {
		current.glActiveTexture(texture);
	}

	public void glUniform3uiv(int location, int count, IntBuffer value) {
		current.glUniform3uiv(location, count, value);
	}

	public void glGetTexImage(int target, int level, int format, int type, long pixels_buffer_offset) {
		current.glGetTexImage(target, level, format, type, pixels_buffer_offset);
	}

	public void glBindBuffer(int target, int buffer) {
		current.glBindBuffer(target, buffer);
	}

	public void glGetQueryObjectuiv(int id, int pname, int[] params, int params_offset) {
		current.glGetQueryObjectuiv(id, pname, params, params_offset);
	}

	public void glGetTexLevelParameterfv(int target, int level, int pname, FloatBuffer params) {
		current.glGetTexLevelParameterfv(target, level, pname, params);
	}

	public void glUniform3uiv(int location, int count, int[] value, int value_offset) {
		current.glUniform3uiv(location, count, value, value_offset);
	}

	public void glBindFramebuffer(int target, int framebuffer) {
		current.glBindFramebuffer(target, framebuffer);
	}

	public void glGetQueryiv(int target, int pname, IntBuffer params) {
		current.glGetQueryiv(target, pname, params);
	}

	public void glUniform4ui(int location, int v0, int v1, int v2, int v3) {
		current.glUniform4ui(location, v0, v1, v2, v3);
	}

	public void glGetTexLevelParameterfv(int target, int level, int pname, float[] params, int params_offset) {
		current.glGetTexLevelParameterfv(target, level, pname, params, params_offset);
	}

	public void glBindRenderbuffer(int target, int renderbuffer) {
		current.glBindRenderbuffer(target, renderbuffer);
	}

	public void glGetQueryiv(int target, int pname, int[] params, int params_offset) {
		current.glGetQueryiv(target, pname, params, params_offset);
	}

	public void glUniform4uiv(int location, int count, IntBuffer value) {
		current.glUniform4uiv(location, count, value);
	}

	public void glGetTexLevelParameteriv(int target, int level, int pname, IntBuffer params) {
		current.glGetTexLevelParameteriv(target, level, pname, params);
	}

	public void glBindTexture(int target, int texture) {
		current.glBindTexture(target, texture);
	}

	public void glGetShaderInfoLog(int shader, int bufsize, IntBuffer length, ByteBuffer infolog) {
		current.glGetShaderInfoLog(shader, bufsize, length, infolog);
	}

	public void glBlendEquation(int mode) {
		current.glBlendEquation(mode);
	}

	public void glGetTexLevelParameteriv(int target, int level, int pname, int[] params, int params_offset) {
		current.glGetTexLevelParameteriv(target, level, pname, params, params_offset);
	}

	public void glUniform4uiv(int location, int count, int[] value, int value_offset) {
		current.glUniform4uiv(location, count, value, value_offset);
	}

	public void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
		current.glBlendEquationSeparate(modeRGB, modeAlpha);
	}

	public void glGetTexParameterIiv(int target, int pname, IntBuffer params) {
		current.glGetTexParameterIiv(target, pname, params);
	}

	public void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) {
		current.glUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding);
	}

	public void glGetShaderInfoLog(int shader, int bufsize, int[] length, int length_offset, byte[] infolog, int infolog_offset) {
		current.glGetShaderInfoLog(shader, bufsize, length, length_offset, infolog, infolog_offset);
	}

	public void glBlendFunc(int sfactor, int dfactor) {
		current.glBlendFunc(sfactor, dfactor);
	}

	public void glGetTexParameterIiv(int target, int pname, int[] params, int params_offset) {
		current.glGetTexParameterIiv(target, pname, params, params_offset);
	}

	public void glUniformMatrix2x3fv(int location, int count, boolean transpose, FloatBuffer value) {
		current.glUniformMatrix2x3fv(location, count, transpose, value);
	}

	public void glGetShaderSource(int shader, int bufsize, IntBuffer length, ByteBuffer source) {
		current.glGetShaderSource(shader, bufsize, length, source);
	}

	public void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
		current.glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
	}

	public void glGetTexParameterIuiv(int target, int pname, IntBuffer params) {
		current.glGetTexParameterIuiv(target, pname, params);
	}

	public void glUniformMatrix2x3fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glUniformMatrix2x3fv(location, count, transpose, value, value_offset);
	}

	public void glBufferData(int target, long size, Buffer data, int usage) {
		current.glBufferData(target, size, data, usage);
	}

	public void glGetShaderSource(int shader, int bufsize, int[] length, int length_offset, byte[] source, int source_offset) {
		current.glGetShaderSource(shader, bufsize, length, length_offset, source, source_offset);
	}

	public void glGetTexParameterIuiv(int target, int pname, int[] params, int params_offset) {
		current.glGetTexParameterIuiv(target, pname, params, params_offset);
	}

	public void glUniformMatrix2x4fv(int location, int count, boolean transpose, FloatBuffer value) {
		current.glUniformMatrix2x4fv(location, count, transpose, value);
	}

	public void glGetShaderiv(int shader, int pname, IntBuffer params) {
		current.glGetShaderiv(shader, pname, params);
	}

	public void glGetUniformui64vNV(int program, int location, LongBuffer params) {
		current.glGetUniformui64vNV(program, location, params);
	}

	public void glBufferSubData(int target, long offset, long size, Buffer data) {
		current.glBufferSubData(target, offset, size, data);
	}

	public void glUniformMatrix2x4fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glUniformMatrix2x4fv(location, count, transpose, value, value_offset);
	}

	public void glGetShaderiv(int shader, int pname, int[] params, int params_offset) {
		current.glGetShaderiv(shader, pname, params, params_offset);
	}

	public void glGetUniformui64vNV(int program, int location, long[] params, int params_offset) {
		current.glGetUniformui64vNV(program, location, params, params_offset);
	}

	public int glGetUniformLocation(int program, String name) {
		return current.glGetUniformLocation(program, name);
	}

	public void glUniformMatrix3x2fv(int location, int count, boolean transpose, FloatBuffer value) {
		current.glUniformMatrix3x2fv(location, count, transpose, value);
	}

	public int glCheckFramebufferStatus(int target) {
		return current.glCheckFramebufferStatus(target);
	}

	public void glGetVertexAttribdv(int index, int pname, DoubleBuffer params) {
		current.glGetVertexAttribdv(index, pname, params);
	}

	public void glGetUniformfv(int program, int location, FloatBuffer params) {
		current.glGetUniformfv(program, location, params);
	}

	public void glClear(int mask) {
		current.glClear(mask);
	}

	public void glGetVertexAttribdv(int index, int pname, double[] params, int params_offset) {
		current.glGetVertexAttribdv(index, pname, params, params_offset);
	}

	public void glUniformMatrix3x2fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glUniformMatrix3x2fv(location, count, transpose, value, value_offset);
	}

	public void glClearColor(float red, float green, float blue, float alpha) {
		current.glClearColor(red, green, blue, alpha);
	}

	public void glGetUniformfv(int program, int location, float[] params, int params_offset) {
		current.glGetUniformfv(program, location, params, params_offset);
	}

	public void glGetnCompressedTexImage(int target, int lod, int bufSize, Buffer img) {
		current.glGetnCompressedTexImage(target, lod, bufSize, img);
	}

	public void glUniformMatrix3x4fv(int location, int count, boolean transpose, FloatBuffer value) {
		current.glUniformMatrix3x4fv(location, count, transpose, value);
	}

	public void glClearDepthf(float depth) {
		current.glClearDepthf(depth);
	}

	public void glGetUniformiv(int program, int location, IntBuffer params) {
		current.glGetUniformiv(program, location, params);
	}

	public void glGetnTexImage(int target, int level, int format, int type, int bufSize, Buffer img) {
		current.glGetnTexImage(target, level, format, type, bufSize, img);
	}

	public void glUniformMatrix3x4fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glUniformMatrix3x4fv(location, count, transpose, value, value_offset);
	}

	public void glClearStencil(int s) {
		current.glClearStencil(s);
	}

	public void glGetUniformiv(int program, int location, int[] params, int params_offset) {
		current.glGetUniformiv(program, location, params, params_offset);
	}

	public void glGetnUniformdv(int program, int location, int bufSize, DoubleBuffer params) {
		current.glGetnUniformdv(program, location, bufSize, params);
	}

	public void glColorMask(boolean red, boolean green, boolean blue, boolean alpha) {
		current.glColorMask(red, green, blue, alpha);
	}

	public void glUniformMatrix4x2fv(int location, int count, boolean transpose, FloatBuffer value) {
		current.glUniformMatrix4x2fv(location, count, transpose, value);
	}

	public void glGetVertexAttribfv(int index, int pname, FloatBuffer params) {
		current.glGetVertexAttribfv(index, pname, params);
	}

	public void glGetnUniformdv(int program, int location, int bufSize, double[] params, int params_offset) {
		current.glGetnUniformdv(program, location, bufSize, params, params_offset);
	}

	public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, Buffer data) {
		current.glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data);
	}

	public void glGetVertexAttribfv(int index, int pname, float[] params, int params_offset) {
		current.glGetVertexAttribfv(index, pname, params, params_offset);
	}

	public void glUniformMatrix4x2fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glUniformMatrix4x2fv(location, count, transpose, value, value_offset);
	}

	public void glGetnUniformuiv(int program, int location, int bufSize, IntBuffer params) {
		current.glGetnUniformuiv(program, location, bufSize, params);
	}

	public void glGetVertexAttribiv(int index, int pname, IntBuffer params) {
		current.glGetVertexAttribiv(index, pname, params);
	}

	public void glUniformMatrix4x3fv(int location, int count, boolean transpose, FloatBuffer value) {
		current.glUniformMatrix4x3fv(location, count, transpose, value);
	}

	public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, long data_buffer_offset) {
		current.glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data_buffer_offset);
	}

	public void glGetnUniformuiv(int program, int location, int bufSize, int[] params, int params_offset) {
		current.glGetnUniformuiv(program, location, bufSize, params, params_offset);
	}

	public void glGetVertexAttribiv(int index, int pname, int[] params, int params_offset) {
		current.glGetVertexAttribiv(index, pname, params, params_offset);
	}

	public void glUniformMatrix4x3fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glUniformMatrix4x3fv(location, count, transpose, value, value_offset);
	}

	public long glImportSyncEXT(int external_sync_type, long external_sync, int flags) {
		return current.glImportSyncEXT(external_sync_type, external_sync, flags);
	}

	public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Buffer data) {
		current.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data);
	}

	public boolean glIsProgram(int program) {
		return current.glIsProgram(program);
	}

	public void glIndexFormatNV(int type, int stride) {
		current.glIndexFormatNV(type, stride);
	}

	public void glVertexAttribI4i(int index, int x, int y, int z, int w) {
		current.glVertexAttribI4i(index, x, y, z, w);
	}

	public boolean glIsQuery(int id) {
		return current.glIsQuery(id);
	}

	public boolean glIsBufferResidentNV(int target) {
		return current.glIsBufferResidentNV(target);
	}

	public void glVertexAttribI4iv(int index, IntBuffer v) {
		current.glVertexAttribI4iv(index, v);
	}

	public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, long data_buffer_offset) {
		current.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data_buffer_offset);
	}

	public boolean glIsShader(int shader) {
		return current.glIsShader(shader);
	}

	public boolean glIsEnabledi(int target, int index) {
		return current.glIsEnabledi(target, index);
	}

	public void glLinkProgram(int program) {
		current.glLinkProgram(program);
	}

	public void glVertexAttribI4iv(int index, int[] v, int v_offset) {
		current.glVertexAttribI4iv(index, v, v_offset);
	}

	public boolean glIsNamedBufferResidentNV(int buffer) {
		return current.glIsNamedBufferResidentNV(buffer);
	}

	public void glObjectLabel(int identifier, int name, int length, ByteBuffer label) {
		current.glObjectLabel(identifier, name, length, label);
	}

	public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border) {
		current.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border);
	}

	public boolean glIsNamedStringARB(int namelen, String name) {
		return current.glIsNamedStringARB(namelen, name);
	}

	public void glVertexAttribI4ui(int index, int x, int y, int z, int w) {
		current.glVertexAttribI4ui(index, x, y, z, w);
	}

	public void glVertexAttribI4uiv(int index, IntBuffer v) {
		current.glVertexAttribI4uiv(index, v);
	}

	public void glObjectLabel(int identifier, int name, int length, byte[] label, int label_offset) {
		current.glObjectLabel(identifier, name, length, label, label_offset);
	}

	public void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
		current.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
	}

	public void glMakeBufferNonResidentNV(int target) {
		current.glMakeBufferNonResidentNV(target);
	}

	public void glVertexAttribI4uiv(int index, int[] v, int v_offset) {
		current.glVertexAttribI4uiv(index, v, v_offset);
	}

	public void glMakeBufferResidentNV(int target, int access) {
		current.glMakeBufferResidentNV(target, access);
	}

	public void glObjectPtrLabel(Buffer ptr, int length, ByteBuffer label) {
		current.glObjectPtrLabel(ptr, length, label);
	}

	public void glCullFace(int mode) {
		current.glCullFace(mode);
	}

	public void glVertexAttribIPointer(int index, int size, int type, int stride, long pointer_buffer_offset) {
		current.glVertexAttribIPointer(index, size, type, stride, pointer_buffer_offset);
	}

	public void glMakeNamedBufferNonResidentNV(int buffer) {
		current.glMakeNamedBufferNonResidentNV(buffer);
	}

	public void glDeleteBuffers(int n, IntBuffer buffers) {
		current.glDeleteBuffers(n, buffers);
	}

	public void glObjectPtrLabel(Buffer ptr, int length, byte[] label, int label_offset) {
		current.glObjectPtrLabel(ptr, length, label, label_offset);
	}

	public void glMakeNamedBufferResidentNV(int buffer, int access) {
		current.glMakeNamedBufferResidentNV(buffer, access);
	}

	public void glMultiDrawArrays(int mode, IntBuffer first, IntBuffer count, int drawcount) {
		current.glMultiDrawArrays(mode, first, count, drawcount);
	}

	public void glDeleteBuffers(int n, int[] buffers, int buffers_offset) {
		current.glDeleteBuffers(n, buffers, buffers_offset);
	}

	public void glPopDebugGroup() {
		current.glPopDebugGroup();
	}

	public boolean isPBOPackBound() {
		return current.isPBOPackBound();
	}

	public boolean isPBOUnpackBound() {
		return current.isPBOUnpackBound();
	}

	public void glDeleteFramebuffers(int n, IntBuffer framebuffers) {
		current.glDeleteFramebuffers(n, framebuffers);
	}

	public void glProgramBinary(int program, int binaryFormat, Buffer binary, int length) {
		current.glProgramBinary(program, binaryFormat, binary, length);
	}

	public void glMultiDrawArrays(int mode, int[] first, int first_offset, int[] count, int count_offset, int drawcount) {
		current.glMultiDrawArrays(mode, first, first_offset, count, count_offset, drawcount);
	}

	public void glMultiDrawArraysIndirectAMD(int mode, Buffer indirect, int primcount, int stride) {
		current.glMultiDrawArraysIndirectAMD(mode, indirect, primcount, stride);
	}

	public void glDeleteFramebuffers(int n, int[] framebuffers, int framebuffers_offset) {
		current.glDeleteFramebuffers(n, framebuffers, framebuffers_offset);
	}

	public void glPushDebugGroup(int source, int id, int length, ByteBuffer message) {
		current.glPushDebugGroup(source, id, length, message);
	}

	public void glDeleteRenderbuffers(int n, IntBuffer renderbuffers) {
		current.glDeleteRenderbuffers(n, renderbuffers);
	}

	public void glMultiDrawElements(int mode, IntBuffer count, int type, PointerBuffer indices, int drawcount) {
		current.glMultiDrawElements(mode, count, type, indices, drawcount);
	}

	public void glPushDebugGroup(int source, int id, int length, byte[] message, int message_offset) {
		current.glPushDebugGroup(source, id, length, message, message_offset);
	}

	public void glDeleteRenderbuffers(int n, int[] renderbuffers, int renderbuffers_offset) {
		current.glDeleteRenderbuffers(n, renderbuffers, renderbuffers_offset);
	}

	public void glShaderSource(int shader, int count, String[] string, IntBuffer length) {
		current.glShaderSource(shader, count, string, length);
	}

	public void glMultiDrawElementsIndirectAMD(int mode, int type, Buffer indirect, int primcount, int stride) {
		current.glMultiDrawElementsIndirectAMD(mode, type, indirect, primcount, stride);
	}

	public void glDeleteTextures(int n, IntBuffer textures) {
		current.glDeleteTextures(n, textures);
	}

	public void glShaderSource(int shader, int count, String[] string, int[] length, int length_offset) {
		current.glShaderSource(shader, count, string, length, length_offset);
	}

	public void glNamedFramebufferParameteriEXT(int framebuffer, int pname, int param) {
		current.glNamedFramebufferParameteriEXT(framebuffer, pname, param);
	}

	public void glDeleteTextures(int n, int[] textures, int textures_offset) {
		current.glDeleteTextures(n, textures, textures_offset);
	}

	public void glStencilFuncSeparate(int face, int func, int ref, int mask) {
		current.glStencilFuncSeparate(face, func, ref, mask);
	}

	public void glNamedStringARB(int type, int namelen, String name, int stringlen, String string) {
		current.glNamedStringARB(type, namelen, name, stringlen, string);
	}

	public void glStencilMaskSeparate(int face, int mask) {
		current.glStencilMaskSeparate(face, mask);
	}

	public void glDepthFunc(int func) {
		current.glDepthFunc(func);
	}

	public void glNormalFormatNV(int type, int stride) {
		current.glNormalFormatNV(type, stride);
	}

	public void glStencilOpSeparate(int face, int fail, int zfail, int zpass) {
		current.glStencilOpSeparate(face, fail, zfail, zpass);
	}

	public void glDepthMask(boolean flag) {
		current.glDepthMask(flag);
	}

	public void glPixelStoref(int pname, float param) {
		current.glPixelStoref(pname, param);
	}

	public void glDepthRangef(float zNear, float zFar) {
		current.glDepthRangef(zNear, zFar);
	}

	public void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, Buffer pixels) {
		current.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, pixels);
	}

	public void glDisable(int cap) {
		current.glDisable(cap);
	}

	public void glDrawArrays(int mode, int first, int count) {
		current.glDrawArrays(mode, first, count);
	}

	public void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, long pixels_buffer_offset) {
		current.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, pixels_buffer_offset);
	}

	public void glDrawElements(int mode, int count, int type, long indices_buffer_offset) {
		current.glDrawElements(mode, count, type, indices_buffer_offset);
	}

	public void glPointParameteri(int pname, int param) {
		current.glPointParameteri(pname, param);
	}

	public void glPointParameteriv(int pname, IntBuffer params) {
		current.glPointParameteriv(pname, params);
	}

	public void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Buffer pixels) {
		current.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
	}

	public void glEnable(int cap) {
		current.glEnable(cap);
	}

	public void glPointParameteriv(int pname, int[] params, int params_offset) {
		current.glPointParameteriv(pname, params, params_offset);
	}

	public void glFinish() {
		current.glFinish();
	}

	public void glFlush() {
		current.glFlush();
	}

	public void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, long pixels_buffer_offset) {
		current.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels_buffer_offset);
	}

	public void glPolygonMode(int face, int mode) {
		current.glPolygonMode(face, mode);
	}

	public void glFlushMappedBufferRange(int target, long offset, long length) {
		current.glFlushMappedBufferRange(target, offset, length);
	}

	public void glPrimitiveRestartIndex(int index) {
		current.glPrimitiveRestartIndex(index);
	}

	public void glUniform1f(int location, float x) {
		current.glUniform1f(location, x);
	}

	public void glProgramParameteriARB(int program, int pname, int value) {
		current.glProgramParameteriARB(program, pname, value);
	}

	public void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
		current.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
	}

	public void glUniform1fv(int location, int count, FloatBuffer v) {
		current.glUniform1fv(location, count, v);
	}

	public void glProgramUniformui64NV(int program, int location, long value) {
		current.glProgramUniformui64NV(program, location, value);
	}

	public void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
		current.glFramebufferTexture2D(target, attachment, textarget, texture, level);
	}

	public void glProgramUniformui64vNV(int program, int location, int count, LongBuffer value) {
		current.glProgramUniformui64vNV(program, location, count, value);
	}

	public void glUniform1fv(int location, int count, float[] v, int v_offset) {
		current.glUniform1fv(location, count, v, v_offset);
	}

	public void glUniform1i(int location, int x) {
		current.glUniform1i(location, x);
	}

	public void glFrontFace(int mode) {
		current.glFrontFace(mode);
	}

	public void glProgramUniformui64vNV(int program, int location, int count, long[] value, int value_offset) {
		current.glProgramUniformui64vNV(program, location, count, value, value_offset);
	}

	public void glUniform1iv(int location, int count, IntBuffer v) {
		current.glUniform1iv(location, count, v);
	}

	public void glGenBuffers(int n, IntBuffer buffers) {
		current.glGenBuffers(n, buffers);
	}

	public void glSecondaryColorFormatNV(int size, int type, int stride) {
		current.glSecondaryColorFormatNV(size, type, stride);
	}

	public void glUniform1iv(int location, int count, int[] v, int v_offset) {
		current.glUniform1iv(location, count, v, v_offset);
	}

	public void glGenBuffers(int n, int[] buffers, int buffers_offset) {
		current.glGenBuffers(n, buffers, buffers_offset);
	}

	public void glSetMultisamplefvAMD(int pname, int index, FloatBuffer val) {
		current.glSetMultisamplefvAMD(pname, index, val);
	}

	public void glUniform2f(int location, float x, float y) {
		current.glUniform2f(location, x, y);
	}

	public void glGenFramebuffers(int n, IntBuffer framebuffers) {
		current.glGenFramebuffers(n, framebuffers);
	}

	public void glSetMultisamplefvAMD(int pname, int index, float[] val, int val_offset) {
		current.glSetMultisamplefvAMD(pname, index, val, val_offset);
	}

	public void glUniform2fv(int location, int count, FloatBuffer v) {
		current.glUniform2fv(location, count, v);
	}

	public void glStencilOpValueAMD(int face, int value) {
		current.glStencilOpValueAMD(face, value);
	}

	public void glGenFramebuffers(int n, int[] framebuffers, int framebuffers_offset) {
		current.glGenFramebuffers(n, framebuffers, framebuffers_offset);
	}

	public void glUniform2fv(int location, int count, float[] v, int v_offset) {
		current.glUniform2fv(location, count, v, v_offset);
	}

	public void glTessellationFactorAMD(float factor) {
		current.glTessellationFactorAMD(factor);
	}

	public void glGenRenderbuffers(int n, IntBuffer renderbuffers) {
		current.glGenRenderbuffers(n, renderbuffers);
	}

	public void glUniform2i(int location, int x, int y) {
		current.glUniform2i(location, x, y);
	}

	public void glTessellationModeAMD(int mode) {
		current.glTessellationModeAMD(mode);
	}

	public void glUniform2iv(int location, int count, IntBuffer v) {
		current.glUniform2iv(location, count, v);
	}

	public void glTexBuffer(int target, int internalformat, int buffer) {
		current.glTexBuffer(target, internalformat, buffer);
	}

	public void glGenRenderbuffers(int n, int[] renderbuffers, int renderbuffers_offset) {
		current.glGenRenderbuffers(n, renderbuffers, renderbuffers_offset);
	}

	public void glUniform2iv(int location, int count, int[] v, int v_offset) {
		current.glUniform2iv(location, count, v, v_offset);
	}

	public void glTexCoordFormatNV(int size, int type, int stride) {
		current.glTexCoordFormatNV(size, type, stride);
	}

	public void glGenTextures(int n, IntBuffer textures) {
		current.glGenTextures(n, textures);
	}

	public void glUniform3f(int location, float x, float y, float z) {
		current.glUniform3f(location, x, y, z);
	}

	public void glTexImage1D(int target, int level, int internalFormat, int width, int border, int format, int type, Buffer pixels) {
		current.glTexImage1D(target, level, internalFormat, width, border, format, type, pixels);
	}

	public void glGenTextures(int n, int[] textures, int textures_offset) {
		current.glGenTextures(n, textures, textures_offset);
	}

	public void glUniform3fv(int location, int count, FloatBuffer v) {
		current.glUniform3fv(location, count, v);
	}

	public void glTexImage1D(int target, int level, int internalFormat, int width, int border, int format, int type, long pixels_buffer_offset) {
		current.glTexImage1D(target, level, internalFormat, width, border, format, type, pixels_buffer_offset);
	}

	public void glGenerateMipmap(int target) {
		current.glGenerateMipmap(target);
	}

	public void glUniform3fv(int location, int count, float[] v, int v_offset) {
		current.glUniform3fv(location, count, v, v_offset);
	}

	public void glGetBooleanv(int pname, ByteBuffer params) {
		current.glGetBooleanv(pname, params);
	}

	public void glTexImage2DMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, boolean fixedSampleLocations) {
		current.glTexImage2DMultisampleCoverageNV(target, coverageSamples, colorSamples, internalFormat, width, height, fixedSampleLocations);
	}

	public void glUniform3i(int location, int x, int y, int z) {
		current.glUniform3i(location, x, y, z);
	}

	public void glUniform3iv(int location, int count, IntBuffer v) {
		current.glUniform3iv(location, count, v);
	}

	public void glGetBooleanv(int pname, byte[] params, int params_offset) {
		current.glGetBooleanv(pname, params, params_offset);
	}

	public void glTexImage3DMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, int depth,
			boolean fixedSampleLocations) {
		current.glTexImage3DMultisampleCoverageNV(target, coverageSamples, colorSamples, internalFormat, width, height, depth, fixedSampleLocations);
	}

	public void glGetBufferParameteriv(int target, int pname, IntBuffer params) {
		current.glGetBufferParameteriv(target, pname, params);
	}

	public void glUniform3iv(int location, int count, int[] v, int v_offset) {
		current.glUniform3iv(location, count, v, v_offset);
	}

	public void glUniform4f(int location, float x, float y, float z, float w) {
		current.glUniform4f(location, x, y, z, w);
	}

	public void glTexParameterIiv(int target, int pname, IntBuffer params) {
		current.glTexParameterIiv(target, pname, params);
	}

	public void glGetBufferParameteriv(int target, int pname, int[] params, int params_offset) {
		current.glGetBufferParameteriv(target, pname, params, params_offset);
	}

	public void glUniform4fv(int location, int count, FloatBuffer v) {
		current.glUniform4fv(location, count, v);
	}

	public void glTexParameterIiv(int target, int pname, int[] params, int params_offset) {
		current.glTexParameterIiv(target, pname, params, params_offset);
	}

	public int glGetError() {
		return current.glGetError();
	}

	public void glUniform4fv(int location, int count, float[] v, int v_offset) {
		current.glUniform4fv(location, count, v, v_offset);
	}

	public void glGetFloatv(int pname, FloatBuffer params) {
		current.glGetFloatv(pname, params);
	}

	public void glTexParameterIuiv(int target, int pname, IntBuffer params) {
		current.glTexParameterIuiv(target, pname, params);
	}

	public void glUniform4i(int location, int x, int y, int z, int w) {
		current.glUniform4i(location, x, y, z, w);
	}

	public void glGetFloatv(int pname, float[] params, int params_offset) {
		current.glGetFloatv(pname, params, params_offset);
	}

	public void glTexParameterIuiv(int target, int pname, int[] params, int params_offset) {
		current.glTexParameterIuiv(target, pname, params, params_offset);
	}

	public void glUniform4iv(int location, int count, IntBuffer v) {
		current.glUniform4iv(location, count, v);
	}

	public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, IntBuffer params) {
		current.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
	}

	public void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, Buffer pixels) {
		current.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
	}

	public void glUniform4iv(int location, int count, int[] v, int v_offset) {
		current.glUniform4iv(location, count, v, v_offset);
	}

	public void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, long pixels_buffer_offset) {
		current.glTexSubImage1D(target, level, xoffset, width, format, type, pixels_buffer_offset);
	}

	public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, int[] params, int params_offset) {
		current.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params, params_offset);
	}

	public void glUniformMatrix2fv(int location, int count, boolean transpose, FloatBuffer value) {
		current.glUniformMatrix2fv(location, count, transpose, value);
	}

	public void glTextureBufferRangeEXT(int texture, int target, int internalformat, int buffer, long offset, long size) {
		current.glTextureBufferRangeEXT(texture, target, internalformat, buffer, offset, size);
	}

	public void glUniformMatrix2fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glUniformMatrix2fv(location, count, transpose, value, value_offset);
	}

	public int glGetGraphicsResetStatus() {
		return current.glGetGraphicsResetStatus();
	}

	public void glGetIntegerv(int pname, IntBuffer params) {
		current.glGetIntegerv(pname, params);
	}

	public void glTextureImage2DMultisampleCoverageNV(int texture, int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height,
			boolean fixedSampleLocations) {
		current.glTextureImage2DMultisampleCoverageNV(texture, target, coverageSamples, colorSamples, internalFormat, width, height, fixedSampleLocations);
	}

	public void glUniformMatrix3fv(int location, int count, boolean transpose, FloatBuffer value) {
		current.glUniformMatrix3fv(location, count, transpose, value);
	}

	public void glGetIntegerv(int pname, int[] params, int params_offset) {
		current.glGetIntegerv(pname, params, params_offset);
	}

	public void glUniformMatrix3fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glUniformMatrix3fv(location, count, transpose, value, value_offset);
	}

	public void glTextureImage2DMultisampleNV(int texture, int target, int samples, int internalFormat, int width, int height, boolean fixedSampleLocations) {
		current.glTextureImage2DMultisampleNV(texture, target, samples, internalFormat, width, height, fixedSampleLocations);
	}

	public void glGetRenderbufferParameteriv(int target, int pname, IntBuffer params) {
		current.glGetRenderbufferParameteriv(target, pname, params);
	}

	public void glUniformMatrix4fv(int location, int count, boolean transpose, FloatBuffer value) {
		current.glUniformMatrix4fv(location, count, transpose, value);
	}

	public void glTextureImage3DMultisampleCoverageNV(int texture, int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, int depth,
			boolean fixedSampleLocations) {
		current.glTextureImage3DMultisampleCoverageNV(texture, target, coverageSamples, colorSamples, internalFormat, width, height, depth, fixedSampleLocations);
	}

	public void glGetRenderbufferParameteriv(int target, int pname, int[] params, int params_offset) {
		current.glGetRenderbufferParameteriv(target, pname, params, params_offset);
	}

	public void glUniformMatrix4fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glUniformMatrix4fv(location, count, transpose, value, value_offset);
	}

	public String glGetString(int name) {
		return current.glGetString(name);
	}

	public void glTextureImage3DMultisampleNV(int texture, int target, int samples, int internalFormat, int width, int height, int depth, boolean fixedSampleLocations) {
		current.glTextureImage3DMultisampleNV(texture, target, samples, internalFormat, width, height, depth, fixedSampleLocations);
	}

	public void glUseProgram(int program) {
		current.glUseProgram(program);
	}

	public void glGetTexParameterfv(int target, int pname, FloatBuffer params) {
		current.glGetTexParameterfv(target, pname, params);
	}

	public void glValidateProgram(int program) {
		current.glValidateProgram(program);
	}

	public void glUniformui64NV(int location, long value) {
		current.glUniformui64NV(location, value);
	}

	public void glVertexAttrib1f(int indx, float x) {
		current.glVertexAttrib1f(indx, x);
	}

	public void glGetTexParameterfv(int target, int pname, float[] params, int params_offset) {
		current.glGetTexParameterfv(target, pname, params, params_offset);
	}

	public void glUniformui64vNV(int location, int count, LongBuffer value) {
		current.glUniformui64vNV(location, count, value);
	}

	public void glVertexAttrib1fv(int indx, FloatBuffer values) {
		current.glVertexAttrib1fv(indx, values);
	}

	public void glGetTexParameteriv(int target, int pname, IntBuffer params) {
		current.glGetTexParameteriv(target, pname, params);
	}

	public void glUniformui64vNV(int location, int count, long[] value, int value_offset) {
		current.glUniformui64vNV(location, count, value, value_offset);
	}

	public void glVertexAttrib1fv(int indx, float[] values, int values_offset) {
		current.glVertexAttrib1fv(indx, values, values_offset);
	}

	public void glVertexArrayBindVertexBufferEXT(int vaobj, int bindingindex, int buffer, long offset, int stride) {
		current.glVertexArrayBindVertexBufferEXT(vaobj, bindingindex, buffer, offset, stride);
	}

	public void glGetTexParameteriv(int target, int pname, int[] params, int params_offset) {
		current.glGetTexParameteriv(target, pname, params, params_offset);
	}

	public void glVertexAttrib2f(int indx, float x, float y) {
		current.glVertexAttrib2f(indx, x, y);
	}

	public void glVertexAttrib2fv(int indx, FloatBuffer values) {
		current.glVertexAttrib2fv(indx, values);
	}

	public void glGetnUniformfv(int program, int location, int bufSize, FloatBuffer params) {
		current.glGetnUniformfv(program, location, bufSize, params);
	}

	public void glVertexArrayVertexAttribBindingEXT(int vaobj, int attribindex, int bindingindex) {
		current.glVertexArrayVertexAttribBindingEXT(vaobj, attribindex, bindingindex);
	}

	public void glVertexAttrib2fv(int indx, float[] values, int values_offset) {
		current.glVertexAttrib2fv(indx, values, values_offset);
	}

	public void glVertexArrayVertexAttribFormatEXT(int vaobj, int attribindex, int size, int type, boolean normalized, int relativeoffset) {
		current.glVertexArrayVertexAttribFormatEXT(vaobj, attribindex, size, type, normalized, relativeoffset);
	}

	public void glGetnUniformfv(int program, int location, int bufSize, float[] params, int params_offset) {
		current.glGetnUniformfv(program, location, bufSize, params, params_offset);
	}

	public void glVertexAttrib3f(int indx, float x, float y, float z) {
		current.glVertexAttrib3f(indx, x, y, z);
	}

	public void glGetnUniformiv(int program, int location, int bufSize, IntBuffer params) {
		current.glGetnUniformiv(program, location, bufSize, params);
	}

	public void glVertexArrayVertexAttribIFormatEXT(int vaobj, int attribindex, int size, int type, int relativeoffset) {
		current.glVertexArrayVertexAttribIFormatEXT(vaobj, attribindex, size, type, relativeoffset);
	}

	public void glVertexAttrib3fv(int indx, FloatBuffer values) {
		current.glVertexAttrib3fv(indx, values);
	}

	public void glVertexArrayVertexAttribLFormatEXT(int vaobj, int attribindex, int size, int type, int relativeoffset) {
		current.glVertexArrayVertexAttribLFormatEXT(vaobj, attribindex, size, type, relativeoffset);
	}

	public void glGetnUniformiv(int program, int location, int bufSize, int[] params, int params_offset) {
		current.glGetnUniformiv(program, location, bufSize, params, params_offset);
	}

	public void glVertexAttrib3fv(int indx, float[] values, int values_offset) {
		current.glVertexAttrib3fv(indx, values, values_offset);
	}

	public void glHint(int target, int mode) {
		current.glHint(target, mode);
	}

	public void glVertexAttrib4f(int indx, float x, float y, float z, float w) {
		current.glVertexAttrib4f(indx, x, y, z, w);
	}

	public void glVertexArrayVertexBindingDivisorEXT(int vaobj, int bindingindex, int divisor) {
		current.glVertexArrayVertexBindingDivisorEXT(vaobj, bindingindex, divisor);
	}

	public boolean glIsBuffer(int buffer) {
		return current.glIsBuffer(buffer);
	}

	public void glVertexAttrib4fv(int indx, FloatBuffer values) {
		current.glVertexAttrib4fv(indx, values);
	}

	public void glVertexAttrib1d(int index, double x) {
		current.glVertexAttrib1d(index, x);
	}

	public boolean glIsEnabled(int cap) {
		return current.glIsEnabled(cap);
	}

	public void glVertexAttrib1dv(int index, DoubleBuffer v) {
		current.glVertexAttrib1dv(index, v);
	}

	public void glVertexAttrib4fv(int indx, float[] values, int values_offset) {
		current.glVertexAttrib4fv(indx, values, values_offset);
	}

	public boolean glIsFramebuffer(int framebuffer) {
		return current.glIsFramebuffer(framebuffer);
	}

	public void glVertexAttrib1dv(int index, double[] v, int v_offset) {
		current.glVertexAttrib1dv(index, v, v_offset);
	}

	public void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, long ptr_buffer_offset) {
		current.glVertexAttribPointer(indx, size, type, normalized, stride, ptr_buffer_offset);
	}

	public void glVertexAttrib1s(int index, short x) {
		current.glVertexAttrib1s(index, x);
	}

	public boolean glIsRenderbuffer(int renderbuffer) {
		return current.glIsRenderbuffer(renderbuffer);
	}

	public void glVertexAttrib1sv(int index, ShortBuffer v) {
		current.glVertexAttrib1sv(index, v);
	}

	public boolean glIsTexture(int texture) {
		return current.glIsTexture(texture);
	}

	public void glReleaseShaderCompiler() {
		current.glReleaseShaderCompiler();
	}

	public void glVertexAttrib1sv(int index, short[] v, int v_offset) {
		current.glVertexAttrib1sv(index, v, v_offset);
	}

	public void glLineWidth(float width) {
		current.glLineWidth(width);
	}

	public void glVertexAttrib2d(int index, double x, double y) {
		current.glVertexAttrib2d(index, x, y);
	}

	public void glShaderBinary(int n, IntBuffer shaders, int binaryformat, Buffer binary, int length) {
		current.glShaderBinary(n, shaders, binaryformat, binary, length);
	}

	public ByteBuffer glMapBuffer(int target, int access) {
		return current.glMapBuffer(target, access);
	}

	public void glVertexAttrib2dv(int index, DoubleBuffer v) {
		current.glVertexAttrib2dv(index, v);
	}

	public void glVertexAttrib2dv(int index, double[] v, int v_offset) {
		current.glVertexAttrib2dv(index, v, v_offset);
	}

	public void glShaderBinary(int n, int[] shaders, int shaders_offset, int binaryformat, Buffer binary, int length) {
		current.glShaderBinary(n, shaders, shaders_offset, binaryformat, binary, length);
	}

	public void glVertexAttrib2s(int index, short x, short y) {
		current.glVertexAttrib2s(index, x, y);
	}

	public ByteBuffer glMapBufferRange(int target, long offset, long length, int access) {
		return current.glMapBufferRange(target, offset, length, access);
	}

	public void glVertexAttrib2sv(int index, ShortBuffer v) {
		current.glVertexAttrib2sv(index, v);
	}

	public void glGetShaderPrecisionFormat(int shadertype, int precisiontype, IntBuffer range, IntBuffer precision) {
		current.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
	}

	public void glVertexAttrib2sv(int index, short[] v, int v_offset) {
		current.glVertexAttrib2sv(index, v, v_offset);
	}

	public void glVertexAttrib3d(int index, double x, double y, double z) {
		current.glVertexAttrib3d(index, x, y, z);
	}

	public void glGetShaderPrecisionFormat(int shadertype, int precisiontype, int[] range, int range_offset, int[] precision, int precision_offset) {
		current.glGetShaderPrecisionFormat(shadertype, precisiontype, range, range_offset, precision, precision_offset);
	}

	public void glVertexAttrib3dv(int index, DoubleBuffer v) {
		current.glVertexAttrib3dv(index, v);
	}

	public void glPixelStorei(int pname, int param) {
		current.glPixelStorei(pname, param);
	}

	public void glPolygonOffset(float factor, float units) {
		current.glPolygonOffset(factor, units);
	}

	public void glVertexAttrib3dv(int index, double[] v, int v_offset) {
		current.glVertexAttrib3dv(index, v, v_offset);
	}

	public void glVertexAttrib3s(int index, short x, short y, short z) {
		current.glVertexAttrib3s(index, x, y, z);
	}

	public void glReadPixels(int x, int y, int width, int height, int format, int type, Buffer pixels) {
		current.glReadPixels(x, y, width, height, format, type, pixels);
	}

	public void glVertexAttrib3sv(int index, ShortBuffer v) {
		current.glVertexAttrib3sv(index, v);
	}

	public void glReadPixels(int x, int y, int width, int height, int format, int type, long pixels_buffer_offset) {
		current.glReadPixels(x, y, width, height, format, type, pixels_buffer_offset);
	}

	public void glVertexAttrib3sv(int index, short[] v, int v_offset) {
		current.glVertexAttrib3sv(index, v, v_offset);
	}

	public void glVertexAttribPointer(GLArrayData array) {
		current.glVertexAttribPointer(array);
	}

	public void glUniform(GLUniformData data) {
		current.glUniform(data);
	}

	public void glVertexAttrib4Nbv(int index, ByteBuffer v) {
		current.glVertexAttrib4Nbv(index, v);
	}

	public void glReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, Buffer data) {
		current.glReadnPixels(x, y, width, height, format, type, bufSize, data);
	}

	public void glVertexAttrib4Nbv(int index, byte[] v, int v_offset) {
		current.glVertexAttrib4Nbv(index, v, v_offset);
	}

	public void glVertexAttrib4Niv(int index, IntBuffer v) {
		current.glVertexAttrib4Niv(index, v);
	}

	public void glRenderbufferStorage(int target, int internalformat, int width, int height) {
		current.glRenderbufferStorage(target, internalformat, width, height);
	}

	public void glVertexAttrib4Niv(int index, int[] v, int v_offset) {
		current.glVertexAttrib4Niv(index, v, v_offset);
	}

	public void glSampleCoverage(float value, boolean invert) {
		current.glSampleCoverage(value, invert);
	}

	public void glVertexAttrib4Nsv(int index, ShortBuffer v) {
		current.glVertexAttrib4Nsv(index, v);
	}

	public void glScissor(int x, int y, int width, int height) {
		current.glScissor(x, y, width, height);
	}

	public void glVertexAttrib4Nsv(int index, short[] v, int v_offset) {
		current.glVertexAttrib4Nsv(index, v, v_offset);
	}

	public void glStencilFunc(int func, int ref, int mask) {
		current.glStencilFunc(func, ref, mask);
	}

	public void glVertexAttrib4Nub(int index, byte x, byte y, byte z, byte w) {
		current.glVertexAttrib4Nub(index, x, y, z, w);
	}

	public void glVertexAttrib4Nubv(int index, ByteBuffer v) {
		current.glVertexAttrib4Nubv(index, v);
	}

	public void glStencilMask(int mask) {
		current.glStencilMask(mask);
	}

	public void glStencilOp(int fail, int zfail, int zpass) {
		current.glStencilOp(fail, zfail, zpass);
	}

	public void glVertexAttrib4Nubv(int index, byte[] v, int v_offset) {
		current.glVertexAttrib4Nubv(index, v, v_offset);
	}

	public void glVertexAttrib4Nuiv(int index, IntBuffer v) {
		current.glVertexAttrib4Nuiv(index, v);
	}

	public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, Buffer pixels) {
		current.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
	}

	public void glVertexAttrib4Nuiv(int index, int[] v, int v_offset) {
		current.glVertexAttrib4Nuiv(index, v, v_offset);
	}

	public void glVertexAttrib4Nusv(int index, ShortBuffer v) {
		current.glVertexAttrib4Nusv(index, v);
	}

	public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, long pixels_buffer_offset) {
		current.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels_buffer_offset);
	}

	public void glVertexAttrib4Nusv(int index, short[] v, int v_offset) {
		current.glVertexAttrib4Nusv(index, v, v_offset);
	}

	public void glTexParameterf(int target, int pname, float param) {
		current.glTexParameterf(target, pname, param);
	}

	public void glVertexAttrib4bv(int index, ByteBuffer v) {
		current.glVertexAttrib4bv(index, v);
	}

	public void glVertexAttrib4bv(int index, byte[] v, int v_offset) {
		current.glVertexAttrib4bv(index, v, v_offset);
	}

	public void glTexParameterfv(int target, int pname, FloatBuffer params) {
		current.glTexParameterfv(target, pname, params);
	}

	public void glVertexAttrib4d(int index, double x, double y, double z, double w) {
		current.glVertexAttrib4d(index, x, y, z, w);
	}

	public void glTexParameterfv(int target, int pname, float[] params, int params_offset) {
		current.glTexParameterfv(target, pname, params, params_offset);
	}

	public void glVertexAttrib4dv(int index, DoubleBuffer v) {
		current.glVertexAttrib4dv(index, v);
	}

	public void glTexParameteri(int target, int pname, int param) {
		current.glTexParameteri(target, pname, param);
	}

	public void glVertexAttrib4dv(int index, double[] v, int v_offset) {
		current.glVertexAttrib4dv(index, v, v_offset);
	}

	public void glTexParameteriv(int target, int pname, IntBuffer params) {
		current.glTexParameteriv(target, pname, params);
	}

	public void glVertexAttrib4iv(int index, IntBuffer v) {
		current.glVertexAttrib4iv(index, v);
	}

	public void glVertexAttrib4iv(int index, int[] v, int v_offset) {
		current.glVertexAttrib4iv(index, v, v_offset);
	}

	public void glTexParameteriv(int target, int pname, int[] params, int params_offset) {
		current.glTexParameteriv(target, pname, params, params_offset);
	}

	public void glVertexAttrib4s(int index, short x, short y, short z, short w) {
		current.glVertexAttrib4s(index, x, y, z, w);
	}

	public void glTexStorage1D(int target, int levels, int internalformat, int width) {
		current.glTexStorage1D(target, levels, internalformat, width);
	}

	public void glVertexAttrib4sv(int index, ShortBuffer v) {
		current.glVertexAttrib4sv(index, v);
	}

	public void glVertexAttrib4sv(int index, short[] v, int v_offset) {
		current.glVertexAttrib4sv(index, v, v_offset);
	}

	public void glTexStorage2D(int target, int levels, int internalformat, int width, int height) {
		current.glTexStorage2D(target, levels, internalformat, width, height);
	}

	public void glVertexAttrib4ubv(int index, ByteBuffer v) {
		current.glVertexAttrib4ubv(index, v);
	}

	public void glTexStorage3D(int target, int levels, int internalformat, int width, int height, int depth) {
		current.glTexStorage3D(target, levels, internalformat, width, height, depth);
	}

	public void glVertexAttrib4ubv(int index, byte[] v, int v_offset) {
		current.glVertexAttrib4ubv(index, v, v_offset);
	}

	public void glVertexAttrib4uiv(int index, IntBuffer v) {
		current.glVertexAttrib4uiv(index, v);
	}

	public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, Buffer pixels) {
		current.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
	}

	public void glVertexAttrib4uiv(int index, int[] v, int v_offset) {
		current.glVertexAttrib4uiv(index, v, v_offset);
	}

	public void glVertexAttrib4usv(int index, ShortBuffer v) {
		current.glVertexAttrib4usv(index, v);
	}

	public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels_buffer_offset) {
		current.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels_buffer_offset);
	}

	public void glVertexAttrib4usv(int index, short[] v, int v_offset) {
		current.glVertexAttrib4usv(index, v, v_offset);
	}

	public void glVertexAttribFormatNV(int index, int size, int type, boolean normalized, int stride) {
		current.glVertexAttribFormatNV(index, size, type, normalized, stride);
	}

	public void glTextureStorage1D(int texture, int target, int levels, int internalformat, int width) {
		current.glTextureStorage1D(texture, target, levels, internalformat, width);
	}

	public void glVertexAttribI1i(int index, int x) {
		current.glVertexAttribI1i(index, x);
	}

	public void glTextureStorage2D(int texture, int target, int levels, int internalformat, int width, int height) {
		current.glTextureStorage2D(texture, target, levels, internalformat, width, height);
	}

	public void glVertexAttribI1iv(int index, IntBuffer v) {
		current.glVertexAttribI1iv(index, v);
	}

	public void glTextureStorage3D(int texture, int target, int levels, int internalformat, int width, int height, int depth) {
		current.glTextureStorage3D(texture, target, levels, internalformat, width, height, depth);
	}

	public void glVertexAttribI1iv(int index, int[] v, int v_offset) {
		current.glVertexAttribI1iv(index, v, v_offset);
	}

	public void glVertexAttribI1ui(int index, int x) {
		current.glVertexAttribI1ui(index, x);
	}

	public boolean glUnmapBuffer(int target) {
		return current.glUnmapBuffer(target);
	}

	public void glVertexAttribI1uiv(int index, IntBuffer v) {
		current.glVertexAttribI1uiv(index, v);
	}

	public void glViewport(int x, int y, int width, int height) {
		current.glViewport(x, y, width, height);
	}

	public void glVertexAttribI1uiv(int index, int[] v, int v_offset) {
		current.glVertexAttribI1uiv(index, v, v_offset);
	}

	public void glVertexAttribI2i(int index, int x, int y) {
		current.glVertexAttribI2i(index, x, y);
	}

	public void glVertexAttribI2iv(int index, IntBuffer v) {
		current.glVertexAttribI2iv(index, v);
	}

	public void glVertexAttribI2iv(int index, int[] v, int v_offset) {
		current.glVertexAttribI2iv(index, v, v_offset);
	}

	public void glVertexAttribI2ui(int index, int x, int y) {
		current.glVertexAttribI2ui(index, x, y);
	}

	public void glVertexAttribI2uiv(int index, IntBuffer v) {
		current.glVertexAttribI2uiv(index, v);
	}

	public void glVertexAttribI2uiv(int index, int[] v, int v_offset) {
		current.glVertexAttribI2uiv(index, v, v_offset);
	}

	public void glVertexAttribI3i(int index, int x, int y, int z) {
		current.glVertexAttribI3i(index, x, y, z);
	}

	public void glVertexAttribI3iv(int index, IntBuffer v) {
		current.glVertexAttribI3iv(index, v);
	}

	public void glVertexAttribI3iv(int index, int[] v, int v_offset) {
		current.glVertexAttribI3iv(index, v, v_offset);
	}

	public void glVertexAttribI3ui(int index, int x, int y, int z) {
		current.glVertexAttribI3ui(index, x, y, z);
	}

	public void glVertexAttribI3uiv(int index, IntBuffer v) {
		current.glVertexAttribI3uiv(index, v);
	}

	public void glVertexAttribI3uiv(int index, int[] v, int v_offset) {
		current.glVertexAttribI3uiv(index, v, v_offset);
	}

	public void glVertexAttribI4bv(int index, ByteBuffer v) {
		current.glVertexAttribI4bv(index, v);
	}

	public void glVertexAttribI4bv(int index, byte[] v, int v_offset) {
		current.glVertexAttribI4bv(index, v, v_offset);
	}

	public void glVertexAttribI4sv(int index, ShortBuffer v) {
		current.glVertexAttribI4sv(index, v);
	}

	public void glVertexAttribI4sv(int index, short[] v, int v_offset) {
		current.glVertexAttribI4sv(index, v, v_offset);
	}

	public void glVertexAttribI4ubv(int index, ByteBuffer v) {
		current.glVertexAttribI4ubv(index, v);
	}

	public void glVertexAttribI4ubv(int index, byte[] v, int v_offset) {
		current.glVertexAttribI4ubv(index, v, v_offset);
	}

	public void glVertexAttribI4usv(int index, ShortBuffer v) {
		current.glVertexAttribI4usv(index, v);
	}

	public void glVertexAttribI4usv(int index, short[] v, int v_offset) {
		current.glVertexAttribI4usv(index, v, v_offset);
	}

	public void glVertexAttribIFormatNV(int index, int size, int type, int stride) {
		current.glVertexAttribIFormatNV(index, size, type, stride);
	}

	public void glVertexFormatNV(int size, int type, int stride) {
		current.glVertexFormatNV(size, type, stride);
	}

	public void glAccum(int op, float value) {
		current.glAccum(op, value);
	}

	public void glActiveStencilFaceEXT(int face) {
		current.glActiveStencilFaceEXT(face);
	}

	public void glApplyTextureEXT(int mode) {
		current.glApplyTextureEXT(mode);
	}

	public boolean glAreTexturesResident(int n, IntBuffer textures, ByteBuffer residences) {
		return current.glAreTexturesResident(n, textures, residences);
	}

	public boolean glAreTexturesResident(int n, int[] textures, int textures_offset, byte[] residences, int residences_offset) {
		return current.glAreTexturesResident(n, textures, textures_offset, residences, residences_offset);
	}

	public void glArrayElement(int i) {
		current.glArrayElement(i);
	}

	public void glAttachObjectARB(int containerObj, int obj) {
		current.glAttachObjectARB(containerObj, obj);
	}

	public void glBegin(int mode) {
		current.glBegin(mode);
	}

	public void glBeginConditionalRenderNVX(int id) {
		current.glBeginConditionalRenderNVX(id);
	}

	public void glBeginOcclusionQueryNV(int id) {
		current.glBeginOcclusionQueryNV(id);
	}

	public void glBeginPerfMonitorAMD(int monitor) {
		current.glBeginPerfMonitorAMD(monitor);
	}

	public void glBeginVertexShaderEXT() {
		current.glBeginVertexShaderEXT();
	}

	public void glBeginVideoCaptureNV(int video_capture_slot) {
		current.glBeginVideoCaptureNV(video_capture_slot);
	}

	public int glBindLightParameterEXT(int light, int value) {
		return current.glBindLightParameterEXT(light, value);
	}

	public int glBindMaterialParameterEXT(int face, int value) {
		return current.glBindMaterialParameterEXT(face, value);
	}

	public void glBindMultiTextureEXT(int texunit, int target, int texture) {
		current.glBindMultiTextureEXT(texunit, target, texture);
	}

	public int glBindParameterEXT(int value) {
		return current.glBindParameterEXT(value);
	}

	public void glBindProgramARB(int target, int program) {
		current.glBindProgramARB(target, program);
	}

	public int glBindTexGenParameterEXT(int unit, int coord, int value) {
		return current.glBindTexGenParameterEXT(unit, coord, value);
	}

	public int glBindTextureUnitParameterEXT(int unit, int value) {
		return current.glBindTextureUnitParameterEXT(unit, value);
	}

	public void glBindTransformFeedbackNV(int target, int id) {
		current.glBindTransformFeedbackNV(target, id);
	}

	public void glBindVertexShaderEXT(int id) {
		current.glBindVertexShaderEXT(id);
	}

	public void glBindVideoCaptureStreamBufferNV(int video_capture_slot, int stream, int frame_region, long offset) {
		current.glBindVideoCaptureStreamBufferNV(video_capture_slot, stream, frame_region, offset);
	}

	public void glBindVideoCaptureStreamTextureNV(int video_capture_slot, int stream, int frame_region, int target, int texture) {
		current.glBindVideoCaptureStreamTextureNV(video_capture_slot, stream, frame_region, target, texture);
	}

	public void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, ByteBuffer bitmap) {
		current.glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap);
	}

	public void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, byte[] bitmap, int bitmap_offset) {
		current.glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap, bitmap_offset);
	}

	public void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, long bitmap_buffer_offset) {
		current.glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap_buffer_offset);
	}

	public void glBlendEquationIndexedAMD(int buf, int mode) {
		current.glBlendEquationIndexedAMD(buf, mode);
	}

	public void glBlendEquationSeparateIndexedAMD(int buf, int modeRGB, int modeAlpha) {
		current.glBlendEquationSeparateIndexedAMD(buf, modeRGB, modeAlpha);
	}

	public void glBlendFuncIndexedAMD(int buf, int src, int dst) {
		current.glBlendFuncIndexedAMD(buf, src, dst);
	}

	public void glBlendFuncSeparateINGR(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
		current.glBlendFuncSeparateINGR(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
	}

	public void glBlendFuncSeparateIndexedAMD(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
		current.glBlendFuncSeparateIndexedAMD(buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
	}

	public void glBufferParameteri(int target, int pname, int param) {
		current.glBufferParameteri(target, pname, param);
	}

	public void glCallList(int list) {
		current.glCallList(list);
	}

	public void glCallLists(int n, int type, Buffer lists) {
		current.glCallLists(n, type, lists);
	}

	public int glCheckNamedFramebufferStatusEXT(int framebuffer, int target) {
		return current.glCheckNamedFramebufferStatusEXT(framebuffer, target);
	}

	public void glClearAccum(float red, float green, float blue, float alpha) {
		current.glClearAccum(red, green, blue, alpha);
	}

	public void glClearColorIi(int red, int green, int blue, int alpha) {
		current.glClearColorIi(red, green, blue, alpha);
	}

	public void glClearColorIui(int red, int green, int blue, int alpha) {
		current.glClearColorIui(red, green, blue, alpha);
	}

	public void glClearIndex(float c) {
		current.glClearIndex(c);
	}

	public void glClientAttribDefaultEXT(int mask) {
		current.glClientAttribDefaultEXT(mask);
	}

	public void glClipPlane(int plane, DoubleBuffer equation) {
		current.glClipPlane(plane, equation);
	}

	public void glClipPlane(int plane, double[] equation, int equation_offset) {
		current.glClipPlane(plane, equation, equation_offset);
	}

	public void glClipPlanef(int plane, FloatBuffer equation) {
		current.glClipPlanef(plane, equation);
	}

	public void glClipPlanef(int plane, float[] equation, int equation_offset) {
		current.glClipPlanef(plane, equation, equation_offset);
	}

	public void glColor3b(byte red, byte green, byte blue) {
		current.glColor3b(red, green, blue);
	}

	public void glColor3bv(ByteBuffer v) {
		current.glColor3bv(v);
	}

	public void glColor3bv(byte[] v, int v_offset) {
		current.glColor3bv(v, v_offset);
	}

	public void glColor3d(double red, double green, double blue) {
		current.glColor3d(red, green, blue);
	}

	public void glColor3dv(DoubleBuffer v) {
		current.glColor3dv(v);
	}

	public void glColor3dv(double[] v, int v_offset) {
		current.glColor3dv(v, v_offset);
	}

	public void glColor3f(float red, float green, float blue) {
		current.glColor3f(red, green, blue);
	}

	public void glColor3fv(FloatBuffer v) {
		current.glColor3fv(v);
	}

	public void glColor3fv(float[] v, int v_offset) {
		current.glColor3fv(v, v_offset);
	}

	public void glColor3h(short red, short green, short blue) {
		current.glColor3h(red, green, blue);
	}

	public void glColor3hv(ShortBuffer v) {
		current.glColor3hv(v);
	}

	public void glColor3hv(short[] v, int v_offset) {
		current.glColor3hv(v, v_offset);
	}

	public void glColor3i(int red, int green, int blue) {
		current.glColor3i(red, green, blue);
	}

	public void glColor3iv(IntBuffer v) {
		current.glColor3iv(v);
	}

	public void glColor3iv(int[] v, int v_offset) {
		current.glColor3iv(v, v_offset);
	}

	public void glColor3s(short red, short green, short blue) {
		current.glColor3s(red, green, blue);
	}

	public void glColor3sv(ShortBuffer v) {
		current.glColor3sv(v);
	}

	public void glColor3sv(short[] v, int v_offset) {
		current.glColor3sv(v, v_offset);
	}

	public void glColor3ub(byte red, byte green, byte blue) {
		current.glColor3ub(red, green, blue);
	}

	public void glColor3ubv(ByteBuffer v) {
		current.glColor3ubv(v);
	}

	public void glColor3ubv(byte[] v, int v_offset) {
		current.glColor3ubv(v, v_offset);
	}

	public void glColor3ui(int red, int green, int blue) {
		current.glColor3ui(red, green, blue);
	}

	public void glColor3uiv(IntBuffer v) {
		current.glColor3uiv(v);
	}

	public void glColor3uiv(int[] v, int v_offset) {
		current.glColor3uiv(v, v_offset);
	}

	public void glColor3us(short red, short green, short blue) {
		current.glColor3us(red, green, blue);
	}

	public void glColor3usv(ShortBuffer v) {
		current.glColor3usv(v);
	}

	public void glColor3usv(short[] v, int v_offset) {
		current.glColor3usv(v, v_offset);
	}

	public void glColor4b(byte red, byte green, byte blue, byte alpha) {
		current.glColor4b(red, green, blue, alpha);
	}

	public void glColor4bv(ByteBuffer v) {
		current.glColor4bv(v);
	}

	public void glColor4bv(byte[] v, int v_offset) {
		current.glColor4bv(v, v_offset);
	}

	public void glColor4d(double red, double green, double blue, double alpha) {
		current.glColor4d(red, green, blue, alpha);
	}

	public void glColor4dv(DoubleBuffer v) {
		current.glColor4dv(v);
	}

	public void glColor4dv(double[] v, int v_offset) {
		current.glColor4dv(v, v_offset);
	}

	public void glColor4fv(FloatBuffer v) {
		current.glColor4fv(v);
	}

	public void glColor4fv(float[] v, int v_offset) {
		current.glColor4fv(v, v_offset);
	}

	public void glColor4h(short red, short green, short blue, short alpha) {
		current.glColor4h(red, green, blue, alpha);
	}

	public void glColor4hv(ShortBuffer v) {
		current.glColor4hv(v);
	}

	public void glColor4hv(short[] v, int v_offset) {
		current.glColor4hv(v, v_offset);
	}

	public void glColor4i(int red, int green, int blue, int alpha) {
		current.glColor4i(red, green, blue, alpha);
	}

	public void glColor4iv(IntBuffer v) {
		current.glColor4iv(v);
	}

	public void glColor4iv(int[] v, int v_offset) {
		current.glColor4iv(v, v_offset);
	}

	public void glColor4s(short red, short green, short blue, short alpha) {
		current.glColor4s(red, green, blue, alpha);
	}

	public void glColor4sv(ShortBuffer v) {
		current.glColor4sv(v);
	}

	public void glColor4sv(short[] v, int v_offset) {
		current.glColor4sv(v, v_offset);
	}

	public void glColor4ubv(ByteBuffer v) {
		current.glColor4ubv(v);
	}

	public void glColor4ubv(byte[] v, int v_offset) {
		current.glColor4ubv(v, v_offset);
	}

	public void glColor4ui(int red, int green, int blue, int alpha) {
		current.glColor4ui(red, green, blue, alpha);
	}

	public void glColor4uiv(IntBuffer v) {
		current.glColor4uiv(v);
	}

	public void glColor4uiv(int[] v, int v_offset) {
		current.glColor4uiv(v, v_offset);
	}

	public void glColor4us(short red, short green, short blue, short alpha) {
		current.glColor4us(red, green, blue, alpha);
	}

	public void glColor4usv(ShortBuffer v) {
		current.glColor4usv(v);
	}

	public void glColor4usv(short[] v, int v_offset) {
		current.glColor4usv(v, v_offset);
	}

	public void glColorMaskIndexed(int index, boolean r, boolean g, boolean b, boolean a) {
		current.glColorMaskIndexed(index, r, g, b, a);
	}

	public void glColorMaterial(int face, int mode) {
		current.glColorMaterial(face, mode);
	}

	public void glColorSubTable(int target, int start, int count, int format, int type, Buffer data) {
		current.glColorSubTable(target, start, count, format, type, data);
	}

	public void glColorSubTable(int target, int start, int count, int format, int type, long data_buffer_offset) {
		current.glColorSubTable(target, start, count, format, type, data_buffer_offset);
	}

	public void glColorTable(int target, int internalformat, int width, int format, int type, Buffer table) {
		current.glColorTable(target, internalformat, width, format, type, table);
	}

	public void glColorTable(int target, int internalformat, int width, int format, int type, long table_buffer_offset) {
		current.glColorTable(target, internalformat, width, format, type, table_buffer_offset);
	}

	public void glColorTableParameterfv(int target, int pname, FloatBuffer params) {
		current.glColorTableParameterfv(target, pname, params);
	}

	public void glColorTableParameterfv(int target, int pname, float[] params, int params_offset) {
		current.glColorTableParameterfv(target, pname, params, params_offset);
	}

	public void glColorTableParameteriv(int target, int pname, IntBuffer params) {
		current.glColorTableParameteriv(target, pname, params);
	}

	public void glColorTableParameteriv(int target, int pname, int[] params, int params_offset) {
		current.glColorTableParameteriv(target, pname, params, params_offset);
	}

	public void glCompileShaderARB(int shaderObj) {
		current.glCompileShaderARB(shaderObj);
	}

	public void glCompressedMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int width, int border, int imageSize, Buffer bits) {
		current.glCompressedMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, imageSize, bits);
	}

	public void glCompressedMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int width, int height, int border, int imageSize, Buffer bits) {
		current.glCompressedMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, imageSize, bits);
	}

	public void glCompressedMultiTexImage3DEXT(int texunit, int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Buffer bits) {
		current.glCompressedMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, imageSize, bits);
	}

	public void glCompressedMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int width, int format, int imageSize, Buffer bits) {
		current.glCompressedMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, imageSize, bits);
	}

	public void glCompressedMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Buffer bits) {
		current.glCompressedMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, imageSize, bits);
	}

	public void glCompressedMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format,
			int imageSize, Buffer bits) {
		current.glCompressedMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, bits);
	}

	public void glCompressedTextureImage1DEXT(int texture, int target, int level, int internalformat, int width, int border, int imageSize, Buffer bits) {
		current.glCompressedTextureImage1DEXT(texture, target, level, internalformat, width, border, imageSize, bits);
	}

	public void glCompressedTextureImage2DEXT(int texture, int target, int level, int internalformat, int width, int height, int border, int imageSize, Buffer bits) {
		current.glCompressedTextureImage2DEXT(texture, target, level, internalformat, width, height, border, imageSize, bits);
	}

	public void glCompressedTextureImage3DEXT(int texture, int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Buffer bits) {
		current.glCompressedTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, imageSize, bits);
	}

	public void glCompressedTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int width, int format, int imageSize, Buffer bits) {
		current.glCompressedTextureSubImage1DEXT(texture, target, level, xoffset, width, format, imageSize, bits);
	}

	public void glCompressedTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Buffer bits) {
		current.glCompressedTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, imageSize, bits);
	}

	public void glCompressedTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format,
			int imageSize, Buffer bits) {
		current.glCompressedTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, bits);
	}

	public void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, Buffer image) {
		current.glConvolutionFilter1D(target, internalformat, width, format, type, image);
	}

	public void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, long image_buffer_offset) {
		current.glConvolutionFilter1D(target, internalformat, width, format, type, image_buffer_offset);
	}

	public void glConvolutionFilter2D(int target, int internalformat, int width, int height, int format, int type, Buffer image) {
		current.glConvolutionFilter2D(target, internalformat, width, height, format, type, image);
	}

	public void glConvolutionFilter2D(int target, int internalformat, int width, int height, int format, int type, long image_buffer_offset) {
		current.glConvolutionFilter2D(target, internalformat, width, height, format, type, image_buffer_offset);
	}

	public void glConvolutionParameterf(int target, int pname, float params) {
		current.glConvolutionParameterf(target, pname, params);
	}

	public void glConvolutionParameterfv(int target, int pname, FloatBuffer params) {
		current.glConvolutionParameterfv(target, pname, params);
	}

	public void glConvolutionParameterfv(int target, int pname, float[] params, int params_offset) {
		current.glConvolutionParameterfv(target, pname, params, params_offset);
	}

	public void glConvolutionParameteri(int target, int pname, int params) {
		current.glConvolutionParameteri(target, pname, params);
	}

	public void glConvolutionParameteriv(int target, int pname, IntBuffer params) {
		current.glConvolutionParameteriv(target, pname, params);
	}

	public void glConvolutionParameteriv(int target, int pname, int[] params, int params_offset) {
		current.glConvolutionParameteriv(target, pname, params, params_offset);
	}

	public void glCopyColorSubTable(int target, int start, int x, int y, int width) {
		current.glCopyColorSubTable(target, start, x, y, width);
	}

	public void glCopyColorTable(int target, int internalformat, int x, int y, int width) {
		current.glCopyColorTable(target, internalformat, x, y, width);
	}

	public void glCopyConvolutionFilter1D(int target, int internalformat, int x, int y, int width) {
		current.glCopyConvolutionFilter1D(target, internalformat, x, y, width);
	}

	public void glCopyConvolutionFilter2D(int target, int internalformat, int x, int y, int width, int height) {
		current.glCopyConvolutionFilter2D(target, internalformat, x, y, width, height);
	}

	public void glCopyImageSubDataNV(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY,
			int dstZ, int width, int height, int depth) {
		current.glCopyImageSubDataNV(srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, width, height, depth);
	}

	public void glCopyMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int x, int y, int width, int border) {
		current.glCopyMultiTexImage1DEXT(texunit, target, level, internalformat, x, y, width, border);
	}

	public void glCopyMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int x, int y, int width, int height, int border) {
		current.glCopyMultiTexImage2DEXT(texunit, target, level, internalformat, x, y, width, height, border);
	}

	public void glCopyMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int x, int y, int width) {
		current.glCopyMultiTexSubImage1DEXT(texunit, target, level, xoffset, x, y, width);
	}

	public void glCopyMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
		current.glCopyMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, x, y, width, height);
	}

	public void glCopyMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
		current.glCopyMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, x, y, width, height);
	}

	public void glCopyPathNV(int resultPath, int srcPath) {
		current.glCopyPathNV(resultPath, srcPath);
	}

	public void glCopyPixels(int x, int y, int width, int height, int type) {
		current.glCopyPixels(x, y, width, height, type);
	}

	public void glCopyTextureImage1DEXT(int texture, int target, int level, int internalformat, int x, int y, int width, int border) {
		current.glCopyTextureImage1DEXT(texture, target, level, internalformat, x, y, width, border);
	}

	public void glCopyTextureImage2DEXT(int texture, int target, int level, int internalformat, int x, int y, int width, int height, int border) {
		current.glCopyTextureImage2DEXT(texture, target, level, internalformat, x, y, width, height, border);
	}

	public void glCopyTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int x, int y, int width) {
		current.glCopyTextureSubImage1DEXT(texture, target, level, xoffset, x, y, width);
	}

	public void glCopyTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
		current.glCopyTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, x, y, width, height);
	}

	public void glCopyTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
		current.glCopyTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, x, y, width, height);
	}

	public void glCoverFillPathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int coverMode, int transformType, FloatBuffer transformValues) {
		current.glCoverFillPathInstancedNV(numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues);
	}

	public void glCoverFillPathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int coverMode, int transformType, float[] transformValues,
			int transformValues_offset) {
		current.glCoverFillPathInstancedNV(numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues, transformValues_offset);
	}

	public void glCoverFillPathNV(int path, int coverMode) {
		current.glCoverFillPathNV(path, coverMode);
	}

	public void glCoverStrokePathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int coverMode, int transformType, FloatBuffer transformValues) {
		current.glCoverStrokePathInstancedNV(numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues);
	}

	public void glCoverStrokePathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int coverMode, int transformType, float[] transformValues,
			int transformValues_offset) {
		current.glCoverStrokePathInstancedNV(numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues, transformValues_offset);
	}

	public void glCoverStrokePathNV(int path, int coverMode) {
		current.glCoverStrokePathNV(path, coverMode);
	}

	public int glCreateProgramObjectARB() {
		return current.glCreateProgramObjectARB();
	}

	public int glCreateShaderObjectARB(int shaderType) {
		return current.glCreateShaderObjectARB(shaderType);
	}

	public void glCullParameterdvEXT(int pname, DoubleBuffer params) {
		current.glCullParameterdvEXT(pname, params);
	}

	public void glCullParameterdvEXT(int pname, double[] params, int params_offset) {
		current.glCullParameterdvEXT(pname, params, params_offset);
	}

	public void glCullParameterfvEXT(int pname, FloatBuffer params) {
		current.glCullParameterfvEXT(pname, params);
	}

	public void glCullParameterfvEXT(int pname, float[] params, int params_offset) {
		current.glCullParameterfvEXT(pname, params, params_offset);
	}

	public void glCurrentPaletteMatrix(int index) {
		current.glCurrentPaletteMatrix(index);
	}

	public void glDeleteFencesAPPLE(int n, IntBuffer fences) {
		current.glDeleteFencesAPPLE(n, fences);
	}

	public void glDeleteFencesAPPLE(int n, int[] fences, int fences_offset) {
		current.glDeleteFencesAPPLE(n, fences, fences_offset);
	}

	public void glDeleteFencesNV(int n, IntBuffer fences) {
		current.glDeleteFencesNV(n, fences);
	}

	public void glDeleteFencesNV(int n, int[] fences, int fences_offset) {
		current.glDeleteFencesNV(n, fences, fences_offset);
	}

	public void glDeleteLists(int list, int range) {
		current.glDeleteLists(list, range);
	}

	public void glDeleteNamesAMD(int identifier, int num, IntBuffer names) {
		current.glDeleteNamesAMD(identifier, num, names);
	}

	public void glDeleteNamesAMD(int identifier, int num, int[] names, int names_offset) {
		current.glDeleteNamesAMD(identifier, num, names, names_offset);
	}

	public void glDeleteObjectARB(int obj) {
		current.glDeleteObjectARB(obj);
	}

	public void glDeleteOcclusionQueriesNV(int n, IntBuffer ids) {
		current.glDeleteOcclusionQueriesNV(n, ids);
	}

	public void glDeleteOcclusionQueriesNV(int n, int[] ids, int ids_offset) {
		current.glDeleteOcclusionQueriesNV(n, ids, ids_offset);
	}

	public void glDeletePathsNV(int path, int range) {
		current.glDeletePathsNV(path, range);
	}

	public void glDeletePerfMonitorsAMD(int n, IntBuffer monitors) {
		current.glDeletePerfMonitorsAMD(n, monitors);
	}

	public void glDeletePerfMonitorsAMD(int n, int[] monitors, int monitors_offset) {
		current.glDeletePerfMonitorsAMD(n, monitors, monitors_offset);
	}

	public void glDeleteProgramsARB(int n, IntBuffer programs) {
		current.glDeleteProgramsARB(n, programs);
	}

	public void glDeleteProgramsARB(int n, int[] programs, int programs_offset) {
		current.glDeleteProgramsARB(n, programs, programs_offset);
	}

	public void glDeleteTransformFeedbacksNV(int n, IntBuffer ids) {
		current.glDeleteTransformFeedbacksNV(n, ids);
	}

	public void glDeleteTransformFeedbacksNV(int n, int[] ids, int ids_offset) {
		current.glDeleteTransformFeedbacksNV(n, ids, ids_offset);
	}

	public void glDeleteVertexShaderEXT(int id) {
		current.glDeleteVertexShaderEXT(id);
	}

	public void glDepthBoundsEXT(double zmin, double zmax) {
		current.glDepthBoundsEXT(zmin, zmax);
	}

	public void glDetachObjectARB(int containerObj, int attachedObj) {
		current.glDetachObjectARB(containerObj, attachedObj);
	}

	public void glDisableClientStateIndexedEXT(int array, int index) {
		current.glDisableClientStateIndexedEXT(array, index);
	}

	public void glDisableClientStateiEXT(int array, int index) {
		current.glDisableClientStateiEXT(array, index);
	}

	public void glDisableIndexed(int target, int index) {
		current.glDisableIndexed(target, index);
	}

	public void glDisableVariantClientStateEXT(int id) {
		current.glDisableVariantClientStateEXT(id);
	}

	public void glDisableVertexArrayAttribEXT(int vaobj, int index) {
		current.glDisableVertexArrayAttribEXT(vaobj, index);
	}

	public void glDisableVertexArrayEXT(int vaobj, int array) {
		current.glDisableVertexArrayEXT(vaobj, array);
	}

	public void glDisableVertexAttribAPPLE(int index, int pname) {
		current.glDisableVertexAttribAPPLE(index, pname);
	}

	public void glDisableVertexAttribArrayARB(int index) {
		current.glDisableVertexAttribArrayARB(index);
	}

	public void glDrawBuffersATI(int n, IntBuffer bufs) {
		current.glDrawBuffersATI(n, bufs);
	}

	public void glDrawBuffersATI(int n, int[] bufs, int bufs_offset) {
		current.glDrawBuffersATI(n, bufs, bufs_offset);
	}

	public void glDrawPixels(int width, int height, int format, int type, Buffer pixels) {
		current.glDrawPixels(width, height, format, type, pixels);
	}

	public void glDrawPixels(int width, int height, int format, int type, long pixels_buffer_offset) {
		current.glDrawPixels(width, height, format, type, pixels_buffer_offset);
	}

	public void glDrawTextureNV(int texture, int sampler, float x0, float y0, float x1, float y1, float z, float s0, float t0, float s1, float t1) {
		current.glDrawTextureNV(texture, sampler, x0, y0, x1, y1, z, s0, t0, s1, t1);
	}

	public void glDrawTransformFeedbackNV(int mode, int id) {
		current.glDrawTransformFeedbackNV(mode, id);
	}

	public void glEdgeFlag(boolean flag) {
		current.glEdgeFlag(flag);
	}

	public void glEdgeFlagPointer(int stride, Buffer ptr) {
		current.glEdgeFlagPointer(stride, ptr);
	}

	public void glEdgeFlagPointer(int stride, long ptr_buffer_offset) {
		current.glEdgeFlagPointer(stride, ptr_buffer_offset);
	}

	public void glEdgeFlagv(ByteBuffer flag) {
		current.glEdgeFlagv(flag);
	}

	public void glEdgeFlagv(byte[] flag, int flag_offset) {
		current.glEdgeFlagv(flag, flag_offset);
	}

	public void glEnableClientStateIndexedEXT(int array, int index) {
		current.glEnableClientStateIndexedEXT(array, index);
	}

	public void glEnableClientStateiEXT(int array, int index) {
		current.glEnableClientStateiEXT(array, index);
	}

	public void glEnableIndexed(int target, int index) {
		current.glEnableIndexed(target, index);
	}

	public void glEnableVariantClientStateEXT(int id) {
		current.glEnableVariantClientStateEXT(id);
	}

	public void glEnableVertexArrayAttribEXT(int vaobj, int index) {
		current.glEnableVertexArrayAttribEXT(vaobj, index);
	}

	public void glEnableVertexArrayEXT(int vaobj, int array) {
		current.glEnableVertexArrayEXT(vaobj, array);
	}

	public void glEnableVertexAttribAPPLE(int index, int pname) {
		current.glEnableVertexAttribAPPLE(index, pname);
	}

	public void glEnableVertexAttribArrayARB(int index) {
		current.glEnableVertexAttribArrayARB(index);
	}

	public void glEnd() {
		current.glEnd();
	}

	public void glEndConditionalRenderNVX() {
		current.glEndConditionalRenderNVX();
	}

	public void glEndList() {
		current.glEndList();
	}

	public void glEndOcclusionQueryNV() {
		current.glEndOcclusionQueryNV();
	}

	public void glEndPerfMonitorAMD(int monitor) {
		current.glEndPerfMonitorAMD(monitor);
	}

	public void glEndVertexShaderEXT() {
		current.glEndVertexShaderEXT();
	}

	public void glEndVideoCaptureNV(int video_capture_slot) {
		current.glEndVideoCaptureNV(video_capture_slot);
	}

	public void glEvalCoord1d(double u) {
		current.glEvalCoord1d(u);
	}

	public void glEvalCoord1dv(DoubleBuffer u) {
		current.glEvalCoord1dv(u);
	}

	public void glEvalCoord1dv(double[] u, int u_offset) {
		current.glEvalCoord1dv(u, u_offset);
	}

	public void glEvalCoord1f(float u) {
		current.glEvalCoord1f(u);
	}

	public void glEvalCoord1fv(FloatBuffer u) {
		current.glEvalCoord1fv(u);
	}

	public void glEvalCoord1fv(float[] u, int u_offset) {
		current.glEvalCoord1fv(u, u_offset);
	}

	public void glEvalCoord2d(double u, double v) {
		current.glEvalCoord2d(u, v);
	}

	public void glEvalCoord2dv(DoubleBuffer u) {
		current.glEvalCoord2dv(u);
	}

	public void glEvalCoord2dv(double[] u, int u_offset) {
		current.glEvalCoord2dv(u, u_offset);
	}

	public void glEvalCoord2f(float u, float v) {
		current.glEvalCoord2f(u, v);
	}

	public void glEvalCoord2fv(FloatBuffer u) {
		current.glEvalCoord2fv(u);
	}

	public void glEvalCoord2fv(float[] u, int u_offset) {
		current.glEvalCoord2fv(u, u_offset);
	}

	public void glEvalMapsNV(int target, int mode) {
		current.glEvalMapsNV(target, mode);
	}

	public void glEvalMesh1(int mode, int i1, int i2) {
		current.glEvalMesh1(mode, i1, i2);
	}

	public void glEvalMesh2(int mode, int i1, int i2, int j1, int j2) {
		current.glEvalMesh2(mode, i1, i2, j1, j2);
	}

	public void glEvalPoint1(int i) {
		current.glEvalPoint1(i);
	}

	public void glEvalPoint2(int i, int j) {
		current.glEvalPoint2(i, j);
	}

	public void glExtractComponentEXT(int res, int src, int num) {
		current.glExtractComponentEXT(res, src, num);
	}

	public void glFeedbackBuffer(int size, int type, FloatBuffer buffer) {
		current.glFeedbackBuffer(size, type, buffer);
	}

	public void glFinishFenceAPPLE(int fence) {
		current.glFinishFenceAPPLE(fence);
	}

	public void glFinishFenceNV(int fence) {
		current.glFinishFenceNV(fence);
	}

	public void glFinishObjectAPPLE(int object, int name) {
		current.glFinishObjectAPPLE(object, name);
	}

	public void glFinishTextureSUNX() {
		current.glFinishTextureSUNX();
	}

	public void glFlushMappedNamedBufferRangeEXT(int buffer, long offset, long length) {
		current.glFlushMappedNamedBufferRangeEXT(buffer, offset, length);
	}

	public void glFlushPixelDataRangeNV(int target) {
		current.glFlushPixelDataRangeNV(target);
	}

	public void glFlushVertexArrayRangeAPPLE(int length, Buffer pointer) {
		current.glFlushVertexArrayRangeAPPLE(length, pointer);
	}

	public void glFlushVertexArrayRangeNV() {
		current.glFlushVertexArrayRangeNV();
	}

	public void glFogCoordPointer(int type, int stride, Buffer pointer) {
		current.glFogCoordPointer(type, stride, pointer);
	}

	public void glFogCoordPointer(int type, int stride, long pointer_buffer_offset) {
		current.glFogCoordPointer(type, stride, pointer_buffer_offset);
	}

	public void glFogCoordd(double coord) {
		current.glFogCoordd(coord);
	}

	public void glFogCoorddv(DoubleBuffer coord) {
		current.glFogCoorddv(coord);
	}

	public void glFogCoorddv(double[] coord, int coord_offset) {
		current.glFogCoorddv(coord, coord_offset);
	}

	public void glFogCoordf(float coord) {
		current.glFogCoordf(coord);
	}

	public void glFogCoordfv(FloatBuffer coord) {
		current.glFogCoordfv(coord);
	}

	public void glFogCoordfv(float[] coord, int coord_offset) {
		current.glFogCoordfv(coord, coord_offset);
	}

	public void glFogCoordh(short fog) {
		current.glFogCoordh(fog);
	}

	public void glFogCoordhv(ShortBuffer fog) {
		current.glFogCoordhv(fog);
	}

	public void glFogCoordhv(short[] fog, int fog_offset) {
		current.glFogCoordhv(fog, fog_offset);
	}

	public void glFogi(int pname, int param) {
		current.glFogi(pname, param);
	}

	public void glFogiv(int pname, IntBuffer params) {
		current.glFogiv(pname, params);
	}

	public void glFogiv(int pname, int[] params, int params_offset) {
		current.glFogiv(pname, params, params_offset);
	}

	public void glFrameTerminatorGREMEDY() {
		current.glFrameTerminatorGREMEDY();
	}

	public void glFramebufferDrawBufferEXT(int framebuffer, int mode) {
		current.glFramebufferDrawBufferEXT(framebuffer, mode);
	}

	public void glFramebufferDrawBuffersEXT(int framebuffer, int n, IntBuffer bufs) {
		current.glFramebufferDrawBuffersEXT(framebuffer, n, bufs);
	}

	public void glFramebufferDrawBuffersEXT(int framebuffer, int n, int[] bufs, int bufs_offset) {
		current.glFramebufferDrawBuffersEXT(framebuffer, n, bufs, bufs_offset);
	}

	public void glFramebufferReadBufferEXT(int framebuffer, int mode) {
		current.glFramebufferReadBufferEXT(framebuffer, mode);
	}

	public void glFramebufferTextureEXT(int target, int attachment, int texture, int level) {
		current.glFramebufferTextureEXT(target, attachment, texture, level);
	}

	public void glFramebufferTextureFaceEXT(int target, int attachment, int texture, int level, int face) {
		current.glFramebufferTextureFaceEXT(target, attachment, texture, level, face);
	}

	public void glFramebufferTextureLayerEXT(int target, int attachment, int texture, int level, int layer) {
		current.glFramebufferTextureLayerEXT(target, attachment, texture, level, layer);
	}

	public void glGenFencesAPPLE(int n, IntBuffer fences) {
		current.glGenFencesAPPLE(n, fences);
	}

	public void glGenFencesAPPLE(int n, int[] fences, int fences_offset) {
		current.glGenFencesAPPLE(n, fences, fences_offset);
	}

	public void glGenFencesNV(int n, IntBuffer fences) {
		current.glGenFencesNV(n, fences);
	}

	public void glGenFencesNV(int n, int[] fences, int fences_offset) {
		current.glGenFencesNV(n, fences, fences_offset);
	}

	public int glGenLists(int range) {
		return current.glGenLists(range);
	}

	public void glGenNamesAMD(int identifier, int num, IntBuffer names) {
		current.glGenNamesAMD(identifier, num, names);
	}

	public void glGenNamesAMD(int identifier, int num, int[] names, int names_offset) {
		current.glGenNamesAMD(identifier, num, names, names_offset);
	}

	public void glGenOcclusionQueriesNV(int n, IntBuffer ids) {
		current.glGenOcclusionQueriesNV(n, ids);
	}

	public void glGenOcclusionQueriesNV(int n, int[] ids, int ids_offset) {
		current.glGenOcclusionQueriesNV(n, ids, ids_offset);
	}

	public int glGenPathsNV(int range) {
		return current.glGenPathsNV(range);
	}

	public void glGenPerfMonitorsAMD(int n, IntBuffer monitors) {
		current.glGenPerfMonitorsAMD(n, monitors);
	}

	public void glGenPerfMonitorsAMD(int n, int[] monitors, int monitors_offset) {
		current.glGenPerfMonitorsAMD(n, monitors, monitors_offset);
	}

	public void glGenProgramsARB(int n, IntBuffer programs) {
		current.glGenProgramsARB(n, programs);
	}

	public void glGenProgramsARB(int n, int[] programs, int programs_offset) {
		current.glGenProgramsARB(n, programs, programs_offset);
	}

	public int glGenSymbolsEXT(int datatype, int storagetype, int range, int components) {
		return current.glGenSymbolsEXT(datatype, storagetype, range, components);
	}

	public void glGenTransformFeedbacksNV(int n, IntBuffer ids) {
		current.glGenTransformFeedbacksNV(n, ids);
	}

	public void glGenTransformFeedbacksNV(int n, int[] ids, int ids_offset) {
		current.glGenTransformFeedbacksNV(n, ids, ids_offset);
	}

	public int glGenVertexShadersEXT(int range) {
		return current.glGenVertexShadersEXT(range);
	}

	public void glGenerateMultiTexMipmapEXT(int texunit, int target) {
		current.glGenerateMultiTexMipmapEXT(texunit, target);
	}

	public void glGenerateTextureMipmapEXT(int texture, int target) {
		current.glGenerateTextureMipmapEXT(texture, target);
	}

	public void glGetActiveUniformARB(int programObj, int index, int maxLength, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
		current.glGetActiveUniformARB(programObj, index, maxLength, length, size, type, name);
	}

	public void glGetActiveUniformARB(int programObj, int index, int maxLength, int[] length, int length_offset, int[] size, int size_offset, int[] type, int type_offset,
			byte[] name, int name_offset) {
		current.glGetActiveUniformARB(programObj, index, maxLength, length, length_offset, size, size_offset, type, type_offset, name, name_offset);
	}

	public void glGetAttachedObjectsARB(int containerObj, int maxCount, IntBuffer count, IntBuffer obj) {
		current.glGetAttachedObjectsARB(containerObj, maxCount, count, obj);
	}

	public void glGetAttachedObjectsARB(int containerObj, int maxCount, int[] count, int count_offset, int[] obj, int obj_offset) {
		current.glGetAttachedObjectsARB(containerObj, maxCount, count, count_offset, obj, obj_offset);
	}

	public void glGetBooleanIndexedv(int target, int index, ByteBuffer data) {
		current.glGetBooleanIndexedv(target, index, data);
	}

	public void glGetBooleanIndexedv(int target, int index, byte[] data, int data_offset) {
		current.glGetBooleanIndexedv(target, index, data, data_offset);
	}

	public void glGetClipPlane(int plane, DoubleBuffer equation) {
		current.glGetClipPlane(plane, equation);
	}

	public void glGetClipPlane(int plane, double[] equation, int equation_offset) {
		current.glGetClipPlane(plane, equation, equation_offset);
	}

	public void glGetClipPlanef(int plane, FloatBuffer equation) {
		current.glGetClipPlanef(plane, equation);
	}

	public void glGetClipPlanef(int plane, float[] equation, int equation_offset) {
		current.glGetClipPlanef(plane, equation, equation_offset);
	}

	public void glGetColorTable(int target, int format, int type, Buffer table) {
		current.glGetColorTable(target, format, type, table);
	}

	public void glGetColorTable(int target, int format, int type, long table_buffer_offset) {
		current.glGetColorTable(target, format, type, table_buffer_offset);
	}

	public void glGetColorTableParameterfv(int target, int pname, FloatBuffer params) {
		current.glGetColorTableParameterfv(target, pname, params);
	}

	public void glGetColorTableParameterfv(int target, int pname, float[] params, int params_offset) {
		current.glGetColorTableParameterfv(target, pname, params, params_offset);
	}

	public void glGetColorTableParameteriv(int target, int pname, IntBuffer params) {
		current.glGetColorTableParameteriv(target, pname, params);
	}

	public void glGetColorTableParameteriv(int target, int pname, int[] params, int params_offset) {
		current.glGetColorTableParameteriv(target, pname, params, params_offset);
	}

	public void glGetCompressedMultiTexImageEXT(int texunit, int target, int lod, Buffer img) {
		current.glGetCompressedMultiTexImageEXT(texunit, target, lod, img);
	}

	public void glGetCompressedTextureImageEXT(int texture, int target, int lod, Buffer img) {
		current.glGetCompressedTextureImageEXT(texture, target, lod, img);
	}

	public void glGetConvolutionFilter(int target, int format, int type, Buffer image) {
		current.glGetConvolutionFilter(target, format, type, image);
	}

	public void glGetConvolutionFilter(int target, int format, int type, long image_buffer_offset) {
		current.glGetConvolutionFilter(target, format, type, image_buffer_offset);
	}

	public void glGetConvolutionParameterfv(int target, int pname, FloatBuffer params) {
		current.glGetConvolutionParameterfv(target, pname, params);
	}

	public void glGetConvolutionParameterfv(int target, int pname, float[] params, int params_offset) {
		current.glGetConvolutionParameterfv(target, pname, params, params_offset);
	}

	public void glGetConvolutionParameteriv(int target, int pname, IntBuffer params) {
		current.glGetConvolutionParameteriv(target, pname, params);
	}

	public void glGetConvolutionParameteriv(int target, int pname, int[] params, int params_offset) {
		current.glGetConvolutionParameteriv(target, pname, params, params_offset);
	}

	public void glGetDoubleIndexedvEXT(int target, int index, DoubleBuffer data) {
		current.glGetDoubleIndexedvEXT(target, index, data);
	}

	public void glGetDoubleIndexedvEXT(int target, int index, double[] data, int data_offset) {
		current.glGetDoubleIndexedvEXT(target, index, data, data_offset);
	}

	public void glGetDoublei_vEXT(int pname, int index, DoubleBuffer params) {
		current.glGetDoublei_vEXT(pname, index, params);
	}

	public void glGetDoublei_vEXT(int pname, int index, double[] params, int params_offset) {
		current.glGetDoublei_vEXT(pname, index, params, params_offset);
	}

	public void glGetFenceivNV(int fence, int pname, IntBuffer params) {
		current.glGetFenceivNV(fence, pname, params);
	}

	public void glGetFenceivNV(int fence, int pname, int[] params, int params_offset) {
		current.glGetFenceivNV(fence, pname, params, params_offset);
	}

	public void glGetFloatIndexedvEXT(int target, int index, FloatBuffer data) {
		current.glGetFloatIndexedvEXT(target, index, data);
	}

	public void glGetFloatIndexedvEXT(int target, int index, float[] data, int data_offset) {
		current.glGetFloatIndexedvEXT(target, index, data, data_offset);
	}

	public void glGetFloati_vEXT(int pname, int index, FloatBuffer params) {
		current.glGetFloati_vEXT(pname, index, params);
	}

	public void glGetFloati_vEXT(int pname, int index, float[] params, int params_offset) {
		current.glGetFloati_vEXT(pname, index, params, params_offset);
	}

	public void glGetFramebufferParameterivEXT(int framebuffer, int pname, IntBuffer params) {
		current.glGetFramebufferParameterivEXT(framebuffer, pname, params);
	}

	public void glGetFramebufferParameterivEXT(int framebuffer, int pname, int[] params, int params_offset) {
		current.glGetFramebufferParameterivEXT(framebuffer, pname, params, params_offset);
	}

	public int glGetHandleARB(int pname) {
		return current.glGetHandleARB(pname);
	}

	public void glGetHistogram(int target, boolean reset, int format, int type, Buffer values) {
		current.glGetHistogram(target, reset, format, type, values);
	}

	public void glGetHistogram(int target, boolean reset, int format, int type, long values_buffer_offset) {
		current.glGetHistogram(target, reset, format, type, values_buffer_offset);
	}

	public void glGetHistogramParameterfv(int target, int pname, FloatBuffer params) {
		current.glGetHistogramParameterfv(target, pname, params);
	}

	public void glGetHistogramParameterfv(int target, int pname, float[] params, int params_offset) {
		current.glGetHistogramParameterfv(target, pname, params, params_offset);
	}

	public void glGetHistogramParameteriv(int target, int pname, IntBuffer params) {
		current.glGetHistogramParameteriv(target, pname, params);
	}

	public void glGetHistogramParameteriv(int target, int pname, int[] params, int params_offset) {
		current.glGetHistogramParameteriv(target, pname, params, params_offset);
	}

	public long glGetImageHandleNV(int texture, int level, boolean layered, int layer, int format) {
		return current.glGetImageHandleNV(texture, level, layered, layer, format);
	}

	public void glGetInfoLogARB(int obj, int maxLength, IntBuffer length, ByteBuffer infoLog) {
		current.glGetInfoLogARB(obj, maxLength, length, infoLog);
	}

	public void glGetInfoLogARB(int obj, int maxLength, int[] length, int length_offset, byte[] infoLog, int infoLog_offset) {
		current.glGetInfoLogARB(obj, maxLength, length, length_offset, infoLog, infoLog_offset);
	}

	public void glGetIntegerIndexedv(int target, int index, IntBuffer data) {
		current.glGetIntegerIndexedv(target, index, data);
	}

	public void glGetIntegerIndexedv(int target, int index, int[] data, int data_offset) {
		current.glGetIntegerIndexedv(target, index, data, data_offset);
	}

	public void glGetInvariantBooleanvEXT(int id, int value, ByteBuffer data) {
		current.glGetInvariantBooleanvEXT(id, value, data);
	}

	public void glGetInvariantBooleanvEXT(int id, int value, byte[] data, int data_offset) {
		current.glGetInvariantBooleanvEXT(id, value, data, data_offset);
	}

	public void glGetInvariantFloatvEXT(int id, int value, FloatBuffer data) {
		current.glGetInvariantFloatvEXT(id, value, data);
	}

	public void glGetInvariantFloatvEXT(int id, int value, float[] data, int data_offset) {
		current.glGetInvariantFloatvEXT(id, value, data, data_offset);
	}

	public void glGetInvariantIntegervEXT(int id, int value, IntBuffer data) {
		current.glGetInvariantIntegervEXT(id, value, data);
	}

	public void glGetInvariantIntegervEXT(int id, int value, int[] data, int data_offset) {
		current.glGetInvariantIntegervEXT(id, value, data, data_offset);
	}

	public void glGetLightiv(int light, int pname, IntBuffer params) {
		current.glGetLightiv(light, pname, params);
	}

	public void glGetLightiv(int light, int pname, int[] params, int params_offset) {
		current.glGetLightiv(light, pname, params, params_offset);
	}

	public void glGetLocalConstantBooleanvEXT(int id, int value, ByteBuffer data) {
		current.glGetLocalConstantBooleanvEXT(id, value, data);
	}

	public void glGetLocalConstantBooleanvEXT(int id, int value, byte[] data, int data_offset) {
		current.glGetLocalConstantBooleanvEXT(id, value, data, data_offset);
	}

	public void glGetLocalConstantFloatvEXT(int id, int value, FloatBuffer data) {
		current.glGetLocalConstantFloatvEXT(id, value, data);
	}

	public void glGetLocalConstantFloatvEXT(int id, int value, float[] data, int data_offset) {
		current.glGetLocalConstantFloatvEXT(id, value, data, data_offset);
	}

	public void glGetLocalConstantIntegervEXT(int id, int value, IntBuffer data) {
		current.glGetLocalConstantIntegervEXT(id, value, data);
	}

	public void glGetLocalConstantIntegervEXT(int id, int value, int[] data, int data_offset) {
		current.glGetLocalConstantIntegervEXT(id, value, data, data_offset);
	}

	public void glGetMapAttribParameterfvNV(int target, int index, int pname, FloatBuffer params) {
		current.glGetMapAttribParameterfvNV(target, index, pname, params);
	}

	public void glGetMapAttribParameterfvNV(int target, int index, int pname, float[] params, int params_offset) {
		current.glGetMapAttribParameterfvNV(target, index, pname, params, params_offset);
	}

	public void glGetMapAttribParameterivNV(int target, int index, int pname, IntBuffer params) {
		current.glGetMapAttribParameterivNV(target, index, pname, params);
	}

	public void glGetMapAttribParameterivNV(int target, int index, int pname, int[] params, int params_offset) {
		current.glGetMapAttribParameterivNV(target, index, pname, params, params_offset);
	}

	public void glGetMapControlPointsNV(int target, int index, int type, int ustride, int vstride, boolean packed, Buffer points) {
		current.glGetMapControlPointsNV(target, index, type, ustride, vstride, packed, points);
	}

	public void glGetMapParameterfvNV(int target, int pname, FloatBuffer params) {
		current.glGetMapParameterfvNV(target, pname, params);
	}

	public void glGetMapParameterfvNV(int target, int pname, float[] params, int params_offset) {
		current.glGetMapParameterfvNV(target, pname, params, params_offset);
	}

	public void glGetMapParameterivNV(int target, int pname, IntBuffer params) {
		current.glGetMapParameterivNV(target, pname, params);
	}

	public void glGetMapParameterivNV(int target, int pname, int[] params, int params_offset) {
		current.glGetMapParameterivNV(target, pname, params, params_offset);
	}

	public void glGetMapdv(int target, int query, DoubleBuffer v) {
		current.glGetMapdv(target, query, v);
	}

	public void glGetMapdv(int target, int query, double[] v, int v_offset) {
		current.glGetMapdv(target, query, v, v_offset);
	}

	public void glGetMapfv(int target, int query, FloatBuffer v) {
		current.glGetMapfv(target, query, v);
	}

	public void glGetMapfv(int target, int query, float[] v, int v_offset) {
		current.glGetMapfv(target, query, v, v_offset);
	}

	public void glGetMapiv(int target, int query, IntBuffer v) {
		current.glGetMapiv(target, query, v);
	}

	public void glGetMapiv(int target, int query, int[] v, int v_offset) {
		current.glGetMapiv(target, query, v, v_offset);
	}

	public void glGetMaterialiv(int face, int pname, IntBuffer params) {
		current.glGetMaterialiv(face, pname, params);
	}

	public void glGetMaterialiv(int face, int pname, int[] params, int params_offset) {
		current.glGetMaterialiv(face, pname, params, params_offset);
	}

	public void glGetMinmax(int target, boolean reset, int format, int type, Buffer values) {
		current.glGetMinmax(target, reset, format, type, values);
	}

	public void glGetMinmax(int target, boolean reset, int format, int type, long values_buffer_offset) {
		current.glGetMinmax(target, reset, format, type, values_buffer_offset);
	}

	public void glGetMinmaxParameterfv(int target, int pname, FloatBuffer params) {
		current.glGetMinmaxParameterfv(target, pname, params);
	}

	public void glGetMinmaxParameterfv(int target, int pname, float[] params, int params_offset) {
		current.glGetMinmaxParameterfv(target, pname, params, params_offset);
	}

	public void glGetMinmaxParameteriv(int target, int pname, IntBuffer params) {
		current.glGetMinmaxParameteriv(target, pname, params);
	}

	public void glGetMinmaxParameteriv(int target, int pname, int[] params, int params_offset) {
		current.glGetMinmaxParameteriv(target, pname, params, params_offset);
	}

	public void glGetMultiTexEnvfvEXT(int texunit, int target, int pname, FloatBuffer params) {
		current.glGetMultiTexEnvfvEXT(texunit, target, pname, params);
	}

	public void glGetMultiTexEnvfvEXT(int texunit, int target, int pname, float[] params, int params_offset) {
		current.glGetMultiTexEnvfvEXT(texunit, target, pname, params, params_offset);
	}

	public void glGetMultiTexEnvivEXT(int texunit, int target, int pname, IntBuffer params) {
		current.glGetMultiTexEnvivEXT(texunit, target, pname, params);
	}

	public void glGetMultiTexEnvivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		current.glGetMultiTexEnvivEXT(texunit, target, pname, params, params_offset);
	}

	public void glGetMultiTexGendvEXT(int texunit, int coord, int pname, DoubleBuffer params) {
		current.glGetMultiTexGendvEXT(texunit, coord, pname, params);
	}

	public void glGetMultiTexGendvEXT(int texunit, int coord, int pname, double[] params, int params_offset) {
		current.glGetMultiTexGendvEXT(texunit, coord, pname, params, params_offset);
	}

	public void glGetMultiTexGenfvEXT(int texunit, int coord, int pname, FloatBuffer params) {
		current.glGetMultiTexGenfvEXT(texunit, coord, pname, params);
	}

	public void glGetMultiTexGenfvEXT(int texunit, int coord, int pname, float[] params, int params_offset) {
		current.glGetMultiTexGenfvEXT(texunit, coord, pname, params, params_offset);
	}

	public void glGetMultiTexGenivEXT(int texunit, int coord, int pname, IntBuffer params) {
		current.glGetMultiTexGenivEXT(texunit, coord, pname, params);
	}

	public void glGetMultiTexGenivEXT(int texunit, int coord, int pname, int[] params, int params_offset) {
		current.glGetMultiTexGenivEXT(texunit, coord, pname, params, params_offset);
	}

	public void glGetMultiTexImageEXT(int texunit, int target, int level, int format, int type, Buffer pixels) {
		current.glGetMultiTexImageEXT(texunit, target, level, format, type, pixels);
	}

	public void glGetMultiTexLevelParameterfvEXT(int texunit, int target, int level, int pname, FloatBuffer params) {
		current.glGetMultiTexLevelParameterfvEXT(texunit, target, level, pname, params);
	}

	public void glGetMultiTexLevelParameterfvEXT(int texunit, int target, int level, int pname, float[] params, int params_offset) {
		current.glGetMultiTexLevelParameterfvEXT(texunit, target, level, pname, params, params_offset);
	}

	public void glGetMultiTexLevelParameterivEXT(int texunit, int target, int level, int pname, IntBuffer params) {
		current.glGetMultiTexLevelParameterivEXT(texunit, target, level, pname, params);
	}

	public void glGetMultiTexLevelParameterivEXT(int texunit, int target, int level, int pname, int[] params, int params_offset) {
		current.glGetMultiTexLevelParameterivEXT(texunit, target, level, pname, params, params_offset);
	}

	public void glGetMultiTexParameterIivEXT(int texunit, int target, int pname, IntBuffer params) {
		current.glGetMultiTexParameterIivEXT(texunit, target, pname, params);
	}

	public void glGetMultiTexParameterIivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		current.glGetMultiTexParameterIivEXT(texunit, target, pname, params, params_offset);
	}

	public void glGetMultiTexParameterIuivEXT(int texunit, int target, int pname, IntBuffer params) {
		current.glGetMultiTexParameterIuivEXT(texunit, target, pname, params);
	}

	public void glGetMultiTexParameterIuivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		current.glGetMultiTexParameterIuivEXT(texunit, target, pname, params, params_offset);
	}

	public void glGetMultiTexParameterfvEXT(int texunit, int target, int pname, FloatBuffer params) {
		current.glGetMultiTexParameterfvEXT(texunit, target, pname, params);
	}

	public void glGetMultiTexParameterfvEXT(int texunit, int target, int pname, float[] params, int params_offset) {
		current.glGetMultiTexParameterfvEXT(texunit, target, pname, params, params_offset);
	}

	public void glGetMultiTexParameterivEXT(int texunit, int target, int pname, IntBuffer params) {
		current.glGetMultiTexParameterivEXT(texunit, target, pname, params);
	}

	public void glGetMultiTexParameterivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		current.glGetMultiTexParameterivEXT(texunit, target, pname, params, params_offset);
	}

	public void glGetMultisamplefvNV(int pname, int index, FloatBuffer val) {
		current.glGetMultisamplefvNV(pname, index, val);
	}

	public void glGetMultisamplefvNV(int pname, int index, float[] val, int val_offset) {
		current.glGetMultisamplefvNV(pname, index, val, val_offset);
	}

	public void glGetNamedBufferParameterivEXT(int buffer, int pname, IntBuffer params) {
		current.glGetNamedBufferParameterivEXT(buffer, pname, params);
	}

	public void glGetNamedBufferParameterivEXT(int buffer, int pname, int[] params, int params_offset) {
		current.glGetNamedBufferParameterivEXT(buffer, pname, params, params_offset);
	}

	public void glGetNamedBufferSubDataEXT(int buffer, long offset, long size, Buffer data) {
		current.glGetNamedBufferSubDataEXT(buffer, offset, size, data);
	}

	public void glGetNamedFramebufferAttachmentParameterivEXT(int framebuffer, int attachment, int pname, IntBuffer params) {
		current.glGetNamedFramebufferAttachmentParameterivEXT(framebuffer, attachment, pname, params);
	}

	public void glGetNamedFramebufferAttachmentParameterivEXT(int framebuffer, int attachment, int pname, int[] params, int params_offset) {
		current.glGetNamedFramebufferAttachmentParameterivEXT(framebuffer, attachment, pname, params, params_offset);
	}

	public void glGetNamedProgramLocalParameterIivEXT(int program, int target, int index, IntBuffer params) {
		current.glGetNamedProgramLocalParameterIivEXT(program, target, index, params);
	}

	public void glGetNamedProgramLocalParameterIivEXT(int program, int target, int index, int[] params, int params_offset) {
		current.glGetNamedProgramLocalParameterIivEXT(program, target, index, params, params_offset);
	}

	public void glGetNamedProgramLocalParameterIuivEXT(int program, int target, int index, IntBuffer params) {
		current.glGetNamedProgramLocalParameterIuivEXT(program, target, index, params);
	}

	public void glGetNamedProgramLocalParameterIuivEXT(int program, int target, int index, int[] params, int params_offset) {
		current.glGetNamedProgramLocalParameterIuivEXT(program, target, index, params, params_offset);
	}

	public void glGetNamedProgramLocalParameterdvEXT(int program, int target, int index, DoubleBuffer params) {
		current.glGetNamedProgramLocalParameterdvEXT(program, target, index, params);
	}

	public void glGetNamedProgramLocalParameterdvEXT(int program, int target, int index, double[] params, int params_offset) {
		current.glGetNamedProgramLocalParameterdvEXT(program, target, index, params, params_offset);
	}

	public void glGetNamedProgramLocalParameterfvEXT(int program, int target, int index, FloatBuffer params) {
		current.glGetNamedProgramLocalParameterfvEXT(program, target, index, params);
	}

	public void glGetNamedProgramLocalParameterfvEXT(int program, int target, int index, float[] params, int params_offset) {
		current.glGetNamedProgramLocalParameterfvEXT(program, target, index, params, params_offset);
	}

	public void glGetNamedProgramStringEXT(int program, int target, int pname, Buffer string) {
		current.glGetNamedProgramStringEXT(program, target, pname, string);
	}

	public void glGetNamedProgramivEXT(int program, int target, int pname, IntBuffer params) {
		current.glGetNamedProgramivEXT(program, target, pname, params);
	}

	public void glGetNamedProgramivEXT(int program, int target, int pname, int[] params, int params_offset) {
		current.glGetNamedProgramivEXT(program, target, pname, params, params_offset);
	}

	public void glGetNamedRenderbufferParameterivEXT(int renderbuffer, int pname, IntBuffer params) {
		current.glGetNamedRenderbufferParameterivEXT(renderbuffer, pname, params);
	}

	public void glGetNamedRenderbufferParameterivEXT(int renderbuffer, int pname, int[] params, int params_offset) {
		current.glGetNamedRenderbufferParameterivEXT(renderbuffer, pname, params, params_offset);
	}

	public void glGetObjectParameterfvARB(int obj, int pname, FloatBuffer params) {
		current.glGetObjectParameterfvARB(obj, pname, params);
	}

	public void glGetObjectParameterfvARB(int obj, int pname, float[] params, int params_offset) {
		current.glGetObjectParameterfvARB(obj, pname, params, params_offset);
	}

	public void glGetObjectParameterivAPPLE(int objectType, int name, int pname, IntBuffer params) {
		current.glGetObjectParameterivAPPLE(objectType, name, pname, params);
	}

	public void glGetObjectParameterivAPPLE(int objectType, int name, int pname, int[] params, int params_offset) {
		current.glGetObjectParameterivAPPLE(objectType, name, pname, params, params_offset);
	}

	public void glGetObjectParameterivARB(int obj, int pname, IntBuffer params) {
		current.glGetObjectParameterivARB(obj, pname, params);
	}

	public void glGetObjectParameterivARB(int obj, int pname, int[] params, int params_offset) {
		current.glGetObjectParameterivARB(obj, pname, params, params_offset);
	}

	public void glGetOcclusionQueryivNV(int id, int pname, IntBuffer params) {
		current.glGetOcclusionQueryivNV(id, pname, params);
	}

	public void glGetOcclusionQueryivNV(int id, int pname, int[] params, int params_offset) {
		current.glGetOcclusionQueryivNV(id, pname, params, params_offset);
	}

	public void glGetOcclusionQueryuivNV(int id, int pname, IntBuffer params) {
		current.glGetOcclusionQueryuivNV(id, pname, params);
	}

	public void glGetOcclusionQueryuivNV(int id, int pname, int[] params, int params_offset) {
		current.glGetOcclusionQueryuivNV(id, pname, params, params_offset);
	}

	public void glGetPathColorGenfvNV(int color, int pname, FloatBuffer value) {
		current.glGetPathColorGenfvNV(color, pname, value);
	}

	public void glGetPathColorGenfvNV(int color, int pname, float[] value, int value_offset) {
		current.glGetPathColorGenfvNV(color, pname, value, value_offset);
	}

	public void glGetPathColorGenivNV(int color, int pname, IntBuffer value) {
		current.glGetPathColorGenivNV(color, pname, value);
	}

	public void glGetPathColorGenivNV(int color, int pname, int[] value, int value_offset) {
		current.glGetPathColorGenivNV(color, pname, value, value_offset);
	}

	public void glGetPathCommandsNV(int path, ByteBuffer commands) {
		current.glGetPathCommandsNV(path, commands);
	}

	public void glGetPathCommandsNV(int path, byte[] commands, int commands_offset) {
		current.glGetPathCommandsNV(path, commands, commands_offset);
	}

	public void glGetPathCoordsNV(int path, FloatBuffer coords) {
		current.glGetPathCoordsNV(path, coords);
	}

	public void glGetPathCoordsNV(int path, float[] coords, int coords_offset) {
		current.glGetPathCoordsNV(path, coords, coords_offset);
	}

	public void glGetPathDashArrayNV(int path, FloatBuffer dashArray) {
		current.glGetPathDashArrayNV(path, dashArray);
	}

	public void glGetPathDashArrayNV(int path, float[] dashArray, int dashArray_offset) {
		current.glGetPathDashArrayNV(path, dashArray, dashArray_offset);
	}

	public float glGetPathLengthNV(int path, int startSegment, int numSegments) {
		return current.glGetPathLengthNV(path, startSegment, numSegments);
	}

	public void glGetPathMetricRangeNV(int metricQueryMask, int firstPathName, int numPaths, int stride, FloatBuffer metrics) {
		current.glGetPathMetricRangeNV(metricQueryMask, firstPathName, numPaths, stride, metrics);
	}

	public void glGetPathMetricRangeNV(int metricQueryMask, int firstPathName, int numPaths, int stride, float[] metrics, int metrics_offset) {
		current.glGetPathMetricRangeNV(metricQueryMask, firstPathName, numPaths, stride, metrics, metrics_offset);
	}

	public void glGetPathMetricsNV(int metricQueryMask, int numPaths, int pathNameType, Buffer paths, int pathBase, int stride, FloatBuffer metrics) {
		current.glGetPathMetricsNV(metricQueryMask, numPaths, pathNameType, paths, pathBase, stride, metrics);
	}

	public void glGetPathMetricsNV(int metricQueryMask, int numPaths, int pathNameType, Buffer paths, int pathBase, int stride, float[] metrics, int metrics_offset) {
		current.glGetPathMetricsNV(metricQueryMask, numPaths, pathNameType, paths, pathBase, stride, metrics, metrics_offset);
	}

	public void glGetPathParameterfvNV(int path, int pname, FloatBuffer value) {
		current.glGetPathParameterfvNV(path, pname, value);
	}

	public void glGetPathParameterfvNV(int path, int pname, float[] value, int value_offset) {
		current.glGetPathParameterfvNV(path, pname, value, value_offset);
	}

	public void glGetPathParameterivNV(int path, int pname, IntBuffer value) {
		current.glGetPathParameterivNV(path, pname, value);
	}

	public void glGetPathParameterivNV(int path, int pname, int[] value, int value_offset) {
		current.glGetPathParameterivNV(path, pname, value, value_offset);
	}

	public void glGetPathSpacingNV(int pathListMode, int numPaths, int pathNameType, Buffer paths, int pathBase, float advanceScale, float kerningScale, int transformType,
			FloatBuffer returnedSpacing) {
		current.glGetPathSpacingNV(pathListMode, numPaths, pathNameType, paths, pathBase, advanceScale, kerningScale, transformType, returnedSpacing);
	}

	public void glGetPathSpacingNV(int pathListMode, int numPaths, int pathNameType, Buffer paths, int pathBase, float advanceScale, float kerningScale, int transformType,
			float[] returnedSpacing, int returnedSpacing_offset) {
		current.glGetPathSpacingNV(pathListMode, numPaths, pathNameType, paths, pathBase, advanceScale, kerningScale, transformType, returnedSpacing, returnedSpacing_offset);
	}

	public void glGetPathTexGenfvNV(int texCoordSet, int pname, FloatBuffer value) {
		current.glGetPathTexGenfvNV(texCoordSet, pname, value);
	}

	public void glGetPathTexGenfvNV(int texCoordSet, int pname, float[] value, int value_offset) {
		current.glGetPathTexGenfvNV(texCoordSet, pname, value, value_offset);
	}

	public void glGetPathTexGenivNV(int texCoordSet, int pname, IntBuffer value) {
		current.glGetPathTexGenivNV(texCoordSet, pname, value);
	}

	public void glGetPathTexGenivNV(int texCoordSet, int pname, int[] value, int value_offset) {
		current.glGetPathTexGenivNV(texCoordSet, pname, value, value_offset);
	}

	public void glGetPerfMonitorCounterDataAMD(int monitor, int pname, int dataSize, IntBuffer data, IntBuffer bytesWritten) {
		current.glGetPerfMonitorCounterDataAMD(monitor, pname, dataSize, data, bytesWritten);
	}

	public void glGetPerfMonitorCounterDataAMD(int monitor, int pname, int dataSize, int[] data, int data_offset, int[] bytesWritten, int bytesWritten_offset) {
		current.glGetPerfMonitorCounterDataAMD(monitor, pname, dataSize, data, data_offset, bytesWritten, bytesWritten_offset);
	}

	public void glGetPerfMonitorCounterInfoAMD(int group, int counter, int pname, Buffer data) {
		current.glGetPerfMonitorCounterInfoAMD(group, counter, pname, data);
	}

	public void glGetPerfMonitorCounterStringAMD(int group, int counter, int bufSize, IntBuffer length, ByteBuffer counterString) {
		current.glGetPerfMonitorCounterStringAMD(group, counter, bufSize, length, counterString);
	}

	public void glGetPerfMonitorCounterStringAMD(int group, int counter, int bufSize, int[] length, int length_offset, byte[] counterString, int counterString_offset) {
		current.glGetPerfMonitorCounterStringAMD(group, counter, bufSize, length, length_offset, counterString, counterString_offset);
	}

	public void glGetPerfMonitorCountersAMD(int group, IntBuffer numCounters, IntBuffer maxActiveCounters, int counterSize, IntBuffer counters) {
		current.glGetPerfMonitorCountersAMD(group, numCounters, maxActiveCounters, counterSize, counters);
	}

	public void glGetPerfMonitorCountersAMD(int group, int[] numCounters, int numCounters_offset, int[] maxActiveCounters, int maxActiveCounters_offset, int counterSize,
			int[] counters, int counters_offset) {
		current.glGetPerfMonitorCountersAMD(group, numCounters, numCounters_offset, maxActiveCounters, maxActiveCounters_offset, counterSize, counters, counters_offset);
	}

	public void glGetPerfMonitorGroupStringAMD(int group, int bufSize, IntBuffer length, ByteBuffer groupString) {
		current.glGetPerfMonitorGroupStringAMD(group, bufSize, length, groupString);
	}

	public void glGetPerfMonitorGroupStringAMD(int group, int bufSize, int[] length, int length_offset, byte[] groupString, int groupString_offset) {
		current.glGetPerfMonitorGroupStringAMD(group, bufSize, length, length_offset, groupString, groupString_offset);
	}

	public void glGetPerfMonitorGroupsAMD(IntBuffer numGroups, int groupsSize, IntBuffer groups) {
		current.glGetPerfMonitorGroupsAMD(numGroups, groupsSize, groups);
	}

	public void glGetPerfMonitorGroupsAMD(int[] numGroups, int numGroups_offset, int groupsSize, int[] groups, int groups_offset) {
		current.glGetPerfMonitorGroupsAMD(numGroups, numGroups_offset, groupsSize, groups, groups_offset);
	}

	public void glGetPixelMapfv(int map, FloatBuffer values) {
		current.glGetPixelMapfv(map, values);
	}

	public void glGetPixelMapfv(int map, float[] values, int values_offset) {
		current.glGetPixelMapfv(map, values, values_offset);
	}

	public void glGetPixelMapfv(int map, long values_buffer_offset) {
		current.glGetPixelMapfv(map, values_buffer_offset);
	}

	public void glGetPixelMapuiv(int map, IntBuffer values) {
		current.glGetPixelMapuiv(map, values);
	}

	public void glGetPixelMapuiv(int map, int[] values, int values_offset) {
		current.glGetPixelMapuiv(map, values, values_offset);
	}

	public void glGetPixelMapuiv(int map, long values_buffer_offset) {
		current.glGetPixelMapuiv(map, values_buffer_offset);
	}

	public void glGetPixelMapusv(int map, ShortBuffer values) {
		current.glGetPixelMapusv(map, values);
	}

	public void glGetPixelMapusv(int map, short[] values, int values_offset) {
		current.glGetPixelMapusv(map, values, values_offset);
	}

	public void glGetPixelMapusv(int map, long values_buffer_offset) {
		current.glGetPixelMapusv(map, values_buffer_offset);
	}

	public void glGetPixelTransformParameterfvEXT(int target, int pname, FloatBuffer params) {
		current.glGetPixelTransformParameterfvEXT(target, pname, params);
	}

	public void glGetPixelTransformParameterfvEXT(int target, int pname, float[] params, int params_offset) {
		current.glGetPixelTransformParameterfvEXT(target, pname, params, params_offset);
	}

	public void glGetPixelTransformParameterivEXT(int target, int pname, IntBuffer params) {
		current.glGetPixelTransformParameterivEXT(target, pname, params);
	}

	public void glGetPixelTransformParameterivEXT(int target, int pname, int[] params, int params_offset) {
		current.glGetPixelTransformParameterivEXT(target, pname, params, params_offset);
	}

	public void glGetPointeri_vEXT(int pname, int index, PointerBuffer params) {
		current.glGetPointeri_vEXT(pname, index, params);
	}

	public void glGetPolygonStipple(ByteBuffer mask) {
		current.glGetPolygonStipple(mask);
	}

	public void glGetPolygonStipple(byte[] mask, int mask_offset) {
		current.glGetPolygonStipple(mask, mask_offset);
	}

	public void glGetPolygonStipple(long mask_buffer_offset) {
		current.glGetPolygonStipple(mask_buffer_offset);
	}

	public void glGetProgramEnvParameterIivNV(int target, int index, IntBuffer params) {
		current.glGetProgramEnvParameterIivNV(target, index, params);
	}

	public void glGetProgramEnvParameterIivNV(int target, int index, int[] params, int params_offset) {
		current.glGetProgramEnvParameterIivNV(target, index, params, params_offset);
	}

	public void glGetProgramEnvParameterIuivNV(int target, int index, IntBuffer params) {
		current.glGetProgramEnvParameterIuivNV(target, index, params);
	}

	public void glGetProgramEnvParameterIuivNV(int target, int index, int[] params, int params_offset) {
		current.glGetProgramEnvParameterIuivNV(target, index, params, params_offset);
	}

	public void glGetProgramEnvParameterdvARB(int target, int index, DoubleBuffer params) {
		current.glGetProgramEnvParameterdvARB(target, index, params);
	}

	public void glGetProgramEnvParameterdvARB(int target, int index, double[] params, int params_offset) {
		current.glGetProgramEnvParameterdvARB(target, index, params, params_offset);
	}

	public void glGetProgramEnvParameterfvARB(int target, int index, FloatBuffer params) {
		current.glGetProgramEnvParameterfvARB(target, index, params);
	}

	public void glGetProgramEnvParameterfvARB(int target, int index, float[] params, int params_offset) {
		current.glGetProgramEnvParameterfvARB(target, index, params, params_offset);
	}

	public void glGetProgramLocalParameterIivNV(int target, int index, IntBuffer params) {
		current.glGetProgramLocalParameterIivNV(target, index, params);
	}

	public void glGetProgramLocalParameterIivNV(int target, int index, int[] params, int params_offset) {
		current.glGetProgramLocalParameterIivNV(target, index, params, params_offset);
	}

	public void glGetProgramLocalParameterIuivNV(int target, int index, IntBuffer params) {
		current.glGetProgramLocalParameterIuivNV(target, index, params);
	}

	public void glGetProgramLocalParameterIuivNV(int target, int index, int[] params, int params_offset) {
		current.glGetProgramLocalParameterIuivNV(target, index, params, params_offset);
	}

	public void glGetProgramLocalParameterdvARB(int target, int index, DoubleBuffer params) {
		current.glGetProgramLocalParameterdvARB(target, index, params);
	}

	public void glGetProgramLocalParameterdvARB(int target, int index, double[] params, int params_offset) {
		current.glGetProgramLocalParameterdvARB(target, index, params, params_offset);
	}

	public void glGetProgramLocalParameterfvARB(int target, int index, FloatBuffer params) {
		current.glGetProgramLocalParameterfvARB(target, index, params);
	}

	public void glGetProgramLocalParameterfvARB(int target, int index, float[] params, int params_offset) {
		current.glGetProgramLocalParameterfvARB(target, index, params, params_offset);
	}

	public void glGetProgramStringARB(int target, int pname, Buffer string) {
		current.glGetProgramStringARB(target, pname, string);
	}

	public void glGetProgramSubroutineParameteruivNV(int target, int index, IntBuffer param) {
		current.glGetProgramSubroutineParameteruivNV(target, index, param);
	}

	public void glGetProgramSubroutineParameteruivNV(int target, int index, int[] param, int param_offset) {
		current.glGetProgramSubroutineParameteruivNV(target, index, param, param_offset);
	}

	public void glGetProgramivARB(int target, int pname, IntBuffer params) {
		current.glGetProgramivARB(target, pname, params);
	}

	public void glGetProgramivARB(int target, int pname, int[] params, int params_offset) {
		current.glGetProgramivARB(target, pname, params, params_offset);
	}

	public void glGetQueryObjecti64vEXT(int id, int pname, LongBuffer params) {
		current.glGetQueryObjecti64vEXT(id, pname, params);
	}

	public void glGetQueryObjecti64vEXT(int id, int pname, long[] params, int params_offset) {
		current.glGetQueryObjecti64vEXT(id, pname, params, params_offset);
	}

	public void glGetQueryObjectui64vEXT(int id, int pname, LongBuffer params) {
		current.glGetQueryObjectui64vEXT(id, pname, params);
	}

	public void glGetQueryObjectui64vEXT(int id, int pname, long[] params, int params_offset) {
		current.glGetQueryObjectui64vEXT(id, pname, params, params_offset);
	}

	public void glGetSeparableFilter(int target, int format, int type, Buffer row, Buffer column, Buffer span) {
		current.glGetSeparableFilter(target, format, type, row, column, span);
	}

	public void glGetSeparableFilter(int target, int format, int type, long row_buffer_offset, long column_buffer_offset, long span_buffer_offset) {
		current.glGetSeparableFilter(target, format, type, row_buffer_offset, column_buffer_offset, span_buffer_offset);
	}

	public void glGetShaderSourceARB(int obj, int maxLength, IntBuffer length, ByteBuffer source) {
		current.glGetShaderSourceARB(obj, maxLength, length, source);
	}

	public void glGetShaderSourceARB(int obj, int maxLength, int[] length, int length_offset, byte[] source, int source_offset) {
		current.glGetShaderSourceARB(obj, maxLength, length, length_offset, source, source_offset);
	}

	public void glGetTexGendv(int coord, int pname, DoubleBuffer params) {
		current.glGetTexGendv(coord, pname, params);
	}

	public void glGetTexGendv(int coord, int pname, double[] params, int params_offset) {
		current.glGetTexGendv(coord, pname, params, params_offset);
	}

	public long glGetTextureHandleNV(int texture) {
		return current.glGetTextureHandleNV(texture);
	}

	public void glGetTextureImageEXT(int texture, int target, int level, int format, int type, Buffer pixels) {
		current.glGetTextureImageEXT(texture, target, level, format, type, pixels);
	}

	public void glGetTextureLevelParameterfvEXT(int texture, int target, int level, int pname, FloatBuffer params) {
		current.glGetTextureLevelParameterfvEXT(texture, target, level, pname, params);
	}

	public void glGetTextureLevelParameterfvEXT(int texture, int target, int level, int pname, float[] params, int params_offset) {
		current.glGetTextureLevelParameterfvEXT(texture, target, level, pname, params, params_offset);
	}

	public void glGetTextureLevelParameterivEXT(int texture, int target, int level, int pname, IntBuffer params) {
		current.glGetTextureLevelParameterivEXT(texture, target, level, pname, params);
	}

	public void glGetTextureLevelParameterivEXT(int texture, int target, int level, int pname, int[] params, int params_offset) {
		current.glGetTextureLevelParameterivEXT(texture, target, level, pname, params, params_offset);
	}

	public void glGetTextureParameterIivEXT(int texture, int target, int pname, IntBuffer params) {
		current.glGetTextureParameterIivEXT(texture, target, pname, params);
	}

	public void glGetTextureParameterIivEXT(int texture, int target, int pname, int[] params, int params_offset) {
		current.glGetTextureParameterIivEXT(texture, target, pname, params, params_offset);
	}

	public void glGetTextureParameterIuivEXT(int texture, int target, int pname, IntBuffer params) {
		current.glGetTextureParameterIuivEXT(texture, target, pname, params);
	}

	public void glGetTextureParameterIuivEXT(int texture, int target, int pname, int[] params, int params_offset) {
		current.glGetTextureParameterIuivEXT(texture, target, pname, params, params_offset);
	}

	public void glGetTextureParameterfvEXT(int texture, int target, int pname, FloatBuffer params) {
		current.glGetTextureParameterfvEXT(texture, target, pname, params);
	}

	public void glGetTextureParameterfvEXT(int texture, int target, int pname, float[] params, int params_offset) {
		current.glGetTextureParameterfvEXT(texture, target, pname, params, params_offset);
	}

	public void glGetTextureParameterivEXT(int texture, int target, int pname, IntBuffer params) {
		current.glGetTextureParameterivEXT(texture, target, pname, params);
	}

	public void glGetTextureParameterivEXT(int texture, int target, int pname, int[] params, int params_offset) {
		current.glGetTextureParameterivEXT(texture, target, pname, params, params_offset);
	}

	public long glGetTextureSamplerHandleNV(int texture, int sampler) {
		return current.glGetTextureSamplerHandleNV(texture, sampler);
	}

	public int glGetUniformBufferSizeEXT(int program, int location) {
		return current.glGetUniformBufferSizeEXT(program, location);
	}

	public int glGetUniformLocationARB(int programObj, String name) {
		return current.glGetUniformLocationARB(programObj, name);
	}

	public long glGetUniformOffsetEXT(int program, int location) {
		return current.glGetUniformOffsetEXT(program, location);
	}

	public void glGetUniformfvARB(int programObj, int location, FloatBuffer params) {
		current.glGetUniformfvARB(programObj, location, params);
	}

	public void glGetUniformfvARB(int programObj, int location, float[] params, int params_offset) {
		current.glGetUniformfvARB(programObj, location, params, params_offset);
	}

	public void glGetUniformivARB(int programObj, int location, IntBuffer params) {
		current.glGetUniformivARB(programObj, location, params);
	}

	public void glGetUniformivARB(int programObj, int location, int[] params, int params_offset) {
		current.glGetUniformivARB(programObj, location, params, params_offset);
	}

	public void glGetVariantBooleanvEXT(int id, int value, ByteBuffer data) {
		current.glGetVariantBooleanvEXT(id, value, data);
	}

	public void glGetVariantBooleanvEXT(int id, int value, byte[] data, int data_offset) {
		current.glGetVariantBooleanvEXT(id, value, data, data_offset);
	}

	public void glGetVariantFloatvEXT(int id, int value, FloatBuffer data) {
		current.glGetVariantFloatvEXT(id, value, data);
	}

	public void glGetVariantFloatvEXT(int id, int value, float[] data, int data_offset) {
		current.glGetVariantFloatvEXT(id, value, data, data_offset);
	}

	public void glGetVariantIntegervEXT(int id, int value, IntBuffer data) {
		current.glGetVariantIntegervEXT(id, value, data);
	}

	public void glGetVariantIntegervEXT(int id, int value, int[] data, int data_offset) {
		current.glGetVariantIntegervEXT(id, value, data, data_offset);
	}

	public void glGetVertexArrayIntegeri_vEXT(int vaobj, int index, int pname, IntBuffer param) {
		current.glGetVertexArrayIntegeri_vEXT(vaobj, index, pname, param);
	}

	public void glGetVertexArrayIntegeri_vEXT(int vaobj, int index, int pname, int[] param, int param_offset) {
		current.glGetVertexArrayIntegeri_vEXT(vaobj, index, pname, param, param_offset);
	}

	public void glGetVertexArrayIntegervEXT(int vaobj, int pname, IntBuffer param) {
		current.glGetVertexArrayIntegervEXT(vaobj, pname, param);
	}

	public void glGetVertexArrayIntegervEXT(int vaobj, int pname, int[] param, int param_offset) {
		current.glGetVertexArrayIntegervEXT(vaobj, pname, param, param_offset);
	}

	public void glGetVertexArrayPointeri_vEXT(int vaobj, int index, int pname, PointerBuffer param) {
		current.glGetVertexArrayPointeri_vEXT(vaobj, index, pname, param);
	}

	public void glGetVertexArrayPointervEXT(int vaobj, int pname, PointerBuffer param) {
		current.glGetVertexArrayPointervEXT(vaobj, pname, param);
	}

	public void glGetVertexAttribIivEXT(int index, int pname, IntBuffer params) {
		current.glGetVertexAttribIivEXT(index, pname, params);
	}

	public void glGetVertexAttribIivEXT(int index, int pname, int[] params, int params_offset) {
		current.glGetVertexAttribIivEXT(index, pname, params, params_offset);
	}

	public void glGetVertexAttribIuivEXT(int index, int pname, IntBuffer params) {
		current.glGetVertexAttribIuivEXT(index, pname, params);
	}

	public void glGetVertexAttribIuivEXT(int index, int pname, int[] params, int params_offset) {
		current.glGetVertexAttribIuivEXT(index, pname, params, params_offset);
	}

	public void glGetVertexAttribLi64vNV(int index, int pname, LongBuffer params) {
		current.glGetVertexAttribLi64vNV(index, pname, params);
	}

	public void glGetVertexAttribLi64vNV(int index, int pname, long[] params, int params_offset) {
		current.glGetVertexAttribLi64vNV(index, pname, params, params_offset);
	}

	public void glGetVertexAttribLui64vNV(int index, int pname, LongBuffer params) {
		current.glGetVertexAttribLui64vNV(index, pname, params);
	}

	public void glGetVertexAttribLui64vNV(int index, int pname, long[] params, int params_offset) {
		current.glGetVertexAttribLui64vNV(index, pname, params, params_offset);
	}

	public void glGetVertexAttribdvARB(int index, int pname, DoubleBuffer params) {
		current.glGetVertexAttribdvARB(index, pname, params);
	}

	public void glGetVertexAttribdvARB(int index, int pname, double[] params, int params_offset) {
		current.glGetVertexAttribdvARB(index, pname, params, params_offset);
	}

	public void glGetVertexAttribfvARB(int index, int pname, FloatBuffer params) {
		current.glGetVertexAttribfvARB(index, pname, params);
	}

	public void glGetVertexAttribfvARB(int index, int pname, float[] params, int params_offset) {
		current.glGetVertexAttribfvARB(index, pname, params, params_offset);
	}

	public void glGetVertexAttribivARB(int index, int pname, IntBuffer params) {
		current.glGetVertexAttribivARB(index, pname, params);
	}

	public void glGetVertexAttribivARB(int index, int pname, int[] params, int params_offset) {
		current.glGetVertexAttribivARB(index, pname, params, params_offset);
	}

	public void glGetVideoCaptureStreamdvNV(int video_capture_slot, int stream, int pname, DoubleBuffer params) {
		current.glGetVideoCaptureStreamdvNV(video_capture_slot, stream, pname, params);
	}

	public void glGetVideoCaptureStreamdvNV(int video_capture_slot, int stream, int pname, double[] params, int params_offset) {
		current.glGetVideoCaptureStreamdvNV(video_capture_slot, stream, pname, params, params_offset);
	}

	public void glGetVideoCaptureStreamfvNV(int video_capture_slot, int stream, int pname, FloatBuffer params) {
		current.glGetVideoCaptureStreamfvNV(video_capture_slot, stream, pname, params);
	}

	public void glGetVideoCaptureStreamfvNV(int video_capture_slot, int stream, int pname, float[] params, int params_offset) {
		current.glGetVideoCaptureStreamfvNV(video_capture_slot, stream, pname, params, params_offset);
	}

	public void glGetVideoCaptureStreamivNV(int video_capture_slot, int stream, int pname, IntBuffer params) {
		current.glGetVideoCaptureStreamivNV(video_capture_slot, stream, pname, params);
	}

	public void glGetVideoCaptureStreamivNV(int video_capture_slot, int stream, int pname, int[] params, int params_offset) {
		current.glGetVideoCaptureStreamivNV(video_capture_slot, stream, pname, params, params_offset);
	}

	public void glGetVideoCaptureivNV(int video_capture_slot, int pname, IntBuffer params) {
		current.glGetVideoCaptureivNV(video_capture_slot, pname, params);
	}

	public void glGetVideoCaptureivNV(int video_capture_slot, int pname, int[] params, int params_offset) {
		current.glGetVideoCaptureivNV(video_capture_slot, pname, params, params_offset);
	}

	public void glGetnColorTable(int target, int format, int type, int bufSize, Buffer table) {
		current.glGetnColorTable(target, format, type, bufSize, table);
	}

	public void glGetnConvolutionFilter(int target, int format, int type, int bufSize, Buffer image) {
		current.glGetnConvolutionFilter(target, format, type, bufSize, image);
	}

	public void glGetnHistogram(int target, boolean reset, int format, int type, int bufSize, Buffer values) {
		current.glGetnHistogram(target, reset, format, type, bufSize, values);
	}

	public void glGetnMapdv(int target, int query, int bufSize, DoubleBuffer v) {
		current.glGetnMapdv(target, query, bufSize, v);
	}

	public void glGetnMapdv(int target, int query, int bufSize, double[] v, int v_offset) {
		current.glGetnMapdv(target, query, bufSize, v, v_offset);
	}

	public void glGetnMapfv(int target, int query, int bufSize, FloatBuffer v) {
		current.glGetnMapfv(target, query, bufSize, v);
	}

	public void glGetnMapfv(int target, int query, int bufSize, float[] v, int v_offset) {
		current.glGetnMapfv(target, query, bufSize, v, v_offset);
	}

	public void glGetnMapiv(int target, int query, int bufSize, IntBuffer v) {
		current.glGetnMapiv(target, query, bufSize, v);
	}

	public void glGetnMapiv(int target, int query, int bufSize, int[] v, int v_offset) {
		current.glGetnMapiv(target, query, bufSize, v, v_offset);
	}

	public void glGetnMinmax(int target, boolean reset, int format, int type, int bufSize, Buffer values) {
		current.glGetnMinmax(target, reset, format, type, bufSize, values);
	}

	public void glGetnPixelMapfv(int map, int bufSize, FloatBuffer values) {
		current.glGetnPixelMapfv(map, bufSize, values);
	}

	public void glGetnPixelMapfv(int map, int bufSize, float[] values, int values_offset) {
		current.glGetnPixelMapfv(map, bufSize, values, values_offset);
	}

	public void glGetnPixelMapuiv(int map, int bufSize, IntBuffer values) {
		current.glGetnPixelMapuiv(map, bufSize, values);
	}

	public void glGetnPixelMapuiv(int map, int bufSize, int[] values, int values_offset) {
		current.glGetnPixelMapuiv(map, bufSize, values, values_offset);
	}

	public void glGetnPixelMapusv(int map, int bufSize, ShortBuffer values) {
		current.glGetnPixelMapusv(map, bufSize, values);
	}

	public void glGetnPixelMapusv(int map, int bufSize, short[] values, int values_offset) {
		current.glGetnPixelMapusv(map, bufSize, values, values_offset);
	}

	public void glGetnPolygonStipple(int bufSize, ByteBuffer pattern) {
		current.glGetnPolygonStipple(bufSize, pattern);
	}

	public void glGetnPolygonStipple(int bufSize, byte[] pattern, int pattern_offset) {
		current.glGetnPolygonStipple(bufSize, pattern, pattern_offset);
	}

	public void glGetnSeparableFilter(int target, int format, int type, int rowBufSize, Buffer row, int columnBufSize, Buffer column, Buffer span) {
		current.glGetnSeparableFilter(target, format, type, rowBufSize, row, columnBufSize, column, span);
	}

	public void glHintPGI(int target, int mode) {
		current.glHintPGI(target, mode);
	}

	public void glHistogram(int target, int width, int internalformat, boolean sink) {
		current.glHistogram(target, width, internalformat, sink);
	}

	public void glIndexFuncEXT(int func, float ref) {
		current.glIndexFuncEXT(func, ref);
	}

	public void glIndexMask(int mask) {
		current.glIndexMask(mask);
	}

	public void glIndexMaterialEXT(int face, int mode) {
		current.glIndexMaterialEXT(face, mode);
	}

	public void glIndexPointer(int type, int stride, Buffer ptr) {
		current.glIndexPointer(type, stride, ptr);
	}

	public void glIndexd(double c) {
		current.glIndexd(c);
	}

	public void glIndexdv(DoubleBuffer c) {
		current.glIndexdv(c);
	}

	public void glIndexdv(double[] c, int c_offset) {
		current.glIndexdv(c, c_offset);
	}

	public void glIndexf(float c) {
		current.glIndexf(c);
	}

	public void glIndexfv(FloatBuffer c) {
		current.glIndexfv(c);
	}

	public void glIndexfv(float[] c, int c_offset) {
		current.glIndexfv(c, c_offset);
	}

	public void glIndexi(int c) {
		current.glIndexi(c);
	}

	public void glIndexiv(IntBuffer c) {
		current.glIndexiv(c);
	}

	public void glIndexiv(int[] c, int c_offset) {
		current.glIndexiv(c, c_offset);
	}

	public void glIndexs(short c) {
		current.glIndexs(c);
	}

	public void glIndexsv(ShortBuffer c) {
		current.glIndexsv(c);
	}

	public void glIndexsv(short[] c, int c_offset) {
		current.glIndexsv(c, c_offset);
	}

	public void glIndexub(byte c) {
		current.glIndexub(c);
	}

	public void glIndexubv(ByteBuffer c) {
		current.glIndexubv(c);
	}

	public void glIndexubv(byte[] c, int c_offset) {
		current.glIndexubv(c, c_offset);
	}

	public void glInitNames() {
		current.glInitNames();
	}

	public void glInsertComponentEXT(int res, int src, int num) {
		current.glInsertComponentEXT(res, src, num);
	}

	public void glInterleavedArrays(int format, int stride, Buffer pointer) {
		current.glInterleavedArrays(format, stride, pointer);
	}

	public void glInterleavedArrays(int format, int stride, long pointer_buffer_offset) {
		current.glInterleavedArrays(format, stride, pointer_buffer_offset);
	}

	public void glInterpolatePathsNV(int resultPath, int pathA, int pathB, float weight) {
		current.glInterpolatePathsNV(resultPath, pathA, pathB, weight);
	}

	public boolean glIsEnabledIndexed(int target, int index) {
		return current.glIsEnabledIndexed(target, index);
	}

	public boolean glIsFenceAPPLE(int fence) {
		return current.glIsFenceAPPLE(fence);
	}

	public boolean glIsFenceNV(int fence) {
		return current.glIsFenceNV(fence);
	}

	public boolean glIsImageHandleResidentNV(long handle) {
		return current.glIsImageHandleResidentNV(handle);
	}

	public boolean glIsList(int list) {
		return current.glIsList(list);
	}

	public boolean glIsNameAMD(int identifier, int name) {
		return current.glIsNameAMD(identifier, name);
	}

	public boolean glIsOcclusionQueryNV(int id) {
		return current.glIsOcclusionQueryNV(id);
	}

	public boolean glIsPathNV(int path) {
		return current.glIsPathNV(path);
	}

	public boolean glIsPointInFillPathNV(int path, int mask, float x, float y) {
		return current.glIsPointInFillPathNV(path, mask, x, y);
	}

	public boolean glIsPointInStrokePathNV(int path, float x, float y) {
		return current.glIsPointInStrokePathNV(path, x, y);
	}

	public boolean glIsProgramARB(int program) {
		return current.glIsProgramARB(program);
	}

	public boolean glIsTextureHandleResidentNV(long handle) {
		return current.glIsTextureHandleResidentNV(handle);
	}

	public boolean glIsTransformFeedbackNV(int id) {
		return current.glIsTransformFeedbackNV(id);
	}

	public boolean glIsVariantEnabledEXT(int id, int cap) {
		return current.glIsVariantEnabledEXT(id, cap);
	}

	public boolean glIsVertexAttribEnabledAPPLE(int index, int pname) {
		return current.glIsVertexAttribEnabledAPPLE(index, pname);
	}

	public void glLightModeli(int pname, int param) {
		current.glLightModeli(pname, param);
	}

	public void glLightModeliv(int pname, IntBuffer params) {
		current.glLightModeliv(pname, params);
	}

	public void glLightModeliv(int pname, int[] params, int params_offset) {
		current.glLightModeliv(pname, params, params_offset);
	}

	public void glLighti(int light, int pname, int param) {
		current.glLighti(light, pname, param);
	}

	public void glLightiv(int light, int pname, IntBuffer params) {
		current.glLightiv(light, pname, params);
	}

	public void glLightiv(int light, int pname, int[] params, int params_offset) {
		current.glLightiv(light, pname, params, params_offset);
	}

	public void glLineStipple(int factor, short pattern) {
		current.glLineStipple(factor, pattern);
	}

	public void glLinkProgramARB(int programObj) {
		current.glLinkProgramARB(programObj);
	}

	public void glListBase(int base) {
		current.glListBase(base);
	}

	public void glLoadMatrixd(DoubleBuffer m) {
		current.glLoadMatrixd(m);
	}

	public void glLoadMatrixd(double[] m, int m_offset) {
		current.glLoadMatrixd(m, m_offset);
	}

	public void glLoadName(int name) {
		current.glLoadName(name);
	}

	public void glLoadTransposeMatrixd(DoubleBuffer m) {
		current.glLoadTransposeMatrixd(m);
	}

	public void glLoadTransposeMatrixd(double[] m, int m_offset) {
		current.glLoadTransposeMatrixd(m, m_offset);
	}

	public void glLoadTransposeMatrixf(FloatBuffer m) {
		current.glLoadTransposeMatrixf(m);
	}

	public void glLoadTransposeMatrixf(float[] m, int m_offset) {
		current.glLoadTransposeMatrixf(m, m_offset);
	}

	public void glLockArraysEXT(int first, int count) {
		current.glLockArraysEXT(first, count);
	}

	public void glMakeImageHandleNonResidentNV(long handle) {
		current.glMakeImageHandleNonResidentNV(handle);
	}

	public void glMakeImageHandleResidentNV(long handle, int access) {
		current.glMakeImageHandleResidentNV(handle, access);
	}

	public void glMakeTextureHandleNonResidentNV(long handle) {
		current.glMakeTextureHandleNonResidentNV(handle);
	}

	public void glMakeTextureHandleResidentNV(long handle) {
		current.glMakeTextureHandleResidentNV(handle);
	}

	public void glMap1d(int target, double u1, double u2, int stride, int order, DoubleBuffer points) {
		current.glMap1d(target, u1, u2, stride, order, points);
	}

	public void glMap1d(int target, double u1, double u2, int stride, int order, double[] points, int points_offset) {
		current.glMap1d(target, u1, u2, stride, order, points, points_offset);
	}

	public void glMap1f(int target, float u1, float u2, int stride, int order, FloatBuffer points) {
		current.glMap1f(target, u1, u2, stride, order, points);
	}

	public void glMap1f(int target, float u1, float u2, int stride, int order, float[] points, int points_offset) {
		current.glMap1f(target, u1, u2, stride, order, points, points_offset);
	}

	public void glMap2d(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, DoubleBuffer points) {
		current.glMap2d(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
	}

	public void glMap2d(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, double[] points, int points_offset) {
		current.glMap2d(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, points_offset);
	}

	public void glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, FloatBuffer points) {
		current.glMap2f(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
	}

	public void glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, float[] points, int points_offset) {
		current.glMap2f(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, points_offset);
	}

	public void glMapControlPointsNV(int target, int index, int type, int ustride, int vstride, int uorder, int vorder, boolean packed, Buffer points) {
		current.glMapControlPointsNV(target, index, type, ustride, vstride, uorder, vorder, packed, points);
	}

	public void glMapGrid1d(int un, double u1, double u2) {
		current.glMapGrid1d(un, u1, u2);
	}

	public void glMapGrid1f(int un, float u1, float u2) {
		current.glMapGrid1f(un, u1, u2);
	}

	public void glMapGrid2d(int un, double u1, double u2, int vn, double v1, double v2) {
		current.glMapGrid2d(un, u1, u2, vn, v1, v2);
	}

	public void glMapGrid2f(int un, float u1, float u2, int vn, float v1, float v2) {
		current.glMapGrid2f(un, u1, u2, vn, v1, v2);
	}

	public ByteBuffer glMapNamedBufferEXT(int buffer, int access) {
		return current.glMapNamedBufferEXT(buffer, access);
	}

	public ByteBuffer glMapNamedBufferRangeEXT(int buffer, long offset, long length, int access) {
		return current.glMapNamedBufferRangeEXT(buffer, offset, length, access);
	}

	public void glMapParameterfvNV(int target, int pname, FloatBuffer params) {
		current.glMapParameterfvNV(target, pname, params);
	}

	public void glMapParameterfvNV(int target, int pname, float[] params, int params_offset) {
		current.glMapParameterfvNV(target, pname, params, params_offset);
	}

	public void glMapParameterivNV(int target, int pname, IntBuffer params) {
		current.glMapParameterivNV(target, pname, params);
	}

	public void glMapParameterivNV(int target, int pname, int[] params, int params_offset) {
		current.glMapParameterivNV(target, pname, params, params_offset);
	}

	public ByteBuffer glMapTexture2DINTEL(int texture, int level, int access, IntBuffer stride, IntBuffer layout) {
		return current.glMapTexture2DINTEL(texture, level, access, stride, layout);
	}

	public ByteBuffer glMapTexture2DINTEL(int texture, int level, int access, int[] stride, int stride_offset, int[] layout, int layout_offset) {
		return current.glMapTexture2DINTEL(texture, level, access, stride, stride_offset, layout, layout_offset);
	}

	public void glMapVertexAttrib1dAPPLE(int index, int size, double u1, double u2, int stride, int order, DoubleBuffer points) {
		current.glMapVertexAttrib1dAPPLE(index, size, u1, u2, stride, order, points);
	}

	public void glMapVertexAttrib1dAPPLE(int index, int size, double u1, double u2, int stride, int order, double[] points, int points_offset) {
		current.glMapVertexAttrib1dAPPLE(index, size, u1, u2, stride, order, points, points_offset);
	}

	public void glMapVertexAttrib1fAPPLE(int index, int size, float u1, float u2, int stride, int order, FloatBuffer points) {
		current.glMapVertexAttrib1fAPPLE(index, size, u1, u2, stride, order, points);
	}

	public void glMapVertexAttrib1fAPPLE(int index, int size, float u1, float u2, int stride, int order, float[] points, int points_offset) {
		current.glMapVertexAttrib1fAPPLE(index, size, u1, u2, stride, order, points, points_offset);
	}

	public void glMapVertexAttrib2dAPPLE(int index, int size, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, DoubleBuffer points) {
		current.glMapVertexAttrib2dAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
	}

	public void glMapVertexAttrib2dAPPLE(int index, int size, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, double[] points,
			int points_offset) {
		current.glMapVertexAttrib2dAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, points_offset);
	}

	public void glMapVertexAttrib2fAPPLE(int index, int size, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, FloatBuffer points) {
		current.glMapVertexAttrib2fAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
	}

	public void glMapVertexAttrib2fAPPLE(int index, int size, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, float[] points,
			int points_offset) {
		current.glMapVertexAttrib2fAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, points_offset);
	}

	public void glMateriali(int face, int pname, int param) {
		current.glMateriali(face, pname, param);
	}

	public void glMaterialiv(int face, int pname, IntBuffer params) {
		current.glMaterialiv(face, pname, params);
	}

	public void glMaterialiv(int face, int pname, int[] params, int params_offset) {
		current.glMaterialiv(face, pname, params, params_offset);
	}

	public void glMatrixFrustumEXT(int mode, double left, double right, double bottom, double top, double zNear, double zFar) {
		current.glMatrixFrustumEXT(mode, left, right, bottom, top, zNear, zFar);
	}

	public void glMatrixIndexPointer(int size, int type, int stride, Buffer pointer) {
		current.glMatrixIndexPointer(size, type, stride, pointer);
	}

	public void glMatrixIndexubvARB(int size, ByteBuffer indices) {
		current.glMatrixIndexubvARB(size, indices);
	}

	public void glMatrixIndexubvARB(int size, byte[] indices, int indices_offset) {
		current.glMatrixIndexubvARB(size, indices, indices_offset);
	}

	public void glMatrixIndexuivARB(int size, IntBuffer indices) {
		current.glMatrixIndexuivARB(size, indices);
	}

	public void glMatrixIndexuivARB(int size, int[] indices, int indices_offset) {
		current.glMatrixIndexuivARB(size, indices, indices_offset);
	}

	public void glMatrixIndexusvARB(int size, ShortBuffer indices) {
		current.glMatrixIndexusvARB(size, indices);
	}

	public void glMatrixIndexusvARB(int size, short[] indices, int indices_offset) {
		current.glMatrixIndexusvARB(size, indices, indices_offset);
	}

	public void glMatrixLoadIdentityEXT(int mode) {
		current.glMatrixLoadIdentityEXT(mode);
	}

	public void glMatrixLoadTransposedEXT(int mode, DoubleBuffer m) {
		current.glMatrixLoadTransposedEXT(mode, m);
	}

	public void glMatrixLoadTransposedEXT(int mode, double[] m, int m_offset) {
		current.glMatrixLoadTransposedEXT(mode, m, m_offset);
	}

	public void glMatrixLoadTransposefEXT(int mode, FloatBuffer m) {
		current.glMatrixLoadTransposefEXT(mode, m);
	}

	public void glMatrixLoadTransposefEXT(int mode, float[] m, int m_offset) {
		current.glMatrixLoadTransposefEXT(mode, m, m_offset);
	}

	public void glMatrixLoaddEXT(int mode, DoubleBuffer m) {
		current.glMatrixLoaddEXT(mode, m);
	}

	public void glMatrixLoaddEXT(int mode, double[] m, int m_offset) {
		current.glMatrixLoaddEXT(mode, m, m_offset);
	}

	public void glMatrixLoadfEXT(int mode, FloatBuffer m) {
		current.glMatrixLoadfEXT(mode, m);
	}

	public void glMatrixLoadfEXT(int mode, float[] m, int m_offset) {
		current.glMatrixLoadfEXT(mode, m, m_offset);
	}

	public void glMatrixMultTransposedEXT(int mode, DoubleBuffer m) {
		current.glMatrixMultTransposedEXT(mode, m);
	}

	public void glMatrixMultTransposedEXT(int mode, double[] m, int m_offset) {
		current.glMatrixMultTransposedEXT(mode, m, m_offset);
	}

	public void glMatrixMultTransposefEXT(int mode, FloatBuffer m) {
		current.glMatrixMultTransposefEXT(mode, m);
	}

	public void glMatrixMultTransposefEXT(int mode, float[] m, int m_offset) {
		current.glMatrixMultTransposefEXT(mode, m, m_offset);
	}

	public void glMatrixMultdEXT(int mode, DoubleBuffer m) {
		current.glMatrixMultdEXT(mode, m);
	}

	public void glMatrixMultdEXT(int mode, double[] m, int m_offset) {
		current.glMatrixMultdEXT(mode, m, m_offset);
	}

	public void glMatrixMultfEXT(int mode, FloatBuffer m) {
		current.glMatrixMultfEXT(mode, m);
	}

	public void glMatrixMultfEXT(int mode, float[] m, int m_offset) {
		current.glMatrixMultfEXT(mode, m, m_offset);
	}

	public void glMatrixOrthoEXT(int mode, double left, double right, double bottom, double top, double zNear, double zFar) {
		current.glMatrixOrthoEXT(mode, left, right, bottom, top, zNear, zFar);
	}

	public void glMatrixPopEXT(int mode) {
		current.glMatrixPopEXT(mode);
	}

	public void glMatrixPushEXT(int mode) {
		current.glMatrixPushEXT(mode);
	}

	public void glMatrixRotatedEXT(int mode, double angle, double x, double y, double z) {
		current.glMatrixRotatedEXT(mode, angle, x, y, z);
	}

	public void glMatrixRotatefEXT(int mode, float angle, float x, float y, float z) {
		current.glMatrixRotatefEXT(mode, angle, x, y, z);
	}

	public void glMatrixScaledEXT(int mode, double x, double y, double z) {
		current.glMatrixScaledEXT(mode, x, y, z);
	}

	public void glMatrixScalefEXT(int mode, float x, float y, float z) {
		current.glMatrixScalefEXT(mode, x, y, z);
	}

	public void glMatrixTranslatedEXT(int mode, double x, double y, double z) {
		current.glMatrixTranslatedEXT(mode, x, y, z);
	}

	public void glMatrixTranslatefEXT(int mode, float x, float y, float z) {
		current.glMatrixTranslatefEXT(mode, x, y, z);
	}

	public void glMinmax(int target, int internalformat, boolean sink) {
		current.glMinmax(target, internalformat, sink);
	}

	public void glMultMatrixd(DoubleBuffer m) {
		current.glMultMatrixd(m);
	}

	public void glMultMatrixd(double[] m, int m_offset) {
		current.glMultMatrixd(m, m_offset);
	}

	public void glMultTransposeMatrixd(DoubleBuffer m) {
		current.glMultTransposeMatrixd(m);
	}

	public void glMultTransposeMatrixd(double[] m, int m_offset) {
		current.glMultTransposeMatrixd(m, m_offset);
	}

	public void glMultTransposeMatrixf(FloatBuffer m) {
		current.glMultTransposeMatrixf(m);
	}

	public void glMultTransposeMatrixf(float[] m, int m_offset) {
		current.glMultTransposeMatrixf(m, m_offset);
	}

	public void glMultiTexBufferEXT(int texunit, int target, int internalformat, int buffer) {
		current.glMultiTexBufferEXT(texunit, target, internalformat, buffer);
	}

	public void glMultiTexCoord1bOES(int texture, byte s) {
		current.glMultiTexCoord1bOES(texture, s);
	}

	public void glMultiTexCoord1bvOES(int texture, ByteBuffer coords) {
		current.glMultiTexCoord1bvOES(texture, coords);
	}

	public void glMultiTexCoord1bvOES(int texture, byte[] coords, int coords_offset) {
		current.glMultiTexCoord1bvOES(texture, coords, coords_offset);
	}

	public void glMultiTexCoord1d(int target, double s) {
		current.glMultiTexCoord1d(target, s);
	}

	public void glMultiTexCoord1dv(int target, DoubleBuffer v) {
		current.glMultiTexCoord1dv(target, v);
	}

	public void glMultiTexCoord1dv(int target, double[] v, int v_offset) {
		current.glMultiTexCoord1dv(target, v, v_offset);
	}

	public void glMultiTexCoord1f(int target, float s) {
		current.glMultiTexCoord1f(target, s);
	}

	public void glMultiTexCoord1fv(int target, FloatBuffer v) {
		current.glMultiTexCoord1fv(target, v);
	}

	public void glMultiTexCoord1fv(int target, float[] v, int v_offset) {
		current.glMultiTexCoord1fv(target, v, v_offset);
	}

	public void glMultiTexCoord1h(int target, short s) {
		current.glMultiTexCoord1h(target, s);
	}

	public void glMultiTexCoord1hv(int target, ShortBuffer v) {
		current.glMultiTexCoord1hv(target, v);
	}

	public void glMultiTexCoord1hv(int target, short[] v, int v_offset) {
		current.glMultiTexCoord1hv(target, v, v_offset);
	}

	public void glMultiTexCoord1i(int target, int s) {
		current.glMultiTexCoord1i(target, s);
	}

	public void glMultiTexCoord1iv(int target, IntBuffer v) {
		current.glMultiTexCoord1iv(target, v);
	}

	public void glMultiTexCoord1iv(int target, int[] v, int v_offset) {
		current.glMultiTexCoord1iv(target, v, v_offset);
	}

	public void glMultiTexCoord1s(int target, short s) {
		current.glMultiTexCoord1s(target, s);
	}

	public void glMultiTexCoord1sv(int target, ShortBuffer v) {
		current.glMultiTexCoord1sv(target, v);
	}

	public void glMultiTexCoord1sv(int target, short[] v, int v_offset) {
		current.glMultiTexCoord1sv(target, v, v_offset);
	}

	public void glMultiTexCoord2bOES(int texture, byte s, byte t) {
		current.glMultiTexCoord2bOES(texture, s, t);
	}

	public void glMultiTexCoord2bvOES(int texture, ByteBuffer coords) {
		current.glMultiTexCoord2bvOES(texture, coords);
	}

	public void glMultiTexCoord2bvOES(int texture, byte[] coords, int coords_offset) {
		current.glMultiTexCoord2bvOES(texture, coords, coords_offset);
	}

	public void glMultiTexCoord2d(int target, double s, double t) {
		current.glMultiTexCoord2d(target, s, t);
	}

	public void glMultiTexCoord2dv(int target, DoubleBuffer v) {
		current.glMultiTexCoord2dv(target, v);
	}

	public void glMultiTexCoord2dv(int target, double[] v, int v_offset) {
		current.glMultiTexCoord2dv(target, v, v_offset);
	}

	public void glMultiTexCoord2f(int target, float s, float t) {
		current.glMultiTexCoord2f(target, s, t);
	}

	public void glMultiTexCoord2fv(int target, FloatBuffer v) {
		current.glMultiTexCoord2fv(target, v);
	}

	public void glMultiTexCoord2fv(int target, float[] v, int v_offset) {
		current.glMultiTexCoord2fv(target, v, v_offset);
	}

	public void glMultiTexCoord2h(int target, short s, short t) {
		current.glMultiTexCoord2h(target, s, t);
	}

	public void glMultiTexCoord2hv(int target, ShortBuffer v) {
		current.glMultiTexCoord2hv(target, v);
	}

	public void glMultiTexCoord2hv(int target, short[] v, int v_offset) {
		current.glMultiTexCoord2hv(target, v, v_offset);
	}

	public void glMultiTexCoord2i(int target, int s, int t) {
		current.glMultiTexCoord2i(target, s, t);
	}

	public void glMultiTexCoord2iv(int target, IntBuffer v) {
		current.glMultiTexCoord2iv(target, v);
	}

	public void glMultiTexCoord2iv(int target, int[] v, int v_offset) {
		current.glMultiTexCoord2iv(target, v, v_offset);
	}

	public void glMultiTexCoord2s(int target, short s, short t) {
		current.glMultiTexCoord2s(target, s, t);
	}

	public void glMultiTexCoord2sv(int target, ShortBuffer v) {
		current.glMultiTexCoord2sv(target, v);
	}

	public void glMultiTexCoord2sv(int target, short[] v, int v_offset) {
		current.glMultiTexCoord2sv(target, v, v_offset);
	}

	public void glMultiTexCoord3bOES(int texture, byte s, byte t, byte r) {
		current.glMultiTexCoord3bOES(texture, s, t, r);
	}

	public void glMultiTexCoord3bvOES(int texture, ByteBuffer coords) {
		current.glMultiTexCoord3bvOES(texture, coords);
	}

	public void glMultiTexCoord3bvOES(int texture, byte[] coords, int coords_offset) {
		current.glMultiTexCoord3bvOES(texture, coords, coords_offset);
	}

	public void glMultiTexCoord3d(int target, double s, double t, double r) {
		current.glMultiTexCoord3d(target, s, t, r);
	}

	public void glMultiTexCoord3dv(int target, DoubleBuffer v) {
		current.glMultiTexCoord3dv(target, v);
	}

	public void glMultiTexCoord3dv(int target, double[] v, int v_offset) {
		current.glMultiTexCoord3dv(target, v, v_offset);
	}

	public void glMultiTexCoord3f(int target, float s, float t, float r) {
		current.glMultiTexCoord3f(target, s, t, r);
	}

	public void glMultiTexCoord3fv(int target, FloatBuffer v) {
		current.glMultiTexCoord3fv(target, v);
	}

	public void glMultiTexCoord3fv(int target, float[] v, int v_offset) {
		current.glMultiTexCoord3fv(target, v, v_offset);
	}

	public void glMultiTexCoord3h(int target, short s, short t, short r) {
		current.glMultiTexCoord3h(target, s, t, r);
	}

	public void glMultiTexCoord3hv(int target, ShortBuffer v) {
		current.glMultiTexCoord3hv(target, v);
	}

	public void glMultiTexCoord3hv(int target, short[] v, int v_offset) {
		current.glMultiTexCoord3hv(target, v, v_offset);
	}

	public void glMultiTexCoord3i(int target, int s, int t, int r) {
		current.glMultiTexCoord3i(target, s, t, r);
	}

	public void glMultiTexCoord3iv(int target, IntBuffer v) {
		current.glMultiTexCoord3iv(target, v);
	}

	public void glMultiTexCoord3iv(int target, int[] v, int v_offset) {
		current.glMultiTexCoord3iv(target, v, v_offset);
	}

	public void glMultiTexCoord3s(int target, short s, short t, short r) {
		current.glMultiTexCoord3s(target, s, t, r);
	}

	public void glMultiTexCoord3sv(int target, ShortBuffer v) {
		current.glMultiTexCoord3sv(target, v);
	}

	public void glMultiTexCoord3sv(int target, short[] v, int v_offset) {
		current.glMultiTexCoord3sv(target, v, v_offset);
	}

	public void glMultiTexCoord4bOES(int texture, byte s, byte t, byte r, byte q) {
		current.glMultiTexCoord4bOES(texture, s, t, r, q);
	}

	public void glMultiTexCoord4bvOES(int texture, ByteBuffer coords) {
		current.glMultiTexCoord4bvOES(texture, coords);
	}

	public void glMultiTexCoord4bvOES(int texture, byte[] coords, int coords_offset) {
		current.glMultiTexCoord4bvOES(texture, coords, coords_offset);
	}

	public void glMultiTexCoord4d(int target, double s, double t, double r, double q) {
		current.glMultiTexCoord4d(target, s, t, r, q);
	}

	public void glMultiTexCoord4dv(int target, DoubleBuffer v) {
		current.glMultiTexCoord4dv(target, v);
	}

	public void glMultiTexCoord4dv(int target, double[] v, int v_offset) {
		current.glMultiTexCoord4dv(target, v, v_offset);
	}

	public void glMultiTexCoord4fv(int target, FloatBuffer v) {
		current.glMultiTexCoord4fv(target, v);
	}

	public void glMultiTexCoord4fv(int target, float[] v, int v_offset) {
		current.glMultiTexCoord4fv(target, v, v_offset);
	}

	public void glMultiTexCoord4h(int target, short s, short t, short r, short q) {
		current.glMultiTexCoord4h(target, s, t, r, q);
	}

	public void glMultiTexCoord4hv(int target, ShortBuffer v) {
		current.glMultiTexCoord4hv(target, v);
	}

	public void glMultiTexCoord4hv(int target, short[] v, int v_offset) {
		current.glMultiTexCoord4hv(target, v, v_offset);
	}

	public void glMultiTexCoord4i(int target, int s, int t, int r, int q) {
		current.glMultiTexCoord4i(target, s, t, r, q);
	}

	public void glMultiTexCoord4iv(int target, IntBuffer v) {
		current.glMultiTexCoord4iv(target, v);
	}

	public void glMultiTexCoord4iv(int target, int[] v, int v_offset) {
		current.glMultiTexCoord4iv(target, v, v_offset);
	}

	public void glMultiTexCoord4s(int target, short s, short t, short r, short q) {
		current.glMultiTexCoord4s(target, s, t, r, q);
	}

	public void glMultiTexCoord4sv(int target, ShortBuffer v) {
		current.glMultiTexCoord4sv(target, v);
	}

	public void glMultiTexCoord4sv(int target, short[] v, int v_offset) {
		current.glMultiTexCoord4sv(target, v, v_offset);
	}

	public void glMultiTexCoordPointerEXT(int texunit, int size, int type, int stride, Buffer pointer) {
		current.glMultiTexCoordPointerEXT(texunit, size, type, stride, pointer);
	}

	public void glMultiTexEnvfEXT(int texunit, int target, int pname, float param) {
		current.glMultiTexEnvfEXT(texunit, target, pname, param);
	}

	public void glMultiTexEnvfvEXT(int texunit, int target, int pname, FloatBuffer params) {
		current.glMultiTexEnvfvEXT(texunit, target, pname, params);
	}

	public void glMultiTexEnvfvEXT(int texunit, int target, int pname, float[] params, int params_offset) {
		current.glMultiTexEnvfvEXT(texunit, target, pname, params, params_offset);
	}

	public void glMultiTexEnviEXT(int texunit, int target, int pname, int param) {
		current.glMultiTexEnviEXT(texunit, target, pname, param);
	}

	public void glMultiTexEnvivEXT(int texunit, int target, int pname, IntBuffer params) {
		current.glMultiTexEnvivEXT(texunit, target, pname, params);
	}

	public void glMultiTexEnvivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		current.glMultiTexEnvivEXT(texunit, target, pname, params, params_offset);
	}

	public void glMultiTexGendEXT(int texunit, int coord, int pname, double param) {
		current.glMultiTexGendEXT(texunit, coord, pname, param);
	}

	public void glMultiTexGendvEXT(int texunit, int coord, int pname, DoubleBuffer params) {
		current.glMultiTexGendvEXT(texunit, coord, pname, params);
	}

	public void glMultiTexGendvEXT(int texunit, int coord, int pname, double[] params, int params_offset) {
		current.glMultiTexGendvEXT(texunit, coord, pname, params, params_offset);
	}

	public void glMultiTexGenfEXT(int texunit, int coord, int pname, float param) {
		current.glMultiTexGenfEXT(texunit, coord, pname, param);
	}

	public void glMultiTexGenfvEXT(int texunit, int coord, int pname, FloatBuffer params) {
		current.glMultiTexGenfvEXT(texunit, coord, pname, params);
	}

	public void glMultiTexGenfvEXT(int texunit, int coord, int pname, float[] params, int params_offset) {
		current.glMultiTexGenfvEXT(texunit, coord, pname, params, params_offset);
	}

	public void glMultiTexGeniEXT(int texunit, int coord, int pname, int param) {
		current.glMultiTexGeniEXT(texunit, coord, pname, param);
	}

	public void glMultiTexGenivEXT(int texunit, int coord, int pname, IntBuffer params) {
		current.glMultiTexGenivEXT(texunit, coord, pname, params);
	}

	public void glMultiTexGenivEXT(int texunit, int coord, int pname, int[] params, int params_offset) {
		current.glMultiTexGenivEXT(texunit, coord, pname, params, params_offset);
	}

	public void glMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int width, int border, int format, int type, Buffer pixels) {
		current.glMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, pixels);
	}

	public void glMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int width, int height, int border, int format, int type, Buffer pixels) {
		current.glMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, pixels);
	}

	public void glMultiTexImage3DEXT(int texunit, int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, Buffer pixels) {
		current.glMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, pixels);
	}

	public void glMultiTexParameterIivEXT(int texunit, int target, int pname, IntBuffer params) {
		current.glMultiTexParameterIivEXT(texunit, target, pname, params);
	}

	public void glMultiTexParameterIivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		current.glMultiTexParameterIivEXT(texunit, target, pname, params, params_offset);
	}

	public void glMultiTexParameterIuivEXT(int texunit, int target, int pname, IntBuffer params) {
		current.glMultiTexParameterIuivEXT(texunit, target, pname, params);
	}

	public void glMultiTexParameterIuivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		current.glMultiTexParameterIuivEXT(texunit, target, pname, params, params_offset);
	}

	public void glMultiTexParameterfEXT(int texunit, int target, int pname, float param) {
		current.glMultiTexParameterfEXT(texunit, target, pname, param);
	}

	public void glMultiTexParameterfvEXT(int texunit, int target, int pname, FloatBuffer params) {
		current.glMultiTexParameterfvEXT(texunit, target, pname, params);
	}

	public void glMultiTexParameterfvEXT(int texunit, int target, int pname, float[] params, int params_offset) {
		current.glMultiTexParameterfvEXT(texunit, target, pname, params, params_offset);
	}

	public void glMultiTexParameteriEXT(int texunit, int target, int pname, int param) {
		current.glMultiTexParameteriEXT(texunit, target, pname, param);
	}

	public void glMultiTexParameterivEXT(int texunit, int target, int pname, IntBuffer params) {
		current.glMultiTexParameterivEXT(texunit, target, pname, params);
	}

	public void glMultiTexParameterivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		current.glMultiTexParameterivEXT(texunit, target, pname, params, params_offset);
	}

	public void glMultiTexRenderbufferEXT(int texunit, int target, int renderbuffer) {
		current.glMultiTexRenderbufferEXT(texunit, target, renderbuffer);
	}

	public void glMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int width, int format, int type, Buffer pixels) {
		current.glMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, pixels);
	}

	public void glMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, Buffer pixels) {
		current.glMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels);
	}

	public void glMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type,
			Buffer pixels) {
		current.glMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
	}

	public void glNamedBufferDataEXT(int buffer, long size, Buffer data, int usage) {
		current.glNamedBufferDataEXT(buffer, size, data, usage);
	}

	public void glNamedBufferSubDataEXT(int buffer, long offset, long size, Buffer data) {
		current.glNamedBufferSubDataEXT(buffer, offset, size, data);
	}

	public void glNamedCopyBufferSubDataEXT(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
		current.glNamedCopyBufferSubDataEXT(readBuffer, writeBuffer, readOffset, writeOffset, size);
	}

	public void glNamedFramebufferRenderbufferEXT(int framebuffer, int attachment, int renderbuffertarget, int renderbuffer) {
		current.glNamedFramebufferRenderbufferEXT(framebuffer, attachment, renderbuffertarget, renderbuffer);
	}

	public void glNamedFramebufferTexture1DEXT(int framebuffer, int attachment, int textarget, int texture, int level) {
		current.glNamedFramebufferTexture1DEXT(framebuffer, attachment, textarget, texture, level);
	}

	public void glNamedFramebufferTexture2DEXT(int framebuffer, int attachment, int textarget, int texture, int level) {
		current.glNamedFramebufferTexture2DEXT(framebuffer, attachment, textarget, texture, level);
	}

	public void glNamedFramebufferTexture3DEXT(int framebuffer, int attachment, int textarget, int texture, int level, int zoffset) {
		current.glNamedFramebufferTexture3DEXT(framebuffer, attachment, textarget, texture, level, zoffset);
	}

	public void glNamedFramebufferTextureEXT(int framebuffer, int attachment, int texture, int level) {
		current.glNamedFramebufferTextureEXT(framebuffer, attachment, texture, level);
	}

	public void glNamedFramebufferTextureFaceEXT(int framebuffer, int attachment, int texture, int level, int face) {
		current.glNamedFramebufferTextureFaceEXT(framebuffer, attachment, texture, level, face);
	}

	public void glNamedFramebufferTextureLayerEXT(int framebuffer, int attachment, int texture, int level, int layer) {
		current.glNamedFramebufferTextureLayerEXT(framebuffer, attachment, texture, level, layer);
	}

	public void glNamedProgramLocalParameter4dEXT(int program, int target, int index, double x, double y, double z, double w) {
		current.glNamedProgramLocalParameter4dEXT(program, target, index, x, y, z, w);
	}

	public void glNamedProgramLocalParameter4dvEXT(int program, int target, int index, DoubleBuffer params) {
		current.glNamedProgramLocalParameter4dvEXT(program, target, index, params);
	}

	public void glNamedProgramLocalParameter4dvEXT(int program, int target, int index, double[] params, int params_offset) {
		current.glNamedProgramLocalParameter4dvEXT(program, target, index, params, params_offset);
	}

	public void glNamedProgramLocalParameter4fEXT(int program, int target, int index, float x, float y, float z, float w) {
		current.glNamedProgramLocalParameter4fEXT(program, target, index, x, y, z, w);
	}

	public void glNamedProgramLocalParameter4fvEXT(int program, int target, int index, FloatBuffer params) {
		current.glNamedProgramLocalParameter4fvEXT(program, target, index, params);
	}

	public void glNamedProgramLocalParameter4fvEXT(int program, int target, int index, float[] params, int params_offset) {
		current.glNamedProgramLocalParameter4fvEXT(program, target, index, params, params_offset);
	}

	public void glNamedProgramLocalParameterI4iEXT(int program, int target, int index, int x, int y, int z, int w) {
		current.glNamedProgramLocalParameterI4iEXT(program, target, index, x, y, z, w);
	}

	public void glNamedProgramLocalParameterI4ivEXT(int program, int target, int index, IntBuffer params) {
		current.glNamedProgramLocalParameterI4ivEXT(program, target, index, params);
	}

	public void glNamedProgramLocalParameterI4ivEXT(int program, int target, int index, int[] params, int params_offset) {
		current.glNamedProgramLocalParameterI4ivEXT(program, target, index, params, params_offset);
	}

	public void glNamedProgramLocalParameterI4uiEXT(int program, int target, int index, int x, int y, int z, int w) {
		current.glNamedProgramLocalParameterI4uiEXT(program, target, index, x, y, z, w);
	}

	public void glNamedProgramLocalParameterI4uivEXT(int program, int target, int index, IntBuffer params) {
		current.glNamedProgramLocalParameterI4uivEXT(program, target, index, params);
	}

	public void glNamedProgramLocalParameterI4uivEXT(int program, int target, int index, int[] params, int params_offset) {
		current.glNamedProgramLocalParameterI4uivEXT(program, target, index, params, params_offset);
	}

	public void glNamedProgramLocalParameters4fvEXT(int program, int target, int index, int count, FloatBuffer params) {
		current.glNamedProgramLocalParameters4fvEXT(program, target, index, count, params);
	}

	public void glNamedProgramLocalParameters4fvEXT(int program, int target, int index, int count, float[] params, int params_offset) {
		current.glNamedProgramLocalParameters4fvEXT(program, target, index, count, params, params_offset);
	}

	public void glNamedProgramLocalParametersI4ivEXT(int program, int target, int index, int count, IntBuffer params) {
		current.glNamedProgramLocalParametersI4ivEXT(program, target, index, count, params);
	}

	public void glNamedProgramLocalParametersI4ivEXT(int program, int target, int index, int count, int[] params, int params_offset) {
		current.glNamedProgramLocalParametersI4ivEXT(program, target, index, count, params, params_offset);
	}

	public void glNamedProgramLocalParametersI4uivEXT(int program, int target, int index, int count, IntBuffer params) {
		current.glNamedProgramLocalParametersI4uivEXT(program, target, index, count, params);
	}

	public void glNamedProgramLocalParametersI4uivEXT(int program, int target, int index, int count, int[] params, int params_offset) {
		current.glNamedProgramLocalParametersI4uivEXT(program, target, index, count, params, params_offset);
	}

	public void glNamedProgramStringEXT(int program, int target, int format, int len, Buffer string) {
		current.glNamedProgramStringEXT(program, target, format, len, string);
	}

	public void glNamedRenderbufferStorageEXT(int renderbuffer, int internalformat, int width, int height) {
		current.glNamedRenderbufferStorageEXT(renderbuffer, internalformat, width, height);
	}

	public void glNamedRenderbufferStorageMultisampleCoverageEXT(int renderbuffer, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
		current.glNamedRenderbufferStorageMultisampleCoverageEXT(renderbuffer, coverageSamples, colorSamples, internalformat, width, height);
	}

	public void glNamedRenderbufferStorageMultisampleEXT(int renderbuffer, int samples, int internalformat, int width, int height) {
		current.glNamedRenderbufferStorageMultisampleEXT(renderbuffer, samples, internalformat, width, height);
	}

	public void glNewList(int list, int mode) {
		current.glNewList(list, mode);
	}

	public void glNormal3b(byte nx, byte ny, byte nz) {
		current.glNormal3b(nx, ny, nz);
	}

	public void glNormal3bv(ByteBuffer v) {
		current.glNormal3bv(v);
	}

	public void glNormal3bv(byte[] v, int v_offset) {
		current.glNormal3bv(v, v_offset);
	}

	public void glNormal3d(double nx, double ny, double nz) {
		current.glNormal3d(nx, ny, nz);
	}

	public void glNormal3dv(DoubleBuffer v) {
		current.glNormal3dv(v);
	}

	public void glNormal3dv(double[] v, int v_offset) {
		current.glNormal3dv(v, v_offset);
	}

	public void glNormal3fv(FloatBuffer v) {
		current.glNormal3fv(v);
	}

	public void glNormal3fv(float[] v, int v_offset) {
		current.glNormal3fv(v, v_offset);
	}

	public void glNormal3h(short nx, short ny, short nz) {
		current.glNormal3h(nx, ny, nz);
	}

	public void glNormal3hv(ShortBuffer v) {
		current.glNormal3hv(v);
	}

	public void glNormal3hv(short[] v, int v_offset) {
		current.glNormal3hv(v, v_offset);
	}

	public void glNormal3i(int nx, int ny, int nz) {
		current.glNormal3i(nx, ny, nz);
	}

	public void glNormal3iv(IntBuffer v) {
		current.glNormal3iv(v);
	}

	public void glNormal3iv(int[] v, int v_offset) {
		current.glNormal3iv(v, v_offset);
	}

	public void glNormal3s(short nx, short ny, short nz) {
		current.glNormal3s(nx, ny, nz);
	}

	public void glNormal3sv(ShortBuffer v) {
		current.glNormal3sv(v);
	}

	public void glNormal3sv(short[] v, int v_offset) {
		current.glNormal3sv(v, v_offset);
	}

	public int glObjectPurgeableAPPLE(int objectType, int name, int option) {
		return current.glObjectPurgeableAPPLE(objectType, name, option);
	}

	public int glObjectUnpurgeableAPPLE(int objectType, int name, int option) {
		return current.glObjectUnpurgeableAPPLE(objectType, name, option);
	}

	public void glPNTrianglesfATI(int pname, float param) {
		current.glPNTrianglesfATI(pname, param);
	}

	public void glPNTrianglesiATI(int pname, int param) {
		current.glPNTrianglesiATI(pname, param);
	}

	public void glPassThrough(float token) {
		current.glPassThrough(token);
	}

	public void glPathColorGenNV(int color, int genMode, int colorFormat, FloatBuffer coeffs) {
		current.glPathColorGenNV(color, genMode, colorFormat, coeffs);
	}

	public void glPathColorGenNV(int color, int genMode, int colorFormat, float[] coeffs, int coeffs_offset) {
		current.glPathColorGenNV(color, genMode, colorFormat, coeffs, coeffs_offset);
	}

	public void glPathCommandsNV(int path, int numCommands, ByteBuffer commands, int numCoords, int coordType, Buffer coords) {
		current.glPathCommandsNV(path, numCommands, commands, numCoords, coordType, coords);
	}

	public void glPathCommandsNV(int path, int numCommands, byte[] commands, int commands_offset, int numCoords, int coordType, Buffer coords) {
		current.glPathCommandsNV(path, numCommands, commands, commands_offset, numCoords, coordType, coords);
	}

	public void glPathCoordsNV(int path, int numCoords, int coordType, Buffer coords) {
		current.glPathCoordsNV(path, numCoords, coordType, coords);
	}

	public void glPathCoverDepthFuncNV(int func) {
		current.glPathCoverDepthFuncNV(func);
	}

	public void glPathDashArrayNV(int path, int dashCount, FloatBuffer dashArray) {
		current.glPathDashArrayNV(path, dashCount, dashArray);
	}

	public void glPathDashArrayNV(int path, int dashCount, float[] dashArray, int dashArray_offset) {
		current.glPathDashArrayNV(path, dashCount, dashArray, dashArray_offset);
	}

	public void glPathFogGenNV(int genMode) {
		current.glPathFogGenNV(genMode);
	}

	public void glPathGlyphRangeNV(int firstPathName, int fontTarget, Buffer fontName, int fontStyle, int firstGlyph, int numGlyphs, int handleMissingGlyphs,
			int pathParameterTemplate, float emScale) {
		current.glPathGlyphRangeNV(firstPathName, fontTarget, fontName, fontStyle, firstGlyph, numGlyphs, handleMissingGlyphs, pathParameterTemplate, emScale);
	}

	public void glPathGlyphsNV(int firstPathName, int fontTarget, Buffer fontName, int fontStyle, int numGlyphs, int type, Buffer charcodes, int handleMissingGlyphs,
			int pathParameterTemplate, float emScale) {
		current.glPathGlyphsNV(firstPathName, fontTarget, fontName, fontStyle, numGlyphs, type, charcodes, handleMissingGlyphs, pathParameterTemplate, emScale);
	}

	public void glPathParameterfNV(int path, int pname, float value) {
		current.glPathParameterfNV(path, pname, value);
	}

	public void glPathParameterfvNV(int path, int pname, FloatBuffer value) {
		current.glPathParameterfvNV(path, pname, value);
	}

	public void glPathParameterfvNV(int path, int pname, float[] value, int value_offset) {
		current.glPathParameterfvNV(path, pname, value, value_offset);
	}

	public void glPathParameteriNV(int path, int pname, int value) {
		current.glPathParameteriNV(path, pname, value);
	}

	public void glPathParameterivNV(int path, int pname, IntBuffer value) {
		current.glPathParameterivNV(path, pname, value);
	}

	public void glPathParameterivNV(int path, int pname, int[] value, int value_offset) {
		current.glPathParameterivNV(path, pname, value, value_offset);
	}

	public void glPathStencilDepthOffsetNV(float factor, float units) {
		current.glPathStencilDepthOffsetNV(factor, units);
	}

	public void glPathStencilFuncNV(int func, int ref, int mask) {
		current.glPathStencilFuncNV(func, ref, mask);
	}

	public void glPathStringNV(int path, int format, int length, Buffer pathString) {
		current.glPathStringNV(path, format, length, pathString);
	}

	public void glPathSubCommandsNV(int path, int commandStart, int commandsToDelete, int numCommands, ByteBuffer commands, int numCoords, int coordType, Buffer coords) {
		current.glPathSubCommandsNV(path, commandStart, commandsToDelete, numCommands, commands, numCoords, coordType, coords);
	}

	public void glPathSubCommandsNV(int path, int commandStart, int commandsToDelete, int numCommands, byte[] commands, int commands_offset, int numCoords, int coordType,
			Buffer coords) {
		current.glPathSubCommandsNV(path, commandStart, commandsToDelete, numCommands, commands, commands_offset, numCoords, coordType, coords);
	}

	public void glPathSubCoordsNV(int path, int coordStart, int numCoords, int coordType, Buffer coords) {
		current.glPathSubCoordsNV(path, coordStart, numCoords, coordType, coords);
	}

	public void glPathTexGenNV(int texCoordSet, int genMode, int components, FloatBuffer coeffs) {
		current.glPathTexGenNV(texCoordSet, genMode, components, coeffs);
	}

	public void glPathTexGenNV(int texCoordSet, int genMode, int components, float[] coeffs, int coeffs_offset) {
		current.glPathTexGenNV(texCoordSet, genMode, components, coeffs, coeffs_offset);
	}

	public void glPauseTransformFeedbackNV() {
		current.glPauseTransformFeedbackNV();
	}

	public void glPixelDataRangeNV(int target, int length, Buffer pointer) {
		current.glPixelDataRangeNV(target, length, pointer);
	}

	public void glPixelMapfv(int map, int mapsize, FloatBuffer values) {
		current.glPixelMapfv(map, mapsize, values);
	}

	public void glPixelMapfv(int map, int mapsize, float[] values, int values_offset) {
		current.glPixelMapfv(map, mapsize, values, values_offset);
	}

	public void glPixelMapfv(int map, int mapsize, long values_buffer_offset) {
		current.glPixelMapfv(map, mapsize, values_buffer_offset);
	}

	public void glPixelMapuiv(int map, int mapsize, IntBuffer values) {
		current.glPixelMapuiv(map, mapsize, values);
	}

	public void glPixelMapuiv(int map, int mapsize, int[] values, int values_offset) {
		current.glPixelMapuiv(map, mapsize, values, values_offset);
	}

	public void glPixelMapuiv(int map, int mapsize, long values_buffer_offset) {
		current.glPixelMapuiv(map, mapsize, values_buffer_offset);
	}

	public void glPixelMapusv(int map, int mapsize, ShortBuffer values) {
		current.glPixelMapusv(map, mapsize, values);
	}

	public void glPixelMapusv(int map, int mapsize, short[] values, int values_offset) {
		current.glPixelMapusv(map, mapsize, values, values_offset);
	}

	public void glPixelMapusv(int map, int mapsize, long values_buffer_offset) {
		current.glPixelMapusv(map, mapsize, values_buffer_offset);
	}

	public void glPixelTransferf(int pname, float param) {
		current.glPixelTransferf(pname, param);
	}

	public void glPixelTransferi(int pname, int param) {
		current.glPixelTransferi(pname, param);
	}

	public void glPixelTransformParameterfEXT(int target, int pname, float param) {
		current.glPixelTransformParameterfEXT(target, pname, param);
	}

	public void glPixelTransformParameterfvEXT(int target, int pname, FloatBuffer params) {
		current.glPixelTransformParameterfvEXT(target, pname, params);
	}

	public void glPixelTransformParameterfvEXT(int target, int pname, float[] params, int params_offset) {
		current.glPixelTransformParameterfvEXT(target, pname, params, params_offset);
	}

	public void glPixelTransformParameteriEXT(int target, int pname, int param) {
		current.glPixelTransformParameteriEXT(target, pname, param);
	}

	public void glPixelTransformParameterivEXT(int target, int pname, IntBuffer params) {
		current.glPixelTransformParameterivEXT(target, pname, params);
	}

	public void glPixelTransformParameterivEXT(int target, int pname, int[] params, int params_offset) {
		current.glPixelTransformParameterivEXT(target, pname, params, params_offset);
	}

	public void glPixelZoom(float xfactor, float yfactor) {
		current.glPixelZoom(xfactor, yfactor);
	}

	public boolean glPointAlongPathNV(int path, int startSegment, int numSegments, float distance, FloatBuffer x, FloatBuffer y, FloatBuffer tangentX, FloatBuffer tangentY) {
		return current.glPointAlongPathNV(path, startSegment, numSegments, distance, x, y, tangentX, tangentY);
	}

	public boolean glPointAlongPathNV(int path, int startSegment, int numSegments, float distance, float[] x, int x_offset, float[] y, int y_offset, float[] tangentX,
			int tangentX_offset, float[] tangentY, int tangentY_offset) {
		return current.glPointAlongPathNV(path, startSegment, numSegments, distance, x, x_offset, y, y_offset, tangentX, tangentX_offset, tangentY, tangentY_offset);
	}

	public void glPolygonStipple(ByteBuffer mask) {
		current.glPolygonStipple(mask);
	}

	public void glPolygonStipple(byte[] mask, int mask_offset) {
		current.glPolygonStipple(mask, mask_offset);
	}

	public void glPolygonStipple(long mask_buffer_offset) {
		current.glPolygonStipple(mask_buffer_offset);
	}

	public void glPopAttrib() {
		current.glPopAttrib();
	}

	public void glPopClientAttrib() {
		current.glPopClientAttrib();
	}

	public void glPopName() {
		current.glPopName();
	}

	public void glPrimitiveRestartIndexNV(int index) {
		current.glPrimitiveRestartIndexNV(index);
	}

	public void glPrimitiveRestartNV() {
		current.glPrimitiveRestartNV();
	}

	public void glPrioritizeTextures(int n, IntBuffer textures, FloatBuffer priorities) {
		current.glPrioritizeTextures(n, textures, priorities);
	}

	public void glPrioritizeTextures(int n, int[] textures, int textures_offset, float[] priorities, int priorities_offset) {
		current.glPrioritizeTextures(n, textures, textures_offset, priorities, priorities_offset);
	}

	public void glProgramBufferParametersIivNV(int target, int bindingIndex, int wordIndex, int count, IntBuffer params) {
		current.glProgramBufferParametersIivNV(target, bindingIndex, wordIndex, count, params);
	}

	public void glProgramBufferParametersIivNV(int target, int bindingIndex, int wordIndex, int count, int[] params, int params_offset) {
		current.glProgramBufferParametersIivNV(target, bindingIndex, wordIndex, count, params, params_offset);
	}

	public void glProgramBufferParametersIuivNV(int target, int bindingIndex, int wordIndex, int count, IntBuffer params) {
		current.glProgramBufferParametersIuivNV(target, bindingIndex, wordIndex, count, params);
	}

	public void glProgramBufferParametersIuivNV(int target, int bindingIndex, int wordIndex, int count, int[] params, int params_offset) {
		current.glProgramBufferParametersIuivNV(target, bindingIndex, wordIndex, count, params, params_offset);
	}

	public void glProgramBufferParametersfvNV(int target, int bindingIndex, int wordIndex, int count, FloatBuffer params) {
		current.glProgramBufferParametersfvNV(target, bindingIndex, wordIndex, count, params);
	}

	public void glProgramBufferParametersfvNV(int target, int bindingIndex, int wordIndex, int count, float[] params, int params_offset) {
		current.glProgramBufferParametersfvNV(target, bindingIndex, wordIndex, count, params, params_offset);
	}

	public void glProgramEnvParameter4dARB(int target, int index, double x, double y, double z, double w) {
		current.glProgramEnvParameter4dARB(target, index, x, y, z, w);
	}

	public void glProgramEnvParameter4dvARB(int target, int index, DoubleBuffer params) {
		current.glProgramEnvParameter4dvARB(target, index, params);
	}

	public void glProgramEnvParameter4dvARB(int target, int index, double[] params, int params_offset) {
		current.glProgramEnvParameter4dvARB(target, index, params, params_offset);
	}

	public void glProgramEnvParameter4fARB(int target, int index, float x, float y, float z, float w) {
		current.glProgramEnvParameter4fARB(target, index, x, y, z, w);
	}

	public void glProgramEnvParameter4fvARB(int target, int index, FloatBuffer params) {
		current.glProgramEnvParameter4fvARB(target, index, params);
	}

	public void glProgramEnvParameter4fvARB(int target, int index, float[] params, int params_offset) {
		current.glProgramEnvParameter4fvARB(target, index, params, params_offset);
	}

	public void glProgramEnvParameterI4iNV(int target, int index, int x, int y, int z, int w) {
		current.glProgramEnvParameterI4iNV(target, index, x, y, z, w);
	}

	public void glProgramEnvParameterI4ivNV(int target, int index, IntBuffer params) {
		current.glProgramEnvParameterI4ivNV(target, index, params);
	}

	public void glProgramEnvParameterI4ivNV(int target, int index, int[] params, int params_offset) {
		current.glProgramEnvParameterI4ivNV(target, index, params, params_offset);
	}

	public void glProgramEnvParameterI4uiNV(int target, int index, int x, int y, int z, int w) {
		current.glProgramEnvParameterI4uiNV(target, index, x, y, z, w);
	}

	public void glProgramEnvParameterI4uivNV(int target, int index, IntBuffer params) {
		current.glProgramEnvParameterI4uivNV(target, index, params);
	}

	public void glProgramEnvParameterI4uivNV(int target, int index, int[] params, int params_offset) {
		current.glProgramEnvParameterI4uivNV(target, index, params, params_offset);
	}

	public void glProgramEnvParameters4fvEXT(int target, int index, int count, FloatBuffer params) {
		current.glProgramEnvParameters4fvEXT(target, index, count, params);
	}

	public void glProgramEnvParameters4fvEXT(int target, int index, int count, float[] params, int params_offset) {
		current.glProgramEnvParameters4fvEXT(target, index, count, params, params_offset);
	}

	public void glProgramEnvParametersI4ivNV(int target, int index, int count, IntBuffer params) {
		current.glProgramEnvParametersI4ivNV(target, index, count, params);
	}

	public void glProgramEnvParametersI4ivNV(int target, int index, int count, int[] params, int params_offset) {
		current.glProgramEnvParametersI4ivNV(target, index, count, params, params_offset);
	}

	public void glProgramEnvParametersI4uivNV(int target, int index, int count, IntBuffer params) {
		current.glProgramEnvParametersI4uivNV(target, index, count, params);
	}

	public void glProgramEnvParametersI4uivNV(int target, int index, int count, int[] params, int params_offset) {
		current.glProgramEnvParametersI4uivNV(target, index, count, params, params_offset);
	}

	public void glProgramLocalParameter4dARB(int target, int index, double x, double y, double z, double w) {
		current.glProgramLocalParameter4dARB(target, index, x, y, z, w);
	}

	public void glProgramLocalParameter4dvARB(int target, int index, DoubleBuffer params) {
		current.glProgramLocalParameter4dvARB(target, index, params);
	}

	public void glProgramLocalParameter4dvARB(int target, int index, double[] params, int params_offset) {
		current.glProgramLocalParameter4dvARB(target, index, params, params_offset);
	}

	public void glProgramLocalParameter4fARB(int target, int index, float x, float y, float z, float w) {
		current.glProgramLocalParameter4fARB(target, index, x, y, z, w);
	}

	public void glProgramLocalParameter4fvARB(int target, int index, FloatBuffer params) {
		current.glProgramLocalParameter4fvARB(target, index, params);
	}

	public void glProgramLocalParameter4fvARB(int target, int index, float[] params, int params_offset) {
		current.glProgramLocalParameter4fvARB(target, index, params, params_offset);
	}

	public void glProgramLocalParameterI4iNV(int target, int index, int x, int y, int z, int w) {
		current.glProgramLocalParameterI4iNV(target, index, x, y, z, w);
	}

	public void glProgramLocalParameterI4ivNV(int target, int index, IntBuffer params) {
		current.glProgramLocalParameterI4ivNV(target, index, params);
	}

	public void glProgramLocalParameterI4ivNV(int target, int index, int[] params, int params_offset) {
		current.glProgramLocalParameterI4ivNV(target, index, params, params_offset);
	}

	public void glProgramLocalParameterI4uiNV(int target, int index, int x, int y, int z, int w) {
		current.glProgramLocalParameterI4uiNV(target, index, x, y, z, w);
	}

	public void glProgramLocalParameterI4uivNV(int target, int index, IntBuffer params) {
		current.glProgramLocalParameterI4uivNV(target, index, params);
	}

	public void glProgramLocalParameterI4uivNV(int target, int index, int[] params, int params_offset) {
		current.glProgramLocalParameterI4uivNV(target, index, params, params_offset);
	}

	public void glProgramLocalParameters4fvEXT(int target, int index, int count, FloatBuffer params) {
		current.glProgramLocalParameters4fvEXT(target, index, count, params);
	}

	public void glProgramLocalParameters4fvEXT(int target, int index, int count, float[] params, int params_offset) {
		current.glProgramLocalParameters4fvEXT(target, index, count, params, params_offset);
	}

	public void glProgramLocalParametersI4ivNV(int target, int index, int count, IntBuffer params) {
		current.glProgramLocalParametersI4ivNV(target, index, count, params);
	}

	public void glProgramLocalParametersI4ivNV(int target, int index, int count, int[] params, int params_offset) {
		current.glProgramLocalParametersI4ivNV(target, index, count, params, params_offset);
	}

	public void glProgramLocalParametersI4uivNV(int target, int index, int count, IntBuffer params) {
		current.glProgramLocalParametersI4uivNV(target, index, count, params);
	}

	public void glProgramLocalParametersI4uivNV(int target, int index, int count, int[] params, int params_offset) {
		current.glProgramLocalParametersI4uivNV(target, index, count, params, params_offset);
	}

	public void glProgramStringARB(int target, int format, int len, String string) {
		current.glProgramStringARB(target, format, len, string);
	}

	public void glProgramSubroutineParametersuivNV(int target, int count, IntBuffer params) {
		current.glProgramSubroutineParametersuivNV(target, count, params);
	}

	public void glProgramSubroutineParametersuivNV(int target, int count, int[] params, int params_offset) {
		current.glProgramSubroutineParametersuivNV(target, count, params, params_offset);
	}

	public void glProgramUniform1uiEXT(int program, int location, int v0) {
		current.glProgramUniform1uiEXT(program, location, v0);
	}

	public void glProgramUniform1uivEXT(int program, int location, int count, IntBuffer value) {
		current.glProgramUniform1uivEXT(program, location, count, value);
	}

	public void glProgramUniform1uivEXT(int program, int location, int count, int[] value, int value_offset) {
		current.glProgramUniform1uivEXT(program, location, count, value, value_offset);
	}

	public void glProgramUniform2uiEXT(int program, int location, int v0, int v1) {
		current.glProgramUniform2uiEXT(program, location, v0, v1);
	}

	public void glProgramUniform2uivEXT(int program, int location, int count, IntBuffer value) {
		current.glProgramUniform2uivEXT(program, location, count, value);
	}

	public void glProgramUniform2uivEXT(int program, int location, int count, int[] value, int value_offset) {
		current.glProgramUniform2uivEXT(program, location, count, value, value_offset);
	}

	public void glProgramUniform3uiEXT(int program, int location, int v0, int v1, int v2) {
		current.glProgramUniform3uiEXT(program, location, v0, v1, v2);
	}

	public void glProgramUniform3uivEXT(int program, int location, int count, IntBuffer value) {
		current.glProgramUniform3uivEXT(program, location, count, value);
	}

	public void glProgramUniform3uivEXT(int program, int location, int count, int[] value, int value_offset) {
		current.glProgramUniform3uivEXT(program, location, count, value, value_offset);
	}

	public void glProgramUniform4uiEXT(int program, int location, int v0, int v1, int v2, int v3) {
		current.glProgramUniform4uiEXT(program, location, v0, v1, v2, v3);
	}

	public void glProgramUniform4uivEXT(int program, int location, int count, IntBuffer value) {
		current.glProgramUniform4uivEXT(program, location, count, value);
	}

	public void glProgramUniform4uivEXT(int program, int location, int count, int[] value, int value_offset) {
		current.glProgramUniform4uivEXT(program, location, count, value, value_offset);
	}

	public void glProgramUniformHandleui64NV(int program, int location, long value) {
		current.glProgramUniformHandleui64NV(program, location, value);
	}

	public void glProgramUniformHandleui64vNV(int program, int location, int count, LongBuffer values) {
		current.glProgramUniformHandleui64vNV(program, location, count, values);
	}

	public void glProgramUniformHandleui64vNV(int program, int location, int count, long[] values, int values_offset) {
		current.glProgramUniformHandleui64vNV(program, location, count, values, values_offset);
	}

	public void glProgramUniformMatrix2x3fvEXT(int program, int location, int count, boolean transpose, FloatBuffer value) {
		current.glProgramUniformMatrix2x3fvEXT(program, location, count, transpose, value);
	}

	public void glProgramUniformMatrix2x3fvEXT(int program, int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glProgramUniformMatrix2x3fvEXT(program, location, count, transpose, value, value_offset);
	}

	public void glProgramUniformMatrix2x4fvEXT(int program, int location, int count, boolean transpose, FloatBuffer value) {
		current.glProgramUniformMatrix2x4fvEXT(program, location, count, transpose, value);
	}

	public void glProgramUniformMatrix2x4fvEXT(int program, int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glProgramUniformMatrix2x4fvEXT(program, location, count, transpose, value, value_offset);
	}

	public void glProgramUniformMatrix3x2fvEXT(int program, int location, int count, boolean transpose, FloatBuffer value) {
		current.glProgramUniformMatrix3x2fvEXT(program, location, count, transpose, value);
	}

	public void glProgramUniformMatrix3x2fvEXT(int program, int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glProgramUniformMatrix3x2fvEXT(program, location, count, transpose, value, value_offset);
	}

	public void glProgramUniformMatrix3x4fvEXT(int program, int location, int count, boolean transpose, FloatBuffer value) {
		current.glProgramUniformMatrix3x4fvEXT(program, location, count, transpose, value);
	}

	public void glProgramUniformMatrix3x4fvEXT(int program, int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glProgramUniformMatrix3x4fvEXT(program, location, count, transpose, value, value_offset);
	}

	public void glProgramUniformMatrix4x2fvEXT(int program, int location, int count, boolean transpose, FloatBuffer value) {
		current.glProgramUniformMatrix4x2fvEXT(program, location, count, transpose, value);
	}

	public void glProgramUniformMatrix4x2fvEXT(int program, int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glProgramUniformMatrix4x2fvEXT(program, location, count, transpose, value, value_offset);
	}

	public void glProgramUniformMatrix4x3fvEXT(int program, int location, int count, boolean transpose, FloatBuffer value) {
		current.glProgramUniformMatrix4x3fvEXT(program, location, count, transpose, value);
	}

	public void glProgramUniformMatrix4x3fvEXT(int program, int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glProgramUniformMatrix4x3fvEXT(program, location, count, transpose, value, value_offset);
	}

	public void glProgramVertexLimitNV(int target, int limit) {
		current.glProgramVertexLimitNV(target, limit);
	}

	public void glProvokingVertexEXT(int mode) {
		current.glProvokingVertexEXT(mode);
	}

	public void glPushAttrib(int mask) {
		current.glPushAttrib(mask);
	}

	public void glPushClientAttrib(int mask) {
		current.glPushClientAttrib(mask);
	}

	public void glPushClientAttribDefaultEXT(int mask) {
		current.glPushClientAttribDefaultEXT(mask);
	}

	public void glPushName(int name) {
		current.glPushName(name);
	}

	public int glQueryMatrixxOES(IntBuffer mantissa, IntBuffer exponent) {
		return current.glQueryMatrixxOES(mantissa, exponent);
	}

	public int glQueryMatrixxOES(int[] mantissa, int mantissa_offset, int[] exponent, int exponent_offset) {
		return current.glQueryMatrixxOES(mantissa, mantissa_offset, exponent, exponent_offset);
	}

	public void glRasterPos2d(double x, double y) {
		current.glRasterPos2d(x, y);
	}

	public void glRasterPos2dv(DoubleBuffer v) {
		current.glRasterPos2dv(v);
	}

	public void glRasterPos2dv(double[] v, int v_offset) {
		current.glRasterPos2dv(v, v_offset);
	}

	public void glRasterPos2f(float x, float y) {
		current.glRasterPos2f(x, y);
	}

	public void glRasterPos2fv(FloatBuffer v) {
		current.glRasterPos2fv(v);
	}

	public void glRasterPos2fv(float[] v, int v_offset) {
		current.glRasterPos2fv(v, v_offset);
	}

	public void glRasterPos2i(int x, int y) {
		current.glRasterPos2i(x, y);
	}

	public void glRasterPos2iv(IntBuffer v) {
		current.glRasterPos2iv(v);
	}

	public void glRasterPos2iv(int[] v, int v_offset) {
		current.glRasterPos2iv(v, v_offset);
	}

	public void glRasterPos2s(short x, short y) {
		current.glRasterPos2s(x, y);
	}

	public void glRasterPos2sv(ShortBuffer v) {
		current.glRasterPos2sv(v);
	}

	public void glRasterPos2sv(short[] v, int v_offset) {
		current.glRasterPos2sv(v, v_offset);
	}

	public void glRasterPos3d(double x, double y, double z) {
		current.glRasterPos3d(x, y, z);
	}

	public void glRasterPos3dv(DoubleBuffer v) {
		current.glRasterPos3dv(v);
	}

	public void glRasterPos3dv(double[] v, int v_offset) {
		current.glRasterPos3dv(v, v_offset);
	}

	public void glRasterPos3f(float x, float y, float z) {
		current.glRasterPos3f(x, y, z);
	}

	public void glRasterPos3fv(FloatBuffer v) {
		current.glRasterPos3fv(v);
	}

	public void glRasterPos3fv(float[] v, int v_offset) {
		current.glRasterPos3fv(v, v_offset);
	}

	public void glRasterPos3i(int x, int y, int z) {
		current.glRasterPos3i(x, y, z);
	}

	public void glRasterPos3iv(IntBuffer v) {
		current.glRasterPos3iv(v);
	}

	public void glRasterPos3iv(int[] v, int v_offset) {
		current.glRasterPos3iv(v, v_offset);
	}

	public void glRasterPos3s(short x, short y, short z) {
		current.glRasterPos3s(x, y, z);
	}

	public void glRasterPos3sv(ShortBuffer v) {
		current.glRasterPos3sv(v);
	}

	public void glRasterPos3sv(short[] v, int v_offset) {
		current.glRasterPos3sv(v, v_offset);
	}

	public void glRasterPos4d(double x, double y, double z, double w) {
		current.glRasterPos4d(x, y, z, w);
	}

	public void glRasterPos4dv(DoubleBuffer v) {
		current.glRasterPos4dv(v);
	}

	public void glRasterPos4dv(double[] v, int v_offset) {
		current.glRasterPos4dv(v, v_offset);
	}

	public void glRasterPos4f(float x, float y, float z, float w) {
		current.glRasterPos4f(x, y, z, w);
	}

	public void glRasterPos4fv(FloatBuffer v) {
		current.glRasterPos4fv(v);
	}

	public void glRasterPos4fv(float[] v, int v_offset) {
		current.glRasterPos4fv(v, v_offset);
	}

	public void glRasterPos4i(int x, int y, int z, int w) {
		current.glRasterPos4i(x, y, z, w);
	}

	public void glRasterPos4iv(IntBuffer v) {
		current.glRasterPos4iv(v);
	}

	public void glRasterPos4iv(int[] v, int v_offset) {
		current.glRasterPos4iv(v, v_offset);
	}

	public void glRasterPos4s(short x, short y, short z, short w) {
		current.glRasterPos4s(x, y, z, w);
	}

	public void glRasterPos4sv(ShortBuffer v) {
		current.glRasterPos4sv(v);
	}

	public void glRasterPos4sv(short[] v, int v_offset) {
		current.glRasterPos4sv(v, v_offset);
	}

	public void glRectd(double x1, double y1, double x2, double y2) {
		current.glRectd(x1, y1, x2, y2);
	}

	public void glRectdv(DoubleBuffer v1, DoubleBuffer v2) {
		current.glRectdv(v1, v2);
	}

	public void glRectdv(double[] v1, int v1_offset, double[] v2, int v2_offset) {
		current.glRectdv(v1, v1_offset, v2, v2_offset);
	}

	public void glRectf(float x1, float y1, float x2, float y2) {
		current.glRectf(x1, y1, x2, y2);
	}

	public void glRectfv(FloatBuffer v1, FloatBuffer v2) {
		current.glRectfv(v1, v2);
	}

	public void glRectfv(float[] v1, int v1_offset, float[] v2, int v2_offset) {
		current.glRectfv(v1, v1_offset, v2, v2_offset);
	}

	public void glRecti(int x1, int y1, int x2, int y2) {
		current.glRecti(x1, y1, x2, y2);
	}

	public void glRectiv(IntBuffer v1, IntBuffer v2) {
		current.glRectiv(v1, v2);
	}

	public void glRectiv(int[] v1, int v1_offset, int[] v2, int v2_offset) {
		current.glRectiv(v1, v1_offset, v2, v2_offset);
	}

	public void glRects(short x1, short y1, short x2, short y2) {
		current.glRects(x1, y1, x2, y2);
	}

	public void glRectsv(ShortBuffer v1, ShortBuffer v2) {
		current.glRectsv(v1, v2);
	}

	public void glRectsv(short[] v1, int v1_offset, short[] v2, int v2_offset) {
		current.glRectsv(v1, v1_offset, v2, v2_offset);
	}

	public int glRenderMode(int mode) {
		return current.glRenderMode(mode);
	}

	public void glRenderbufferStorageMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
		current.glRenderbufferStorageMultisampleCoverageNV(target, coverageSamples, colorSamples, internalformat, width, height);
	}

	public void glResetHistogram(int target) {
		current.glResetHistogram(target);
	}

	public void glResetMinmax(int target) {
		current.glResetMinmax(target);
	}

	public void glResumeTransformFeedbackNV() {
		current.glResumeTransformFeedbackNV();
	}

	public void glRotated(double angle, double x, double y, double z) {
		current.glRotated(angle, x, y, z);
	}

	public void glSampleMaskIndexedNV(int index, int mask) {
		current.glSampleMaskIndexedNV(index, mask);
	}

	public void glScaled(double x, double y, double z) {
		current.glScaled(x, y, z);
	}

	public void glSecondaryColor3b(byte red, byte green, byte blue) {
		current.glSecondaryColor3b(red, green, blue);
	}

	public void glSecondaryColor3bv(ByteBuffer v) {
		current.glSecondaryColor3bv(v);
	}

	public void glSecondaryColor3bv(byte[] v, int v_offset) {
		current.glSecondaryColor3bv(v, v_offset);
	}

	public void glSecondaryColor3d(double red, double green, double blue) {
		current.glSecondaryColor3d(red, green, blue);
	}

	public void glSecondaryColor3dv(DoubleBuffer v) {
		current.glSecondaryColor3dv(v);
	}

	public void glSecondaryColor3dv(double[] v, int v_offset) {
		current.glSecondaryColor3dv(v, v_offset);
	}

	public void glSecondaryColor3f(float red, float green, float blue) {
		current.glSecondaryColor3f(red, green, blue);
	}

	public void glSecondaryColor3fv(FloatBuffer v) {
		current.glSecondaryColor3fv(v);
	}

	public void glSecondaryColor3fv(float[] v, int v_offset) {
		current.glSecondaryColor3fv(v, v_offset);
	}

	public void glSecondaryColor3h(short red, short green, short blue) {
		current.glSecondaryColor3h(red, green, blue);
	}

	public void glSecondaryColor3hv(ShortBuffer v) {
		current.glSecondaryColor3hv(v);
	}

	public void glSecondaryColor3hv(short[] v, int v_offset) {
		current.glSecondaryColor3hv(v, v_offset);
	}

	public void glSecondaryColor3i(int red, int green, int blue) {
		current.glSecondaryColor3i(red, green, blue);
	}

	public void glSecondaryColor3iv(IntBuffer v) {
		current.glSecondaryColor3iv(v);
	}

	public void glSecondaryColor3iv(int[] v, int v_offset) {
		current.glSecondaryColor3iv(v, v_offset);
	}

	public void glSecondaryColor3s(short red, short green, short blue) {
		current.glSecondaryColor3s(red, green, blue);
	}

	public void glSecondaryColor3sv(ShortBuffer v) {
		current.glSecondaryColor3sv(v);
	}

	public void glSecondaryColor3sv(short[] v, int v_offset) {
		current.glSecondaryColor3sv(v, v_offset);
	}

	public void glSecondaryColor3ub(byte red, byte green, byte blue) {
		current.glSecondaryColor3ub(red, green, blue);
	}

	public void glSecondaryColor3ubv(ByteBuffer v) {
		current.glSecondaryColor3ubv(v);
	}

	public void glSecondaryColor3ubv(byte[] v, int v_offset) {
		current.glSecondaryColor3ubv(v, v_offset);
	}

	public void glSecondaryColor3ui(int red, int green, int blue) {
		current.glSecondaryColor3ui(red, green, blue);
	}

	public void glSecondaryColor3uiv(IntBuffer v) {
		current.glSecondaryColor3uiv(v);
	}

	public void glSecondaryColor3uiv(int[] v, int v_offset) {
		current.glSecondaryColor3uiv(v, v_offset);
	}

	public void glSecondaryColor3us(short red, short green, short blue) {
		current.glSecondaryColor3us(red, green, blue);
	}

	public void glSecondaryColor3usv(ShortBuffer v) {
		current.glSecondaryColor3usv(v);
	}

	public void glSecondaryColor3usv(short[] v, int v_offset) {
		current.glSecondaryColor3usv(v, v_offset);
	}

	public void glSecondaryColorPointer(int size, int type, int stride, Buffer pointer) {
		current.glSecondaryColorPointer(size, type, stride, pointer);
	}

	public void glSecondaryColorPointer(int size, int type, int stride, long pointer_buffer_offset) {
		current.glSecondaryColorPointer(size, type, stride, pointer_buffer_offset);
	}

	public void glSelectBuffer(int size, IntBuffer buffer) {
		current.glSelectBuffer(size, buffer);
	}

	public void glSelectPerfMonitorCountersAMD(int monitor, boolean enable, int group, int numCounters, IntBuffer counterList) {
		current.glSelectPerfMonitorCountersAMD(monitor, enable, group, numCounters, counterList);
	}

	public void glSelectPerfMonitorCountersAMD(int monitor, boolean enable, int group, int numCounters, int[] counterList, int counterList_offset) {
		current.glSelectPerfMonitorCountersAMD(monitor, enable, group, numCounters, counterList, counterList_offset);
	}

	public void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, Buffer row, Buffer column) {
		current.glSeparableFilter2D(target, internalformat, width, height, format, type, row, column);
	}

	public void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, long row_buffer_offset, long column_buffer_offset) {
		current.glSeparableFilter2D(target, internalformat, width, height, format, type, row_buffer_offset, column_buffer_offset);
	}

	public void glSetFenceAPPLE(int fence) {
		current.glSetFenceAPPLE(fence);
	}

	public void glSetFenceNV(int fence, int condition) {
		current.glSetFenceNV(fence, condition);
	}

	public void glSetInvariantEXT(int id, int type, Buffer addr) {
		current.glSetInvariantEXT(id, type, addr);
	}

	public void glSetLocalConstantEXT(int id, int type, Buffer addr) {
		current.glSetLocalConstantEXT(id, type, addr);
	}

	public void glShaderOp1EXT(int op, int res, int arg1) {
		current.glShaderOp1EXT(op, res, arg1);
	}

	public void glShaderOp2EXT(int op, int res, int arg1, int arg2) {
		current.glShaderOp2EXT(op, res, arg1, arg2);
	}

	public void glShaderOp3EXT(int op, int res, int arg1, int arg2, int arg3) {
		current.glShaderOp3EXT(op, res, arg1, arg2, arg3);
	}

	public void glShaderSourceARB(int shaderObj, int count, String[] string, IntBuffer length) {
		current.glShaderSourceARB(shaderObj, count, string, length);
	}

	public void glShaderSourceARB(int shaderObj, int count, String[] string, int[] length, int length_offset) {
		current.glShaderSourceARB(shaderObj, count, string, length, length_offset);
	}

	public void glStencilClearTagEXT(int stencilTagBits, int stencilClearTag) {
		current.glStencilClearTagEXT(stencilTagBits, stencilClearTag);
	}

	public void glStencilFillPathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int fillMode, int mask, int transformType, FloatBuffer transformValues) {
		current.glStencilFillPathInstancedNV(numPaths, pathNameType, paths, pathBase, fillMode, mask, transformType, transformValues);
	}

	public void glStencilFillPathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int fillMode, int mask, int transformType, float[] transformValues,
			int transformValues_offset) {
		current.glStencilFillPathInstancedNV(numPaths, pathNameType, paths, pathBase, fillMode, mask, transformType, transformValues, transformValues_offset);
	}

	public void glStencilFillPathNV(int path, int fillMode, int mask) {
		current.glStencilFillPathNV(path, fillMode, mask);
	}

	public void glStencilStrokePathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int reference, int mask, int transformType, FloatBuffer transformValues) {
		current.glStencilStrokePathInstancedNV(numPaths, pathNameType, paths, pathBase, reference, mask, transformType, transformValues);
	}

	public void glStencilStrokePathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int reference, int mask, int transformType, float[] transformValues,
			int transformValues_offset) {
		current.glStencilStrokePathInstancedNV(numPaths, pathNameType, paths, pathBase, reference, mask, transformType, transformValues, transformValues_offset);
	}

	public void glStencilStrokePathNV(int path, int reference, int mask) {
		current.glStencilStrokePathNV(path, reference, mask);
	}

	public void glStringMarkerGREMEDY(int len, Buffer string) {
		current.glStringMarkerGREMEDY(len, string);
	}

	public void glSwizzleEXT(int res, int in, int outX, int outY, int outZ, int outW) {
		current.glSwizzleEXT(res, in, outX, outY, outZ, outW);
	}

	public void glSyncTextureINTEL(int texture) {
		current.glSyncTextureINTEL(texture);
	}

	public boolean glTestFenceAPPLE(int fence) {
		return current.glTestFenceAPPLE(fence);
	}

	public boolean glTestFenceNV(int fence) {
		return current.glTestFenceNV(fence);
	}

	public boolean glTestObjectAPPLE(int object, int name) {
		return current.glTestObjectAPPLE(object, name);
	}

	public void glTexCoord1bOES(byte s) {
		current.glTexCoord1bOES(s);
	}

	public void glTexCoord1bvOES(ByteBuffer coords) {
		current.glTexCoord1bvOES(coords);
	}

	public void glTexCoord1bvOES(byte[] coords, int coords_offset) {
		current.glTexCoord1bvOES(coords, coords_offset);
	}

	public void glTexCoord1d(double s) {
		current.glTexCoord1d(s);
	}

	public void glTexCoord1dv(DoubleBuffer v) {
		current.glTexCoord1dv(v);
	}

	public void glTexCoord1dv(double[] v, int v_offset) {
		current.glTexCoord1dv(v, v_offset);
	}

	public void glTexCoord1f(float s) {
		current.glTexCoord1f(s);
	}

	public void glTexCoord1fv(FloatBuffer v) {
		current.glTexCoord1fv(v);
	}

	public void glTexCoord1fv(float[] v, int v_offset) {
		current.glTexCoord1fv(v, v_offset);
	}

	public void glTexCoord1h(short s) {
		current.glTexCoord1h(s);
	}

	public void glTexCoord1hv(ShortBuffer v) {
		current.glTexCoord1hv(v);
	}

	public void glTexCoord1hv(short[] v, int v_offset) {
		current.glTexCoord1hv(v, v_offset);
	}

	public void glTexCoord1i(int s) {
		current.glTexCoord1i(s);
	}

	public void glTexCoord1iv(IntBuffer v) {
		current.glTexCoord1iv(v);
	}

	public void glTexCoord1iv(int[] v, int v_offset) {
		current.glTexCoord1iv(v, v_offset);
	}

	public void glTexCoord1s(short s) {
		current.glTexCoord1s(s);
	}

	public void glTexCoord1sv(ShortBuffer v) {
		current.glTexCoord1sv(v);
	}

	public void glTexCoord1sv(short[] v, int v_offset) {
		current.glTexCoord1sv(v, v_offset);
	}

	public void glTexCoord2bOES(byte s, byte t) {
		current.glTexCoord2bOES(s, t);
	}

	public void glTexCoord2bvOES(ByteBuffer coords) {
		current.glTexCoord2bvOES(coords);
	}

	public void glTexCoord2bvOES(byte[] coords, int coords_offset) {
		current.glTexCoord2bvOES(coords, coords_offset);
	}

	public void glTexCoord2d(double s, double t) {
		current.glTexCoord2d(s, t);
	}

	public void glTexCoord2dv(DoubleBuffer v) {
		current.glTexCoord2dv(v);
	}

	public void glTexCoord2dv(double[] v, int v_offset) {
		current.glTexCoord2dv(v, v_offset);
	}

	public void glTexCoord2f(float s, float t) {
		current.glTexCoord2f(s, t);
	}

	public void glTexCoord2fv(FloatBuffer v) {
		current.glTexCoord2fv(v);
	}

	public void glTexCoord2fv(float[] v, int v_offset) {
		current.glTexCoord2fv(v, v_offset);
	}

	public void glTexCoord2h(short s, short t) {
		current.glTexCoord2h(s, t);
	}

	public void glTexCoord2hv(ShortBuffer v) {
		current.glTexCoord2hv(v);
	}

	public void glTexCoord2hv(short[] v, int v_offset) {
		current.glTexCoord2hv(v, v_offset);
	}

	public void glTexCoord2i(int s, int t) {
		current.glTexCoord2i(s, t);
	}

	public void glTexCoord2iv(IntBuffer v) {
		current.glTexCoord2iv(v);
	}

	public void glTexCoord2iv(int[] v, int v_offset) {
		current.glTexCoord2iv(v, v_offset);
	}

	public void glTexCoord2s(short s, short t) {
		current.glTexCoord2s(s, t);
	}

	public void glTexCoord2sv(ShortBuffer v) {
		current.glTexCoord2sv(v);
	}

	public void glTexCoord2sv(short[] v, int v_offset) {
		current.glTexCoord2sv(v, v_offset);
	}

	public void glTexCoord3bOES(byte s, byte t, byte r) {
		current.glTexCoord3bOES(s, t, r);
	}

	public void glTexCoord3bvOES(ByteBuffer coords) {
		current.glTexCoord3bvOES(coords);
	}

	public void glTexCoord3bvOES(byte[] coords, int coords_offset) {
		current.glTexCoord3bvOES(coords, coords_offset);
	}

	public void glTexCoord3d(double s, double t, double r) {
		current.glTexCoord3d(s, t, r);
	}

	public void glTexCoord3dv(DoubleBuffer v) {
		current.glTexCoord3dv(v);
	}

	public void glTexCoord3dv(double[] v, int v_offset) {
		current.glTexCoord3dv(v, v_offset);
	}

	public void glTexCoord3f(float s, float t, float r) {
		current.glTexCoord3f(s, t, r);
	}

	public void glTexCoord3fv(FloatBuffer v) {
		current.glTexCoord3fv(v);
	}

	public void glTexCoord3fv(float[] v, int v_offset) {
		current.glTexCoord3fv(v, v_offset);
	}

	public void glTexCoord3h(short s, short t, short r) {
		current.glTexCoord3h(s, t, r);
	}

	public void glTexCoord3hv(ShortBuffer v) {
		current.glTexCoord3hv(v);
	}

	public void glTexCoord3hv(short[] v, int v_offset) {
		current.glTexCoord3hv(v, v_offset);
	}

	public void glTexCoord3i(int s, int t, int r) {
		current.glTexCoord3i(s, t, r);
	}

	public void glTexCoord3iv(IntBuffer v) {
		current.glTexCoord3iv(v);
	}

	public void glTexCoord3iv(int[] v, int v_offset) {
		current.glTexCoord3iv(v, v_offset);
	}

	public void glTexCoord3s(short s, short t, short r) {
		current.glTexCoord3s(s, t, r);
	}

	public void glTexCoord3sv(ShortBuffer v) {
		current.glTexCoord3sv(v);
	}

	public void glTexCoord3sv(short[] v, int v_offset) {
		current.glTexCoord3sv(v, v_offset);
	}

	public void glTexCoord4bOES(byte s, byte t, byte r, byte q) {
		current.glTexCoord4bOES(s, t, r, q);
	}

	public void glTexCoord4bvOES(ByteBuffer coords) {
		current.glTexCoord4bvOES(coords);
	}

	public void glTexCoord4bvOES(byte[] coords, int coords_offset) {
		current.glTexCoord4bvOES(coords, coords_offset);
	}

	public void glTexCoord4d(double s, double t, double r, double q) {
		current.glTexCoord4d(s, t, r, q);
	}

	public void glTexCoord4dv(DoubleBuffer v) {
		current.glTexCoord4dv(v);
	}

	public void glTexCoord4dv(double[] v, int v_offset) {
		current.glTexCoord4dv(v, v_offset);
	}

	public void glTexCoord4f(float s, float t, float r, float q) {
		current.glTexCoord4f(s, t, r, q);
	}

	public void glTexCoord4fv(FloatBuffer v) {
		current.glTexCoord4fv(v);
	}

	public void glTexCoord4fv(float[] v, int v_offset) {
		current.glTexCoord4fv(v, v_offset);
	}

	public void glTexCoord4h(short s, short t, short r, short q) {
		current.glTexCoord4h(s, t, r, q);
	}

	public void glTexCoord4hv(ShortBuffer v) {
		current.glTexCoord4hv(v);
	}

	public void glTexCoord4hv(short[] v, int v_offset) {
		current.glTexCoord4hv(v, v_offset);
	}

	public void glTexCoord4i(int s, int t, int r, int q) {
		current.glTexCoord4i(s, t, r, q);
	}

	public void glTexCoord4iv(IntBuffer v) {
		current.glTexCoord4iv(v);
	}

	public void glTexCoord4iv(int[] v, int v_offset) {
		current.glTexCoord4iv(v, v_offset);
	}

	public void glTexCoord4s(short s, short t, short r, short q) {
		current.glTexCoord4s(s, t, r, q);
	}

	public void glTexCoord4sv(ShortBuffer v) {
		current.glTexCoord4sv(v);
	}

	public void glTexCoord4sv(short[] v, int v_offset) {
		current.glTexCoord4sv(v, v_offset);
	}

	public void glTexGend(int coord, int pname, double param) {
		current.glTexGend(coord, pname, param);
	}

	public void glTexGendv(int coord, int pname, DoubleBuffer params) {
		current.glTexGendv(coord, pname, params);
	}

	public void glTexGendv(int coord, int pname, double[] params, int params_offset) {
		current.glTexGendv(coord, pname, params, params_offset);
	}

	public void glTexRenderbufferNV(int target, int renderbuffer) {
		current.glTexRenderbufferNV(target, renderbuffer);
	}

	public void glTexStorageSparseAMD(int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
		current.glTexStorageSparseAMD(target, internalFormat, width, height, depth, layers, flags);
	}

	public void glTextureBarrierNV() {
		current.glTextureBarrierNV();
	}

	public void glTextureBufferEXT(int texture, int target, int internalformat, int buffer) {
		current.glTextureBufferEXT(texture, target, internalformat, buffer);
	}

	public void glTextureImage1DEXT(int texture, int target, int level, int internalformat, int width, int border, int format, int type, Buffer pixels) {
		current.glTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, pixels);
	}

	public void glTextureImage2DEXT(int texture, int target, int level, int internalformat, int width, int height, int border, int format, int type, Buffer pixels) {
		current.glTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, pixels);
	}

	public void glTextureImage3DEXT(int texture, int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, Buffer pixels) {
		current.glTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, pixels);
	}

	public void glTextureLightEXT(int pname) {
		current.glTextureLightEXT(pname);
	}

	public void glTextureMaterialEXT(int face, int mode) {
		current.glTextureMaterialEXT(face, mode);
	}

	public void glTextureNormalEXT(int mode) {
		current.glTextureNormalEXT(mode);
	}

	public void glTextureParameterIivEXT(int texture, int target, int pname, IntBuffer params) {
		current.glTextureParameterIivEXT(texture, target, pname, params);
	}

	public void glTextureParameterIivEXT(int texture, int target, int pname, int[] params, int params_offset) {
		current.glTextureParameterIivEXT(texture, target, pname, params, params_offset);
	}

	public void glTextureParameterIuivEXT(int texture, int target, int pname, IntBuffer params) {
		current.glTextureParameterIuivEXT(texture, target, pname, params);
	}

	public void glTextureParameterIuivEXT(int texture, int target, int pname, int[] params, int params_offset) {
		current.glTextureParameterIuivEXT(texture, target, pname, params, params_offset);
	}

	public void glTextureParameterfEXT(int texture, int target, int pname, float param) {
		current.glTextureParameterfEXT(texture, target, pname, param);
	}

	public void glTextureParameterfvEXT(int texture, int target, int pname, FloatBuffer params) {
		current.glTextureParameterfvEXT(texture, target, pname, params);
	}

	public void glTextureParameterfvEXT(int texture, int target, int pname, float[] params, int params_offset) {
		current.glTextureParameterfvEXT(texture, target, pname, params, params_offset);
	}

	public void glTextureParameteriEXT(int texture, int target, int pname, int param) {
		current.glTextureParameteriEXT(texture, target, pname, param);
	}

	public void glTextureParameterivEXT(int texture, int target, int pname, IntBuffer params) {
		current.glTextureParameterivEXT(texture, target, pname, params);
	}

	public void glTextureParameterivEXT(int texture, int target, int pname, int[] params, int params_offset) {
		current.glTextureParameterivEXT(texture, target, pname, params, params_offset);
	}

	public void glTextureRangeAPPLE(int target, int length, Buffer pointer) {
		current.glTextureRangeAPPLE(target, length, pointer);
	}

	public void glTextureRenderbufferEXT(int texture, int target, int renderbuffer) {
		current.glTextureRenderbufferEXT(texture, target, renderbuffer);
	}

	public void glTextureStorageSparseAMD(int texture, int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
		current.glTextureStorageSparseAMD(texture, target, internalFormat, width, height, depth, layers, flags);
	}

	public void glTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int width, int format, int type, Buffer pixels) {
		current.glTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, pixels);
	}

	public void glTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, Buffer pixels) {
		current.glTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, pixels);
	}

	public void glTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type,
			Buffer pixels) {
		current.glTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
	}

	public void glTransformPathNV(int resultPath, int srcPath, int transformType, FloatBuffer transformValues) {
		current.glTransformPathNV(resultPath, srcPath, transformType, transformValues);
	}

	public void glTransformPathNV(int resultPath, int srcPath, int transformType, float[] transformValues, int transformValues_offset) {
		current.glTransformPathNV(resultPath, srcPath, transformType, transformValues, transformValues_offset);
	}

	public void glTranslated(double x, double y, double z) {
		current.glTranslated(x, y, z);
	}

	public void glUniform1fARB(int location, float v0) {
		current.glUniform1fARB(location, v0);
	}

	public void glUniform1fvARB(int location, int count, FloatBuffer value) {
		current.glUniform1fvARB(location, count, value);
	}

	public void glUniform1fvARB(int location, int count, float[] value, int value_offset) {
		current.glUniform1fvARB(location, count, value, value_offset);
	}

	public void glUniform1iARB(int location, int v0) {
		current.glUniform1iARB(location, v0);
	}

	public void glUniform1ivARB(int location, int count, IntBuffer value) {
		current.glUniform1ivARB(location, count, value);
	}

	public void glUniform1ivARB(int location, int count, int[] value, int value_offset) {
		current.glUniform1ivARB(location, count, value, value_offset);
	}

	public void glUniform2fARB(int location, float v0, float v1) {
		current.glUniform2fARB(location, v0, v1);
	}

	public void glUniform2fvARB(int location, int count, FloatBuffer value) {
		current.glUniform2fvARB(location, count, value);
	}

	public void glUniform2fvARB(int location, int count, float[] value, int value_offset) {
		current.glUniform2fvARB(location, count, value, value_offset);
	}

	public void glUniform2iARB(int location, int v0, int v1) {
		current.glUniform2iARB(location, v0, v1);
	}

	public void glUniform2ivARB(int location, int count, IntBuffer value) {
		current.glUniform2ivARB(location, count, value);
	}

	public void glUniform2ivARB(int location, int count, int[] value, int value_offset) {
		current.glUniform2ivARB(location, count, value, value_offset);
	}

	public void glUniform3fARB(int location, float v0, float v1, float v2) {
		current.glUniform3fARB(location, v0, v1, v2);
	}

	public void glUniform3fvARB(int location, int count, FloatBuffer value) {
		current.glUniform3fvARB(location, count, value);
	}

	public void glUniform3fvARB(int location, int count, float[] value, int value_offset) {
		current.glUniform3fvARB(location, count, value, value_offset);
	}

	public void glUniform3iARB(int location, int v0, int v1, int v2) {
		current.glUniform3iARB(location, v0, v1, v2);
	}

	public void glUniform3ivARB(int location, int count, IntBuffer value) {
		current.glUniform3ivARB(location, count, value);
	}

	public void glUniform3ivARB(int location, int count, int[] value, int value_offset) {
		current.glUniform3ivARB(location, count, value, value_offset);
	}

	public void glUniform4fARB(int location, float v0, float v1, float v2, float v3) {
		current.glUniform4fARB(location, v0, v1, v2, v3);
	}

	public void glUniform4fvARB(int location, int count, FloatBuffer value) {
		current.glUniform4fvARB(location, count, value);
	}

	public void glUniform4fvARB(int location, int count, float[] value, int value_offset) {
		current.glUniform4fvARB(location, count, value, value_offset);
	}

	public void glUniform4iARB(int location, int v0, int v1, int v2, int v3) {
		current.glUniform4iARB(location, v0, v1, v2, v3);
	}

	public void glUniform4ivARB(int location, int count, IntBuffer value) {
		current.glUniform4ivARB(location, count, value);
	}

	public void glUniform4ivARB(int location, int count, int[] value, int value_offset) {
		current.glUniform4ivARB(location, count, value, value_offset);
	}

	public void glUniformBufferEXT(int program, int location, int buffer) {
		current.glUniformBufferEXT(program, location, buffer);
	}

	public void glUniformHandleui64NV(int location, long value) {
		current.glUniformHandleui64NV(location, value);
	}

	public void glUniformHandleui64vNV(int location, int count, LongBuffer value) {
		current.glUniformHandleui64vNV(location, count, value);
	}

	public void glUniformHandleui64vNV(int location, int count, long[] value, int value_offset) {
		current.glUniformHandleui64vNV(location, count, value, value_offset);
	}

	public void glUniformMatrix2fvARB(int location, int count, boolean transpose, FloatBuffer value) {
		current.glUniformMatrix2fvARB(location, count, transpose, value);
	}

	public void glUniformMatrix2fvARB(int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glUniformMatrix2fvARB(location, count, transpose, value, value_offset);
	}

	public void glUniformMatrix3fvARB(int location, int count, boolean transpose, FloatBuffer value) {
		current.glUniformMatrix3fvARB(location, count, transpose, value);
	}

	public void glUniformMatrix3fvARB(int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glUniformMatrix3fvARB(location, count, transpose, value, value_offset);
	}

	public void glUniformMatrix4fvARB(int location, int count, boolean transpose, FloatBuffer value) {
		current.glUniformMatrix4fvARB(location, count, transpose, value);
	}

	public void glUniformMatrix4fvARB(int location, int count, boolean transpose, float[] value, int value_offset) {
		current.glUniformMatrix4fvARB(location, count, transpose, value, value_offset);
	}

	public void glUnlockArraysEXT() {
		current.glUnlockArraysEXT();
	}

	public boolean glUnmapNamedBufferEXT(int buffer) {
		return current.glUnmapNamedBufferEXT(buffer);
	}

	public void glUnmapTexture2DINTEL(int texture, int level) {
		current.glUnmapTexture2DINTEL(texture, level);
	}

	public void glUseProgramObjectARB(int programObj) {
		current.glUseProgramObjectARB(programObj);
	}

	public void glVDPAUFiniNV() {
		current.glVDPAUFiniNV();
	}

	public void glVDPAUGetSurfaceivNV(long surface, int pname, int bufSize, IntBuffer length, IntBuffer values) {
		current.glVDPAUGetSurfaceivNV(surface, pname, bufSize, length, values);
	}

	public void glVDPAUGetSurfaceivNV(long surface, int pname, int bufSize, int[] length, int length_offset, int[] values, int values_offset) {
		current.glVDPAUGetSurfaceivNV(surface, pname, bufSize, length, length_offset, values, values_offset);
	}

	public void glVDPAUInitNV(Buffer vdpDevice, Buffer getProcAddress) {
		current.glVDPAUInitNV(vdpDevice, getProcAddress);
	}

	public void glVDPAUIsSurfaceNV(long surface) {
		current.glVDPAUIsSurfaceNV(surface);
	}

	public void glVDPAUMapSurfacesNV(int numSurfaces, PointerBuffer surfaces) {
		current.glVDPAUMapSurfacesNV(numSurfaces, surfaces);
	}

	public long glVDPAURegisterOutputSurfaceNV(Buffer vdpSurface, int target, int numTextureNames, IntBuffer textureNames) {
		return current.glVDPAURegisterOutputSurfaceNV(vdpSurface, target, numTextureNames, textureNames);
	}

	public long glVDPAURegisterOutputSurfaceNV(Buffer vdpSurface, int target, int numTextureNames, int[] textureNames, int textureNames_offset) {
		return current.glVDPAURegisterOutputSurfaceNV(vdpSurface, target, numTextureNames, textureNames, textureNames_offset);
	}

	public long glVDPAURegisterVideoSurfaceNV(Buffer vdpSurface, int target, int numTextureNames, IntBuffer textureNames) {
		return current.glVDPAURegisterVideoSurfaceNV(vdpSurface, target, numTextureNames, textureNames);
	}

	public long glVDPAURegisterVideoSurfaceNV(Buffer vdpSurface, int target, int numTextureNames, int[] textureNames, int textureNames_offset) {
		return current.glVDPAURegisterVideoSurfaceNV(vdpSurface, target, numTextureNames, textureNames, textureNames_offset);
	}

	public void glVDPAUSurfaceAccessNV(long surface, int access) {
		current.glVDPAUSurfaceAccessNV(surface, access);
	}

	public void glVDPAUUnmapSurfacesNV(int numSurface, PointerBuffer surfaces) {
		current.glVDPAUUnmapSurfacesNV(numSurface, surfaces);
	}

	public void glVDPAUUnregisterSurfaceNV(long surface) {
		current.glVDPAUUnregisterSurfaceNV(surface);
	}

	public void glValidateProgramARB(int programObj) {
		current.glValidateProgramARB(programObj);
	}

	public void glVariantPointerEXT(int id, int type, int stride, Buffer addr) {
		current.glVariantPointerEXT(id, type, stride, addr);
	}

	public void glVariantPointerEXT(int id, int type, int stride, long addr_buffer_offset) {
		current.glVariantPointerEXT(id, type, stride, addr_buffer_offset);
	}

	public void glVariantbvEXT(int id, ByteBuffer addr) {
		current.glVariantbvEXT(id, addr);
	}

	public void glVariantbvEXT(int id, byte[] addr, int addr_offset) {
		current.glVariantbvEXT(id, addr, addr_offset);
	}

	public void glVariantdvEXT(int id, DoubleBuffer addr) {
		current.glVariantdvEXT(id, addr);
	}

	public void glVariantdvEXT(int id, double[] addr, int addr_offset) {
		current.glVariantdvEXT(id, addr, addr_offset);
	}

	public void glVariantfvEXT(int id, FloatBuffer addr) {
		current.glVariantfvEXT(id, addr);
	}

	public void glVariantfvEXT(int id, float[] addr, int addr_offset) {
		current.glVariantfvEXT(id, addr, addr_offset);
	}

	public void glVariantivEXT(int id, IntBuffer addr) {
		current.glVariantivEXT(id, addr);
	}

	public void glVariantivEXT(int id, int[] addr, int addr_offset) {
		current.glVariantivEXT(id, addr, addr_offset);
	}

	public void glVariantsvEXT(int id, ShortBuffer addr) {
		current.glVariantsvEXT(id, addr);
	}

	public void glVariantsvEXT(int id, short[] addr, int addr_offset) {
		current.glVariantsvEXT(id, addr, addr_offset);
	}

	public void glVariantubvEXT(int id, ByteBuffer addr) {
		current.glVariantubvEXT(id, addr);
	}

	public void glVariantubvEXT(int id, byte[] addr, int addr_offset) {
		current.glVariantubvEXT(id, addr, addr_offset);
	}

	public void glVariantuivEXT(int id, IntBuffer addr) {
		current.glVariantuivEXT(id, addr);
	}

	public void glVariantuivEXT(int id, int[] addr, int addr_offset) {
		current.glVariantuivEXT(id, addr, addr_offset);
	}

	public void glVariantusvEXT(int id, ShortBuffer addr) {
		current.glVariantusvEXT(id, addr);
	}

	public void glVariantusvEXT(int id, short[] addr, int addr_offset) {
		current.glVariantusvEXT(id, addr, addr_offset);
	}

	public void glVertex2bOES(byte x) {
		current.glVertex2bOES(x);
	}

	public void glVertex2bvOES(ByteBuffer coords) {
		current.glVertex2bvOES(coords);
	}

	public void glVertex2bvOES(byte[] coords, int coords_offset) {
		current.glVertex2bvOES(coords, coords_offset);
	}

	public void glVertex2d(double x, double y) {
		current.glVertex2d(x, y);
	}

	public void glVertex2dv(DoubleBuffer v) {
		current.glVertex2dv(v);
	}

	public void glVertex2dv(double[] v, int v_offset) {
		current.glVertex2dv(v, v_offset);
	}

	public void glVertex2f(float x, float y) {
		current.glVertex2f(x, y);
	}

	public void glVertex2fv(FloatBuffer v) {
		current.glVertex2fv(v);
	}

	public void glVertex2fv(float[] v, int v_offset) {
		current.glVertex2fv(v, v_offset);
	}

	public void glVertex2h(short x, short y) {
		current.glVertex2h(x, y);
	}

	public void glVertex2hv(ShortBuffer v) {
		current.glVertex2hv(v);
	}

	public void glVertex2hv(short[] v, int v_offset) {
		current.glVertex2hv(v, v_offset);
	}

	public void glVertex2i(int x, int y) {
		current.glVertex2i(x, y);
	}

	public void glVertex2iv(IntBuffer v) {
		current.glVertex2iv(v);
	}

	public void glVertex2iv(int[] v, int v_offset) {
		current.glVertex2iv(v, v_offset);
	}

	public void glVertex2s(short x, short y) {
		current.glVertex2s(x, y);
	}

	public void glVertex2sv(ShortBuffer v) {
		current.glVertex2sv(v);
	}

	public void glVertex2sv(short[] v, int v_offset) {
		current.glVertex2sv(v, v_offset);
	}

	public void glVertex3bOES(byte x, byte y) {
		current.glVertex3bOES(x, y);
	}

	public void glVertex3bvOES(ByteBuffer coords) {
		current.glVertex3bvOES(coords);
	}

	public void glVertex3bvOES(byte[] coords, int coords_offset) {
		current.glVertex3bvOES(coords, coords_offset);
	}

	public void glVertex3d(double x, double y, double z) {
		current.glVertex3d(x, y, z);
	}

	public void glVertex3dv(DoubleBuffer v) {
		current.glVertex3dv(v);
	}

	public void glVertex3dv(double[] v, int v_offset) {
		current.glVertex3dv(v, v_offset);
	}

	public void glVertex3f(float x, float y, float z) {
		current.glVertex3f(x, y, z);
	}

	public void glVertex3fv(FloatBuffer v) {
		current.glVertex3fv(v);
	}

	public void glVertex3fv(float[] v, int v_offset) {
		current.glVertex3fv(v, v_offset);
	}

	public void glVertex3h(short x, short y, short z) {
		current.glVertex3h(x, y, z);
	}

	public void glVertex3hv(ShortBuffer v) {
		current.glVertex3hv(v);
	}

	public void glVertex3hv(short[] v, int v_offset) {
		current.glVertex3hv(v, v_offset);
	}

	public void glVertex3i(int x, int y, int z) {
		current.glVertex3i(x, y, z);
	}

	public void glVertex3iv(IntBuffer v) {
		current.glVertex3iv(v);
	}

	public void glVertex3iv(int[] v, int v_offset) {
		current.glVertex3iv(v, v_offset);
	}

	public void glVertex3s(short x, short y, short z) {
		current.glVertex3s(x, y, z);
	}

	public void glVertex3sv(ShortBuffer v) {
		current.glVertex3sv(v);
	}

	public void glVertex3sv(short[] v, int v_offset) {
		current.glVertex3sv(v, v_offset);
	}

	public void glVertex4bOES(byte x, byte y, byte z) {
		current.glVertex4bOES(x, y, z);
	}

	public void glVertex4bvOES(ByteBuffer coords) {
		current.glVertex4bvOES(coords);
	}

	public void glVertex4bvOES(byte[] coords, int coords_offset) {
		current.glVertex4bvOES(coords, coords_offset);
	}

	public void glVertex4d(double x, double y, double z, double w) {
		current.glVertex4d(x, y, z, w);
	}

	public void glVertex4dv(DoubleBuffer v) {
		current.glVertex4dv(v);
	}

	public void glVertex4dv(double[] v, int v_offset) {
		current.glVertex4dv(v, v_offset);
	}

	public void glVertex4f(float x, float y, float z, float w) {
		current.glVertex4f(x, y, z, w);
	}

	public void glVertex4fv(FloatBuffer v) {
		current.glVertex4fv(v);
	}

	public void glVertex4fv(float[] v, int v_offset) {
		current.glVertex4fv(v, v_offset);
	}

	public void glVertex4h(short x, short y, short z, short w) {
		current.glVertex4h(x, y, z, w);
	}

	public void glVertex4hv(ShortBuffer v) {
		current.glVertex4hv(v);
	}

	public void glVertex4hv(short[] v, int v_offset) {
		current.glVertex4hv(v, v_offset);
	}

	public void glVertex4i(int x, int y, int z, int w) {
		current.glVertex4i(x, y, z, w);
	}

	public void glVertex4iv(IntBuffer v) {
		current.glVertex4iv(v);
	}

	public void glVertex4iv(int[] v, int v_offset) {
		current.glVertex4iv(v, v_offset);
	}

	public void glVertex4s(short x, short y, short z, short w) {
		current.glVertex4s(x, y, z, w);
	}

	public void glVertex4sv(ShortBuffer v) {
		current.glVertex4sv(v);
	}

	public void glVertex4sv(short[] v, int v_offset) {
		current.glVertex4sv(v, v_offset);
	}

	public void glVertexArrayColorOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
		current.glVertexArrayColorOffsetEXT(vaobj, buffer, size, type, stride, offset);
	}

	public void glVertexArrayEdgeFlagOffsetEXT(int vaobj, int buffer, int stride, long offset) {
		current.glVertexArrayEdgeFlagOffsetEXT(vaobj, buffer, stride, offset);
	}

	public void glVertexArrayFogCoordOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
		current.glVertexArrayFogCoordOffsetEXT(vaobj, buffer, type, stride, offset);
	}

	public void glVertexArrayIndexOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
		current.glVertexArrayIndexOffsetEXT(vaobj, buffer, type, stride, offset);
	}

	public void glVertexArrayMultiTexCoordOffsetEXT(int vaobj, int buffer, int texunit, int size, int type, int stride, long offset) {
		current.glVertexArrayMultiTexCoordOffsetEXT(vaobj, buffer, texunit, size, type, stride, offset);
	}

	public void glVertexArrayNormalOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
		current.glVertexArrayNormalOffsetEXT(vaobj, buffer, type, stride, offset);
	}

	public void glVertexArrayParameteriAPPLE(int pname, int param) {
		current.glVertexArrayParameteriAPPLE(pname, param);
	}

	public void glVertexArrayRangeAPPLE(int length, Buffer pointer) {
		current.glVertexArrayRangeAPPLE(length, pointer);
	}

	public void glVertexArrayRangeNV(int length, Buffer pointer) {
		current.glVertexArrayRangeNV(length, pointer);
	}

	public void glVertexArraySecondaryColorOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
		current.glVertexArraySecondaryColorOffsetEXT(vaobj, buffer, size, type, stride, offset);
	}

	public void glVertexArrayTexCoordOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
		current.glVertexArrayTexCoordOffsetEXT(vaobj, buffer, size, type, stride, offset);
	}

	public void glVertexArrayVertexAttribIOffsetEXT(int vaobj, int buffer, int index, int size, int type, int stride, long offset) {
		current.glVertexArrayVertexAttribIOffsetEXT(vaobj, buffer, index, size, type, stride, offset);
	}

	public void glVertexArrayVertexAttribOffsetEXT(int vaobj, int buffer, int index, int size, int type, boolean normalized, int stride, long offset) {
		current.glVertexArrayVertexAttribOffsetEXT(vaobj, buffer, index, size, type, normalized, stride, offset);
	}

	public void glVertexArrayVertexOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
		current.glVertexArrayVertexOffsetEXT(vaobj, buffer, size, type, stride, offset);
	}

	public void glVertexAttrib1dARB(int index, double x) {
		current.glVertexAttrib1dARB(index, x);
	}

	public void glVertexAttrib1dvARB(int index, DoubleBuffer v) {
		current.glVertexAttrib1dvARB(index, v);
	}

	public void glVertexAttrib1dvARB(int index, double[] v, int v_offset) {
		current.glVertexAttrib1dvARB(index, v, v_offset);
	}

	public void glVertexAttrib1fARB(int index, float x) {
		current.glVertexAttrib1fARB(index, x);
	}

	public void glVertexAttrib1fvARB(int index, FloatBuffer v) {
		current.glVertexAttrib1fvARB(index, v);
	}

	public void glVertexAttrib1fvARB(int index, float[] v, int v_offset) {
		current.glVertexAttrib1fvARB(index, v, v_offset);
	}

	public void glVertexAttrib1h(int index, short x) {
		current.glVertexAttrib1h(index, x);
	}

	public void glVertexAttrib1hv(int index, ShortBuffer v) {
		current.glVertexAttrib1hv(index, v);
	}

	public void glVertexAttrib1hv(int index, short[] v, int v_offset) {
		current.glVertexAttrib1hv(index, v, v_offset);
	}

	public void glVertexAttrib1sARB(int index, short x) {
		current.glVertexAttrib1sARB(index, x);
	}

	public void glVertexAttrib1svARB(int index, ShortBuffer v) {
		current.glVertexAttrib1svARB(index, v);
	}

	public void glVertexAttrib1svARB(int index, short[] v, int v_offset) {
		current.glVertexAttrib1svARB(index, v, v_offset);
	}

	public void glVertexAttrib2dARB(int index, double x, double y) {
		current.glVertexAttrib2dARB(index, x, y);
	}

	public void glVertexAttrib2dvARB(int index, DoubleBuffer v) {
		current.glVertexAttrib2dvARB(index, v);
	}

	public void glVertexAttrib2dvARB(int index, double[] v, int v_offset) {
		current.glVertexAttrib2dvARB(index, v, v_offset);
	}

	public void glVertexAttrib2fARB(int index, float x, float y) {
		current.glVertexAttrib2fARB(index, x, y);
	}

	public void glVertexAttrib2fvARB(int index, FloatBuffer v) {
		current.glVertexAttrib2fvARB(index, v);
	}

	public void glVertexAttrib2fvARB(int index, float[] v, int v_offset) {
		current.glVertexAttrib2fvARB(index, v, v_offset);
	}

	public void glVertexAttrib2h(int index, short x, short y) {
		current.glVertexAttrib2h(index, x, y);
	}

	public void glVertexAttrib2hv(int index, ShortBuffer v) {
		current.glVertexAttrib2hv(index, v);
	}

	public void glVertexAttrib2hv(int index, short[] v, int v_offset) {
		current.glVertexAttrib2hv(index, v, v_offset);
	}

	public void glVertexAttrib2sARB(int index, short x, short y) {
		current.glVertexAttrib2sARB(index, x, y);
	}

	public void glVertexAttrib2svARB(int index, ShortBuffer v) {
		current.glVertexAttrib2svARB(index, v);
	}

	public void glVertexAttrib2svARB(int index, short[] v, int v_offset) {
		current.glVertexAttrib2svARB(index, v, v_offset);
	}

	public void glVertexAttrib3dARB(int index, double x, double y, double z) {
		current.glVertexAttrib3dARB(index, x, y, z);
	}

	public void glVertexAttrib3dvARB(int index, DoubleBuffer v) {
		current.glVertexAttrib3dvARB(index, v);
	}

	public void glVertexAttrib3dvARB(int index, double[] v, int v_offset) {
		current.glVertexAttrib3dvARB(index, v, v_offset);
	}

	public void glVertexAttrib3fARB(int index, float x, float y, float z) {
		current.glVertexAttrib3fARB(index, x, y, z);
	}

	public void glVertexAttrib3fvARB(int index, FloatBuffer v) {
		current.glVertexAttrib3fvARB(index, v);
	}

	public void glVertexAttrib3fvARB(int index, float[] v, int v_offset) {
		current.glVertexAttrib3fvARB(index, v, v_offset);
	}

	public void glVertexAttrib3h(int index, short x, short y, short z) {
		current.glVertexAttrib3h(index, x, y, z);
	}

	public void glVertexAttrib3hv(int index, ShortBuffer v) {
		current.glVertexAttrib3hv(index, v);
	}

	public void glVertexAttrib3hv(int index, short[] v, int v_offset) {
		current.glVertexAttrib3hv(index, v, v_offset);
	}

	public void glVertexAttrib3sARB(int index, short x, short y, short z) {
		current.glVertexAttrib3sARB(index, x, y, z);
	}

	public void glVertexAttrib3svARB(int index, ShortBuffer v) {
		current.glVertexAttrib3svARB(index, v);
	}

	public void glVertexAttrib3svARB(int index, short[] v, int v_offset) {
		current.glVertexAttrib3svARB(index, v, v_offset);
	}

	public void glVertexAttrib4NbvARB(int index, ByteBuffer v) {
		current.glVertexAttrib4NbvARB(index, v);
	}

	public void glVertexAttrib4NbvARB(int index, byte[] v, int v_offset) {
		current.glVertexAttrib4NbvARB(index, v, v_offset);
	}

	public void glVertexAttrib4NivARB(int index, IntBuffer v) {
		current.glVertexAttrib4NivARB(index, v);
	}

	public void glVertexAttrib4NivARB(int index, int[] v, int v_offset) {
		current.glVertexAttrib4NivARB(index, v, v_offset);
	}

	public void glVertexAttrib4NsvARB(int index, ShortBuffer v) {
		current.glVertexAttrib4NsvARB(index, v);
	}

	public void glVertexAttrib4NsvARB(int index, short[] v, int v_offset) {
		current.glVertexAttrib4NsvARB(index, v, v_offset);
	}

	public void glVertexAttrib4NubARB(int index, byte x, byte y, byte z, byte w) {
		current.glVertexAttrib4NubARB(index, x, y, z, w);
	}

	public void glVertexAttrib4NubvARB(int index, ByteBuffer v) {
		current.glVertexAttrib4NubvARB(index, v);
	}

	public void glVertexAttrib4NubvARB(int index, byte[] v, int v_offset) {
		current.glVertexAttrib4NubvARB(index, v, v_offset);
	}

	public void glVertexAttrib4NuivARB(int index, IntBuffer v) {
		current.glVertexAttrib4NuivARB(index, v);
	}

	public void glVertexAttrib4NuivARB(int index, int[] v, int v_offset) {
		current.glVertexAttrib4NuivARB(index, v, v_offset);
	}

	public void glVertexAttrib4NusvARB(int index, ShortBuffer v) {
		current.glVertexAttrib4NusvARB(index, v);
	}

	public void glVertexAttrib4NusvARB(int index, short[] v, int v_offset) {
		current.glVertexAttrib4NusvARB(index, v, v_offset);
	}

	public void glVertexAttrib4bvARB(int index, ByteBuffer v) {
		current.glVertexAttrib4bvARB(index, v);
	}

	public void glVertexAttrib4bvARB(int index, byte[] v, int v_offset) {
		current.glVertexAttrib4bvARB(index, v, v_offset);
	}

	public void glVertexAttrib4dARB(int index, double x, double y, double z, double w) {
		current.glVertexAttrib4dARB(index, x, y, z, w);
	}

	public void glVertexAttrib4dvARB(int index, DoubleBuffer v) {
		current.glVertexAttrib4dvARB(index, v);
	}

	public void glVertexAttrib4dvARB(int index, double[] v, int v_offset) {
		current.glVertexAttrib4dvARB(index, v, v_offset);
	}

	public void glVertexAttrib4fARB(int index, float x, float y, float z, float w) {
		current.glVertexAttrib4fARB(index, x, y, z, w);
	}

	public void glVertexAttrib4fvARB(int index, FloatBuffer v) {
		current.glVertexAttrib4fvARB(index, v);
	}

	public void glVertexAttrib4fvARB(int index, float[] v, int v_offset) {
		current.glVertexAttrib4fvARB(index, v, v_offset);
	}

	public void glVertexAttrib4h(int index, short x, short y, short z, short w) {
		current.glVertexAttrib4h(index, x, y, z, w);
	}

	public void glVertexAttrib4hv(int index, ShortBuffer v) {
		current.glVertexAttrib4hv(index, v);
	}

	public void glVertexAttrib4hv(int index, short[] v, int v_offset) {
		current.glVertexAttrib4hv(index, v, v_offset);
	}

	public void glVertexAttrib4ivARB(int index, IntBuffer v) {
		current.glVertexAttrib4ivARB(index, v);
	}

	public void glVertexAttrib4ivARB(int index, int[] v, int v_offset) {
		current.glVertexAttrib4ivARB(index, v, v_offset);
	}

	public void glVertexAttrib4sARB(int index, short x, short y, short z, short w) {
		current.glVertexAttrib4sARB(index, x, y, z, w);
	}

	public void glVertexAttrib4svARB(int index, ShortBuffer v) {
		current.glVertexAttrib4svARB(index, v);
	}

	public void glVertexAttrib4svARB(int index, short[] v, int v_offset) {
		current.glVertexAttrib4svARB(index, v, v_offset);
	}

	public void glVertexAttrib4ubvARB(int index, ByteBuffer v) {
		current.glVertexAttrib4ubvARB(index, v);
	}

	public void glVertexAttrib4ubvARB(int index, byte[] v, int v_offset) {
		current.glVertexAttrib4ubvARB(index, v, v_offset);
	}

	public void glVertexAttrib4uivARB(int index, IntBuffer v) {
		current.glVertexAttrib4uivARB(index, v);
	}

	public void glVertexAttrib4uivARB(int index, int[] v, int v_offset) {
		current.glVertexAttrib4uivARB(index, v, v_offset);
	}

	public void glVertexAttrib4usvARB(int index, ShortBuffer v) {
		current.glVertexAttrib4usvARB(index, v);
	}

	public void glVertexAttrib4usvARB(int index, short[] v, int v_offset) {
		current.glVertexAttrib4usvARB(index, v, v_offset);
	}

	public void glVertexAttribI1iEXT(int index, int x) {
		current.glVertexAttribI1iEXT(index, x);
	}

	public void glVertexAttribI1ivEXT(int index, IntBuffer v) {
		current.glVertexAttribI1ivEXT(index, v);
	}

	public void glVertexAttribI1ivEXT(int index, int[] v, int v_offset) {
		current.glVertexAttribI1ivEXT(index, v, v_offset);
	}

	public void glVertexAttribI1uiEXT(int index, int x) {
		current.glVertexAttribI1uiEXT(index, x);
	}

	public void glVertexAttribI1uivEXT(int index, IntBuffer v) {
		current.glVertexAttribI1uivEXT(index, v);
	}

	public void glVertexAttribI1uivEXT(int index, int[] v, int v_offset) {
		current.glVertexAttribI1uivEXT(index, v, v_offset);
	}

	public void glVertexAttribI2iEXT(int index, int x, int y) {
		current.glVertexAttribI2iEXT(index, x, y);
	}

	public void glVertexAttribI2ivEXT(int index, IntBuffer v) {
		current.glVertexAttribI2ivEXT(index, v);
	}

	public void glVertexAttribI2ivEXT(int index, int[] v, int v_offset) {
		current.glVertexAttribI2ivEXT(index, v, v_offset);
	}

	public void glVertexAttribI2uiEXT(int index, int x, int y) {
		current.glVertexAttribI2uiEXT(index, x, y);
	}

	public void glVertexAttribI2uivEXT(int index, IntBuffer v) {
		current.glVertexAttribI2uivEXT(index, v);
	}

	public void glVertexAttribI2uivEXT(int index, int[] v, int v_offset) {
		current.glVertexAttribI2uivEXT(index, v, v_offset);
	}

	public void glVertexAttribI3iEXT(int index, int x, int y, int z) {
		current.glVertexAttribI3iEXT(index, x, y, z);
	}

	public void glVertexAttribI3ivEXT(int index, IntBuffer v) {
		current.glVertexAttribI3ivEXT(index, v);
	}

	public void glVertexAttribI3ivEXT(int index, int[] v, int v_offset) {
		current.glVertexAttribI3ivEXT(index, v, v_offset);
	}

	public void glVertexAttribI3uiEXT(int index, int x, int y, int z) {
		current.glVertexAttribI3uiEXT(index, x, y, z);
	}

	public void glVertexAttribI3uivEXT(int index, IntBuffer v) {
		current.glVertexAttribI3uivEXT(index, v);
	}

	public void glVertexAttribI3uivEXT(int index, int[] v, int v_offset) {
		current.glVertexAttribI3uivEXT(index, v, v_offset);
	}

	public void glVertexAttribI4bvEXT(int index, ByteBuffer v) {
		current.glVertexAttribI4bvEXT(index, v);
	}

	public void glVertexAttribI4bvEXT(int index, byte[] v, int v_offset) {
		current.glVertexAttribI4bvEXT(index, v, v_offset);
	}

	public void glVertexAttribI4iEXT(int index, int x, int y, int z, int w) {
		current.glVertexAttribI4iEXT(index, x, y, z, w);
	}

	public void glVertexAttribI4ivEXT(int index, IntBuffer v) {
		current.glVertexAttribI4ivEXT(index, v);
	}

	public void glVertexAttribI4ivEXT(int index, int[] v, int v_offset) {
		current.glVertexAttribI4ivEXT(index, v, v_offset);
	}

	public void glVertexAttribI4svEXT(int index, ShortBuffer v) {
		current.glVertexAttribI4svEXT(index, v);
	}

	public void glVertexAttribI4svEXT(int index, short[] v, int v_offset) {
		current.glVertexAttribI4svEXT(index, v, v_offset);
	}

	public void glVertexAttribI4ubvEXT(int index, ByteBuffer v) {
		current.glVertexAttribI4ubvEXT(index, v);
	}

	public void glVertexAttribI4ubvEXT(int index, byte[] v, int v_offset) {
		current.glVertexAttribI4ubvEXT(index, v, v_offset);
	}

	public void glVertexAttribI4uiEXT(int index, int x, int y, int z, int w) {
		current.glVertexAttribI4uiEXT(index, x, y, z, w);
	}

	public void glVertexAttribI4uivEXT(int index, IntBuffer v) {
		current.glVertexAttribI4uivEXT(index, v);
	}

	public void glVertexAttribI4uivEXT(int index, int[] v, int v_offset) {
		current.glVertexAttribI4uivEXT(index, v, v_offset);
	}

	public void glVertexAttribI4usvEXT(int index, ShortBuffer v) {
		current.glVertexAttribI4usvEXT(index, v);
	}

	public void glVertexAttribI4usvEXT(int index, short[] v, int v_offset) {
		current.glVertexAttribI4usvEXT(index, v, v_offset);
	}

	public void glVertexAttribIPointerEXT(int index, int size, int type, int stride, Buffer pointer) {
		current.glVertexAttribIPointerEXT(index, size, type, stride, pointer);
	}

	public void glVertexAttribL1i64NV(int index, long x) {
		current.glVertexAttribL1i64NV(index, x);
	}

	public void glVertexAttribL1i64vNV(int index, LongBuffer v) {
		current.glVertexAttribL1i64vNV(index, v);
	}

	public void glVertexAttribL1i64vNV(int index, long[] v, int v_offset) {
		current.glVertexAttribL1i64vNV(index, v, v_offset);
	}

	public void glVertexAttribL1ui64NV(int index, long x) {
		current.glVertexAttribL1ui64NV(index, x);
	}

	public void glVertexAttribL1ui64vNV(int index, LongBuffer v) {
		current.glVertexAttribL1ui64vNV(index, v);
	}

	public void glVertexAttribL1ui64vNV(int index, long[] v, int v_offset) {
		current.glVertexAttribL1ui64vNV(index, v, v_offset);
	}

	public void glVertexAttribL2i64NV(int index, long x, long y) {
		current.glVertexAttribL2i64NV(index, x, y);
	}

	public void glVertexAttribL2i64vNV(int index, LongBuffer v) {
		current.glVertexAttribL2i64vNV(index, v);
	}

	public void glVertexAttribL2i64vNV(int index, long[] v, int v_offset) {
		current.glVertexAttribL2i64vNV(index, v, v_offset);
	}

	public void glVertexAttribL2ui64NV(int index, long x, long y) {
		current.glVertexAttribL2ui64NV(index, x, y);
	}

	public void glVertexAttribL2ui64vNV(int index, LongBuffer v) {
		current.glVertexAttribL2ui64vNV(index, v);
	}

	public void glVertexAttribL2ui64vNV(int index, long[] v, int v_offset) {
		current.glVertexAttribL2ui64vNV(index, v, v_offset);
	}

	public void glVertexAttribL3i64NV(int index, long x, long y, long z) {
		current.glVertexAttribL3i64NV(index, x, y, z);
	}

	public void glVertexAttribL3i64vNV(int index, LongBuffer v) {
		current.glVertexAttribL3i64vNV(index, v);
	}

	public void glVertexAttribL3i64vNV(int index, long[] v, int v_offset) {
		current.glVertexAttribL3i64vNV(index, v, v_offset);
	}

	public void glVertexAttribL3ui64NV(int index, long x, long y, long z) {
		current.glVertexAttribL3ui64NV(index, x, y, z);
	}

	public void glVertexAttribL3ui64vNV(int index, LongBuffer v) {
		current.glVertexAttribL3ui64vNV(index, v);
	}

	public void glVertexAttribL3ui64vNV(int index, long[] v, int v_offset) {
		current.glVertexAttribL3ui64vNV(index, v, v_offset);
	}

	public void glVertexAttribL4i64NV(int index, long x, long y, long z, long w) {
		current.glVertexAttribL4i64NV(index, x, y, z, w);
	}

	public void glVertexAttribL4i64vNV(int index, LongBuffer v) {
		current.glVertexAttribL4i64vNV(index, v);
	}

	public void glVertexAttribL4i64vNV(int index, long[] v, int v_offset) {
		current.glVertexAttribL4i64vNV(index, v, v_offset);
	}

	public void glVertexAttribL4ui64NV(int index, long x, long y, long z, long w) {
		current.glVertexAttribL4ui64NV(index, x, y, z, w);
	}

	public void glVertexAttribL4ui64vNV(int index, LongBuffer v) {
		current.glVertexAttribL4ui64vNV(index, v);
	}

	public void glVertexAttribL4ui64vNV(int index, long[] v, int v_offset) {
		current.glVertexAttribL4ui64vNV(index, v, v_offset);
	}

	public void glVertexAttribLFormatNV(int index, int size, int type, int stride) {
		current.glVertexAttribLFormatNV(index, size, type, stride);
	}

	public void glVertexAttribParameteriAMD(int index, int pname, int param) {
		current.glVertexAttribParameteriAMD(index, pname, param);
	}

	public void glVertexAttribPointerARB(int index, int size, int type, boolean normalized, int stride, Buffer pointer) {
		current.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
	}

	public void glVertexAttribPointerARB(int index, int size, int type, boolean normalized, int stride, long pointer_buffer_offset) {
		current.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer_buffer_offset);
	}

	public void glVertexAttribs1hv(int index, int n, ShortBuffer v) {
		current.glVertexAttribs1hv(index, n, v);
	}

	public void glVertexAttribs1hv(int index, int n, short[] v, int v_offset) {
		current.glVertexAttribs1hv(index, n, v, v_offset);
	}

	public void glVertexAttribs2hv(int index, int n, ShortBuffer v) {
		current.glVertexAttribs2hv(index, n, v);
	}

	public void glVertexAttribs2hv(int index, int n, short[] v, int v_offset) {
		current.glVertexAttribs2hv(index, n, v, v_offset);
	}

	public void glVertexAttribs3hv(int index, int n, ShortBuffer v) {
		current.glVertexAttribs3hv(index, n, v);
	}

	public void glVertexAttribs3hv(int index, int n, short[] v, int v_offset) {
		current.glVertexAttribs3hv(index, n, v, v_offset);
	}

	public void glVertexAttribs4hv(int index, int n, ShortBuffer v) {
		current.glVertexAttribs4hv(index, n, v);
	}

	public void glVertexAttribs4hv(int index, int n, short[] v, int v_offset) {
		current.glVertexAttribs4hv(index, n, v, v_offset);
	}

	public void glVertexBlendARB(int count) {
		current.glVertexBlendARB(count);
	}

	public void glVertexWeightPointerEXT(int size, int type, int stride, Buffer pointer) {
		current.glVertexWeightPointerEXT(size, type, stride, pointer);
	}

	public void glVertexWeightPointerEXT(int size, int type, int stride, long pointer_buffer_offset) {
		current.glVertexWeightPointerEXT(size, type, stride, pointer_buffer_offset);
	}

	public void glVertexWeightfEXT(float weight) {
		current.glVertexWeightfEXT(weight);
	}

	public void glVertexWeightfvEXT(FloatBuffer weight) {
		current.glVertexWeightfvEXT(weight);
	}

	public void glVertexWeightfvEXT(float[] weight, int weight_offset) {
		current.glVertexWeightfvEXT(weight, weight_offset);
	}

	public void glVertexWeighth(short weight) {
		current.glVertexWeighth(weight);
	}

	public void glVertexWeighthv(ShortBuffer weight) {
		current.glVertexWeighthv(weight);
	}

	public void glVertexWeighthv(short[] weight, int weight_offset) {
		current.glVertexWeighthv(weight, weight_offset);
	}

	public int glVideoCaptureNV(int video_capture_slot, IntBuffer sequence_num, LongBuffer capture_time) {
		return current.glVideoCaptureNV(video_capture_slot, sequence_num, capture_time);
	}

	public int glVideoCaptureNV(int video_capture_slot, int[] sequence_num, int sequence_num_offset, long[] capture_time, int capture_time_offset) {
		return current.glVideoCaptureNV(video_capture_slot, sequence_num, sequence_num_offset, capture_time, capture_time_offset);
	}

	public void glVideoCaptureStreamParameterdvNV(int video_capture_slot, int stream, int pname, DoubleBuffer params) {
		current.glVideoCaptureStreamParameterdvNV(video_capture_slot, stream, pname, params);
	}

	public void glVideoCaptureStreamParameterdvNV(int video_capture_slot, int stream, int pname, double[] params, int params_offset) {
		current.glVideoCaptureStreamParameterdvNV(video_capture_slot, stream, pname, params, params_offset);
	}

	public void glVideoCaptureStreamParameterfvNV(int video_capture_slot, int stream, int pname, FloatBuffer params) {
		current.glVideoCaptureStreamParameterfvNV(video_capture_slot, stream, pname, params);
	}

	public void glVideoCaptureStreamParameterfvNV(int video_capture_slot, int stream, int pname, float[] params, int params_offset) {
		current.glVideoCaptureStreamParameterfvNV(video_capture_slot, stream, pname, params, params_offset);
	}

	public void glVideoCaptureStreamParameterivNV(int video_capture_slot, int stream, int pname, IntBuffer params) {
		current.glVideoCaptureStreamParameterivNV(video_capture_slot, stream, pname, params);
	}

	public void glVideoCaptureStreamParameterivNV(int video_capture_slot, int stream, int pname, int[] params, int params_offset) {
		current.glVideoCaptureStreamParameterivNV(video_capture_slot, stream, pname, params, params_offset);
	}

	public void glWeightPathsNV(int resultPath, int numPaths, IntBuffer paths, FloatBuffer weights) {
		current.glWeightPathsNV(resultPath, numPaths, paths, weights);
	}

	public void glWeightPathsNV(int resultPath, int numPaths, int[] paths, int paths_offset, float[] weights, int weights_offset) {
		current.glWeightPathsNV(resultPath, numPaths, paths, paths_offset, weights, weights_offset);
	}

	public void glWeightPointer(int size, int type, int stride, Buffer pointer) {
		current.glWeightPointer(size, type, stride, pointer);
	}

	public void glWeightbvARB(int size, ByteBuffer weights) {
		current.glWeightbvARB(size, weights);
	}

	public void glWeightbvARB(int size, byte[] weights, int weights_offset) {
		current.glWeightbvARB(size, weights, weights_offset);
	}

	public void glWeightdvARB(int size, DoubleBuffer weights) {
		current.glWeightdvARB(size, weights);
	}

	public void glWeightdvARB(int size, double[] weights, int weights_offset) {
		current.glWeightdvARB(size, weights, weights_offset);
	}

	public void glWeightfvARB(int size, FloatBuffer weights) {
		current.glWeightfvARB(size, weights);
	}

	public void glWeightfvARB(int size, float[] weights, int weights_offset) {
		current.glWeightfvARB(size, weights, weights_offset);
	}

	public void glWeightivARB(int size, IntBuffer weights) {
		current.glWeightivARB(size, weights);
	}

	public void glWeightivARB(int size, int[] weights, int weights_offset) {
		current.glWeightivARB(size, weights, weights_offset);
	}

	public void glWeightsvARB(int size, ShortBuffer weights) {
		current.glWeightsvARB(size, weights);
	}

	public void glWeightsvARB(int size, short[] weights, int weights_offset) {
		current.glWeightsvARB(size, weights, weights_offset);
	}

	public void glWeightubvARB(int size, ByteBuffer weights) {
		current.glWeightubvARB(size, weights);
	}

	public void glWeightubvARB(int size, byte[] weights, int weights_offset) {
		current.glWeightubvARB(size, weights, weights_offset);
	}

	public void glWeightuivARB(int size, IntBuffer weights) {
		current.glWeightuivARB(size, weights);
	}

	public void glWeightuivARB(int size, int[] weights, int weights_offset) {
		current.glWeightuivARB(size, weights, weights_offset);
	}

	public void glWeightusvARB(int size, ShortBuffer weights) {
		current.glWeightusvARB(size, weights);
	}

	public void glWeightusvARB(int size, short[] weights, int weights_offset) {
		current.glWeightusvARB(size, weights, weights_offset);
	}

	public void glWindowPos2d(double x, double y) {
		current.glWindowPos2d(x, y);
	}

	public void glWindowPos2dv(DoubleBuffer v) {
		current.glWindowPos2dv(v);
	}

	public void glWindowPos2dv(double[] v, int v_offset) {
		current.glWindowPos2dv(v, v_offset);
	}

	public void glWindowPos2f(float x, float y) {
		current.glWindowPos2f(x, y);
	}

	public void glWindowPos2fv(FloatBuffer v) {
		current.glWindowPos2fv(v);
	}

	public void glWindowPos2fv(float[] v, int v_offset) {
		current.glWindowPos2fv(v, v_offset);
	}

	public void glWindowPos2i(int x, int y) {
		current.glWindowPos2i(x, y);
	}

	public void glWindowPos2iv(IntBuffer v) {
		current.glWindowPos2iv(v);
	}

	public void glWindowPos2iv(int[] v, int v_offset) {
		current.glWindowPos2iv(v, v_offset);
	}

	public void glWindowPos2s(short x, short y) {
		current.glWindowPos2s(x, y);
	}

	public void glWindowPos2sv(ShortBuffer v) {
		current.glWindowPos2sv(v);
	}

	public void glWindowPos2sv(short[] v, int v_offset) {
		current.glWindowPos2sv(v, v_offset);
	}

	public void glWindowPos3d(double x, double y, double z) {
		current.glWindowPos3d(x, y, z);
	}

	public void glWindowPos3dv(DoubleBuffer v) {
		current.glWindowPos3dv(v);
	}

	public void glWindowPos3dv(double[] v, int v_offset) {
		current.glWindowPos3dv(v, v_offset);
	}

	public void glWindowPos3f(float x, float y, float z) {
		current.glWindowPos3f(x, y, z);
	}

	public void glWindowPos3fv(FloatBuffer v) {
		current.glWindowPos3fv(v);
	}

	public void glWindowPos3fv(float[] v, int v_offset) {
		current.glWindowPos3fv(v, v_offset);
	}

	public void glWindowPos3i(int x, int y, int z) {
		current.glWindowPos3i(x, y, z);
	}

	public void glWindowPos3iv(IntBuffer v) {
		current.glWindowPos3iv(v);
	}

	public void glWindowPos3iv(int[] v, int v_offset) {
		current.glWindowPos3iv(v, v_offset);
	}

	public void glWindowPos3s(short x, short y, short z) {
		current.glWindowPos3s(x, y, z);
	}

	public void glWindowPos3sv(ShortBuffer v) {
		current.glWindowPos3sv(v);
	}

	public void glWindowPos3sv(short[] v, int v_offset) {
		current.glWindowPos3sv(v, v_offset);
	}

	public void glWriteMaskEXT(int res, int in, int outX, int outY, int outZ, int outW) {
		current.glWriteMaskEXT(res, in, outX, outY, outZ, outW);
	}

	public GLBufferStorage mapNamedBuffer(int bufferName, int access) throws GLException {
		return current.mapNamedBuffer(bufferName, access);
	}

	public GLBufferStorage mapNamedBufferRange(int bufferName, long offset, long length, int access) throws GLException {
		return current.mapNamedBufferRange(bufferName, offset, length, access);
	}

	public ByteBuffer glAllocateMemoryNV(int size, float readFrequency, float writeFrequency, float priority) {
		return current.glAllocateMemoryNV(size, readFrequency, writeFrequency, priority);
	}

	public void glFreeMemoryNV(ByteBuffer pointer) {
		current.glFreeMemoryNV(pointer);
	}

	public void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, Buffer ptr) {
		current.glVertexAttribPointer(indx, size, type, normalized, stride, ptr);
	}

	public void glDrawElementsInstanced(int mode, int count, int type, Buffer indices, int instancecount) {
		current.glDrawElementsInstanced(mode, count, type, indices, instancecount);
	}

	public void glDrawRangeElements(int mode, int start, int end, int count, int type, Buffer indices) {
		current.glDrawRangeElements(mode, start, end, count, type, indices);
	}

	public void glVertexAttribIPointer(int index, int size, int type, int stride, Buffer pointer) {
		current.glVertexAttribIPointer(index, size, type, stride, pointer);
	}


	
}
