import java.awt.*;

//todo: fixa gas()

public class Truck extends Car implements TruckBed {
    TruckBed parent = new TruckBedHelper();

    public Truck(double enginePower, int nrDoors, Color color, String modelName, double x, double y, String direction) {
        super(enginePower, nrDoors, color, modelName, x, y, direction);}

    // methods from TruckBed
    public void raise(){if (currentSpeed == 0) parent.raise();}
    public void lower(){if (currentSpeed == 0) parent.lower();}
    public int getBedState(){return parent.getBedState();}

    // methods from Car
    public void startEngine(){
        if (getBedState() == 0) currentSpeed = 0.1;
    }
    public void gas(double amount){
        if((amount == 1 || amount == 0) && getBedState() == 0){
            incrementSpeed(amount); // fråga TA om best practice
        } else System.out.println("amount != (0 or 1)");
    }
}
