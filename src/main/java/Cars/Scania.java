package Cars;

import java.awt.*;

public class Scania extends Truck {

    private double bedHelperDegree;

    public Scania(Scania model) {
        Orientation orientation = model.orientation;
        super(model.enginePower, model.color, model.modelName, orientation.getX(), orientation.getY(), orientation.getCurrentDirectionAsString());
    }

    public static Scania CreateScania(){
        return new Scania();
    }
    public static Scania CreateScania(double x, double y, String direction){
        return new Scania(x,y,direction);
    }
    public static Scania createScania(Scania scania){
        return new Scania(scania);
    }

    private Scania() {
        super(500, Color.red, "Scania", 0, 0, "north");
        this.bedHelperDegree = 0;
    }
    private Scania(double x, double y, String direction){
        super(100, Color.red, "Scania", x, y, direction);
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

