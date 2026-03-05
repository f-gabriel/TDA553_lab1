import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Cars.HasOrientation;
import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;
import Mechanic.VolvoMechanic;

import javax.imageio.ImageIO;

public class DrawObject<T extends HasOrientation>  implements DrawAble{

    protected BufferedImage image;  // bilden som ska ritas
    protected T model; // modellen (Car, Truck, Mechanic)

    public DrawObject(BufferedImage image, T model) {
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

    public DrawObject createDrawObject(T model, BufferedImage image) throws IOException
    {
        return new DrawObject(image, model);
        }
    }


