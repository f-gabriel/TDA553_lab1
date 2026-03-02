import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {

    private final List<DrawAble> drawables = new ArrayList<>();

    public DrawPanel(int width, int height) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.green);
    }

    public void addDrawable(DrawAble drawable) {
        drawables.add(drawable);
    }
    // Ta bort ett objekt
    public void removeDrawable(DrawAble drawable) {
        drawables.remove(drawable);
    }

    public List<DrawAble> getDrawables() {
        return drawables;
    }

    // rita ut de
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (DrawAble drawable : drawables) {
            drawable.draw(g);
        }
    }
}