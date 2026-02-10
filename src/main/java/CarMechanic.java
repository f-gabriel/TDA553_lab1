// todo: ffa fixa så att unload() följer labinstruktionerna. Kanske kräver omskrivning av load() med.
// skapa märkesverkstäder för Saab pch Volvo

import java.util.ArrayList;

abstract public class CarMechanic implements Loadable<Car> {

    Loader<Car> loader = new Loader<>(15);

    public CarMechanic(int cargoSize) {this.loader = new Loader<>(cargoSize);}

    public void load(Car item){loader.load(item);}
    public Car unLoad(int carNumber){
        Car car = loader.getCargo().get(carNumber);
        loader.getCargo().remove(car);
        return car;

    }
}
