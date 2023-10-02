package io.tripled.elevator.rest;

import io.tripled.elevator.Elevator;
import io.tripled.elevator.Feedback;
import io.tripled.elevator.Floor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ElevatorController {

    private static final List<Floor> floorsPassed = new ArrayList<>();
    private static final List<Floor> doorsOpened = new ArrayList<>();

    private Elevator elevator = new Elevator(new Feedback() {
        @Override
        public void doorOpened(Floor floor) {
            doorsOpened.add(floor);
        }

        @Override
        public void floorPassed(Floor floor) {
            floorsPassed.add(floor);
        }
    });

    @GetMapping("/api/elevator")
    GetResponse getCurrentFloor() {
        return new GetResponse(elevator.currentFloor(), doorsOpened, floorsPassed);
    }
    public record GetResponse(Floor currentFloor, List<Floor> doorsOpened, List<Floor> floorsPassed) {


    }
}
