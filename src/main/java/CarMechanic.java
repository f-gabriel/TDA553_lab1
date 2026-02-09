// todo: ffa fixa så att unload() följer labinstruktionerna. Kanske kräver omskrivning av load() med.
// skapa märkesverkstäder för Saab pch Volvo

abstract public class CarMechanic implements Loadable<Car> {
    Loader<Car> loader; // hjälpklass till Loadable

    public CarMechanic(int cargoSize) {this.loader = new Loader<>(cargoSize);}

    public void load(Car item){loader.load(item);}
    public Car unLoad(){return loader.unLoad();}
}
