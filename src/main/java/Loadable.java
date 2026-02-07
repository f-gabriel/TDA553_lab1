public interface Loadable<T> {
    public void load(T item);
    public T unLoad();
}
