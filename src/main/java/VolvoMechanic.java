public class VolvoMechanic<T extends Volvo240> extends CarMechanic<T> {
    public VolvoMechanic(int cargosize) {
        super(cargosize);
    }}


    //public Volvo240 unLoad(int carNumber) {
    //    Volvo240 car = loader.getCargo().get(carNumber);
    //    loader.getCargo().remove(car);
    //    return car;
    //}}
