import java.awt.*;

abstract public class Car extends Engine implements Movable{
    private final int nrDoors; // Number of doors on the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName;
    public Point currentPosition; // är just nu int, kanske borde vara double
    public enum Directions {NORTH, WEST, SOUTH, EAST}
    Directions currentDirection;

    public Car(double enginePower, int nrDoors, Color color, String modelName) {
        super(enginePower);
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;

        // pos och dir går här

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
    public double speedFactor(){
        return 0;
    }
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);}

    /* För att förtydliga. Switch tar ett värde (i detta fall vår riktning)
             switch(currentDirection)
       Därefter kollar den om värdet i "case" == värdet i switch.
            ex) switch (currentDirection), case NORTH kollar om currentDirection == NORTH
       I så fall utför den den följande instruktionen.

       I move() adderar eller subtraherar den vår hastighet (currentSpeed)
       till x- eller -y koordinaten beroende på dess riktning.
    */
    public void move() {
        switch (currentDirection) {
            case NORTH:
                currentPosition.y += currentSpeed;
                break;
            case WEST:
                currentPosition.x -= currentSpeed;
                break;
            case SOUTH:
                currentPosition.y -= currentSpeed;
                break;
            case EAST: // Skulle kunna skrivas som default istället
                currentPosition.x += currentSpeed;
                break;
        }
    }
    public void turnLeft(){
        switch (currentDirection){
            case NORTH:
                currentDirection = Directions.WEST;
                break;
            case WEST:
                currentDirection = Directions.SOUTH;
                break;
            case SOUTH:
                currentDirection = Directions.EAST;
                break;
            case EAST: // Skulle kunna skrivas som default istället
                currentDirection = Directions.NORTH;
                break;
        }
    };
    public void turnRight(){
        switch (currentDirection){
            case NORTH:
                currentDirection = Directions.EAST;
                break;
            case EAST:
                currentDirection = Directions.SOUTH;
                break;
            case SOUTH:
                currentDirection = Directions.WEST;
                break;
            case WEST: // Skulle kunna skrivas som default istället
                currentDirection = Directions.NORTH;
                break;
        }
    };

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }
    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
