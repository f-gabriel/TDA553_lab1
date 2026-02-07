import java.util.ArrayList;

public class Loader<T> implements Loadable<T> {
    ArrayList<T> cargo;
    public Loader(int cargoSize){
        this.cargo = new ArrayList<T>(cargoSize);
    }
    public void load(T item){
        cargo.add(item);
    }
    public T unLoad(){
        T item = cargo.getFirst();
        cargo.remove(item);
        return item;
    }
}
