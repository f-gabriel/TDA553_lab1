package branch;
import java.awt.*;

abstract public class Car extends Vehicle{
    private final int nrDoors; // Number of doors on the car
    public String modelName;

    public Car(double enginePower, int nrDoors, Color color, String modelName, double x, double y, String direction) {
        super(enginePower, color, x, y, direction);
        this.nrDoors = nrDoors;
        this.modelName = modelName;
    }

    public int getNrDoors(){return nrDoors;}

    public void gas(double amount){incrementSpeed(amount);}
    public void brake(double amount){decrementSpeed(amount);}
}








