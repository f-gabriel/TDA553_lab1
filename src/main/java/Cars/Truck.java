package Cars;

import java.awt.*;

public class Truck extends Car implements TruckBed {
    TruckBed truckBed = new TruckBedHelper(1);

    public Truck(double enginePower, Color color, String modelName, double x, double y, String direction) {
        super(enginePower, 2, color, modelName, x, y, direction);}

    // methods from Cars.TruckBed
    public void raise(){if (currentSpeed == 0) truckBed.raise();}
    public void lower(){if (currentSpeed == 0) truckBed.lower();}
    public int getBedState(){return truckBed.getBedState();}

    // methods from Cars.Car
    public void startEngine(){
        if (getBedState() == 1) super.startEngine();
    }
    public void gas(double amount) {if (getBedState() == 1) super.gas(amount);}
}
