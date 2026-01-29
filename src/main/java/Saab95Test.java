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
    void move() {

    }

    @Test
    void turnLeft() {

    }

    @Test
    void turnRight() {
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
        saab.gas(95);
        assertEquals(0.1, saab.getCurrentSpeed());
        System.out.println(saab.getCurrentSpeed());
    }

    @Test
    void gas3(){
        saab.startEngine();
        saab.gas(1);
        assertNotEquals(0.1, saab.getCurrentSpeed(), 0.0);
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
}