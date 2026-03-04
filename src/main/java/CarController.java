import Cars.*;
import GameObjects.GameObjects;
import Mechanic.CarMechanic;
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
    private GameObjects gameObjects;
    ControlPanel controlPanel;

    // Konstruktorn tar emot modellen så att controllern vet vem den ska prata med
    public CarController(GameObjects gameObjects) {
        this.gameObjects = gameObjects;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount); // behöver vara 1 eller 0. Kan också omimplementera funktionerna i Cars.Car
        gas = amount;
        if (amount != 0) {
            gas = 1;
        }
        for (Car car : gameObjects.getCarObjects()) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100; // se gas()
        brake = amount;
        if (amount != 0) {
            brake = 1;
        }
        for (Car car : gameObjects.getCarObjects()) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Car car : gameObjects.getCarObjects()) {
            if (car instanceof TurboChargable) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : gameObjects.getCarObjects()) {
            if (car instanceof TurboChargable) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Car car : gameObjects.getCarObjects()) {
            if (car instanceof Truck) {
                if (car.getCurrentSpeed() == 0) { //
                    ((Scania) car).raise();
                }
            }
        }
    }

    void lowerBed() {
        for (Car car : gameObjects.getCarObjects()) {
            if (car instanceof Scania) {
                if (car.getCurrentSpeed() == 0) {
                    ((Scania) car).lower();
                }
            }
        }
    }

    void startEngine() {
        for (Car car : gameObjects.getCarObjects()) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : gameObjects.getCarObjects()) {
            car.stopEngine();
        }
    }

    void move() {
        for (Car car : gameObjects.getCarObjects()) {
            car.move();
        }
    }

    void turnAround(Car car) {
        car.turnAround();
    }


    public Saab95 createSaab95(double x, double y, String direction) {
        return new Saab95(x, y, direction);
    }

    public Volvo240 createVolvo240(double x, double y, String direction) {
        return new Volvo240(x, y, direction);
    }

    public Scania createScania(double x, double y, String direction) {
        return new Scania(x, y, direction);
    }
}



    // 2. Alla metoder nedan gör exakt en sak: Tar emot ett kommando från Vyn (knapparna)
    // och skickar det rakt vidare till Modellen. Ingen logik, inga loopar, inga "instanceof".

//    public void gas(int amount) {
//        gameModel.gas(amount);
//    }
//
//    public void brake(int amount) {
//        gameModel.brake(amount);
//    }
//
//    public void turboOn() {
//        gameModel.turboOn();
//    }
//
//    public void turboOff() {
//        gameModel.turboOff();
//    }
//
//    public void liftBed() {
//        gameModel.liftBed();
//    }
//
//    public void lowerBed() {
//        gameModel.lowerBed();
//    }
//
//    public void startEngine() {
//        gameModel.startEngine();
//    }
//
//    public void stopEngine() {
//        gameModel.stopEngine();
//    }
//}








