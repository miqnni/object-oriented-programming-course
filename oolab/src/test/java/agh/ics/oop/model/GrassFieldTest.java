package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {



    @Test
    void canMoveTo() {
        GrassField testGrassField = new GrassField(0);
        Animal a1 = new Animal();
        Animal a2 = new Animal(new Vector2d(40,3));
        testGrassField.place(a1);
        testGrassField.place(a2);
        testGrassField.move(a1, MoveDirection.BACKWARD);
        testGrassField.placeGrass(new Grass(new Vector2d(1,1)));
        assertTrue(testGrassField.canMoveTo(new Vector2d(0,0)));
        assertTrue(testGrassField.canMoveTo(new Vector2d(1,1)));
        assertFalse(testGrassField.canMoveTo(new Vector2d(2,1)));
        assertFalse(testGrassField.canMoveTo(new Vector2d(40,3)));
        assertFalse(testGrassField.canMoveTo(new Vector2d(-1,0)));
    }

    @Test
    void place() {
        GrassField testGrassField = new GrassField(0);
        Animal a1 = new Animal();
        Animal a2 = new Animal(new Vector2d(2,2));
        Animal a3 = new Animal(new Vector2d(3,2));
        assertTrue(testGrassField.place(a1));
        assertFalse(testGrassField.place(a2));
        assertTrue(testGrassField.place(a3));
    }

    @Test
    void placeGrass() {
        GrassField testGrassField = new GrassField(0);
        Grass g1 = new Grass(new Vector2d(2,2));
        Grass g2 = new Grass(new Vector2d(2,2));
        Grass g3 = new Grass(new Vector2d(3,2));
        assertTrue(testGrassField.placeGrass(g1));
        assertFalse(testGrassField.placeGrass(g2));
        assertTrue(testGrassField.placeGrass(g3));
    }

    @Test
    void move() {
        GrassField testGrassField = new GrassField(0);
        Animal a1 = new Animal();
        testGrassField.place(a1);
        testGrassField.placeGrass(new Grass(new Vector2d(1,2)));
        testGrassField.move(a1, MoveDirection.RIGHT);
        testGrassField.move(a1, MoveDirection.BACKWARD);
        assertEquals(a1, testGrassField.objectAt(new Vector2d(1,2)));
        Animal a2 = new Animal();
        testGrassField.place(a2);
        testGrassField.move(a2, MoveDirection.LEFT);
        testGrassField.move(a2, MoveDirection.FORWARD);
        assertEquals(a2, testGrassField.objectAt(new Vector2d(2,2)));
    }

    @Test
    void isOccupied() {
        GrassField testGrassField = new GrassField(0);
        Animal a1 = new Animal();
        testGrassField.place(a1);
        Animal a2 = new Animal(new Vector2d(3,3));
        testGrassField.place(a2);
        testGrassField.placeGrass(new Grass(new Vector2d(1,1)));
        testGrassField.placeGrass(new Grass(new Vector2d(3,3)));
        assertTrue(testGrassField.isOccupied(new Vector2d(2,2)));
        assertTrue(testGrassField.isOccupied(new Vector2d(3,3)));
        assertTrue(testGrassField.isOccupied(new Vector2d(1,1)));
        assertFalse(testGrassField.isOccupied(new Vector2d(0,0)));
    }

    @Test
    void objectAt() {
        GrassField testGrassField = new GrassField(0);
        Animal a1 = new Animal();
        testGrassField.place(a1);
        Animal a2 = new Animal(new Vector2d(3,3));
        testGrassField.place(a2);
        Grass g1 = new Grass(new Vector2d(1, 1));
        Grass g2 = new Grass(new Vector2d(3, 3));
        testGrassField.placeGrass(g1);
        testGrassField.placeGrass(g2);

        assertEquals(a1, testGrassField.objectAt(new Vector2d(2,2)));
        assertEquals(a2, testGrassField.objectAt(new Vector2d(3,3)));
        assertEquals(g1, testGrassField.objectAt(new Vector2d(1,1)));
        assertNotEquals(g2, testGrassField.objectAt(new Vector2d(3,3))); // because animals have priority
        assertNotEquals(g2, testGrassField.objectAt(new Vector2d(2,2)));
    }

    @Test
    void testToString() {
        GrassField testGrassField = new GrassField(0);
        Animal a1 = new Animal();
        testGrassField.place(a1);
        testGrassField.move(a1,MoveDirection.LEFT);
        Animal a2 = new Animal(new Vector2d(3,3));
        testGrassField.place(a2);
        testGrassField.move(a2,MoveDirection.RIGHT);
        testGrassField.move(a2,MoveDirection.FORWARD);
        Grass g1 = new Grass(new Vector2d(1, 1));
        Grass g2 = new Grass(new Vector2d(3, 3));
        Grass g3 = new Grass(new Vector2d(4, 3));
        testGrassField.placeGrass(g1);
        testGrassField.placeGrass(g2);
        testGrassField.placeGrass(g3);

        String expOut1 = """
                 y\\x  0 1 2 3 4
                  4: -----------
                  3: | | | |*|>|
                  2: | | |<| | |
                  1: | |*| | | |
                  0: | | | | | |
                 -1: -----------
                """;

        expOut1 = expOut1.replaceAll("\n", "").replaceAll("\r", "");
        String actualOut1 = testGrassField.toString().replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(expOut1, actualOut1);


        GrassField testGrassField2 = new GrassField(0);
        Grass g21 = new Grass(new Vector2d(4, 4));
        Grass g22 = new Grass(new Vector2d(2, 3));
        Grass g23 = new Grass(new Vector2d(5, 6));
        Grass g24 = new Grass(new Vector2d(1, 5));
        Grass g25 = new Grass(new Vector2d(7, 4));
        testGrassField2.placeGrass(g21);
        testGrassField2.placeGrass(g22);
        testGrassField2.placeGrass(g23);
        testGrassField2.placeGrass(g24);
        testGrassField2.placeGrass(g25);
        Animal a21 = new Animal();
        Animal a22 = new Animal(new Vector2d(40,5));
        testGrassField2.place(a21);
        testGrassField2.place(a22);
        testGrassField2.move(a21, MoveDirection.FORWARD);
        testGrassField2.move(a22, MoveDirection.LEFT);


        String expOut2 = """
                 y\\x  0 1 2 3 4 5 6 7 8 910111213141516171819202122232425262728293031323334353637383940
                  7: -----------------------------------------------------------------------------------
                  6: | | | | | |*| | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |
                  5: | |*| | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |<|
                  4: | | | | |*| | |*| | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |
                  3: | | |^| | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |
                  2: | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |
                  1: | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |
                  0: | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |
                 -1: -----------------------------------------------------------------------------------\
                """;

        expOut2 = expOut2.replaceAll("\n", "").replaceAll("\r", "");
        String actualOut2 = testGrassField2.toString().replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(expOut2, actualOut2);

    }
}
