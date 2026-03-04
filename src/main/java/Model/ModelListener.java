package Model;

import Cars.Car;
import Mechanic.CarMechanic;

public interface ModelListener {
    void actOnModelUpdate();
    void actOnAtMechanic(Car car, CarMechanic carMechanic);
    void actOnAtEndOfScreen(Car car);
}
