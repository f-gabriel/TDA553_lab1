import java.awt.*;

abstract public class Car extends Engine implements Movable{
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

    // övriga get-/set-funktioner
    public int getNrDoors(){return nrDoors;}
    public String getModelName(){return modelName;}
    public Color getColor(){return color;}
    public void setColor(Color clr) {color = clr;}



    // funktioner som påverkar currentSpeed
    public void startEngine(){currentSpeed = 0.1;}
    public void stopEngine(){currentSpeed = 0;}
    double speedFactor(){return 0;}
    void incrementSpeed(double amount){currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);}
    void decrementSpeed(double amount){currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);}
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

    // Funktioner som ändrar bilens riktning och position
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






