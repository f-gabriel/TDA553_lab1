package Mechanic;// todo: ffa fixa så att unload() följer labinstruktionerna. Kanske kräver omskrivning av load() med.
// skapa märkesverkstäder för Saab pch Volvo
import Cars.HasOrientation;
import Loader.Loadable;
import Loader.Loader;
import Cars.Car;
import Cars.Orientation;

import java.util.List;

public class CarMechanic<T extends Car> implements Loadable<T>, HasOrientation {
    Loader<T> loader;
    Orientation orientation;

    public CarMechanic() {
        this.loader = new Loader<T>(15);
        this.orientation = new Orientation(0,0, "north");
    }
    public CarMechanic(int cargoSize, double xCoordinate, double yCoordinate, String direction) {
        this.loader = new Loader<T>(cargoSize);
        this.orientation = new Orientation(xCoordinate, yCoordinate, direction);
    }


    public List<T> getCargo() {return loader.getCargo();}

    public void load(T item){loader.load(item);}
    public T unLoad(){return loader.unLoad();}
    public T unLoad(int carNumber){
        T car = loader.getCargo().get(carNumber);
        loader.getCargo().remove(car);
        return car;
    }

    public double getX(){return orientation.getX();}
    public double getY(){return orientation.getY();}
}
