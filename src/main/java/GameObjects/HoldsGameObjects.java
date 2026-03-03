package GameObjects;

import Cars.Car;
import java.util.List;

public interface HoldsGameObjects<T> {
    public void addGameObject(T gameObject);
    public void removeGameObject(T gameObject);
    public List<T> getGameObjects();

}
