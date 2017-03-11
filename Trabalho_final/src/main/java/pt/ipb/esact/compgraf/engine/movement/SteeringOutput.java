package pt.ipb.esact.compgraf.engine.movement;

import pt.ipb.esact.compgraf.tools.math.Vectors;

import javax.vecmath.Vector3f;

public class SteeringOutput {

    private Vector3f linear = new Vector3f();

    private float angular = 0.0f;

    public SteeringOutput() {
    }

    public SteeringOutput(Vector3f linear, float angular) {
        this.linear = linear;
        this.angular = angular;
    }

    public void setLinear(Vector3f linear) {
        this.linear = linear;
    }

    public void setAngular(float angular) {
        this.angular = angular;
    }

    public Vector3f getLinear() {
        return linear;
    }

    public float getAngular() {
        return angular;
    }

    public SteeringOutput mul(float scalar) {
        Vector3f newLinear = new Vector3f(linear);
        Vectors.mult(newLinear, scalar);
        return new SteeringOutput(newLinear, angular * scalar);
    }

    public SteeringOutput add(float scalar) {
        Vector3f newLinear = new Vector3f(linear);
        newLinear.x += scalar;
        newLinear.y += scalar;
        newLinear.z += scalar;
        return new SteeringOutput(newLinear, angular + scalar);
    }

}
