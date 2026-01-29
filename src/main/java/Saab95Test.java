import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    Saab95 saab = new Saab95();

    //sätter currentSpeed till 0 innan varje test så att vi alltid vet vad vi utgår från.
    @BeforeEach
    void setUp() {
        saab.stopEngine();
    }


    @AfterEach
    void tearDown() {

    }

    @Test
    void checkSpeedZeroBeforeStarted() {
        assertEquals(0, saab.getCurrentSpeed());
    }

    @Test
    void gas1() {
        saab.startEngine();
        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(0);
        assertEquals(oldSpeed, saab.getCurrentSpeed());
        System.out.println(saab.getCurrentSpeed());
    }
    @Test
    void gas2(){
        saab.startEngine();
        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(95);
        assertEquals(oldSpeed, saab.getCurrentSpeed());
        System.out.println(saab.getCurrentSpeed());
    }

    @Test
    void gas3(){
        saab.startEngine();
        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(1);
        assertNotEquals(oldSpeed, saab.getCurrentSpeed(), 0.0);
        System.out.println(saab.getCurrentSpeed());
    }

    @Test
    void brake() {
        saab.startEngine(); // currentSpeed = 0.1

        saab.brake(0);
        assertEquals(0.1, saab.getCurrentSpeed());
        saab.brake(95);
        assertEquals(0.1, saab.getCurrentSpeed());
        saab.brake(1);
        assertEquals(0.0, saab.getCurrentSpeed());
    }

    @Test
    void move() {
        saab.startEngine();

        double oldY = saab.orientation.getY();
        saab.incrementSpeed(2);

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
    }

    @Test
    void turnLeft() {
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
    }

    @Test
    void turnRight() {
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
    }




}