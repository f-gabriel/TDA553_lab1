import java.util.ArrayList;

public interface Loadable<T> {
    public ArrayList<T> getCargo();
    public void load(T item);
    public T unLoad();
}
