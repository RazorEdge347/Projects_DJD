package pt.ipb.esact.compgraf.engine.light;

import pt.ipb.esact.compgraf.tools.GlTools;
import pt.ipb.esact.compgraf.tools.buffers.Buffers;
import pt.ipb.esact.compgraf.tools.math.Colors;
import pt.ipb.esact.compgraf.tools.math.Vectors;

import javax.media.opengl.GL2;
import javax.vecmath.Color4f;
import javax.vecmath.Vector3f;

public class Light {

    private Color4f ambient;

    private Color4f diffuse;

    private Color4f specular;

    private Vector3f position;

    private Vector3f spotDirection;

    private int id;

    private GL2 gl;

    private float spotCutoff;

    private float spotExponent;

    private boolean directional = false;

    public Light(int id) {
        this.id = id;
        this.gl = GlTools.gl();
        setAmbient(Colors.LOW_AMBIENT);
        setDiffuse(Colors.MEDIUM_DIFFUSE);
        setSpecular(Colors.WHITE);
        setPosition(Vectors.origin()); // if w=0 light is directional
        setDirectional(false);
        setSpotDirection(new Vector3f(0, 0, -1f));
        setSpotCutoff(0);
        setSpotExponent(0);
        gl.glEnable(id);
    }

    public void setDirectional(boolean directional) {
        this.directional = directional;
    }

    public void setEnabled(boolean enabled) {
        if (enabled)
            gl.glEnable(id);
        else
            gl.glDisable(id);
    }

    public void setSpotCutoff(float spotCutoff) {
        this.spotCutoff = spotCutoff;
    }

    public void setSpotExponent(float spotExponent) {
        this.spotExponent = spotExponent;
    }

    public void setSpotDirection(Vector3f spotDirection) {
        this.spotDirection = spotDirection;
    }

    public void setAmbient(Color4f ambient) {
        this.ambient = ambient;
    }

    public void setDiffuse(Color4f diffuse) {
        this.diffuse = diffuse;
    }

    public void setSpecular(Color4f specular) {
        this.specular = specular;
    }

    public void setPosition(float x, float y, float z) {
        setPosition(new Vector3f(x, y, z));
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public void setup() {
        if (spotCutoff > 0)
            gl.glLightf(id, GL2.GL_SPOT_CUTOFF, spotCutoff);
        if (spotExponent > 0)
            gl.glLightf(id, GL2.GL_SPOT_EXPONENT, spotExponent);
        if (ambient != null)
            gl.glLightfv(id, GL2.GL_AMBIENT, Buffers.newFloatBuffer(ambient.x, ambient.y, ambient.z, ambient.w));
        if (diffuse != null)
            gl.glLightfv(id, GL2.GL_DIFFUSE, Buffers.newFloatBuffer(diffuse.x, diffuse.y, diffuse.z, diffuse.w));
        if (specular != null)
            gl.glLightfv(id, GL2.GL_SPECULAR, Buffers.newFloatBuffer(specular.x, specular.y, specular.z, specular.w));
    }

    public void position() {
        if (position != null)
            gl.glLightfv(id, GL2.GL_POSITION, Buffers.newFloatBuffer(position.x, position.y, position.z, directional ? 0 : 1));
        if (spotDirection != null)
            gl.glLightfv(id, GL2.GL_SPOT_DIRECTION, Buffers.newFloatBuffer(spotDirection.x, spotDirection.y, spotDirection.z));
    }


    public void setAmbient(float r, float g, float b) {
        setAmbient(new Color4f(r, g, b, 1));
    }

    public void setDiffuse(float r, float g, float b) {
        setDiffuse(new Color4f(r, g, b, 1));
    }

    public void setSpecular(float r, float g, float b) {
        setSpecular(new Color4f(r, g, b, 1));
    }
}
