package Cars;

import java.awt.*;

abstract public class PersonalVehicle extends Car {
    public PersonalVehicle(PersonalVehicle pv){
        super(pv);
    }

    public PersonalVehicle(double enginePower, int nrDoors, Color color, String modelName, double x, double y, String direction) {
        super(enginePower, nrDoors, color, modelName, x, y, direction);
    }
}
