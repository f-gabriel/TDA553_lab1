package Cars;

import java.awt.*;

abstract public class Car extends Engine implements Movable, HasOrientation {
    int nrDoors; // Number of doors on the car
    double currentSpeed; // The current speed of the car
    Color color; // Color of the car
    String modelName;
    Orientation orientation;

    public Car(double enginePower, int nrDoors, Color color, String modelName, double x, double y, String direction) {
        super(enginePower);
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.orientation = new Orientation(x, y, direction);
        stopEngine();
    }

    // get-/set-funktioner som rör hastighet och positionering
    public double getCurrentSpeed(){return currentSpeed;}
    public double getX(){return orientation.getX();}
    public double getY(){return orientation.getY();}
    public Orientation.Directions getCurrentDirection(){return orientation.currentDirection;}
    public void setPosition(double x, double y){orientation.setPosition(x,y);}
    public void addToCoordinate(char coordinate, double amount){orientation.addToCoordinate(coordinate, amount);}
    public String getCurrentDirectionAsString(){return orientation.getCurrentDirectionAsString();}

    // övriga get-/set-funktioner
    public int getNrDoors(){return nrDoors;}
    public String getModelName(){return modelName;}
    public Color getColor(){return color;}
    private void setColor(Color clr) {color = clr;}

    // funktioner som påverkar currentSpeed
    public void startEngine(){currentSpeed = 0.1;}
    public void stopEngine(){currentSpeed = 0;}
    public void gas(double amount){
        if(amount == 1 || amount == 0){
            incrementSpeed(amount);
        } else System.out.println("amount != (0 or 1)");
    }
    public void brake(double amount){
        if( amount == 1 || amount == 0){
            decrementSpeed(amount);
        } else System.out.println("amount != (0 or 1)");
    }

    protected double speedFactor(){return enginePower * 0.01;}
    protected void incrementSpeed(double amount){currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);}
    protected void decrementSpeed(double amount){currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);}

    // Funktioner som ändrar bilens riktning och position
    public void move() {
        switch (orientation.currentDirection) {
            case Orientation.Directions.NORTH:
                addToCoordinate('y', currentSpeed);
                break;
            case Orientation.Directions.WEST:
                addToCoordinate('x', -currentSpeed);
                break;
            case Orientation.Directions.SOUTH:
                addToCoordinate('y', -currentSpeed);
                break;
            case Orientation.Directions.EAST: // Skulle kunna skrivas som default istället
                addToCoordinate('x', currentSpeed);
                break;
        }
    }
    public void turnLeft(){
        switch (orientation.getCurrentDirection()){
            case Orientation.Directions.NORTH:
                orientation.setCurrentDirection(Orientation.Directions.WEST);
                break;
            case Orientation.Directions.WEST:
                orientation.setCurrentDirection(Orientation.Directions.SOUTH);
                break;
            case Orientation.Directions.SOUTH:
                orientation.setCurrentDirection(Orientation.Directions.EAST);
                break;
            case Orientation.Directions.EAST: // Skulle kunna skrivas som default istället
                orientation.setCurrentDirection(Orientation.Directions.NORTH);
                break;
        }
    };
    public void turnRight(){
        switch (orientation.getCurrentDirection()){
            case Orientation.Directions.NORTH:
                orientation.setCurrentDirection(Orientation.Directions.EAST);
                break;
            case Orientation.Directions.EAST:
                orientation.setCurrentDirection(Orientation.Directions.SOUTH);
                break;
            case Orientation.Directions.SOUTH:
                orientation.setCurrentDirection(Orientation.Directions.WEST);
                break;
            case Orientation.Directions.WEST: // Skulle kunna skrivas som default istället
                orientation.setCurrentDirection(Orientation.Directions.NORTH);
                break;
        }
    };


}






