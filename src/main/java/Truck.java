import java.awt.*;

public class Truck extends Car implements TruckBed {
    TruckBed parent; = new TruckBedHelper();



    public Truck(double enginePower, int nrDoors, Color color, String modelName, double x, double y, String direction, TruckbedHelper parent) {
        super(enginePower, nrDoors, color, modelName, x, y, direction);
        this.parent = parent;
    }
    void raise(){parent.raise();}
    void lower(){parent.raise();}
    boolean getBedState(){parent.getBedState();}
}
