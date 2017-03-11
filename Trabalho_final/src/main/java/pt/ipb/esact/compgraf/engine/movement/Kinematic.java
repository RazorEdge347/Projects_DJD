package pt.ipb.esact.compgraf.engine.movement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.GlTools;
import pt.ipb.esact.compgraf.tools.math.GlMath;
import pt.ipb.esact.compgraf.tools.math.Vectors;

import javax.vecmath.Vector3f;

public class Kinematic {

    private static final Logger logger = LoggerFactory.getLogger(Kinematic.class);

    private float maxLinearSpeed = 3.0f;

    private float maxAngularSpeed = 10.0f;

    private Vector3f position = Vectors.zero();

    private Vector3f forward = Vectors.forward();

    private float orientation = 0.0f;

    private boolean moveForward = false;

    private boolean moveBackward = false;

    private boolean strafeLeft = false;

    private boolean strafeRight = false;

    private boolean rotateLeft = false;

    private boolean rotateRight = false;

    private String backwardKey;

    private String forwardKey;

    private String strafeLeftKey;

    private String strafeRightKey;

    private String rotateLeftKey;

    private String rotateRightKey;

    public Vector3f getPosition() {
        return position;
    }

    public float getMaxLinearSpeed() {
        return maxLinearSpeed;
    }

    public void setMaxLinearSpeed(float maxLinearSpeed) {
        this.maxLinearSpeed = maxLinearSpeed;
    }

    public float getMaxAngularSpeed() {
        return maxAngularSpeed;
    }

    public void setMaxAngularSpeed(float maxAngularSpeed) {
        this.maxAngularSpeed = maxAngularSpeed;
    }

    public Vector3f getForward() {
        return forward;
    }

    public void transform() {
        GlTools.gl().glTranslatef(position.x, position.y, position.z);
        GlTools.gl().glRotatef(orientation, 0, 1, 0);
    }

    public boolean update(float timeElapsed) {
        boolean needsUpdate = false;
        if (rotateLeft) {
            orientation += maxAngularSpeed * timeElapsed;
            forward = GlMath.rotate(orientation, Vectors.up(), Vectors.forward());
            needsUpdate = true;
        }

        if (rotateRight) {
            orientation -= maxAngularSpeed * timeElapsed;
            forward = GlMath.rotate(orientation, Vectors.up(), Vectors.forward());
            needsUpdate = true;
        }

        Vector3f velocity = new Vector3f();

        if (moveForward || moveBackward)
            velocity.add(forward);

        if (moveBackward)
            velocity.negate();

        if (strafeLeft)
            velocity.add(GlMath.rotate(90.0f, Vectors.up(), forward));

        if (strafeRight)
            velocity.add(GlMath.rotate(-90.0f, Vectors.up(), forward));

        velocity.scale(maxLinearSpeed * timeElapsed);

        position.add(velocity);

        return velocity.lengthSquared() > 0 || needsUpdate;
    }


    public void handleInput(DefaultGLWindow context) {
        if (forwardKey != null)
            moveForward = context.isKeyPressed(forwardKey.charAt(0));
        if (backwardKey != null)
            moveBackward = context.isKeyPressed(backwardKey.charAt(0));
        if (strafeLeftKey != null)
            strafeLeft = context.isKeyPressed(strafeLeftKey.charAt(0));
        if (strafeRightKey != null)
            strafeRight = context.isKeyPressed(strafeRightKey.charAt(0));
        if (rotateLeftKey != null)
            rotateLeft = context.isKeyPressed(rotateLeftKey);
        if (rotateRightKey != null)
            rotateRight = context.isKeyPressed(rotateRightKey);
    }

    public void setPosition(float x, float y, float z) {
        this.position = new Vector3f(x, y, z);
    }

    public void setBackwardKey(String backwardKey) {
        this.backwardKey = backwardKey;
    }

    public void setForwardKey(String forwardKey) {
        this.forwardKey = forwardKey;
    }

    public void setStrafeLeftKey(String strafeLeftKey) {
        this.strafeLeftKey = strafeLeftKey;
    }

    public void setStrafeRightKey(String strafeRightKey) {
        this.strafeRightKey = strafeRightKey;
    }

    public void setRotateLeftKey(String rotateLeftKey) {
        this.rotateLeftKey = rotateLeftKey;
    }

    public void setRotateRightKey(String rotateRightKey) {
        this.rotateRightKey = rotateRightKey;
    }
}
