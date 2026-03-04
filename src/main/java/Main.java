import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;
import Controller.ControlPanel;
import Controller.SimulationController;
import GameObjects.GameObjects;
import Mechanic.VolvoMechanic;
import Model.Model;
import Controller.SimulationController;

public class Main {


    public static void main(String[] args) {
        GameObjects gameObjects = new GameObjects();
        Model model =  new Model(gameObjects);

        ControlPanel controlP = new ControlPanel();
        SimulationController simC = new SimulationController(model, gameObjects, controlP);

        CarView carView = new CarView("CarSim 1.0", model, gameObjects, controlP);

        Saab95 saab95 = simC.createSaab95(0, 0, "east");
        Volvo240 volvo240 = simC.createVolvo240(0, 100, "east");
        Scania scania = simC.createScania(0, 200, "east");

        VolvoMechanic volvoMechanic = simC.createVolvoMechanic(15, 300, 0, "north");

        gameObjects.addGameObject(saab95);
        gameObjects.addGameObject(volvo240);
        gameObjects.addGameObject(scania);
        gameObjects.addGameObject(volvoMechanic);


        model.startSimulation();
    }
}
