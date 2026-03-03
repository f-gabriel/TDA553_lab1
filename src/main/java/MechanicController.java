import Cars.Car;
import Cars.Volvo240;
import Loader.Loader;
import Mechanic.VolvoMechanic;


public class MechanicController {
    //    // En dummy-metod i framtiden kommer den iterera över en lista av carMechanics, så som bilmetoderna fungerar
    boolean car_at_mechanic(VolvoMechanic mechanic, int oldX, int oldY, int x, int y) {
        int mechanicX = (int) Math.round(mechanic.getX());
        int mechanicY = (int) Math.round(mechanic.getY());
        boolean atMechanic;

        atMechanic = x == mechanicX;
        atMechanic = atMechanic || (oldX < mechanicX && mechanicX < x) && y == mechanicY; // om oldX < mechX < x -> bilen har passerat
        atMechanic = atMechanic || (oldX > mechanicX && mechanicX > x) && y == mechanicY; // 'atMechanic ||' ser till att den fortsätter vara True
        atMechanic = atMechanic || (oldY < mechanicY && mechanicY < y) && x == mechanicX; // 'x == mechanicX' kollar att de ligger på samma linje
        atMechanic = atMechanic || (oldY > mechanicY && mechanicY > y) && x == mechanicX;
        return atMechanic;
    }

    void carMechanicLoad(VolvoMechanic mechanic, Volvo240 car) {
        double outsideOfScreen = 801;
        car.setPosition(outsideOfScreen, outsideOfScreen);
        mechanic.load(car);
    }

    private Model gameModel;



    // Anropas när användaren klickar på "Unload Volvo Mechanic" i vyn
    public void unloadMechanic() {
    }

    public static VolvoMechanic createVolvoMechanic(int cargo, int x, int y, String direction) {
        return new VolvoMechanic(cargo, x, y, direction);
    }
}
