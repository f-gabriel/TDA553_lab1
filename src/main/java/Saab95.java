import java.awt.*;

public class Saab95 extends Car{
    boolean turboOn;

    public Saab95(){
        double power = 125;
        super(power, 2, Color.red, "Saab95", 0, 0, "north");
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
