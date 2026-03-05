import Cars.Saab95;
import Cars.Volvo240;
import Mechanic.VolvoMechanic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawVolvoMechanic extends DrawObject<VolvoMechanic>{
    static BufferedImage image;

    static {
        try {
            image = ImageIO.read(DrawVolvo240.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DrawVolvoMechanic(VolvoMechanic model) throws IOException {
        super(image, model);
    }

    public VolvoMechanic getDrawModel(){
        return  this.model; //VolvoMechanic.createVolvoMechanic(model);
    }

    @Override
    public DrawObject createDrawObject(VolvoMechanic model, BufferedImage image) throws IOException {
        return new DrawVolvoMechanic(model);
    }
}
