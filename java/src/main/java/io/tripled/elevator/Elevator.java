package io.tripled.elevator;

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
        feedback.doorOpened(this.currentFloor);
    }

}
