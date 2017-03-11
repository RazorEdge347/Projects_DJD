package pt.ipb.esact.compgraf.tools;

import java.util.List;

import com.google.common.collect.Lists;

public abstract class Cameras {

	public static final List<Camera> cameras = Lists.newArrayList();
	
	private static Camera current = null;
	
	public static Camera addDefaultCamera() {
		Camera camera = new Camera();
		addCamera(camera);
		return camera;
	}
	
	public static void addCamera(Camera camera) {
		cameras.add(camera);
		if(cameras.size() == 1)
			setCurrent(camera);
	}

	public static void setCurrent(Camera camera) {
		current = camera;
	}
	
	public static Camera getCurrent() {
		return current;
	}
	
}
