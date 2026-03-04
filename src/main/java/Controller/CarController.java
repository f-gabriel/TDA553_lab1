package Controller;

import Cars.*;
import GameObjects.GameObjects;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

// todo: se gas() / brake()
// todo framtid: förslag: Controller.CarController är enda klassen som interagerar direkt med bilarna.
//  den ska inte instansiera en CarView
public class CarController {
    private GameObjects gameObjects;
    ControlPanel controlPanel;


    public CarController(GameObjects gameObjects) {
        this.gameObjects = gameObjects;
    }

    // Calls the gas method for each car once
    void gas(int amount, Car car) {
        double gas = ((double) amount); // behöver vara 1 eller 0. Kan också omimplementera funktionerna i Cars.Car
        gas = amount;
        if (amount != 0) {
            gas = 1;
        }
//        for (Car car : gameObjects.getCarObjects()) {
            car.gas(gas);
//        }
    }

    void brake(int amount, Car car) {
        double brake = ((double) amount) / 100; // se gas()
        brake = amount;
        if (amount != 0) {
            brake = 1;
        }
        //for (Car car : gameObjects.getCarObjects()) {
            car.brake(brake);
        //}
    }

    void turboOn(Car car) {
        //for (Car car : gameObjects.getCarObjects()) {
            if (car instanceof TurboChargable) {
                ((Saab95) car).setTurboOn();
            }
        //}
    }

    void turboOff(Car car) {
        //for (Car car : gameObjects.getCarObjects()) {
            if (car instanceof TurboChargable) {
                ((Saab95) car).setTurboOff();
            }
        //}
    }

    void liftBed(Car car) {
        //for (Car car : gameObjects.getCarObjects()) {
            if (car instanceof Truck) {
                    ((Scania) car).raise();
            }
        //}
    }

    void lowerBed(Car car) {
        //for (Car car : gameObjects.getCarObjects()) {
            if (car instanceof Scania) {
                ((Scania) car).lower();
            }
        //}
    }

    void startEngine(Car car) {
        //for (Car car : gameObjects.getCarObjects()) {
            car.startEngine();
        //}
    }

    void stopEngine(Car car) {
        //for (Car car : gameObjects.getCarObjects()) {
            car.stopEngine();
        //}
    }

    void move(Car car) {
        //for (Car car : gameObjects.getCarObjects()) {
            car.move();
        //}
    }

    void turnAround(Car car) {
        car.turnAround();
    }


    public Saab95 createSaab95(double x, double y, String direction) {return Saab95.CreateSaab95(x,y,direction);}

    public Volvo240 createVolvo240(double x, double y, String direction) {return Volvo240.CreateVolvo240(x,y,direction);}

    public Scania createScania(double x, double y, String direction) {return Scania.CreateScania(x,y,direction);}
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








