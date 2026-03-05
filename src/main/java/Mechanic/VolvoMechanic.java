package Mechanic;

import Cars.Saab95;
import Cars.Volvo240;

public class VolvoMechanic extends CarMechanic<Volvo240> {

    private VolvoMechanic(VolvoMechanic model) {
        super(model);
    }



    private VolvoMechanic(){super();}
    private VolvoMechanic(int cargoSize, double xCoordinate, double yCoordinate, String direction) {
        super(cargoSize, xCoordinate, yCoordinate, direction);
    }

    public static VolvoMechanic CreateVolvoMechanic(){
        return new VolvoMechanic();
    }
    public static VolvoMechanic CreateVolvoMechanic(int cargoSize, double xCoordinate, double yCoordinate, String direction){return new VolvoMechanic(cargoSize, xCoordinate, yCoordinate, direction);}

    public static VolvoMechanic createVolvoMechanic(VolvoMechanic model) {
        return new VolvoMechanic(model);
    }
}



