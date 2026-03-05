
import Cars.Saab95;
import Cars.Volvo240;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawVolvo240 extends DrawObject<Volvo240>{
    static BufferedImage image;

    static {
        try {
            image = ImageIO.read(DrawVolvo240.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DrawVolvo240(Volvo240 model) throws IOException {
        super(image, model);
    }
    public Volvo240 getDrawModel(){
        return  this.model; //Volvo240.createVolvo240(model);
    }

    @Override
    public DrawObject createDrawObject(Volvo240 model, BufferedImage image) throws IOException {
        return new DrawVolvo240(model);
    }
}
