package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnimalTest {

    @Test
    void move() {

        // No move; isAt; simple moves
        Animal a0 = new Animal();
        RectangularMap m0 = new RectangularMap(5, 5);

        assertEquals(new Vector2d(2, 2), a0.getPosition());
        assertTrue(a0.isAt(new Vector2d(2, 2)));
        assertEquals(MapDirection.NORTH, a0.getOrientation());

        List<MoveDirection> dir0 = new ArrayList<>();
        dir0.add(MoveDirection.FORWARD);
        dir0.add(MoveDirection.RIGHT);
        dir0.add(MoveDirection.BACKWARD);

        for (MoveDirection d : dir0) {
            a0.move(d, m0);
        }

        assertTrue(a0.isAt(new Vector2d(1, 3)));
        assertEquals(MapDirection.EAST, a0.getOrientation());


        // A full set of tests
        int testCount = 16;
        Vector2d[] testInLoc = new Vector2d[]{
                // basic moves
                new Vector2d(2, 2),
                new Vector2d(2, 2),
                new Vector2d(2, 2),
                new Vector2d(2, 2),

                // not leaving the map v1
                new Vector2d(4, 4),
                new Vector2d(4, 4),
                new Vector2d(4, 4),
                new Vector2d(4, 4),

                // not leaving the map v2
                new Vector2d(0, 0),
                new Vector2d(0, 0),
                new Vector2d(0, 0),
                new Vector2d(0, 0),

                // other tests
                new Vector2d(2, 2),
                new Vector2d(1, 1),
                new Vector2d(4, 3),
                new Vector2d(1, 1)
        };
        String[][] testInMove = new String[][]{
                new String[]{"f"},
                new String[]{"b"},
                new String[]{"l"},
                new String[]{"r"},

                new String[]{"f"},
                new String[]{"r", "f"},
                new String[]{"l", "b"},
                new String[]{"r", "r", "b"},

                new String[]{"b"},
                new String[]{"r", "b"},
                new String[]{"l", "f"},
                new String[]{"l", "l", "f"},

//                new String[]{},
//                new String[]{"p", "f", "l", "R", "", "alabama", "f", "s"},
                new String[]{"f", "b"},
                new String[]{"f", "l", "f"},

                new String[]{"r", "f", "r", "f", "f", "l", "b",
                        "l", "f", "b", "b", "b", "b", "r", "r",
                        "r", "f", "f", "l", "f", "b"},

                new String[]{"r", "f", "f", "l", "f", "f", "l",
                        "f", "f", "l", "f", "r", "b"}
        };

        Vector2d[] testOutLoc = new Vector2d[]{
                new Vector2d(2, 3),
                new Vector2d(2, 1),
                new Vector2d(2, 2),
                new Vector2d(2, 2),

                new Vector2d(4, 4),
                new Vector2d(4, 4),
                new Vector2d(4, 4),
                new Vector2d(4, 4),

                new Vector2d(0, 0),
                new Vector2d(0, 0),
                new Vector2d(0, 0),
                new Vector2d(0, 0),

                new Vector2d(2, 2),
                new Vector2d(0, 2),
                new Vector2d(1, 1),
                new Vector2d(2, 2)
        };

        MapDirection[] testOutOri = new MapDirection[]{
                MapDirection.NORTH,
                MapDirection.NORTH,
                MapDirection.WEST,
                MapDirection.EAST,

                MapDirection.NORTH,
                MapDirection.EAST,
                MapDirection.WEST,
                MapDirection.SOUTH,

                MapDirection.NORTH,
                MapDirection.EAST,
                MapDirection.WEST,
                MapDirection.SOUTH,

                MapDirection.NORTH,
                MapDirection.WEST,
                MapDirection.SOUTH,
                MapDirection.WEST,
        };

        for (int i = 0; i < testCount; i++) {
            Animal testAnimal = new Animal(testInLoc[i]);
            List<MoveDirection> testDir = OptionsParser.parse(testInMove[i]);
            RectangularMap testMap = new RectangularMap(5,5);
            for (MoveDirection d : testDir) {
                testAnimal.move(d, testMap);
            }
            assertEquals(testOutLoc[i], testAnimal.getPosition());
            assertEquals(testOutOri[i], testAnimal.getOrientation());
        }

    }
}