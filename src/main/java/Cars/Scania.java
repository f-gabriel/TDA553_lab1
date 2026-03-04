package Cars;

import java.awt.*;

public class Scania extends Truck {

    private double bedHelperDegree;

    public static Scania CreateScania(){
        return new Scania();
    }
    public static Scania CreateScania(double x, double y, String direction){
        return new Scania(x,y,direction);
    }

    private Scania() {
        super(500, Color.red, "Cars.Scania", 0, 0, "north");
        this.bedHelperDegree = 0;
    }
    private Scania(double x, double y, String direction){
        super(100, Color.red, "Cars.Scania", x, y, direction);
    }

    // kolla med delta
    public void raise() {
        if ((int)getCurrentSpeed() == 0) {
            bedHelperDegree = Math.min(bedHelperDegree + 10, 70);
        }
    }

    public void lower() {
        System.out.println(((int)getCurrentSpeed()));
        if ((int)getCurrentSpeed() == 0) {
            bedHelperDegree = Math.max(bedHelperDegree - 10, 0);
            System.out.println(bedHelperDegree);
        }
    }

    public double getBedHelperDegree() {
        return bedHelperDegree;
    }

    @Override
    public void move() {
        if (bedHelperDegree == 0) {
            super.move();
        }
    }
}

