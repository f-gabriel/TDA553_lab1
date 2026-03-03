package GameObjects;

import Cars.Car;
import Cars.HasOrientation;
import Mechanic.CarMechanic;

import java.util.ArrayList;
import java.util.List;

public class MechanicObjects implements HoldsGameObjects<CarMechanic> {
    private List<CarMechanic> mechanicObjects = new ArrayList<>();
    @Override
    public void addGameObject(CarMechanic mechanic) {
        mechanicObjects.add(mechanic);
    }
    public void removeGameObject(CarMechanic mechanic) {
        mechanicObjects.remove(mechanic);
    }
    public List<CarMechanic> getGameObjects() {
        return new ArrayList<>(mechanicObjects);
    }
}
