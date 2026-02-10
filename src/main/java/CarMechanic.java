// todo: ffa fixa så att unload() följer labinstruktionerna. Kanske kräver omskrivning av load() med.
// skapa märkesverkstäder för Saab pch Volvo

import java.util.ArrayList;

public class CarMechanic<T extends Car> implements Loadable<T> {

    Loader<T> loader;

    public CarMechanic(int cargosize) {
        this.loader = new Loader<>(cargosize);}

    public ArrayList <T> getCargo(){
        return loader.getCargo();
    }

    public void load(T item){loader.load(item);}
    public T unLoad(){return loader.unLoad();}
    public T unLoad(int carNumber){
        T car = loader.getCargo().get(carNumber);
        loader.getCargo().remove(car);
        return car;

    }
}
