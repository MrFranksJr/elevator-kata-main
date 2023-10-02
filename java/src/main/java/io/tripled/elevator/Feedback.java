package io.tripled.elevator;

public interface Feedback {
    void doorOpened(Floor floor);

    void floorPassed(Floor floor);
}
