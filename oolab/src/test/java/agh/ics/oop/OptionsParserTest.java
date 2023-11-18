package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parse() {
        String[] in1 = new String[] {"f", "b", "l", "r", "r", "f", "f", "b"};
        MoveDirection[] out1 = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.BACKWARD};
        List<MoveDirection> out1List = Arrays.asList(out1);

        String[] in2 = new String[]{"f", "f", "s", "l", "b", "alabama", "r"};
        MoveDirection[] out2 = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.RIGHT};
        List<MoveDirection> out2List = Arrays.asList(out2);

        String[] in3 = new String[]{"d", "f", "b", "s", "l", "l", "alabama", "r", "k", "f", "u"};
        MoveDirection[] out3 = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.FORWARD};
        List<MoveDirection> out3List = Arrays.asList(out3);


        assertEquals(out1List, OptionsParser.parse(in1));
        assertEquals(out2List, OptionsParser.parse(in2));
        assertEquals(out3List, OptionsParser.parse(in3));
        assertNotEquals(out3List, OptionsParser.parse(in1));
    }
}
