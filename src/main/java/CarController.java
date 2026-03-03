import Cars.*;
import Mechanic.VolvoMechanic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

// todo: se gas() / brake()
// todo framtid: förslag: CarController är enda klassen som interagerar direkt med bilarna.
//  den ska inte instansiera en CarView
public class CarController {



    // Calls the gas method for each car once
    void gas(int amount, Car car) {
        double gas = ((double) amount) / 100; // behöver vara 1 eller 0. Kan också omimplementera funktionerna i Cars.Car
        gas = amount;
        if (amount != 0) {gas = 1;}
        //for (Car car : cars) {
            car.gas(gas);
        //}
    }
    void brake(int amount, Car car) {
        double brake = ((double) amount) / 100; // se gas()
        brake = amount;
        if (amount != 0) {brake = 1;}
        //for (Car car : cars) {
            car.brake(brake);
        //}
    }
    void turboOn(Car car) {
        //for (Car car : cars) {
            if (car instanceof TurboChargable) {
                ((Saab95) car).setTurboOn();
            }
        //}
    }
    void turboOff(Car car) {
        //for (Car car : cars) {
            if (car instanceof TurboChargable) {
                ((Saab95) car).setTurboOff();
            }
        //}
    }
    void liftBed(Car car) {
        //for (Car car : cars) {
            if (car instanceof Truck) {
                if (car.getCurrentSpeed() == 0) { //
                    ((Scania) car).raise();
                    }
                }
            //}
        }
    void lowerBed(Car car) {
        //for (Car car : cars) {
        if (car instanceof  Scania){
        if (car.getCurrentSpeed() == 0) {
        ((Scania) car).lower();
                }
            }
        //}
    }
    void startEngine(Car car){
        //for (Car car : cars) {
            car.startEngine();
            //}
        }
    void stopEngine(Car car){
        //for (Car car : cars) {
            car.stopEngine();
        //}
    }

    // skapade för lab 4
    void move(Car car) {
            car.move();
    }
    void turnLeft(Car car) {
        car.turnLeft();
    }
    void turnRight(Car car) {
        car.turnRight();
    }
    double getX(Car car) {
        return car.getX();
    }
    double getY(Car car) {
        return car.getY();
    }
    void setPosition(double x, double y, Car car) {
        car.setPosition(x, y);
    }


    private Model gameModel;

    // Konstruktorn tar emot modellen så att controllern vet vem den ska prata med
    public CarController(Model gameModel) {
        this.gameModel = gameModel;
    }

    // 2. Alla metoder nedan gör exakt en sak: Tar emot ett kommando från Vyn (knapparna)
    // och skickar det rakt vidare till Modellen. Ingen logik, inga loopar, inga "instanceof".

    public void gas(int amount) {
        gameModel.gas(amount);
    }

    public void brake(int amount) {
        gameModel.brake(amount);
    }

    public void turboOn() {
        gameModel.turboOn();
    }

    public void turboOff() {
        gameModel.turboOff();
    }

    public void liftBed() {
        gameModel.liftBed();
    }

    public void lowerBed() {
        gameModel.lowerBed();
    }

    public void startEngine() {
        gameModel.startEngine();
    }

    public void stopEngine() {
        gameModel.stopEngine();
    }
}








