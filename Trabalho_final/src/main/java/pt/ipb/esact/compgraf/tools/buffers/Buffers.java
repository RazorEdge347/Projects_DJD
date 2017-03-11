package pt.ipb.esact.compgraf.tools.buffers;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public abstract class Buffers {

	public static FloatBuffer newFloatBuffer(float ... values) {
		return FloatBuffer.wrap(values);
	}
	
	public static IntBuffer newIntBuffer(int ... values) {
		return IntBuffer.wrap(values);
	}
	
}
