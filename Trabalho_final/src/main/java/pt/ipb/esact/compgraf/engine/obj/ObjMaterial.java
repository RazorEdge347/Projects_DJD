package pt.ipb.esact.compgraf.engine.obj;

import java.nio.FloatBuffer;
import java.util.Set;

import javax.media.opengl.GL2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.ipb.esact.compgraf.tools.GlTools;
import pt.ipb.esact.compgraf.tools.ReleaseListener;
import pt.ipb.esact.compgraf.tools.Shader;
import pt.ipb.esact.compgraf.tools.math.GlMath;

import com.google.common.collect.Sets;
import com.jogamp.opengl.util.texture.Texture;


public class ObjMaterial implements ReleaseListener {

    private static final Logger logger = LoggerFactory.getLogger(ObjMaterial.class);

	private String name;

	private Set<Integer> textureIds = Sets.newHashSet();
	
	FloatBuffer ka = FloatBuffer.allocate(4);
	FloatBuffer kd = FloatBuffer.allocate(4);
	FloatBuffer ke = FloatBuffer.allocate(4);
	FloatBuffer ks = FloatBuffer.allocate(4);

	private boolean kaset;

	private boolean ksset;

	private boolean kdset;

    private boolean keset;

	private boolean nsset;

	private boolean dset;

	private float ns;

	private float d;

	private boolean mkdset;
	
	private boolean mbumpset;
	
	private Texture textBump;
	
	private Texture texDiffuse;
    private String diffuseName;

    public ObjMaterial(String name) {
		this.name = name;
	}
	
	public void setKa(float r, float g, float b) {
		kaset = true;
		ka = FloatBuffer.wrap(new float[] {r, g, b, 1.0f});
	}

	public void setKd(float r, float g, float b) {
		kdset = true;
		kd = FloatBuffer.wrap(new float[] {r, g, b, 1.0f});
	}

	public void setKs(float r, float g, float b) {
		ksset = true;
		ks = FloatBuffer.wrap(new float[] {r, g, b, 1.0f});
	}

	public void setKe(float r, float g, float b) {
		keset = true;
		ke = FloatBuffer.wrap(new float[] {r, g, b, 1.0f});
	}

	public void setMapKd(String prefix, String value) {
		mkdset = true;
		diffuseName = findPath(value);
		texDiffuse = GlTools.loadTexture(prefix + diffuseName);
	}

	private String findPath(String value) {
		if(value == null)
			return null;
		value = value.replace("\\\\", "\\");
		int last = value.lastIndexOf('/');
		if(last == -1)
			last = value.lastIndexOf('\\');
		if(last == -1)
			return value;
		return value.substring(last + 1);
	}

	public void setMapBump(String prefix, String value) {
		mbumpset = true;
		String name = findPath(value);
		textBump = GlTools.loadTexture(prefix + name);
	}

	public void setD(float value) {
		dset = true;
		d = GlMath.clamp(value, 0.0f, 1.0f);
	}

	public void setNs(float value) {
		nsset = true;
		ns = GlMath.clamp(value, 0.0f, 1.0f);
	}

	public String debugBuffer(String name, FloatBuffer buffer) {
		StringBuilder s = new StringBuilder();
		s.append(name).append("(");
		for(int i=0; i<buffer.capacity(); i++) {
			if(i>0)
				s.append(", ");
			s.append(buffer.get(i));
		}
		s.append(")");
		return s.toString();
	}
	
	public void set() {
		GL2 gl = GlTools.gl();
		
		if(kdset) {
			if(dset && d < 1.0f && !(mkdset || mbumpset))
				kd.put(3, d);
			gl.glColor4fv(kd);
		}
		
		if(kaset)
			gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_AMBIENT, ka);
		if(kdset)
			gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_DIFFUSE, kd);
		if(ksset)
			gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, ks);
		if(nsset)
			gl.glMaterialf(GL2.GL_FRONT, GL2.GL_SHININESS, ns);
        if(keset)
            gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_EMISSION, ke);

        if(dset && d < 1.0f) {
            enableBlend(gl);
		}

		if(mkdset || mbumpset) {
			gl.glEnable(GL2.GL_TEXTURE_2D);
		}

		if(mbumpset) {
			gl.glActiveTexture(Shader.NORMAL_MAP_INDEX);
			textBump.bind(gl);
		}

		if(mkdset) {
			gl.glActiveTexture(Shader.DIFFUSE_MAP_INDEX);
			texDiffuse.bind(gl);
            if(diffuseName.toLowerCase().endsWith("png")) {
                enableBlend(gl);
            }
		}

		if(!mkdset && !mbumpset)
			gl.glDisable(GL2.GL_TEXTURE_2D);
	}

    private void enableBlend(GL2 gl) {
        gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
    }

    @Override
	public String toString() {
		return "ObjMaterial [name=" + name + ", textureIds=" + textureIds + ", ka=" + ka + ", kd=" + kd + ", ks=" + ks + ", kaset=" + kaset + ", ksset=" + ksset + ", kdset=" + kdset + ", nsset=" + nsset + ", dset=" + dset + ", ns=" + ns + ", d=" + d + ", mkdset=" + mkdset + ", mbumpset=" + mbumpset + ", textBump=" + textBump + ", texDiffuse=" + texDiffuse + "]";
	}

	@Override
	public void release(GL2 gl) {
		if(texDiffuse != null)
			texDiffuse.destroy(gl);
		if(textBump != null)
			textBump.destroy(gl);
	}
	
	
	
}
