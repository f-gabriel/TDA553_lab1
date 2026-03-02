import java.awt.*;
import java.awt.image.BufferedImage;
import Cars.HasOrientation;

public class DrawObject implements DrawAble {

    private BufferedImage image;  // bilden som ska ritas
    private HasOrientation model; // modellen (Car, Truck, Mechanic)

    public DrawObject(BufferedImage image, HasOrientation model) {
        this.image = image;
        this.model = model;
    }

    @Override
    public void draw(Graphics g) {
        if (image != null && model != null) {
            // Hämtar position direkt från Orientation via HasOrientation
            int x = (int) Math.round(model.getX());
            int y = (int) Math.round(model.getY());

            g.drawImage(image, x, y, null);
        }
    }
}