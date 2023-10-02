package io.tripled.elevator;

import java.util.ArrayList;
import java.util.List;

public class TestElevatorFeedback implements ElevatorFeedback {

    private List<Floor> openedDoors = new ArrayList<>();
    private List<Floor> passedFloors = new ArrayList<>();

    @Override
    public void doorOpened(Floor floor){
        this.openedDoors.add(floor);
    }

    @Override
    public void floorPassed(Floor floor) {
        passedFloors.add(floor);
    }

    public List<Floor> allFloorsWhereDoorsOpened() {
        return openedDoors;
    }

    public List<Floor> allFloorsPassed() {
        return passedFloors;
    }
}
