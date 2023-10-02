package io.tripled.elevator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElevatorTest {

    private TestFeedback testFeedback;
    private Elevator elevator;

    @BeforeEach
    void setUp() {
        testFeedback = new TestFeedback();
        elevator = new Elevator(testFeedback);
    }

    @Test
    void newElevatorStartsAtGroundFloor() {
        assertEquals(Floor.GROUND, elevator.currentFloor());
    }

    @Test
    void elevatorCanTravelFromGroundTo3thFloor() {
        // When there is a call from floor3 to go to basement
        elevator.call(Floor.FLOOR_3);

        // Then the doors should open at floor3
        assertEquals(Floor.FLOOR_3, elevator.currentFloor());
        assertEquals(Floor.FLOOR_3, testFeedback.lastFloorDoorsOpened());
    }
}
