import Cars.Saab95;
import Cars.Scania;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawSaab95 extends DrawObject<Saab95>{
    static BufferedImage image;
    static {
        try {
            image = ImageIO.read(DrawVolvo240.class.getResourceAsStream("pics/Saab95.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DrawSaab95(Saab95 model) throws IOException {
        super(image, model);
    }

    public Saab95 getDrawModel(){
        return this.model; //Saab95.createSaab95(model);
    }

    @Override
    public DrawObject createDrawObject(Saab95 model, BufferedImage image) throws IOException {
        return new DrawSaab95(model);
    }
}
