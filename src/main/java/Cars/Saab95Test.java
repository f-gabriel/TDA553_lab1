package Cars;
import Mechanic.SaabMechanic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    Saab95 saab = Saab95.CreateSaab95();
    Volvo240 volvo = Volvo240.CreateVolvo240();

    @BeforeEach
    void setUp() {
        saab.stopEngine(); // återställer currentSpeed
        saab.orientation.setCurrentDirection(DIRECTIONS.NORTH); // återställer currentDirection
        saab.orientation.setPosition(0,0); // återställer position
        volvo.stopEngine(); // återställer currentSpeed
        volvo.orientation.setCurrentDirection(DIRECTIONS.NORTH); // återställer currentDirection
        volvo.orientation.setPosition(0,0); // återställer position
    }
//    @AfterEach
//    void tearDown() {}

//    @Test
//    void checkCurrentSpeedRange(){
//        saab.decrementSpeed(10); // värde spelar ingen roll, bara det inte är negativt
//        assertEquals(0, saab.getCurrentSpeed());
//
//        saab.incrementSpeed(200); // amount > 100
//        assertEquals(saab.enginePower, saab.getCurrentSpeed());
//    }

    @Test
    void checkSpeedZeroBeforeStarted() {
        assertEquals(0, saab.getCurrentSpeed());
        assertEquals(0, volvo.getCurrentSpeed());
    }

    @Test
    void checkGasZero() {
        saab.startEngine();
        double saabOldSpeed = saab.getCurrentSpeed();
        saab.gas(0);
        assertEquals(saabOldSpeed, saab.getCurrentSpeed());
        System.out.println(saab.getCurrentSpeed());

        volvo.startEngine();
        double volvoOldSpeed = volvo.getCurrentSpeed();
        volvo.gas(0);
        assertEquals(volvoOldSpeed, volvo.getCurrentSpeed());
        System.out.println(volvo.getCurrentSpeed());
    }
    @Test
    void checkGasNotOneOrZero(){
        saab.startEngine();
        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(-1);
        assertEquals(oldSpeed, saab.getCurrentSpeed());
        System.out.println(saab.getCurrentSpeed());

        volvo.startEngine();
        oldSpeed = volvo.getCurrentSpeed();
        volvo.gas(-1);
        assertEquals(oldSpeed, volvo.getCurrentSpeed());
        System.out.println(volvo.getCurrentSpeed());
    }

    @Test
    void checkGasOne(){
        saab.startEngine();
        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(1);
        assertNotEquals(oldSpeed, saab.getCurrentSpeed(), 0.0);
        System.out.println(saab.getCurrentSpeed());

        volvo.startEngine();
        oldSpeed = volvo.getCurrentSpeed();
        volvo.gas(1);
        assertNotEquals(oldSpeed, volvo.getCurrentSpeed(), 0.0);
        System.out.println(volvo.getCurrentSpeed());
    }

    @Test
    void checkBrake() {
        saab.startEngine(); // currentSpeed = 0.1

        saab.brake(0);
        assertEquals(0.1, saab.getCurrentSpeed());
        saab.brake(-1);
        assertEquals(0.1, saab.getCurrentSpeed());
        saab.brake(1);
        assertEquals(0.0, saab.getCurrentSpeed());

        volvo.startEngine(); // currentSpeed = 0.1

        volvo.brake(0);
        assertEquals(0.1, volvo.getCurrentSpeed());
        volvo.brake(-1);
        assertEquals(0.1, volvo.getCurrentSpeed());
        volvo.brake(1);
        assertEquals(0.0, volvo.getCurrentSpeed());
    }

    @Test
    void checkMove() {
        saab.startEngine();
        saab.gas(2);

        // currentDirection = NORTH => move() ska ändra y-koordinaten
        double oldY = saab.orientation.getY();
        saab.move();
        assertNotEquals(oldY, saab.orientation.getY());

        saab.turnLeft();
        double oldX = saab.orientation.getX();
        saab.move();
        assertNotEquals(oldX, saab.orientation.getX());

        saab.turnLeft();
        oldY = saab.orientation.getY();
        saab.move();
        assertNotEquals(oldY, saab.orientation.getY());

        saab.turnLeft();
        oldX = saab.orientation.getX();
        saab.move();
        assertNotEquals(oldX, saab.orientation.getX());

        volvo.startEngine();
        volvo.gas(2);

        // currentDirection = NORTH => move() ska ändra y-koordinaten
        oldY = volvo.orientation.getY();
        volvo.move();
        assertNotEquals(oldY, volvo.orientation.getY());

        volvo.turnLeft();
        oldX = volvo.orientation.getX();
        volvo.move();
        assertNotEquals(oldX,volvo.orientation.getX());

        volvo.turnLeft();
        oldY = volvo.orientation.getY();
        volvo.move();
        assertNotEquals(oldY, volvo.orientation.getY());

        volvo.turnLeft();
        oldX = volvo.orientation.getX();
        volvo.move();
        assertNotEquals(oldX, volvo.orientation.getX());
    }

    @Test
    void checkMoveSimple(){
        double startX = saab.getX();
        double startY = saab.getY();
        double startSpeed = saab.getCurrentSpeed();
        saab.startEngine();
        saab.gas(1);
        //double beforeMoveX = saab.getX();
        double beforeMoveY = saab.getY();
        double beforeMoveSpeed = saab.getCurrentSpeed();


        // saab ska inte ha rört sig innan move()
        //assertEquals(startX, beforeMoveX);
        assertEquals(startY, beforeMoveY);
        // Ska ändå ha annan hastighet
        assertNotEquals(startSpeed, beforeMoveSpeed);

        saab.move();
        double afterFirstMoveX = saab.getX();
        double afterFirstMoveY = saab.getY();
        double afterFirstMoveSpeed = saab.getCurrentSpeed();

        // Ska nu ha rört sig
        //assertNotEquals(beforeMoveX, afterFirstMoveX);
        assertNotEquals(beforeMoveY, afterFirstMoveY);
        // speed ska vara samma
        assertEquals(beforeMoveSpeed, afterFirstMoveSpeed);

        saab.stopEngine();
        double afterStopX = saab.getX();
        double afterStopY = saab.getY();
        double afterStopSpeed = saab.getCurrentSpeed();

        // x och y ska vara samma, speed ska vara ändrad
        //assertEquals(afterFirstMoveX, afterStopX);
        assertEquals(afterFirstMoveY, afterStopY);
        assertEquals(0, afterStopSpeed);

        saab.move();
        double afterLastMoveX = saab.getX();
        double afterLastMoveY = saab.getY();
        double afterLastMoveSpeed = saab.getCurrentSpeed();

        // alla ska vara samma som förut
        //assertEquals(afterStopX, afterLastMoveX);
        assertEquals(afterStopY, afterLastMoveY);
        assertEquals(afterStopSpeed, afterLastMoveSpeed);

    }

    @Test
    void CheckTurnLeft() {
        var newDirection = DIRECTIONS.WEST;
        saab.turnLeft();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.SOUTH;
        saab.turnLeft();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.EAST;
        saab.turnLeft();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.NORTH;
        saab.turnLeft();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.WEST;
        volvo.turnLeft();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.SOUTH;
        volvo.turnLeft();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.EAST;
        volvo.turnLeft();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.NORTH;
        volvo.turnLeft();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());
    }

    @Test
    void CheckTurnRight() {
        var newDirection = DIRECTIONS.EAST;
        saab.turnRight();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.SOUTH;
        saab.turnRight();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.WEST;
        saab.turnRight();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.NORTH;
        saab.turnRight();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.EAST;
        volvo.turnRight();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.SOUTH;
        volvo.turnRight();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.WEST;
        volvo.turnRight();
        assertEquals(newDirection,volvo.orientation.getCurrentDirection());

        newDirection = DIRECTIONS.NORTH;
        volvo.turnRight();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());
    }

    //Test för lab 2:
