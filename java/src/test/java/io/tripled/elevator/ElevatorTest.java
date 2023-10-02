package io.tripled.elevator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.tripled.elevator.Floor.*;
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
        assertEquals(GROUND, elevator.currentFloor());
    }

    @Test
    void elevatorCanTravelFromGroundTo3thFloor() {
        // When there is a call from floor3 (to go to basement)
        elevator.call(FLOOR_3);

        // Then the doors should open at floor3
        assertEquals(FLOOR_3, elevator.currentFloor());
        assertEquals(List.of(FLOOR_3), testFeedback.allFloorsWhereDoorsOpened());
        assertEquals(List.of(FLOOR_1, FLOOR_2, FLOOR_3), testFeedback.allFloorsPassed());
    }

    @Test
    void elevatorCanTravelToTheSecondFloor() {
        elevator.call(FLOOR_2);

        assertEquals(FLOOR_2, elevator.currentFloor());
        assertEquals(List.of(FLOOR_2), testFeedback.allFloorsWhereDoorsOpened());
        assertEquals(List.of(FLOOR_1, FLOOR_2), testFeedback.allFloorsPassed());
    }

    @Test
    void elevatorCanTravelFromGroundTo2ndFloorToGoTo3Th() {
        // When there is a call from floor3 to go to basement
        elevator.call(FLOOR_2, FLOOR_3);

        // Then the doors should open at floor3
        assertEquals(FLOOR_3, elevator.currentFloor());
        assertEquals(List.of(FLOOR_2, FLOOR_3), testFeedback.allFloorsWhereDoorsOpened());
        assertEquals(List.of(FLOOR_1, FLOOR_2, FLOOR_3), testFeedback.allFloorsPassed());
    }

    @Test
    void elevatorCanTravelFromThirdFloorToBasement() {
        elevator.call(FLOOR_3, BASEMENT);

        assertEquals(BASEMENT, elevator.currentFloor());
        assertEquals(List.of(FLOOR_3, BASEMENT), testFeedback.allFloorsWhereDoorsOpened());
        assertEquals(List.of(FLOOR_1, FLOOR_2, FLOOR_3, FLOOR_2, FLOOR_1, GROUND, BASEMENT), testFeedback.allFloorsPassed());
    }
}
