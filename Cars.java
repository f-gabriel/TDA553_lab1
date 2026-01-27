import java.awt.*;

public interface Cars {
    public int nrDoors(); // Number of doors on the car
    public double enginePower(); // Engine power of the car
    public double currentSpeed(); // The current speed of the car
    public Color color(); // Color of the car
    public String modelName();


    public int getNrDoors();
    public double getEnginePower();
    public double getCurrentSpeed();
    public Color getColor();
    public void setColor(Color clr);
    public void startEngine();
    public void stopEngine();
    public double speedFactor();
    public void incrementSpeed();
    public void decrementSpeed();
    public void gas();
    public void brake();



}