//    @Test
//    void checkCarTransporterLoad(){
//        VolvoFM460CarTransport carTransport = new VolvoFM460CarTransport();
//        Saab95 saab2 = new Saab95(Color.BLACK, 10, 10, "north");
//        Volvo240 volvo2 = new Volvo240(Color.BLACK, 0.1, 0.1, "north");
//        carTransport.lower();
//        carTransport.load(saab2);
//        carTransport.load(volvo2);
//
//        assertEquals(1, carTransport.getCargo().toArray().length);
//    }
//    @Test
//    void checkCarTransporterMove(){
//        VolvoFM460CarTransport carTransport = new VolvoFM460CarTransport();
//        Saab95 saab2 = new Saab95(Color.BLACK, 0.1, 0.1, "north");
//
//        carTransport.lower();
//        carTransport.load(saab2);
//
//        double original_x_saab = saab2.getX();
//        double original_y_saab = saab2.getY();
//
//        carTransport.raise();
//        carTransport.gas(1);
//        carTransport.move();
//
//        double x_after_move_saab = saab2.getX();
//        double y_after_move_saab = saab2.getY();
//
//        assertNotEquals(original_x_saab, x_after_move_saab);
//        assertNotEquals(original_y_saab, y_after_move_saab);
//
//        assertEquals(carTransport.getX(), x_after_move_saab);
//        assertEquals(carTransport.getY(), y_after_move_saab);
//    }
//    @Test
//    void checkCarTransporterUnload(){
//        VolvoFM460CarTransport carTransport = new VolvoFM460CarTransport();
//        Saab95 saab2 = new Saab95(Color.BLACK, 0, 0, "north");
//        Volvo240 volvo2 = new Volvo240(Color.BLACK, 0, 0, "north");
//
//        carTransport.lower();
//        carTransport.load(saab2);
//        carTransport.load(volvo2);
//
//        PersonalVehicle car = carTransport.unLoad();
//        assertEquals("Cars.Volvo240", car.getModelName());
//        car = carTransport.unLoad();
//        assertEquals("Cars.Saab95", car.getModelName());
//
//        assertNotEquals(0, car.getY());
//    }
//
//    @Test
//    void checkWrongObjectInCarTransport(){
//        VolvoFM460CarTransport transport = new VolvoFM460CarTransport();
//        VolvoFM460CarTransport cargo = new VolvoFM460CarTransport();
//        Saab95 saab = new Saab95();
//        transport.lower();
//
//        for (int i = 0; i != 10; i++){
//            transport.load(saab);
//        }
//        int listLength = transport.getCargo().toArray().length;
//        System.out.println(listLength);
//        assertEquals(8, listLength);
//    }
//
//    @Test
//    void checkSaabInVolvoMechanic(){
//        VolvoFM460CarTransport carTransport = new VolvoFM460CarTransport();
//    SaabMechanic mechanic = new SaabMechanic(1, 0,0,"north");
//    Volvo240 volvo3 = new Volvo240();
//    //mechanic.load(carTransport);
//        }

    @Test
    void checkScania(){
        Scania scania = Scania.CreateScania();
        double oldY = scania.getY();
        scania.gas(1);
        scania.move();
        assertNotEquals(oldY, scania.getY());

        scania.stopEngine();
        oldY = scania.getY();
        scania.raise();
        scania.gas(1);
        scania.move();
        assertEquals(oldY, scania.getY());
        }



}