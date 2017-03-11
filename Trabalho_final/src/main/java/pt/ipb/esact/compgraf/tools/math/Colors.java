package pt.ipb.esact.compgraf.tools.math;

import javax.media.opengl.GLContext;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;

@SuppressWarnings("serial")
public class Colors extends Color4f {

    public static final class ColorWrapper extends Color4f {

        public ColorWrapper(float x, float y, float z) {
            super(x, y, z, 1);
        }

        public ColorWrapper(float x, float y, float z, float w) {
            super(x, y, z, w);
        }

        public Color3f toColor3f() {
            return new Color3f(x, y, z);
        }

        public void set() {
            GLContext.getCurrentGL().getGL2().glColor4f(x, y, z, w);
        }

    }

    public static final ColorWrapper RED = new ColorWrapper(1.0f, 0.0f, 0.0f);

    public static final ColorWrapper GREEN = new ColorWrapper(0.0f, 1.0f, 0.0f);

    public static final ColorWrapper BLUE = new ColorWrapper(0.0f, 0.0f, 1.0f);

    public static final ColorWrapper WHITE = new ColorWrapper(1.0f, 1.0f, 1.0f);

    public static final ColorWrapper GRAY = new ColorWrapper(0.5f, 0.5f, 0.5f);

    public static final ColorWrapper LIGHT_GRAY = new ColorWrapper(0.8f, 0.8f, 0.8f);

    public static final ColorWrapper DARKGRAY = new ColorWrapper(0.3f, 0.3f, 0.3f);

    public static final Color4f LOW_AMBIENT = new Color4f(0.1f, 0.1f, 0.1f, 1.0f);

    public static final Color4f MEDIUM_DIFFUSE = new Color4f(0.5f, 0.5f, 0.5f, 1.0f);

    public static final Color4f YELLOW = new Color4f(1f, 1f, 0, 1f);

    public static Color4f to4f(Color3f c) {
        return new Color4f(c.x, c.y, c.z, 1);
    }

    public static ColorWrapper color(float x, float y, float z, float w) {
        return new ColorWrapper(x, y, z, w);
    }

}
