import java.util.ArrayList;

// hjälpklass till Loadable
public class Loader<T> implements Loadable<T> {
    ArrayList<T> cargo;
    public Loader(int cargoSize){
        this.cargo = new ArrayList<T>(cargoSize);} // T är alltså typ, cargoSize är hur många object listan kan innehålla som mest
    public void load(T item){
        cargo.add(item);
    }
    public T unLoad(){
        T item = cargo.getFirst();
        cargo.remove(item);
        return item;
    }
}
