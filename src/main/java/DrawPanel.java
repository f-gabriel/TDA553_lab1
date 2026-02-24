import Cars.Car;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.


// TODO framtid: DrawPanel ska inte behöva känna till vad den ritar (dvs ta ut specifika bilar, verkstäder etc)
public class DrawPanel extends JPanel {

    BufferedImage volvoImage;
    Point volvoPoint = new Point(0, 0);

    BufferedImage saabImage;
    Point saabPoint = new Point(0, 100);

    BufferedImage scaniaImage;
    Point scaniaPoint = new Point(0, 200);

    BufferedImage volvoWorkshopImage; //todo: kanske vill sätta denna så att volvon kan köra in i den
    Point volvoWorkshopPoint = new Point(300, 0); // (har nu uppdaterat y positionen)

    public void moveIt(Car car, double x, double y) {
        car.setPosition(x, y);
        switch (car.getClass().getSimpleName()) {
            case "Cars.Volvo240":
                volvoPoint.x = (int) x;
                volvoPoint.y = (int) y;
                break;
            case "Cars.Saab95":
                saabPoint.x = (int) x;
                saabPoint.y = (int) y;
                break;
            case "Cars.Scania":
                scaniaPoint.x = (int) x;
                scaniaPoint.y = (int) y;
                break;
            default:
                System.out.println("Okänd biltyp: " + car.getClass().getSimpleName());
                break;
        }
        repaint();
    }

    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (volvoImage != null) g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        if (saabImage != null) g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        if (scaniaImage != null) g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
        if (volvoWorkshopImage != null)
            g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}