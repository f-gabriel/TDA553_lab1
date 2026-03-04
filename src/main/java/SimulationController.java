import Cars.Car;
import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;
import GameObjects.GameObjects;
import Mechanic.CarMechanic;
import Mechanic.VolvoMechanic;

import java.awt.event.ActionListener;

public class SimulationController implements ModelListener, ControllPanelListener{
    private final CarController carC;
    private final MechanicController mechC;
    private final ControlPanel controlP;
    private Model model;

    private GameObjects gameObjects;

    SimulationController(Model model, GameObjects gameObjects, ControlPanel controlP) {
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
        carC.move();
    }

    @Override
    public void actOnAtMechanic(Car car, CarMechanic carMechanic) {
        // todo
    }

    @Override
    public void actOnAtEndOfScreen(Car car) {
        carC.turnAround(car);
    }

    @Override
    public void actOnGasButton(int gasAmount) {
        carC.gas(gasAmount);
    }

    @Override
    public void actOnBrakeButton(int brakeAmount) {
        carC.brake(brakeAmount);
    }

    @Override
    public void actOnTurboOnButton() {
        carC.turboOn();
    }

    @Override
    public void actOnTurboOffButton() {
        carC.turboOff();
    }

    @Override
    public void actOnLiftBedButton() {
        carC.liftBed();
    }

    @Override
    public void actOnLowerBedButton() {
        carC.lowerBed();
    }

    @Override
    public void actOnStartButton() {
        carC.startEngine();
    }

    @Override
    public void actOnStopButton() {
        carC.stopEngine();
    }
}
