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
                case "f" -> mdList.add(MoveDirection.FORWARD);
                case "r" -> mdList.add(MoveDirection.RIGHT);
                case "b" -> mdList.add(MoveDirection.BACKWARD);
                case "l" -> mdList.add(MoveDirection.LEFT);
            }
        }
        return mdList;
    }
}
