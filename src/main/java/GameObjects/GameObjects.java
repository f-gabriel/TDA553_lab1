package GameObjects;

import Cars.Car;
import Cars.HasOrientation;
import Mechanic.CarMechanic;

import java.util.ArrayList;
import java.util.List;

public class GameObjects implements HoldsGameObjects<HasOrientation> {
    private CarObjects carObjects;
    private MechanicObjects mechanicObjects;

    public GameObjects() {
        carObjects = new CarObjects();
        mechanicObjects = new MechanicObjects();
    }
    public void addGameObject(HasOrientation gameObject) {
        if (gameObject instanceof Car) {addCarObject((Car) gameObject);
        }
        else {addMechanicObject((CarMechanic<Car>) gameObject);}
    }
    public List<Car> getCarObjects() {
        return carObjects.getGameObjects();
    }
    public List<CarMechanic> getMechanicObjects() {
        return mechanicObjects.getGameObjects();
    }

    public void removeGameObject(HasOrientation gameObject) {
        if (gameObject instanceof Car) {carObjects.removeGameObject((Car) gameObject);}
        else {mechanicObjects.removeGameObject((CarMechanic<Car>) gameObject);}
    }

    public List<HasOrientation> getGameObjects() {
        ArrayList<HasOrientation> gameObjects = new ArrayList<>();
        gameObjects.addAll(carObjects.getGameObjects());
        gameObjects.addAll(mechanicObjects.getGameObjects());
        return gameObjects;
    }

    private void addCarObject(Car car) {
        carObjects.addGameObject(car);
    }
    private void addMechanicObject(CarMechanic<Car> mechanicObject) {
        mechanicObjects.addGameObject(mechanicObject);
    }
    public int size(){
        return getGameObjects().size();
    }
}
