import Cars.Car;
import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;

import java.util.ArrayList;

public class Model {

    Model cc = new Model();
    ArrayList<Car> cars = new ArrayList<>();

    public void Model(){
    cc.cars.add(new Volvo240(0, 0, "east"));
    cc.cars.add(new Saab95(0, 100, "east"));
    cc.cars.add(new Scania(0, 200, "east"));

    }


}

