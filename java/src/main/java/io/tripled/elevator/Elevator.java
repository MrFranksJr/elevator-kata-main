package io.tripled.elevator;

public class Elevator {

    private final ElevatorFeedback elevatorFeedback;
    private Floor currentFloor = Floor.GROUND;

    public Elevator(ElevatorFeedback elevatorFeedback) {
        this.elevatorFeedback = elevatorFeedback;
    }

    public Floor currentFloor() {
        return currentFloor;
    }

    public void call(Floor origin, Floor target) {
        moveTo(origin);
        moveTo(target);
    }

    private void moveTo(Floor target) {
        while (currentFloor.notReached(target)) {
            currentFloor = currentFloor.move(target);
            elevatorFeedback.floorPassed(currentFloor);

            if (currentFloor.reached(target)){
                elevatorFeedback.doorOpened(this.currentFloor);
            }
        }
    }

}
