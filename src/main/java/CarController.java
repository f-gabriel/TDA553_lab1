import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

// todo: se gas() / brake()
// todo framtid: förslag: CarController är enda klassen som interagerar direkt med bilarna.
//  den ska inte instansiera en CarView
public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    // todo framtid: Denna ska inte vara här!!
    VolvoMechanic volvoMechanic = new VolvoMechanic(15, 300, 0, "north");
    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        // todo: vill vi ändra orienteringen på bilarna så att de inte kör rakt ner?
        // (uppdatering: tog mig friheten att göra detta. Har även uppdaterat volvo
        // och saab klasserna så att det går att instansiera med endast orientering)
        cc.cars.add(new Volvo240(0, 0, "east"));
        cc.cars.add(new Saab95(0, 100, "east"));
        cc.cars.add(new Scania(0, 200, "east"));

        // todo: fixa så att det går att hitta specifika bilar utan att veta dess nummer i listan
        // Dessa kan nu tas bort, men vi behöver fortfarande fixa problemet med att hitta bilarna.
        cc.cars.get(0).setPosition(0, 0);
        cc.cars.get(1).setPosition(0, 100);
        cc.cars.get(2).setPosition(0, 200);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    // todo: behöver även stoppa bilarna när de når kanten (kanske måste göras från CarView?)
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

                  if (car_at_mechanic(oldX, oldY, x, y)){
                      if (car instanceof  Volvo240) {
                          carMechanicLoad((Volvo240) car);
                          x = (int) Math.round(car.getX());
                          y = (int) Math.round(car.getY());
                      }
                  }

                frame.drawPanel.moveIt(car, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100; // behöver vara 1 eller 0. Kan också omimplementera funktionerna i Car

        /// för testning
        gas = amount;
        if (amount != 0) {gas = 1;}
        ///

        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100; // se gas()

        /// för testning
        brake = amount;
        if (amount != 0) {brake = 1;}
        ///
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    void turboOn() {
        for (Car car : cars) {
            if (car instanceof  Saab95) {
                ((Saab95) car).setTurboOn();
            }
            }
        }
    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }
    void liftBed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                if (car.getCurrentSpeed() == 0) { //
                    ((Scania) car).raise();
                    }
                }
            }
        }
    void lowerBed() {
        for (Car car : cars) {
        if (car instanceof  Scania){
        if (car.getCurrentSpeed() == 0) {
        ((Scania) car).lower();
                    }
                }
            }
        }
    void startEngine(){
        for (Car car : cars) {
            car.startEngine();
            }
        }
    void stopEngine(){
        for (Car car : cars) {
            car.stopEngine();
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


    // En dummy-metod i framtiden kommer den iterera över en lista av carMechanics, så som bilmetoderna fungerar
    boolean car_at_mechanic(int oldX, int oldY, int x, int y){
        int mechanicX = (int) Math.round(volvoMechanic.getX());
        int mechanicY = (int) Math.round(volvoMechanic.getY());
        boolean atMechanic;

        atMechanic = x == mechanicX;
        atMechanic = atMechanic || (oldX < mechanicX && mechanicX < x) && y == mechanicY; // om oldX < mechX < x -> bilen har passerat
        atMechanic = atMechanic || (oldX > mechanicX && mechanicX > x) && y == mechanicY; // 'atMechanic ||' ser till att den fortsätter vara True
        atMechanic = atMechanic || (oldY < mechanicY && mechanicY < y) && x == mechanicX; // 'x == mechanicX' kollar att de ligger på samma linje
        atMechanic = atMechanic || (oldY > mechanicY && mechanicY > y) && x == mechanicX;
        return atMechanic;
    }
    void carMechanicLoad(Volvo240 car){
        double outsideOfScreen = 801;
        car.setPosition(outsideOfScreen,outsideOfScreen);
        volvoMechanic.load(car);
    }



    }





