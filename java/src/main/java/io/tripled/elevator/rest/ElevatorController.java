package io.tripled.elevator.rest;

import io.tripled.elevator.Elevator;
import io.tripled.elevator.ElevatorFeedback;
import io.tripled.elevator.Floor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ElevatorController {

    private static final List<Floor> floorsPassed = new ArrayList<>();
    private static final List<Floor> doorsOpened = new ArrayList<>();

    private Elevator elevator = new Elevator(new ElevatorFeedback() {
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

    @PutMapping("/api/elevator")
    GetResponse moveElevator(@RequestBody ChangeFloorRequest request) {
        elevator.call(request.originFloor, request.targetFloor);
        return new GetResponse(elevator.currentFloor(), doorsOpened, floorsPassed);
    }
    public record ChangeFloorRequest(Floor originFloor, Floor targetFloor) { }

}
