package branch;

import java.awt.*;
import java.util.*;

abstract public class Vehicle extends Engine implements Movable {
    public double currentSpeed; // The current speed of the car
    public Color color;
    public Orientation orientation;

    public Vehicle(double enginePower, Color color, double x, double y, String direction){
        super(enginePower);
        this.color = color;
        this.orientation = new Orientation(x, y, direction);
        stopEngine();
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

    public void startEngine(){currentSpeed = 0.1;}
    public void stopEngine(){currentSpeed = 0;}

    public double speedFactor(){return 0;}
    public void incrementSpeed(double amount){currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);}
    public void decrementSpeed(double amount){currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);}

    public void move() {
        switch (orientation.currentDirection) {
            case NORTH:
                orientation.addToCoordinate('y', currentSpeed);
                break;
            case WEST:
                orientation.addToCoordinate('x', -currentSpeed);
                break;
            case SOUTH:
                orientation.addToCoordinate('y', -currentSpeed);
                break;
            case EAST: // Skulle kunna skrivas som default istället
                orientation.addToCoordinate('x', currentSpeed);
                break;
        }
    }
    public void turnLeft(){
        switch (orientation.getCurrentDirection()){
            case NORTH:
                orientation.setCurrentDirection(Orientation.Directions.WEST);
                break;
            case WEST:
                orientation.setCurrentDirection(Orientation.Directions.SOUTH);
                break;
            case SOUTH:
                orientation.setCurrentDirection(Orientation.Directions.EAST);
                break;
            case EAST: // Skulle kunna skrivas som default istället
                orientation.setCurrentDirection(Orientation.Directions.NORTH);
                break;
        }
    };
    public void turnRight(){
        switch (orientation.getCurrentDirection()){
            case NORTH:
                orientation.setCurrentDirection(Orientation.Directions.EAST);
                break;
            case EAST:
                orientation.setCurrentDirection(Orientation.Directions.SOUTH);
                break;
            case SOUTH:
                orientation.setCurrentDirection(Orientation.Directions.WEST);
                break;
            case WEST: // Skulle kunna skrivas som default istället
                orientation.setCurrentDirection(Orientation.Directions.NORTH);
                break;
        }
    };
}
