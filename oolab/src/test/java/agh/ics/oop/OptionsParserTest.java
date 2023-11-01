package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parse() {
        String[] in1 = new String[] {"f", "b", "l", "r", "r", "f", "f", "b"};
        MoveDirection[] out1 = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.BACKWARD};

        String[] in2 = new String[]{"f", "f", "s", "l", "b", "alabama", "r"};
        MoveDirection[] out2 = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.RIGHT};

        String[] in3 = new String[]{"d", "f", "b", "s", "l", "l", "alabama", "r", "k", "f", "u"};
        MoveDirection[] out3 = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.FORWARD};

        assertArrayEquals(out1, OptionsParser.parse(in1));
        assertArrayEquals(out2, OptionsParser.parse(in2));
        assertArrayEquals(out3, OptionsParser.parse(in3));
        assertFalse(Arrays.equals(out3, OptionsParser.parse(in1)));
    }
}
