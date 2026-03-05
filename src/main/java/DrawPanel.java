import Cars.HasOrientation;
import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;
import Mechanic.VolvoMechanic;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel{

    private final List<DrawObject> drawables = new ArrayList<>();
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

    public DrawObject createDrawObject(HasOrientation model) throws IOException {
        DrawObject object;
        if(model instanceof Saab95){
            object = (DrawObject) new DrawSaab95((Saab95) model);
        } else if (model instanceof Volvo240) {
            object = (DrawObject) new DrawVolvo240((Volvo240) model);
        } else if (model instanceof Scania) {
            object = (DrawObject) new DrawScania((Scania) model);
        } else {
            object = (DrawObject) new DrawVolvoMechanic((VolvoMechanic) model);
        }

        return object;
    }


    public JPanel getPanel() {
        return panel;
    }
    public void addDrawable(DrawObject drawable) {
        drawables.add(drawable);
        panel.repaint();
    }

    public void resetDrawables(){
        drawables.clear();
    }

    public void removeDrawable(HasOrientation gameObject) {
        for(DrawObject drawable : drawables){
            if (drawable.model.equals(gameObject)){
                drawables.remove(drawable);
                panel.repaint();
                break;
            }
        }
    }
    public List<DrawObject> getDrawables() {
        return drawables;
    }
    protected void paintComponent(Graphics g) {
        for (DrawAble drawable : drawables) {
            drawable.draw(g);
        }
    }

    }