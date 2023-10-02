package io.tripled.elevator;

public class TestFeedback implements Feedback {

    private Floor floor;

    @Override
    public void doorOpened(Floor floor){
        this.floor = floor;
    }

    public Floor lastFloorDoorsOpened() {
        return floor;
    }
}
