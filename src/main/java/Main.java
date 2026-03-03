import Cars.Car;
import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;
import GameObjects.GameObjects;
import Mechanic.VolvoMechanic;

public class Main {


    public static void main(String[] args) {
        GameObjects gameObjects = new GameObjects();
        Model model =  new Model();
        CarController carController = new CarController(model, gameObjects); //todo carController och Mechanic ska vara samma controller
        MechanicController mechanicController = new MechanicController();
        CarView carView = new CarView("CarSim 1.0", model, gameObjects);

        Saab95 saab95 = carController.createSaab95(0, 0, "east");
        Volvo240 volvo240 = carController.createVolvo240(0, 100, "east");
        Scania scania = carController.createScania(0, 200, "east");

        VolvoMechanic volvoMechanic = MechanicController.createVolvoMechanic(15, 300, 0, "north");

        gameObjects.addGameObject(saab95);
        gameObjects.addGameObject(volvo240);
        gameObjects.addGameObject(scania);
        gameObjects.addGameObject(volvoMechanic);


        model.startSimulation();
    }
}
