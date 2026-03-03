import Cars.*;
import Mechanic.VolvoMechanic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Model {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new Model.TimerListener());
    CarController carC;
    CarView frame;
    ArrayList<HasOrientation> gameObjects = new ArrayList<>(); // låter oss lägga in alla spelobjekt i listan
    MechanicController mechanicC = new MechanicController();

    public static void main(String[] args) {
        Model gm = new Model();
        // Start a new view and send a reference of self
        gm.carC = new CarController();

        gm.gameObjects.add(new Volvo240(0, 0, "east"));
        gm.gameObjects.add(new Saab95(0, 100, "east"));
        gm.gameObjects.add(new Scania(0, 200, "east"));
        gm.gameObjects.add(new VolvoMechanic(15, 300, 0, "north"));

        gm.frame = new CarView("CarSim 1.0", gm);

        gm.addCars();

        // Start the timer
        gm.timer.start();




    }

    private void addCars(){

        for (HasOrientation gameObject : gameObjects) {
            if(gameObject instanceof Car car){
                frame.addCar(car);
            }
        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (HasOrientation gameObject : gameObjects) {
                if(gameObject instanceof Car car){
                    // Detta är helt fukt. Om ni har en bättre idé får ni gärna göra ändringar
                    // Vi behöver veta om bilen passerar carMechanic eftersom den så som det ser ut kan "hoppa över" den
                    // vi behöver alltså position innan och efter move
                    int oldX = (int) Math.round(carC.getX(car));
                    int oldY = (int) Math.round(carC.getY(car));

                    // todo notera: en brute-force lösning ska inte vara såhär i framtiden. Inkluderar alla hjälpmetoder
                    //  metoden är här just nu för att det är här vi uppdaterar frame:t
                    if(car_at_edge(oldX, oldY)){
                        turn_at_edge(car);
                    }
                    carC.move(car);
                    int x = (int) Math.round(gameObject.getX());
                    int y = (int) Math.round(gameObject.getY());
                    frame.draw(car, x, y);

                }


                // todo: skapa uppdatering

            }
        }
    }

    boolean car_at_edge(int x, int y){
        int low_edge = 0;
        int high_edge = 700; //CarView sätter fönstret till 800
        boolean at_edge = (x < low_edge) || (y < low_edge);
        at_edge = at_edge || (x > high_edge) || (y > high_edge);
        return at_edge;
    }

    // Just nu använder funktionen obskyra nummer, som "typ råkar funka" behöver fixas sedan
    // funktionen fungerar också endast för höger/vänster just nu och ser inte jättesnygg ut
    void turn_at_edge(Car car){
        carC.stopEngine(car);

        carC.turnLeft(car);
        carC.turnLeft(car);
        if(carC.getX(car) > 700){
            carC.setPosition(699, carC.getY(car), car);
        }else{carC.setPosition(1, carC.getY(car), car);}
        carC.startEngine(car);
        carC.gas(1, car);

    }


    }

}

