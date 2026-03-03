package GameObjects;

import Cars.Car;
import Cars.HasOrientation;

import java.util.ArrayList;
import java.util.List;

public class CarObjects implements HoldsGameObjects<Car>{
    private List<Car> carObjects = new ArrayList<>();
    @Override
    public void addGameObject(Car car) {
        carObjects.add(car);
    }
    public void removeGameObject(Car car) {
        carObjects.remove(car);
    }
    public List<Car> getGameObjects() {
        return new ArrayList<>(carObjects);
    }
}
