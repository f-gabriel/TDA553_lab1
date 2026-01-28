import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Saab95Test {

    Saab95 saab = new Saab95();


    @BeforeEach
    void setUp() {

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
        saab.gas(0.1);
        //test
        saab.gas(95);
        //test (ska vara samma som 0)
        saab.gas(1);
        //test ska vara >0.1
    }

    @Test
    void brake() {
    }
}