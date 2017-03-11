package pt.ipb.esact.compgraf.engine.movement;

import pt.ipb.esact.compgraf.tools.math.Vectors;

public class Seek extends TargetedSteering {

    @Override
    SteeringOutput getSteering() {
        SteeringOutput output = new SteeringOutput();

        if (getTarget() != null) {
            output.setLinear(Vectors.sub(getTarget(), getPosition()));
            if (output.getLinear().lengthSquared() > 0) {
                output.getLinear().normalize();
                output.getLinear().scale(getMaxAcceleration());
            }
        }

        output.setAngular(0);

        return output;
    }

}
