package Mechanic;

import Cars.Volvo240;

public class VolvoMechanic extends CarMechanic<Volvo240> {

    public static CarMechanic CreateVolvoMechanic(){
        return new VolvoMechanic();
    }

    private VolvoMechanic(){super();}
    private VolvoMechanic(int cargoSize, double xCoordinate, double yCoordinate, String direction) {
        super(cargoSize, xCoordinate, yCoordinate, direction);
    }
}



