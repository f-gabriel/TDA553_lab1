package Mechanic;

import Cars.Volvo240;

public class VolvoMechanic extends CarMechanic<Volvo240> {
    public VolvoMechanic(){super();}
    public VolvoMechanic(int cargoSize, double xCoordinate, double yCoordinate, String direction) {
        super(cargoSize, xCoordinate, yCoordinate, direction);
    }
}



