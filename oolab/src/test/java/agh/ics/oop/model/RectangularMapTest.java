package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void canMoveTo() {
        RectangularMap testMap = new RectangularMap(5, 6);
        Animal blockAnimal = new Animal(new Vector2d(4, 3));
        testMap.place(blockAnimal);

        assertTrue(testMap.canMoveTo(new Vector2d(0, 0)));
        assertTrue(testMap.canMoveTo(new Vector2d(4, 5)));
        assertTrue(testMap.canMoveTo(new Vector2d(0, 5)));
        assertTrue(testMap.canMoveTo(new Vector2d(4, 0)));
        assertTrue(testMap.canMoveTo(new Vector2d(2, 3)));

        assertFalse(testMap.canMoveTo(new Vector2d(0, -1)));
        assertFalse(testMap.canMoveTo(new Vector2d(-1, 0)));
        assertFalse(testMap.canMoveTo(new Vector2d(-1, -1)));
        assertFalse(testMap.canMoveTo(new Vector2d(5, 6)));
        assertFalse(testMap.canMoveTo(new Vector2d(0, 6)));
        assertFalse(testMap.canMoveTo(new Vector2d(5, 0)));
        assertFalse(testMap.canMoveTo(new Vector2d(1, 6)));
        assertFalse(testMap.canMoveTo(new Vector2d(5, 3)));
        assertFalse(testMap.canMoveTo(new Vector2d(4, 3)));
    }

    @Test
    void place() {
        RectangularMap testMap = new RectangularMap(5, 5);
        Animal blockAnimal = new Animal(new Vector2d(4, 3));

        Animal myAnimal0 = new Animal(new Vector2d(1, 2));
        Animal myAnimal1 = new Animal(new Vector2d(4, 4));
        Animal myAnimal2 = new Animal(new Vector2d(-2, 1));
        Animal myAnimal3 = new Animal(new Vector2d(3, 5));
        Animal myAnimal4 = new Animal(new Vector2d(4, 3));

        testMap.place(blockAnimal);

        assertTrue(testMap.place(myAnimal0));
        assertTrue(testMap.place(myAnimal1));
        assertFalse(testMap.place(myAnimal2));
        assertFalse(testMap.place(myAnimal3));
        assertFalse(testMap.place(myAnimal4));

        testMap.move(blockAnimal, MoveDirection.BACKWARD);
        assertFalse(testMap.place(blockAnimal));

    }

    @Test
    void move() {
        RectangularMap testMap = new RectangularMap(4, 3);

        Animal myAnimal0 = new Animal(new Vector2d(3, 2));
        testMap.place(myAnimal0);

        System.out.println(testMap);

        testMap.move(myAnimal0, MoveDirection.FORWARD);  // no move
        System.out.println(testMap);

        testMap.move(myAnimal0, MoveDirection.BACKWARD);
        System.out.println(testMap);

        testMap.move(myAnimal0, MoveDirection.LEFT);
        System.out.println(testMap);

        testMap.move(myAnimal0, MoveDirection.BACKWARD);  // no move
        System.out.println(testMap);

        testMap.move(myAnimal0, MoveDirection.FORWARD);
        System.out.println(testMap);


        assertEquals(myAnimal0, testMap.objectAt(new Vector2d(2,1)));


    }

    @Test
    void isOccupied() {
        RectangularMap testMap = new RectangularMap(5, 5);
        Animal blockAnimal = new Animal(new Vector2d(3, 1));

        testMap.place(blockAnimal);

        assertTrue(testMap.isOccupied(new Vector2d(3, 1)));

        assertFalse(testMap.isOccupied(new Vector2d(3, 0)));
        assertFalse(testMap.isOccupied(new Vector2d(4, 0)));
        assertFalse(testMap.isOccupied(new Vector2d(4, 1)));
        assertFalse(testMap.isOccupied(new Vector2d(4, 2)));
        assertFalse(testMap.isOccupied(new Vector2d(3, 2)));
        assertFalse(testMap.isOccupied(new Vector2d(2, 2)));
        assertFalse(testMap.isOccupied(new Vector2d(2, 1)));
        assertFalse(testMap.isOccupied(new Vector2d(2, 0)));

        assertFalse(testMap.isOccupied(new Vector2d(-1, 0)));
        assertFalse(testMap.isOccupied(new Vector2d(0, 5)));
        assertFalse(testMap.isOccupied(new Vector2d(-1, 6)));

    }

    @Test
    void objectAt() {
        RectangularMap testMap = new RectangularMap(5, 5);
        Animal myAnimal0 = new Animal(new Vector2d(3, 1));
        Animal myAnimal1 = new Animal(new Vector2d(0, 2));
        Animal myAnimal2 = new Animal(new Vector2d(4, 3));
        Animal myAnimal3 = new Animal(new Vector2d(3, 1));

        testMap.place(myAnimal0);
        testMap.place(myAnimal1);
        testMap.place(myAnimal2);
        testMap.place(myAnimal3);

        assertEquals(myAnimal0, testMap.objectAt(new Vector2d(3, 1)));
        assertEquals(myAnimal1, testMap.objectAt(new Vector2d(0, 2)));
        assertEquals(myAnimal2, testMap.objectAt(new Vector2d(4, 3)));

        assertNotEquals(myAnimal3, testMap.objectAt(new Vector2d(3, 1)));
    }

    @Test
    void testToString() {
        // 0
        RectangularMap testMap0 = new RectangularMap(4, 4);
        Animal myAnimal00 = new Animal(new Vector2d(2,2));
        Animal myAnimal01 = new Animal(new Vector2d(2,1));
        testMap0.place(myAnimal00);
        testMap0.place(myAnimal01);
        testMap0.move(myAnimal00, MoveDirection.LEFT);
        testMap0.move(myAnimal01, MoveDirection.FORWARD);
        testMap0.move(myAnimal00, MoveDirection.FORWARD);
        String expOut0 = """
                 y\\x  0 1 2 3
                  4: ---------
                  3: | | | | |
                  2: | |<| | |
                  1: | | |^| |
                  0: | | | | |
                 -1: ---------
                """;
        // Dealing with different newline characters
        expOut0 = expOut0.replaceAll("\n", "").replaceAll("\r", "");
        String actualOut0 = testMap0.toString().replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(expOut0, actualOut0);

        // 1
        RectangularMap testMap1 = new RectangularMap(5, 5);
        List<Vector2d> startPos = List.of(
                new Vector2d(2,2),
                new Vector2d(0,0),
                new Vector2d(4,4),
                new Vector2d(3,1)
        );
        String[] moves1 = {
                "f", "f", "f", "f",
                "r", "r", "r", "r",
                "b", "b", "b", "b"
        };
        Simulation testSim = new Simulation(startPos, OptionsParser.parse(moves1), testMap1);
        testSim.run();
        String expOut1 = """
                 y\\x  0 1 2 3 4
                  5: -----------
                  4: | | | |>| |
                  3: | |>| | | |
                  2: | | |>| | |
                  1: |>| | | | |
                  0: | | | | | |
                 -1: -----------
                """;
        expOut1 = expOut1.replaceAll("\n", "").replaceAll("\r", "");
        String actualOut1 = testMap1.toString().replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(expOut1, actualOut1);
    }
}