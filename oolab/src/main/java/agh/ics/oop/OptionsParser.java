package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] sarr) {

        List<MoveDirection> mdList = new LinkedList<>();

        for (String s: sarr) {
            switch (s) {
                case "f", "forward" -> mdList.add(MoveDirection.FORWARD);
                case "r", "right" -> mdList.add(MoveDirection.RIGHT);
                case "b", "backward" -> mdList.add(MoveDirection.BACKWARD);
                case "l", "left" -> mdList.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(s + " is not legal move specification");
            }
        }
        return mdList;
    }
}
