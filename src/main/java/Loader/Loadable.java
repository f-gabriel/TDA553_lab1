package Loader;

import java.util.List;

public interface Loadable <T> {
    public List<T> getCargo();
    public void load(T item);
    public T unLoad();
}




    // Interface för klasser som kan load:as.
    // Skulle i så fall innehålla metoder för
    // att se till att kolla om de kan load:a

    // se till att de inte kan köra medan de
    // är load:ade och göra att de tar
    // orientation från objektet de är load:ade i.

