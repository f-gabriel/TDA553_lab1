package Cars;

import java.awt.*;

public class Scania extends Truck {

    private double bedHelperDegree;

    public Scania() {
        super(500, Color.red, "Cars.Scania", 0, 0, "north");
        this.bedHelperDegree = 0;
    }
    public Scania(double x, double y, String direction){
        super(100, Color.red, "Cars.Scania", x, y, direction);
    }

    // kolla med delta
    public void raise() {
        if ((int)getCurrentSpeed() == 0) {
            bedHelperDegree = Math.min(bedHelperDegree + 10, 70);
        }
    }

    public void lower() {
        if ((int)getCurrentSpeed() == 0) {
            bedHelperDegree = Math.max(bedHelperDegree - 10, 0);
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

