import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Cars.HasOrientation;
import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;
import Mechanic.VolvoMechanic;

import javax.imageio.ImageIO;

public class DrawObject implements DrawAble {

    private static BufferedImage image;  // bilden som ska ritas
    private HasOrientation model; // modellen (Car, Truck, Mechanic)

    private DrawObject(BufferedImage image, HasOrientation model) {
        this.image = image;
        this.model = model;
    }

    public static DrawObject createDrawObject(Saab95 model){
        try{
        image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
        } catch (IOException e) {throw new RuntimeException(e);}
        return new DrawObject(image, model);
    }
    public static DrawObject createDrawObject(Volvo240 model){
        try{
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException e) {throw new RuntimeException(e);}
        return new DrawObject(image, model);
    }
    public static DrawObject createDrawObject(Scania model){
        try{
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException e) {throw new RuntimeException(e);}
        return new DrawObject(image, model);
    }
    public static DrawObject createDrawObject(VolvoMechanic model){
        try{
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException e) {throw new RuntimeException(e);}
        return new DrawObject(image, model);
    }
    public static DrawObject createDrawObject(HasOrientation model){
        System.out.println("is here");
        return switch (model) {
            case Saab95 saab95 -> createDrawObject((Saab95) model);
            case Volvo240 volvo240 -> createDrawObject((Volvo240) model);
            case Scania scania -> createDrawObject((Scania) model);
            case VolvoMechanic volvoMechanic -> createDrawObject((VolvoMechanic) model);
            case null, default -> new DrawObject(null, null);
        };
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