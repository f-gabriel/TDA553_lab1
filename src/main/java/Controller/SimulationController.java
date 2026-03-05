package Controller;

import java.util.Random;

import Cars.*;
import GameObjects.GameObjects;
import Mechanic.CarMechanic;
import Mechanic.VolvoMechanic;
import Model.Model;
import Model.ModelListener;

public class SimulationController implements ModelListener, ControllPanelListener{
    private final CarController carC;
    private final MechanicController mechC;
    private final ControlPanel controlP;
    private Model model;

    private GameObjects gameObjects;

    public SimulationController(Model model, GameObjects gameObjects, ControlPanel controlP) {
        this.carC = new CarController(gameObjects);
        this.mechC = new MechanicController(gameObjects);
        this.model = model;
        this.controlP = controlP;
        this.gameObjects = gameObjects;

        model.addListener(this);
        controlP.addListener(this);
    }

    public VolvoMechanic createVolvoMechanic(int cargo, int x, int y, String direction) {return mechC.createVolvoMechanic(cargo,x,y, direction);}
    public Saab95 createSaab95(double x, double y, String direction) {return carC.createSaab95(x,y,direction);}
    public Volvo240 createVolvo240(double x, double y, String direction) {
        return carC.createVolvo240(x,y,direction);
    }
    public Scania createScania(double x, double y, String direction) {
        return carC.createScania(x,y,direction);
    }

    @Override
    public void actOnModelUpdate() {
        for(Car car : gameObjects.getCarObjects()) {
            carC.move(car);
        }
    }

    @Override
    public void actOnAtMechanic(Car car, CarMechanic carMechanic) {
        mechC.load(car, carMechanic);
        gameObjects.removeGameObject(car);
    }

    @Override
    public void actOnAtEndOfScreen(Car car) {
        carC.turnAround(car);
    }

    @Override
    public void actOnGasButton(int gasAmount) {
        for(Car car : gameObjects.getCarObjects()) {
        carC.gas(gasAmount, car);}
    }

    @Override
    public void actOnBrakeButton(int brakeAmount) {
        for(Car car : gameObjects.getCarObjects()) {
        carC.brake(brakeAmount, car);}
    }

    @Override
    public void actOnTurboOnButton() {
        for(Car car : gameObjects.getCarObjects()) {
        carC.turboOn(car);}
    }

    @Override
    public void actOnTurboOffButton() {
        for(Car car : gameObjects.getCarObjects()) {
        carC.turboOff(car);}
    }

    @Override
    public void actOnLiftBedButton() {
        for(Car car : gameObjects.getCarObjects()) {
        carC.liftBed(car);}
    }

    @Override
    public void actOnLowerBedButton() {
        for(Car car : gameObjects.getCarObjects()) {
        carC.lowerBed(car);}
    }

    @Override
    public void actOnStartButton() {
        for(Car car : gameObjects.getCarObjects()) {
        carC.startEngine(car);}
    }

    @Override
    public void actOnStopButton() {
        for(Car car : gameObjects.getCarObjects()) {
        carC.stopEngine(car);}
    }

    @Override
    public void actOnAddCarButton() {
        Random rng = new Random();

        int randX = rng.nextInt(7) * 100;
        int randY = rng.nextInt(7) * 100;
        String randDirection = DIRECTIONS.values()[rng.nextInt(3)].toString();

        Volvo240 volvo = createVolvo240(randX, randY,randDirection);
        gameObjects.addGameObject(volvo);
    }

    @Override
    public void actOnRemoveCarButton() {
        Car lastCar = gameObjects.getCarObjects().getLast();
        gameObjects.removeGameObject(lastCar);
    }
}
