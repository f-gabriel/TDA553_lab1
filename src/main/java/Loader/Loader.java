package Loader;

import java.util.ArrayList;

// hjälpklass till Loader.Loadable
public class Loader<T> implements Loadable<T> {
    ArrayList<T> cargo;
    int cargoSize;

    public Loader(int Size){
        this.cargo = new ArrayList<>(); // T är alltså typ, cargoSize är hur många object listan kan innehålla som mest
        this.cargoSize = Size;  }

    public Loader(Loader loader){
        this.cargo = new ArrayList<>(loader.cargo);
        this.cargoSize = loader.cargoSize;
    }

    public ArrayList<T> getCargo(){return cargo;}
    public void load(T item){
        if (cargo.size() < cargoSize) {
            cargo.add(item);
        } else {
            System.out.println("cargo full");}
    }
    public T unLoad(){
        T item = cargo.getLast();
        cargo.remove(item);
        return item;
    }
}
