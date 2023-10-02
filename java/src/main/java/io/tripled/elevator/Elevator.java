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

    public void call(Floor targetFloor) {
        call(targetFloor, targetFloor);
    }

    public void call(Floor origin, Floor target) {
        moveTo(origin);
        moveTo(target);
    }

    private void moveTo(Floor origin) {
        while (currentFloor.notReached(origin)) {
            currentFloor = currentFloor.goUp();
            feedback.floorPassed(currentFloor);

            if (currentFloor.reached(origin)){
                feedback.doorOpened(this.currentFloor);
            }
        }
    }

}
