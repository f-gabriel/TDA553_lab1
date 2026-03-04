package Mechanic;

import Cars.Volvo240;

public class VolvoMechanic extends CarMechanic<Volvo240> {

    public static VolvoMechanic CreateVolvoMechanic(){
        return new VolvoMechanic();
    }
    public static VolvoMechanic CreateVolvoMechanic(int cargoSize, double xCoordinate, double yCoordinate, String direction){
        return new VolvoMechanic(cargoSize, xCoordinate, yCoordinate, direction);
    }

    private VolvoMechanic(){super();}
    private VolvoMechanic(int cargoSize, double xCoordinate, double yCoordinate, String direction) {
        super(cargoSize, xCoordinate, yCoordinate, direction);
    }
}



