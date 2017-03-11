package pt.ipb.esact.compgraf.engine.movement;

import javax.vecmath.Vector3f;

public abstract class Steering {

    private Vector3f position = new Vector3f();

    private float maxSpeed = 10.0f;

    private float maxAcceleration = 10.0f;

    abstract SteeringOutput getSteering();

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getMaxAcceleration() {
        return maxAcceleration;
    }

    public void setMaxAcceleration(float maxAcceleration) {
        this.maxAcceleration = maxAcceleration;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }
}
