import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel {

    private final List<DrawAble> drawables = new ArrayList<>();
    private final JPanel panel;

    public DrawPanel(int width, int height) {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                DrawPanel.this.paintComponent(g); // kallar på paint
            }
        };
        panel.setDoubleBuffered(true);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setBackground(Color.green);
    }
    public JPanel getPanel() {
        return panel;
    }
    public void addDrawable(DrawAble drawable) {
        drawables.add(drawable);
        panel.repaint();
    }
    public void removeDrawable(DrawAble drawable) {
        drawables.remove(drawable);
        panel.repaint();
    }
    public List<DrawAble> getDrawables() {
        return drawables;
    }
    protected void paintComponent(Graphics g) {
        for (DrawAble drawable : drawables) {
            drawable.draw(g);
        }
    }
}