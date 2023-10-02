package io.tripled.elevator;

import java.util.stream.Stream;

public enum Floor {
    BASEMENT(-1),

    GROUND(0),
    FLOOR_1(1),
    FLOOR_2(2),
    FLOOR_3(3);

    private final int sequence;

    Floor(int sequence) {
        this.sequence = sequence;
    }

    private static Floor bySequence(int i) {
        return Stream.of(values())
                .filter(it -> it.sequence == i)
                .findFirst()
                .orElse(null);
    }

    public Floor move(Floor target) {
        return shouldDecend(target) ? down() : up();
    }

    private Floor up() {
        return Floor.bySequence(this.sequence + 1);
    }

    private Floor down() {
        return Floor.bySequence(this.sequence - 1);
    }

    private boolean shouldDecend(Floor target) {
        return this.sequence > target.sequence;
    }

    boolean reached(Floor currentFloor) {
        return this == currentFloor;
    }

    boolean notReached(Floor currentFloor) {
        return this != currentFloor;
    }
}
