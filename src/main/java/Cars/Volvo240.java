package Cars;

import java.awt.*;

public class Volvo240 extends PersonalVehicle{
    static double trimFactor = 1.25;

    public Volvo240(Volvo240 model) {
        super(model);
    }

    public static Volvo240 CreateVolvo240(){
        return new Volvo240();
    }
    public static Volvo240 CreateVolvo240(double x, double y, String direction){
        return new Volvo240(x,y,direction);
    }

    private Volvo240(){
        super(100, 4, Color.black, "Cars.Volvo240",0, 0, "north");
    }
    private Volvo240(double x, double y, String direction){
        super(100, 4, Color.black, "Cars.Volvo240",x, y, direction);
    }
    private Volvo240(Color color, double x, double y, String direction){
        super(100, 4, color, "Cars.Volvo240",x, y, direction);
    }

    public static Volvo240 createVolvo240(Volvo240 model) {
        return new Volvo240(model);
    }


    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
