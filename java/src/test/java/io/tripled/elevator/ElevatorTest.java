package io.tripled.elevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElevatorTest {

    @Test
    void newElevatorStartsAtGroundFloor() {
        var elevator = new Elevator();

        assertEquals(Level.GROUND, elevator.currentFloor());
    }

    
}
