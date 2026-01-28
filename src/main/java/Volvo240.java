import java.awt.*;

public class Volvo240 extends Car{
    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(100, 4, Color.black, "Volvo240",new Point(0,0), Directions.NORTH);
    }
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
