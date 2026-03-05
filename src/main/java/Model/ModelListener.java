package Model;

import Cars.Car;
import Mechanic.CarMechanic;

import java.io.IOException;

public interface ModelListener {
    void actOnModelUpdate() throws IOException;
    void actOnAtMechanic(Car car, CarMechanic carMechanic);
    void actOnAtEndOfScreen(Car car);
}
