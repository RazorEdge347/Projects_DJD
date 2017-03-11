package pt.ipb.esact.compgraf.engine.movement;

import javax.vecmath.Vector3f;

public abstract class TargetedSteering extends Steering {

    private Vector3f target;

    public TargetedSteering() {
    }

    public TargetedSteering(Vector3f target) {
        this.target = target;
    }

    public Vector3f getTarget() {
        return target;
    }

    public void setTarget(Vector3f target) {
        this.target = target;
    }

}
