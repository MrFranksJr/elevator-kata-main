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

    public void call(Floor targetFloor) {

        do {
            currentFloor = currentFloor.goUp();
            feedback.floorPassed(currentFloor);
        } while (targetFloor != currentFloor);

        feedback.doorOpened(this.currentFloor);
    }

}
