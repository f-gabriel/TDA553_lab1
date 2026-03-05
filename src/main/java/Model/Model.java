package Model;

import Cars.*;
import GameObjects.GameObjects;
import Mechanic.CarMechanic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

                if(car_at_edge(car)){notifyAtEdge(car);}

                test_if_car_at_mechanic(car);

                try {    // try: pga lång lista av metoder som till sist mynnar ut i DrawObject med underklasser
                    notifyListeners();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public void startSimulation() {this.timer.start();} // Start the timer

    public void addListener(ModelListener l){listeners.add(l);}

    protected void notifyListeners() throws IOException {for(ModelListener l : listeners){l.actOnModelUpdate();}}
    void notifyAtEdge(Car car){for(ModelListener l : listeners){l.actOnAtEndOfScreen(car);}}

    boolean car_at_edge(Car car){
        int low_edge = 0;
        int high_edge;
        if(car.getCurrentDirection().getCoordinate() == 'x'){high_edge = 680;}
        else {high_edge = 500;}
        int carX = (int) Math.round(car.getX());
        int carY = (int) Math.round(car.getY());
        int carSpeed = (int) Math.round(car.getCurrentSpeed());
        boolean at_edge = (carX + carSpeed < low_edge) || (carY + carSpeed < low_edge);
        at_edge = at_edge || (carX + carSpeed > high_edge) || (carY + carSpeed > high_edge);
        return at_edge;
    }



    private void test_if_car_at_mechanic(Car car) {
        int carX = (int) Math.round(car.getX());
        int carY = (int) Math.round(car.getY());
        int speed = (int) Math.round(car.getCurrentSpeed());
        DIRECTIONS direction = car.getCurrentDirection();
        boolean atMechanic = false;

        for (CarMechanic mechanic : gameObjects.getMechanicObjects()) {
            if(atMechanic){break;}

            int mechanicX = (int) Math.round(mechanic.getX());
            int mechanicY = (int) Math.round(mechanic.getY());

            if(direction.getCoordinate() == 'x'){
                int nextCarX = carX + (5 * speed * direction.getPosOrNegMultiplier()); // 5 multiplier to make sure the check doesn't miss
                boolean onTrajectory =  numberInBoundsOfLowerAndHigher(carY, mechanicY - 75, mechanicY + 75);
                boolean withinBounds = numberInBoundsOfLowerAndHigher(mechanicX, carX, nextCarX)
                                        || numberInBoundsOfLowerAndHigher(mechanicX, nextCarX, carX);

                atMechanic = onTrajectory && withinBounds;
                }
            else{
                int nextCarY = carY + (5 * speed * direction.getPosOrNegMultiplier());
                boolean onTrajectory = mechanicX == carX;
                boolean withinBounds = numberInBoundsOfLowerAndHigher(mechanicY, carY, nextCarY)
                                        || numberInBoundsOfLowerAndHigher(mechanicY, nextCarY, carY);

                atMechanic = onTrajectory && withinBounds;
                }
            if (atMechanic && car instanceof Volvo240){
                notifyAtMechanic(car, mechanic);
            }
        }
    }

    private void notifyAtMechanic(Car car, CarMechanic mechanic) {
        //double outsideOfScreen = 801;
        //car.setPosition(outsideOfScreen, outsideOfScreen);
        for(ModelListener l : listeners){l.actOnAtMechanic(car, mechanic);}
    }

    private boolean numberInBoundsOfLowerAndHigher(int number, int lower, int higher) {
        return number >= lower && number <= higher;
    }
}



