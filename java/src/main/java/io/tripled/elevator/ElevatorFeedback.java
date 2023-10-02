package io.tripled.elevator;

public interface ElevatorFeedback {
    void doorOpened(Floor floor);

    void floorPassed(Floor floor);
}
