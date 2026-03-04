package Model;

import Cars.*;
import GameObjects.GameObjects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Model {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new Model.TimerListener());

    private final List<ModelListener> listeners = new ArrayList<>();
    private GameObjects gameObjects;


    public Model(GameObjects gameObjects) {
        this.gameObjects = gameObjects;
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : gameObjects.getCarObjects()) {

                if(car_at_edge(car)){
                        notifyAtEdge(car);




                }
                int x = (int) Math.round(car.getX()); // todo ta bort
                int y = (int) Math.round(car.getY());
                //System.out.println(x+ ","+y);

                notifyListeners();

            }
        }
    }
    public void startSimulation() {
        // Start the timer
        this.timer.start();
    }

    public void addListener(ModelListener l){
        listeners.add(l);
    }

    protected void notifyListeners(){
        for(ModelListener l : listeners){
            l.actOnModelUpdate();
        }
    }

    boolean car_at_edge(Car car){
        int low_edge = 0;
        int high_edge = 700; //CarView sätter fönstret till 800
        int carX = (int) Math.round(car.getX());
        int carY = (int) Math.round(car.getY());
        int carSpeed = (int) Math.round(car.getCurrentSpeed());
        boolean at_edge = (carX + carSpeed < low_edge) || (carY + carSpeed < low_edge);
        at_edge = at_edge || (carX + carSpeed > high_edge) || (carY + carSpeed > high_edge);
        return at_edge;


//        int low_edge = 0;
//        int high_edge = 700; //CarView sätter fönstret till 800
//        boolean at_edge = (x < low_edge) || (y < low_edge);
//        at_edge = at_edge || (x > high_edge) || (y > high_edge);
//        return at_edge;
    }

    // Just nu använder funktionen obskyra nummer, som "typ råkar funka" behöver fixas sedan
    // funktionen fungerar också endast för höger/vänster just nu och ser inte jättesnygg ut
    void notifyAtEdge(Car car){
        for(ModelListener l : listeners){
            l.actOnAtEndOfScreen(car);
        }


//        car.stopEngine();
//
//        car.turnLeft();
//        car.turnLeft();
//        if(car.getX() > 700){
//            car.setPosition(699, car.getY());
//        }else{car.setPosition(1, car.getY());}
//        car.startEngine();
//        car.gas(1);

    }


    }



