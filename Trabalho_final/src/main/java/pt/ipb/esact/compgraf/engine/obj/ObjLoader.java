package pt.ipb.esact.compgraf.engine.obj;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.jogamp.opengl.util.gl2.GLUT;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.GlTools;
import pt.ipb.esact.compgraf.tools.ReleaseListener;
import pt.ipb.esact.compgraf.tools.math.Colors;
import pt.ipb.esact.compgraf.tools.math.GlMath;
import pt.ipb.esact.compgraf.tools.math.Vectors;

import javax.media.opengl.GL2;
import javax.vecmath.Vector3f;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.text.MessageFormat.format;

public class ObjLoader implements ReleaseListener {

	private static final int VERTS_DATA = 0;
	
	private static final int NORMS_DATA = 1;
	
	private static final int TEXES_DATA = 2;
	
	private static final int OBJ_BUFFER_COUNT = 3;
	
	private Multimap<String, Integer> triIndexes = ArrayListMultimap.create();
	
	private Map<String, Integer> triBufferObjects = Maps.newHashMap();
	
	private Multimap<String, Integer> quadIndexes = ArrayListMultimap.create();
	
	private Map<String, Integer> quadBufferObjects = Maps.newHashMap();
	
	private Map<String, ObjMaterial> material = Maps.newHashMap();
	
	private Map<String, String> objMaterial = Maps.newHashMap();
	
	private List<String> objNames = Lists.newArrayList();
	
	private Map<String, Boolean> shadeModel = Maps.newHashMap();
	
	private List<Vector3f> vertices = Lists.newArrayList();
	
	private List<Vector3f> normals = Lists.newArrayList();
	
	private List<Vector3f> texcoords = Lists.newArrayList();

	private IntBuffer vboIds = IntBuffer.allocate(OBJ_BUFFER_COUNT);
	
	private float scale = 1.0f;
	
	private boolean compress = false;
	
	private Vector3f bbMax = new Vector3f();
	
	private Vector3f bbMin = new Vector3f();

	private static final Pattern MAT_LINE_PATTERN = Pattern.compile("([^ ]*)[ ]+(.*)");
	
	private static final Pattern ro = Pattern.compile("^o[ ]+(.+)$");
	private static final Pattern rf = Pattern.compile("^f[ ]+(.+)$");
	private static final Pattern rv = Pattern.compile("^v[ ]+([\\-0-9.]+)[ ]+([\\-0-9.]+)[ ]+([\\-0-9.]+)");
	private static final Pattern rvt = Pattern.compile("^vt[ ]+([\\-0-9.]+)[ ]+([\\-0-9.]+)");
	private static final Pattern rvt3 = Pattern.compile("^vt[ ]+([\\-0-9.]+)[ ]+([\\-0-9.]+)[ ]+([\\-0-9.]+)");
	private static final Pattern rvn = Pattern.compile("^vn[ ]+([\\-0-9.]+)[ ]+([\\-0-9.]+)[ ]+([\\-0-9.]+)");
	private static final Pattern rs = Pattern.compile("^s[ ]+(off|\\d+)$");
	private static final Pattern rusemtl = Pattern.compile("^usemtl[ ]+(.+)$");
	
	public ObjLoader(DefaultGLWindow reference) {
        checkNotNull(reference);
        reference.addReleaseListener(this);
    }

    public void setScale(float scale) {
		this.scale = scale;
	}
	
	public void load(String model, String material) {
		// extract prefix from model
		String prefix = "";
		int last = model.lastIndexOf('/');
		if(last != -1)
			prefix = model.substring(0, last) + '/';
		
		try (BufferedReader modelStream = new BufferedReader(new FileReader(model))) {
            String line = null;
			List<String> modelLines = Lists.newArrayList();
			while((line = modelStream.readLine()) != null)
				modelLines.add(line);
			parseModel(modelLines, prefix);
		} catch (IOException e) {
			GlTools.exit(format("Error reading model from ''{0}'': {1}", model, e.getMessage()));
		}

		try(BufferedReader materialStream = new BufferedReader(new FileReader(material))) {
			String line = null;
			List<String> materialLines = Lists.newArrayList();
			while((line = materialStream.readLine()) != null)
				materialLines.add(line);
			parseMaterial(materialLines, prefix);
		} catch (IOException e) {
			GlTools.exit(format("Error reading material from ''{0}'': {1}", material, e.getMessage()));
		}
	
	}
	
