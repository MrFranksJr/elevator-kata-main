package io.tripled.elevator;

public class ElevatorController {
    private int currentFloor = 0;
    public void handleCall(ElevatorCall call) {
        //Go to callOrigin
        moveLift(currentFloor, call.callOrigin());
        //open doors
        doorsOpen(currentFloor);
        //Go to callDestination
        moveLift(currentFloor, call.callDestination());
        //open doors
        doorsOpen(currentFloor);
    }

    public int getCurrentElevatorFloor() { return currentFloor; }

    private void moveLift(int currentPos, int destinationPos) {
        do {
            if (isGoingUp(currentPos, destinationPos)) { currentFloor++; }
            else if (isGoingDown(currentPos, destinationPos)) { currentFloor--; }
            liftStatusUpdate(currentFloor);
        } while (currentFloor != destinationPos);
    }

    private static boolean isGoingUp(int currentPos, int destinationPos) { return currentPos < destinationPos; }
    private static boolean isGoingDown(int currentPos, int destinationPos) { return currentPos > destinationPos; }

    private static void liftStatusUpdate(int currentPos) {
        System.out.println("Elevator at " + FloorParser.FLOOR_PARSER.toText(currentPos));
    }

    private static void doorsOpen(int currentPos) {
        System.out.println("<DING> - door open at " + FloorParser.FLOOR_PARSER.toText(currentPos));
    }
}
