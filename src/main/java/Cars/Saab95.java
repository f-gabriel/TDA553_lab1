package Cars;

import java.awt.*;

public class Saab95 extends PersonalVehicle implements TurboChargable {
    boolean turboOn;
    public static Car CreateSaab95(){
        return new Saab95();
    }
    private Saab95(){
        double power = 125;
        super(power, 2, Color.red, "Cars.Saab95", 0, 0, "north");
	    turboOn = false;
    }

    private Saab95(double x, double y, String direction){
        super(125, 2,Color.red, "Cars.Saab95", x, y, direction);
        turboOn = false;
    }

    private Saab95(Color color, double x, double y, String direction){
        super(125, 2, color, "Cars.Saab95", x, y, direction);
        turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }
    public void setTurboOff(){
	    turboOn = false;
    }
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
