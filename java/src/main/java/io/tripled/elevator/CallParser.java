package io.tripled.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.tripled.elevator.FloorParser.FLOOR_PARSER;
import static java.util.Optional.empty;
import static java.util.Optional.of;

public enum CallParser {
    CALL_PARSER;


    public Optional<ElevatorCall> parse(String input) {
        if (inputChecker(input)) {
            final String[] splitTokens = input.split("-");
            return of(createCall(splitTokens));
        } else
            return empty();
    }


    private static ElevatorCall createCall(String[] splitTokens) {
        final String origin = splitTokens[0];
        final String destination = splitTokens[1];
        return new ElevatorCall(FLOOR_PARSER.toNumber(origin), FLOOR_PARSER.toNumber(destination));
    }

    private boolean inputChecker(String input) {
        String pattern = "^[bg123]-[bg123]$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        return matcher.matches();
    }
    
}