package io.tripled.elevator;

import static io.tripled.elevator.Floor.*;

public class Elevator {

    private final Feedback feedback;
    private Floor currentFloor = Floor.GROUND;

    public Elevator(Feedback feedback) {
        this.feedback = feedback;
    }

    public Floor currentFloor() {
        return currentFloor;
    }

    public void call(Floor floor) {
        this.currentFloor = floor;
        feedback.floorPassed(FLOOR_1);
        feedback.floorPassed(FLOOR_2);
        feedback.floorPassed(FLOOR_3);
        feedback.doorOpened(this.currentFloor);
    }

}
