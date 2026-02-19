import java.awt.*;

public class Volvo240 extends PersonalVehicle{
    static double trimFactor = 1.25;

    public Volvo240(){
        super(100, 4, Color.black, "Volvo240",0, 0, "north");
    }
    public Volvo240(double x, double y, String direction){
        super(100, 4, Color.black, "Volvo240",x, y, direction);
    }
    public Volvo240(Color color, double x, double y, String direction){
        super(100, 4, color, "Volvo240",x, y, direction);
    }


    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
