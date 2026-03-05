package Controller;

import Cars.Car;
import Cars.Volvo240;
import GameObjects.GameObjects;
import Mechanic.CarMechanic;
import Mechanic.VolvoMechanic;
import Model.Model;


public class MechanicController {
    //    // En dummy-metod i framtiden kommer den iterera över en lista av carMechanics, så som bilmetoderna fungerar
    GameObjects gameObjects;
    public MechanicController(GameObjects  gameObjects) {
        this.gameObjects = gameObjects;
    }

    public static VolvoMechanic createVolvoMechanic(int cargo, int x, int y, String direction) {
        return VolvoMechanic.CreateVolvoMechanic(cargo, x, y, direction);
    }


    private Model gameModel;

    public void load(Car car, CarMechanic<Car> mechanic){
        mechanic.load(car);
    }

    // Anropas när användaren klickar på "Unload Volvo Mechanic" i vyn
    public void unloadMechanic() {
    }


}
