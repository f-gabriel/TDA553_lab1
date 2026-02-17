import java.awt.*;

public class Scania extends Truck {

    private double bedHelperDegree;

    public Scania() {
        super(500, Color.red, "Scania", 0, 0, "north");
        this.bedHelperDegree = 0;
    }

    public void raise() {
        if (getCurrentSpeed() == 0) {
            bedHelperDegree = Math.min(bedHelperDegree + 10, 70);
        }
    }

    public void lower() {
        if (getCurrentSpeed() == 0) {
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

