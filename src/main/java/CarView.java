import javax.swing.*;
import java.awt.*;
import Cars.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView {

    private static final int FrameSizeX = 800;
    private static final int FrameSizeY = 800;

    private final JFrame frame;
    private final Model gameModel;

    private final DrawPanel drawPanel = new DrawPanel(FrameSizeX, FrameSizeY - 240);
    private static final ControlPanel controlPanel = new ControlPanel();

    public CarView(String frameName, Model gameModel) {
        this.gameModel = gameModel;
        frame = new JFrame();
        initComponents(frameName);
    }

    private void initComponents(String title) {
        frame.setTitle(title);
        frame.setPreferredSize(new Dimension(FrameSizeX, FrameSizeY));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        frame.add(drawPanel.getPanel());
        frame.add(controlPanel);
        frame.pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2 - frame.getSize().width/2, dim.height/2 - frame.getSize().height/2);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addCar(Car car) {
        controlPanel.addCar(car);
    }

    public void draw(Car car, double x, double y) {
        drawPanel.moveIt(car, x, y);
        drawPanel.getPanel().repaint();
    }

    public JFrame getFrame() {
        return frame;
    }
}