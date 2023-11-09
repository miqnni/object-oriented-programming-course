package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] parse(String[] sarr) {
        MoveDirection[] mdarr;

        int new_len = 0;

        for (String s: sarr) {
            if (s.equals("f") || s.equals("r") || s.equals("b") || s.equals("l")) new_len++;
        }

        mdarr = new MoveDirection [new_len];

        int i = 0;
        for (String s: sarr) {
            switch (s) {
                case "f" -> mdarr[i] = MoveDirection.FORWARD;
                case "r" -> mdarr[i] = MoveDirection.RIGHT;
                case "b" -> mdarr[i] = MoveDirection.BACKWARD;
                case "l" -> mdarr[i] = MoveDirection.LEFT;
                default -> i--;
            }
            i++;
        }
        return mdarr;
    }
}
