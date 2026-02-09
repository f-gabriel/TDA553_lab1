import java.awt.*;

public class Truck extends Car implements TruckBed {
    TruckBed parent = new TruckBedHelper();

    public Truck(double enginePower, Color color, String modelName, double x, double y, String direction) {
        super(enginePower, 2, color, modelName, x, y, direction);}

    // methods from TruckBed
    public void raise(){if (currentSpeed == 0) parent.raise();}
    public void lower(){if (currentSpeed == 0) parent.lower();}
    public int getBedState(){return parent.getBedState();}

    // methods from Car
    public void startEngine(){
        if (getBedState() == 0) super.startEngine();
    }
    public void gas(double amount) {if (getBedState() == 0) super.gas(amount);}
}
