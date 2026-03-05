import Cars.Scania;
import Cars.Volvo240;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawScania extends DrawObject<Scania> {
    static BufferedImage image;

    static {
        try {
            image = ImageIO.read(DrawScania.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DrawScania(Scania model) throws IOException {
        super(image, model);
    }

    public Scania getDrawModel(){
        return  this.model; //Scania.createScania(model);
    }

    @Override
    public DrawObject createDrawObject(Scania model, BufferedImage image) throws IOException {
        return new DrawScania( model);
    }
}
