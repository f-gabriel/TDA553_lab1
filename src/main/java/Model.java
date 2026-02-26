import Cars.Car;
import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Model {
    Model cc = new Model();
    ArrayList<Car> cars = new ArrayList<>();

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new Model.TimerListener());


    public void Model(){
    cc.cars.add(new Volvo240(0, 0, "east"));
    cc.cars.add(new Saab95(0, 100, "east"));
    cc.cars.add(new Scania(0, 200, "east"));

    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                // Detta är helt fukt. Om ni har en bättre idé får ni gärna göra ändringar
                // Vi behöver veta om bilen passerar carMechanic eftersom den så som det ser ut kan "hoppa över" den
                // vi behöver alltså position innan och efter move
                int oldX = (int) Math.round(car.getX());
                int oldY = (int) Math.round(car.getY());

                // todo notera: en brute-force lösning ska inte vara såhär i framtiden. Inkluderar alla hjälpmetoder
                //  metoden är här just nu för att det är här vi uppdaterar frame:t
                if(car_at_edge(oldX, oldY)){
                    turn_at_edge(car);
                }
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());


                // Start the timer
                cc.timer.start();
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
        car.stopEngine();

        car.turnLeft();
        car.turnLeft();
        if(car.getX() > 700){
            car.setPosition(699, car.getY());
        }else{car.setPosition(1, car.getY());}
        car.startEngine();
        car.gas(1);

    }



}