	private void parseMaterial(List<String> lines, String prefix) {
		material.clear();
		
		String currentMtl = null;
		
		for(String line : lines) {
			Matcher m = MAT_LINE_PATTERN.matcher(line);
			if(!m.matches())
				continue;
			
			String prop = m.group(1);
			String value = m.group(2);
			List<String> values = Lists.newArrayList(value.split("[ ]+"));
			
			if("newmtl".equals(prop)) {
				currentMtl = m.group(2);
				material.put(currentMtl, new ObjMaterial(currentMtl));
			}
			
			if(Strings.isNullOrEmpty(currentMtl))
				continue;
			
			if("Ka".equals(prop)) {
				float r = GlMath.clamp(Float.parseFloat(values.get(0)), 0.0f, 1.0f);
				float g = GlMath.clamp(Float.parseFloat(values.get(1)), 0.0f, 1.0f);
				float b = GlMath.clamp(Float.parseFloat(values.get(2)), 0.0f, 1.0f);
				material.get(currentMtl).setKa(r, g, b);
			}

			if("Kd".equals(prop)) {
				float r = GlMath.clamp(Float.parseFloat(values.get(0)), 0.0f, 1.0f);
				float g = GlMath.clamp(Float.parseFloat(values.get(1)), 0.0f, 1.0f);
				float b = GlMath.clamp(Float.parseFloat(values.get(2)), 0.0f, 1.0f);
				material.get(currentMtl).setKd(r, g, b);
			}

			if("Ks".equals(prop)) {
				float r = GlMath.clamp(Float.parseFloat(values.get(0)), 0.0f, 1.0f);
				float g = GlMath.clamp(Float.parseFloat(values.get(1)), 0.0f, 1.0f);
				float b = GlMath.clamp(Float.parseFloat(values.get(2)), 0.0f, 1.0f);
				material.get(currentMtl).setKs(r, g, b);
			}
			
			if("Ke".equals(prop)) {
				float r = GlMath.clamp(Float.parseFloat(values.get(0)), 0.0f, 1.0f);
				float g = GlMath.clamp(Float.parseFloat(values.get(1)), 0.0f, 1.0f);
				float b = GlMath.clamp(Float.parseFloat(values.get(2)), 0.0f, 1.0f);
				material.get(currentMtl).setKe(r, g, b);
			}

			if("map_Kd".equals(prop)) {
				material.get(currentMtl).setMapKd(prefix, value);
			}

			if("map_Bump".equals(prop)) {
				material.get(currentMtl).setMapBump(prefix, value);
			}

			if("d".equals(prop)) {
				material.get(currentMtl).setD(Float.parseFloat(value));
			}
			
			if("Ns".equals(prop)) {
				material.get(currentMtl).setNs(Float.parseFloat(value));
			}
		}
	}

