import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    Saab95 saab = new Saab95();
    Volvo240 volvo = new Volvo240();

    @BeforeEach
    void setUp() {
        saab.stopEngine(); // återställer currentSpeed
        saab.orientation.setCurrentDirection(Orientation.Directions.NORTH); // återställer currentDirection
        saab.orientation.setPosition(0,0); // återställer position
        volvo.stopEngine(); // återställer currentSpeed
        volvo.orientation.setCurrentDirection(Orientation.Directions.NORTH); // återställer currentDirection
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
    void CheckTurnLeft() {
        var newDirection = Orientation.Directions.WEST;
        saab.turnLeft();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.SOUTH;
        saab.turnLeft();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.EAST;
        saab.turnLeft();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.NORTH;
        saab.turnLeft();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.WEST;
        volvo.turnLeft();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.SOUTH;
        volvo.turnLeft();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.EAST;
        volvo.turnLeft();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.NORTH;
        volvo.turnLeft();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());
    }

    @Test
    void CheckTurnRight() {
        var newDirection = Orientation.Directions.EAST;
        saab.turnRight();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.SOUTH;
        saab.turnRight();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.WEST;
        saab.turnRight();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.NORTH;
        saab.turnRight();
        assertEquals(newDirection, saab.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.EAST;
        volvo.turnRight();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.SOUTH;
        volvo.turnRight();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.WEST;
        volvo.turnRight();
        assertEquals(newDirection,volvo.orientation.getCurrentDirection());

        newDirection = Orientation.Directions.NORTH;
        volvo.turnRight();
        assertEquals(newDirection, volvo.orientation.getCurrentDirection());
    }




}