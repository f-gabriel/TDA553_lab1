import java.awt.*;

abstract public class Car extends Engine{
    private final int nrDoors; // Number of doors on the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName;

    public Car(
            double enginePower,
            int nrDoors,
            Color color,
            String modelName
    ) {
        super(enginePower);
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }

    public void incrementSpeed(double amount){}
    public void decrementSpeed(double amount){}

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }
    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
