package io.tripled.elevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFeedback implements Feedback {

    private Floor floor;
    private List<Floor> passedFloors = new ArrayList<>();

    @Override
    public void doorOpened(Floor floor){
        this.floor = floor;
    }

    @Override
    public void floorPassed(Floor floor) {
        passedFloors.add(floor);
    }

    public Floor lastFloorDoorsOpened() {
        return floor;
    }

    public List<Floor> allFloorsPassed() {
        return passedFloors;
    }
}
