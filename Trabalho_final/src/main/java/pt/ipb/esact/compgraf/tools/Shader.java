package pt.ipb.esact.compgraf.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.media.opengl.GL2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

public class Shader {

	private static final Logger logger = LoggerFactory.getLogger(Shader.class);
	
	int program = 0;

	private int diffuseUniform;

	private int normalUniform;

	private int specularUniform;

	private boolean linked;
	
	public static final String UNIFORM_DIFFUSE_MAP_NAME = "diffuse_map";
	
	public static final String UNIFORM_NORMAL_MAP_NAME = "normal_map";
	
	public static final String UNIFORM_SPECULAR_MAP_NAME = "specular_map";
	
	public static final int DIFFUSE_MAP_INDEX = GL2.GL_TEXTURE0;
	
	public static final int NORMAL_MAP_INDEX = GL2.GL_TEXTURE2;
	
	public static final int SPECULAR_MAP_INDEX = GL2.GL_TEXTURE4;
	
	public Shader() {
	}
	
	public void load(String vertexShader, String fragmentShader) {
		GL2 gl = GlTools.gl();
		int vertex = compile(GL2.GL_VERTEX_SHADER, vertexShader);
		int fragment = compile(GL2.GL_FRAGMENT_SHADER, fragmentShader);
		
		program = gl.glCreateProgram();
		
		gl.glAttachShader(program, vertex);
		gl.glAttachShader(program, fragment);
		
		gl.glLinkProgram(program);
		gl.glValidateProgram(program);
		
		diffuseUniform = gl.glGetUniformLocation(program, UNIFORM_DIFFUSE_MAP_NAME);
		normalUniform = gl.glGetUniformLocation(program, UNIFORM_NORMAL_MAP_NAME);
		specularUniform = gl.glGetUniformLocation(program, UNIFORM_SPECULAR_MAP_NAME);
	}
	
	public int compile(int type, String path) {
		GL2 gl = GlTools.gl();
		int shader = gl.glCreateShader(type);
		
		try (BufferedReader stream = new BufferedReader(new FileReader(path));) {
			StringBuilder lines = new StringBuilder();
			String line = null;
			while((line = stream.readLine()) != null)
				lines.append(line).append("\n");
			gl.glShaderSource(shader, 1, new String[] { lines.toString() }, (int[]) null, 0);
			gl.glCompileShader(shader);
			System.out.println(shader);
			String info = getInfo(gl, shader);
			if(!Strings.isNullOrEmpty(info))
				logger.error("{}:\n{}", path, info);
			else
				linked = true;
		} catch (IOException e) {
			GlTools.exit(e.getMessage());
		}

		return shader;
	}

	private String getInfo(GL2 gl, int shader) {
		IntBuffer length = IntBuffer.allocate(1);
		gl.glGetShaderiv(shader, GL2.GL_INFO_LOG_LENGTH, length);
		ByteBuffer infolog =  ByteBuffer.allocate(length.get(0));
		gl.glGetShaderInfoLog(shader, 200, length, infolog);
		
		return new String(infolog.array());
	}

	public void bind() {
		GL2 gl = GlTools.gl();
		
		gl.glUniform1i(diffuseUniform, DIFFUSE_MAP_INDEX - GL2.GL_TEXTURE0);
		gl.glUniform1i(normalUniform, NORMAL_MAP_INDEX - GL2.GL_TEXTURE0);
		gl.glUniform1i(specularUniform, SPECULAR_MAP_INDEX - GL2.GL_TEXTURE0);
		
		gl.glUseProgram(program);
	}
	
	public void unbind() {
		GL2 gl = GlTools.gl();
		gl.glUseProgram(0);
	}
	
	public int attributeLocation(String name) {
		GL2 gl = GlTools.gl();
		if(!linked)
			logger.warn("Shader program is not linked");
        return gl.glGetAttribLocation(program, name);
	}
	
	public void setAttributeValue(int location, float value) {
		GL2 gl = GlTools.gl();
		if(location != -1)
			gl.glVertexAttrib1f(location, value);
	}

	public void setAttributeValue(String name, float value) {
		setAttributeValue(attributeLocation(name), value);
	}
	
	public void setAttributeValue(int location, float x, float y) {
		GL2 gl = GlTools.gl();
		if(location != -1)
			gl.glVertexAttrib2f(location, x, y);
	}

	public void setAttributeValue(String name, float x, float y) {
		setAttributeValue(attributeLocation(name), x, y);
	}
	
	public void setAttributeValue(int location, float x, float y, float z) {
		GL2 gl = GlTools.gl();
		if(location != -1)
			gl.glVertexAttrib3f(location, x, y, z);
	}

	public void setAttributeValue(String name, float x, float y, float z) {
		setAttributeValue(attributeLocation(name), x, y, z);
	}
	
	public void setAttributeValue(int location, float x, float y, float z, float w) {
		GL2 gl = GlTools.gl();
		if(location != -1)
			gl.glVertexAttrib4f(location, x, y, z, w);
	}

	public void setAttributeValue(String name, float x, float y, float z, float w) {
		setAttributeValue(attributeLocation(name), x, y, z, w);
	}
	
	public int uniformLocation(String name) {
		GL2 gl = GlTools.gl();
		if(!linked)
			logger.warn("Shader program is not linked");
        return gl.glGetUniformLocation(program, name);
	}
	
	public void setUniformValue(int location, float value) {
		GL2 gl = GlTools.gl();
		if(location != -1)
			gl.glUniform1f(location, value);
	}

	public void setUniformValue(String name, float value) {
        int location = uniformLocation(name);
//        logger.info("uniform({}) = {}", location, value);
        setUniformValue(location, value);
	}
	
	public void setUniformValue(int location, float x, float y) {
		GL2 gl = GlTools.gl();
		if(location != -1)
			gl.glUniform2f(location, x, y);
	}

	public void setUniformValue(String name, float x, float y) {
		setUniformValue(uniformLocation(name), x, y);
	}
	
	public void setUniformValue(int location, float x, float y, float z) {
		GL2 gl = GlTools.gl();
		if(location != -1)
			gl.glUniform3f(location, x, y, z);
	}

	public void setUniformValue(String name, float x, float y, float z) {
		setUniformValue(uniformLocation(name), x, y, z);
	}
	
	public void setUniformValue(int location, float x, float y, float z, float w) {
		GL2 gl = GlTools.gl();
		if(location != -1)
			gl.glUniform4f(location, x, y, z, w);
	}

	public void setUniformValue(String name, float x, float y, float z, float w) {
		setUniformValue(uniformLocation(name), x, y, z, w);
	}
	
	public int getProgram() {
		return program;
	}
	
	public void release() {
		GL2 gl = GlTools.gl();
		gl.glDeleteProgram(program);
	}
	
}
