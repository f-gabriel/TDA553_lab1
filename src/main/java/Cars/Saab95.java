package Cars;

import java.awt.*;

public class Saab95 extends PersonalVehicle implements TurboChargable {
    boolean turboOn;

    public Saab95(Saab95 model) {
        super(model);
        this.turboOn = model.turboOn;
    }

    public static Saab95 CreateSaab95(){
        return new Saab95();
    }
    public static Saab95 CreateSaab95(double x, double y, String direction){
        return new Saab95(x,y,direction);
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

    public static Saab95 createSaab95(Saab95 model) {
        return new Saab95(model);
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
