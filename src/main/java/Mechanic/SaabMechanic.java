package Mechanic;

import Cars.Saab95;

public class SaabMechanic extends CarMechanic<Saab95>{

    public static CarMechanic CreateSaabMechanic(){
        return new SaabMechanic();
    }

    private SaabMechanic(){super();}
    private SaabMechanic(int cargoSize, double xCoordinate, double yCoordinate, String direction) {
        super(cargoSize, xCoordinate, yCoordinate, direction);
    }
}

