package io.tripled.elevator;

import java.util.stream.Stream;

public enum Floor {
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

    public Floor goUp() {
        return Floor.bySequence(this.sequence + 1);
    }
}