	private void parseModel(List<String> lines, String prefix) {
		vertices.clear();
		texcoords.clear();
		normals.clear();

		triIndexes.clear();
		quadIndexes.clear();

		triBufferObjects.clear();
		quadBufferObjects.clear();

		objNames.clear();

		shadeModel.clear();
		
		GL2 gl = GlTools.gl();
		
		List<Vector3f> verts = Lists.newArrayList();
		List<Vector3f> norms = Lists.newArrayList();
		List<Vector3f> texes = Lists.newArrayList();
		
		gl.glGenBuffers(OBJ_BUFFER_COUNT, vboIds);
		
		String oname = "root";
		for(String line : lines) {
			Matcher m;
			
			m = ro.matcher(line);
			if(m.matches()) {
				oname = m.group(1);
				addObject(oname);
			}
			
			m = rv.matcher(line);
			if(m.matches()) {
				verts.add(new Vector3f(
					Float.parseFloat(m.group(1)) * scale,
					Float.parseFloat(m.group(2)) * scale,
					Float.parseFloat(m.group(3)) * scale
				));
			}
			
			m = rvt.matcher(line);
			if(m.matches()) {
				texes.add(new Vector3f(
					Float.parseFloat(m.group(1)),
					Float.parseFloat(m.group(2)),
					0.0f
				));
			}
			
			m = rvt3.matcher(line);
			if(m.matches()) {
				texes.add(new Vector3f(
					Float.parseFloat(m.group(1)),
					Float.parseFloat(m.group(2)),
					0.0f
				));
			}
			
			m = rvn.matcher(line);
			if(m.matches()) {
				norms.add(new Vector3f(
					Float.parseFloat(m.group(1)),
					Float.parseFloat(m.group(2)),
					Float.parseFloat(m.group(3))
				));
			}
			
			m = rs.matcher(line);
			if(m.matches()) {
				boolean smooth = false;
				try {
					smooth = Integer.parseInt(m.group(1)) == 1;
				} catch(NumberFormatException e) {
					smooth = "on".equals(m.group(1));
				}
				shadeModel.put(oname, smooth);
			}
			
			m = rusemtl.matcher(line);
			if(m.matches())
				objMaterial.put(oname, m.group(1));
			
			m = rf.matcher(line);
			if(m.matches()) {
				List<String> tokens = Lists.newArrayList(Splitter.onPattern("[ ]+").split(m.group(1)));
				int vertexCount = tokens.size();

				Vector3f fVerts[] = new Vector3f[vertexCount];
				Vector3f fNorms[] = new Vector3f[vertexCount];
				Vector3f fTexes[] = new Vector3f[vertexCount];
				
				for(int f=0; f<tokens.size(); f++) {
					List<String> ns = Lists.newArrayList(Splitter.onPattern("/").split(tokens.get(f)));
				
					try {
						int vx = Integer.parseInt(ns.get(0));
						fVerts[f] = verts.get(vx-1);
					} catch (NumberFormatException|IndexOutOfBoundsException e) {
						fVerts[f] = new Vector3f();
					}
					
					try {
						int tx = Integer.parseInt(ns.get(1));
						fTexes[f] = texes.get(tx-1);
					} catch (NumberFormatException|IndexOutOfBoundsException e) {
						fTexes[f] = new Vector3f();
					}
					
					try {
						int nx = Integer.parseInt(ns.get(2));
						fNorms[f] = norms.get(nx-1);
					} catch (NumberFormatException|IndexOutOfBoundsException e) {
						fNorms[f] = new Vector3f();
					}
					
				}
				
				addFace(fVerts, fNorms, fTexes, vertexCount, oname);
			}
		}
		
		if(objNames.isEmpty())
			addObject("root");
		
		FloatBuffer vertsPtr = vertsPointer();
		FloatBuffer normsPtr = normsPointer();
		FloatBuffer texesPtr = texesPointer();
		
		final int FLOAT_SIZE = Float.SIZE / 8;
		final int INT_SIZE = Integer.SIZE / 8;
		
		// Generate the Buffers
		// Vertex Data
		gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, vboIds.get(VERTS_DATA));
		gl.glBufferData(GL2.GL_ARRAY_BUFFER, FLOAT_SIZE * vertices.size() * 3, vertsPtr, GL2.GL_STATIC_DRAW);

