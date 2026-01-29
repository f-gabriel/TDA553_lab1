import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void gas() {

        saab.gas(0);
        assertEquals(0.1, saab.getCurrentSpeed());
        saab.gas(95);
        assertEquals(0.1, saab.getCurrentSpeed());
        saab.gas(1);
        //test ska vara >0.1
    }

    @Test
    void brake() {
    }
}