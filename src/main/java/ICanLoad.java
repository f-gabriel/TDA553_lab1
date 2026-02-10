import java.util.ArrayList;

public interface ICanLoad<T> {
    public ArrayList<T> getCargo();
    public void load(T item);
    public T unLoad();
}