		// Texture coordinates
		gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, vboIds.get(TEXES_DATA));
		gl.glBufferData(GL2.GL_ARRAY_BUFFER, FLOAT_SIZE * texcoords.size() * 2, texesPtr, GL2.GL_STATIC_DRAW);

		// Normal data
		gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, vboIds.get(NORMS_DATA));
		gl.glBufferData(GL2.GL_ARRAY_BUFFER, FLOAT_SIZE * normals.size() * 3, normsPtr, GL2.GL_STATIC_DRAW);

		// Triangle Indexes
		for(String o : triBufferObjects.keySet()) {
			int b = triBufferObjects.get(o);
			gl.glBindBuffer(GL2.GL_ELEMENT_ARRAY_BUFFER, b);
			Collection<Integer> idxList = triIndexes.get(o);
			int i=0;
			int[] buffer = new int[idxList.size()];
			for(int idx : idxList)
				buffer[i++] = idx;
			gl.glBufferData(GL2.GL_ELEMENT_ARRAY_BUFFER, INT_SIZE * triIndexes.get(o).size(), IntBuffer.wrap(buffer), GL2.GL_STATIC_DRAW);
		}

		// Quad Indexes
		for(String o : quadBufferObjects.keySet()) {
			int b = quadBufferObjects.get(o);
			gl.glBindBuffer(GL2.GL_ELEMENT_ARRAY_BUFFER, b);
			Collection<Integer> idxList = quadIndexes.get(o);
			int[] buffer = new int[idxList.size()];
			int i=0;
			for(int idx : idxList)
				buffer[i++] = idx;
			gl.glBufferData(GL2.GL_ELEMENT_ARRAY_BUFFER, INT_SIZE * quadIndexes.get(o).size(), IntBuffer.wrap(buffer), GL2.GL_STATIC_DRAW);
		}
	}

	private FloatBuffer vertsPointer() {
		float[] buffer = new float[vertices.size() * 3];
		for(int i=0; i<vertices.size(); i++) {
			Vector3f v = vertices.get(i);
			buffer[3 * i + 0] = v.x;
			buffer[3 * i + 1] = v.y;
			buffer[3 * i + 2] = v.z;
		}
		return FloatBuffer.wrap(buffer);
	}

	private FloatBuffer normsPointer() {
		float[] buffer = new float[normals.size() * 3];
		for(int i=0; i<normals.size(); i++) {
			Vector3f v = normals.get(i);
			buffer[3 * i + 0] = v.x;
			buffer[3 * i + 1] = v.y;
			buffer[3 * i + 2] = v.z;
		}
		return FloatBuffer.wrap(buffer);
	}
	
	private FloatBuffer texesPointer() {
		float[] buffer = new float[texcoords.size() * 2];
		for(int i=0; i<texcoords.size(); i++) {
			Vector3f v = texcoords.get(i);
			buffer[2 * i + 0] = v.x;
			buffer[2 * i + 1] = v.y;
		}
		return FloatBuffer.wrap(buffer);
	}

	private void addFace(Vector3f[] verts, Vector3f[] norms, Vector3f[] texes, int count, String o) {
		if(count < 3 || count > 4)
			return;

		for(int i=0; i<count; i++)
			norms[i].normalize();

		final float e = 0.00001f;

		for(int i=0; i<count; i++) {
			Vector3f v = verts[i];
			Vector3f t = texes[i];
			Vector3f n = norms[i];

			int matchIdx = 0;
			if(compress) {
				for(matchIdx = 0; matchIdx < vertices.size(); matchIdx++) {
					if(
						Vectors.sub(v, vertices.get(matchIdx)).lengthSquared() <= e &&
						Vectors.sub(n, normals.get(matchIdx)).lengthSquared() <= e &&
						Vectors.sub(t, texcoords.get(matchIdx)).lengthSquared() <= e
					) { // there's a match
						boolean match = false;
						if(count == 3) { triIndexes.get(o).add(matchIdx); match=true; }
						if(count == 4) { quadIndexes.get(o).add(matchIdx); match=true; }
						if(match)
							break;
					}
				}
			}

			// No match
			if(matchIdx == vertices.size() || !compress) {
				if(count == 3) triIndexes.get(o).add(vertices.size());
				if(count == 4) quadIndexes.get(o).add(vertices.size());
				
				vertices.add(v);
				normals.add(n);
				texcoords.add(t);

				if(v.x > bbMax.x) bbMax.x = v.x;
				if(v.x < bbMin.x) bbMin.x = v.x;

				if(v.y > bbMax.y) bbMax.y = v.y;
				if(v.y < bbMin.y) bbMin.y = v.y;

				if(v.z > bbMax.z) bbMax.z = v.z;
				if(v.z < bbMin.z) bbMin.z = v.z;
			}
		}
	}

	private void addObject(String oname) {
		objNames.add(oname);
		
		GL2 gl = GlTools.gl();
		
		IntBuffer buffer = IntBuffer.allocate(1);
		
		// Buffer for triangle indexes
		gl.glGenBuffers(1, buffer);
		triBufferObjects.put(oname, buffer.get(0));
		
		// Buffer for quad indexes
		gl.glGenBuffers(1, buffer);
		quadBufferObjects.put(oname, buffer.get(0));
	}
	
	public void release() {
		GL2 gl = GlTools.gl();
		release(gl);
	}
	
	public void render() {
		render(false);
	}
	
	public void render(boolean mesh) {
		GL2 gl = GlTools.gl();
		
		gl.glPushAttrib(GL2.GL_LIGHTING_BIT | GL2.GL_ENABLE_BIT | GL2.GL_CURRENT_BIT | GL2.GL_TEXTURE_BIT);

			gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
			gl.glEnableClientState(GL2.GL_NORMAL_ARRAY);
			if(!mesh)
				gl.glEnableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
	
			gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, vboIds.get(VERTS_DATA));
			gl.glVertexPointer(3, GL2.GL_FLOAT, 0, 0);
	
			gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, vboIds.get(NORMS_DATA));
			gl.glNormalPointer(GL2.GL_FLOAT, 0, 0);
	
			if(!mesh) {
				gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, vboIds.get(TEXES_DATA));
				gl.glTexCoordPointer(2, GL2.GL_FLOAT, 0, 0);
			}
	
			for(String o : objNames) {
				if(!mesh) {
					String mat = objMaterial.get(o);
					if(material.containsKey(mat)) {
						ObjMaterial m = material.get(mat);
						m.set();
					}
					gl.glShadeModel(shadeModel.get(o) ? GL2.GL_SMOOTH : GL2.GL_FLAT);
				} else {
					Colors.WHITE.set();
				}
	
				// Triangle Indexes
				if(triBufferObjects.containsKey(o)) {
					int b = triBufferObjects.get(o);
					gl.glBindBuffer(GL2.GL_ELEMENT_ARRAY_BUFFER, b);
					gl.glDrawElements(!mesh ? GL2.GL_TRIANGLES : GL2.GL_LINES, triIndexes.get(o).size(), GL2.GL_UNSIGNED_INT, 0);
				}
	
				// Quads Indexes
				if(quadBufferObjects.containsKey(o)) {
					int b = quadBufferObjects.get(o);
					gl.glBindBuffer(GL2.GL_ELEMENT_ARRAY_BUFFER, b);
					gl.glDrawElements(!mesh ? GL2.GL_QUADS : GL2.GL_LINES, quadIndexes.get(o).size(), GL2.GL_UNSIGNED_INT, 0);
				}
	
			}
	
			gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, 0);
			gl.glBindBuffer(GL2.GL_ELEMENT_ARRAY_BUFFER, 0);
	
			gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
			gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
			if(!mesh)
				gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);

		gl.glPopAttrib();
	}
	
	public void drawBoundingBox() {
		GL2 gl = GlTools.gl();
		GLUT glut = GlTools.glut();
		
		float xSize = bbMax.x - bbMin.x;
		float ySize = bbMax.y - bbMin.y;
		float zSize = bbMax.z - bbMin.z;
		Vector3f center = new Vector3f(bbMin.x + xSize / 2.0f, bbMin.y + ySize / 2.0f, bbMin.z + zSize / 2.0f);
		gl.glPushAttrib(GL2.GL_CURRENT_BIT | GL2.GL_ENABLE_BIT);
			gl.glDisable(GL2.GL_TEXTURE_2D);
			gl.glDisable(GL2.GL_DEPTH_TEST);
			gl.glDisable(GL2.GL_LIGHTING);
			gl.glDisable(GL2.GL_BLEND);
			Colors.GREEN.set();
			gl.glPushMatrix();
				gl.glTranslatef(center.x, center.y, center.z);
				gl.glScalef(xSize, ySize, zSize);
				glut.glutWireCube(1.0f);
			gl.glPopMatrix();
			gl.glPopAttrib();
	}
	private Vector3f centercoords;
	public Vector3f getobjCenter(){
		float xSize = bbMax.x - bbMin.x;
		float ySize = bbMax.y - bbMin.y;
		float zSize = bbMax.z - bbMin.z;

		centercoords = new Vector3f(bbMin.x + xSize / 2.0f, bbMin.y + ySize / 2.0f, bbMin.z + zSize / 2.0f);
		return centercoords;
	}

	@Override
	public void release(GL2 gl) {
		if(gl == null)
			return;
		
		gl.glDeleteBuffers(OBJ_BUFFER_COUNT, vboIds);

		for(int id : triBufferObjects.values())
			gl.glDeleteBuffers(1, new int[] { id }, 0);

		for(int id : quadBufferObjects.values())
			gl.glDeleteBuffers(1, new int[] { id }, 0);
		
		// Release material stuff
		for(ObjMaterial mat : material.values())
			mat.release(gl);
	}
	
}
