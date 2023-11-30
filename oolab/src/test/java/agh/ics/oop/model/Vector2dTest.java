package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        Vector2d p1 = new Vector2d(1, 1);
        Vector2d p2 = new Vector2d(98, -4);
        Vector2d p3 = new Vector2d(-1248, 0);
        Vector2d p4 = new Vector2d(0, 0);

        String s1 = "(1,1)";
        String w1a = "(1, 1)";
        String w1b = "(1,1";
        String w1c = "1,1)";
        String w1d = "1, 1";
        String w1e = "(1,2)";
        String w1f = "1,1";

        String s2 = "(98,-4)";
        String w2a = "(98, -4)";
        String w2b = "98,-4";
        String w2c = "(98,4)";

        String s3 = "(-1248,0)";
        String w3a = "(1248,0)";
        String w3b = "-1248,0";

        String s4 = "(0,0)";
        String w4a = "0,0";


        assertEquals(s1, p1.toString());
        assertNotEquals(w1a, p1.toString());
        assertNotEquals(w1b, p1.toString());
        assertNotEquals(w1c, p1.toString());
        assertNotEquals(w1d, p1.toString());
        assertNotEquals(w1e, p1.toString());
        assertNotEquals(w1f, p1.toString());

        assertEquals(s2, p2.toString());
        assertNotEquals(s2, w2a.toString());
        assertNotEquals(s2, w2b.toString());
        assertNotEquals(s2, w2c.toString());

        assertEquals(s3, p3.toString());
        assertNotEquals(w3a, p3.toString());
        assertNotEquals(w3b, p3.toString());

        assertEquals(s4, p4.toString());
        assertNotEquals(w4a, p4.toString());
    }

    @Test
    void precedes() {
        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(10, 10);
        Vector2d p2 = new Vector2d(0, 10);
        Vector2d p3 = new Vector2d(10, 0);
        Vector2d p4 = new Vector2d(10, 10);
        Vector2d p5 = new Vector2d(-10, 10);

        // basic
        assertTrue(p0.precedes(p1));
        assertFalse(p1.precedes(p0));

        // incomparable
        assertFalse(p0.precedes(p5));
        assertFalse(p5.precedes(p0));
        assertFalse(p2.precedes(p3));
        assertFalse(p3.precedes(p2));

        // other
        assertTrue(p0.precedes(p2));
        assertTrue(p0.precedes(p3));
        assertTrue(p1.precedes(p4));
        assertTrue(p2.precedes(p4));
        assertTrue(p3.precedes(p4));
        assertFalse(p3.precedes(p5));
        assertFalse(p1.precedes(p5));
        assertFalse(p1.precedes(p2));
        assertFalse(p1.precedes(p3));

        assertTrue(p0.precedes(p0));
        assertTrue(p5.precedes(p5));
    }

    @Test
    void follows() {
        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(10, 10);
        Vector2d p2 = new Vector2d(0, 10);
        Vector2d p3 = new Vector2d(10, 0);
        Vector2d p4 = new Vector2d(10, 10);
        Vector2d p5 = new Vector2d(-10, 10);

        // basic
        assertTrue(p1.follows(p0));
        assertFalse(p0.follows(p1));

        // incomparable
        assertFalse(p0.follows(p5));
        assertFalse(p5.follows(p0));
        assertFalse(p2.follows(p3));
        assertFalse(p3.follows(p2));

        // equal
        assertTrue(p4.follows(p1));
        assertTrue(p1.follows(p4));

        // other
        assertTrue(p2.follows(p0));
        assertTrue(p3.follows(p0));
        assertTrue(p1.follows(p5));
        assertTrue(p2.follows(p5));
        assertFalse(p3.follows(p1));
        assertFalse(p5.follows(p1));

        assertTrue(p0.follows(p0));
        assertTrue(p5.follows(p5));

    }

    @Test
    void add() {
        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(1, 1);
        Vector2d p2 = new Vector2d(2, 3);
        Vector2d p3 = new Vector2d(123, -10);

        Vector2d p0a1 = new Vector2d(1, 1);
        Vector2d p2a0 = new Vector2d(2, 3);
        Vector2d p1a2 = new Vector2d(3, 4);
        Vector2d p3a2 = new Vector2d(125, -7);
        Vector2d p2a3 = new Vector2d(125, -7);
        Vector2d p3a3 = new Vector2d(246, -20);

        assertEquals(p0a1, p0.add(p1));
        assertEquals(p2a0, p2.add(p0));
        assertEquals(p1a2, p1.add(p2));
        assertEquals(p3a2, p3.add(p2));
        assertEquals(p2a3, p2.add(p3));
        assertEquals(p3a3, p3.add(p3));
    }

    @Test
    void subtract() {
        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(1, 1);
        Vector2d p2 = new Vector2d(2, 3);
        Vector2d p3 = new Vector2d(123, -10);

        Vector2d p0s1 = new Vector2d(-1, -1);
        Vector2d p1s0 = new Vector2d(1, 1);
        Vector2d p2s1 = new Vector2d(1, 2);
        Vector2d p1s2 = new Vector2d(-1, -2);
        Vector2d p3s2 = new Vector2d(121, -13);
        Vector2d p0s0 = new Vector2d(0, 0);
        Vector2d p3s3 = new Vector2d(0, 0);

        assertEquals(p0s1, p0.subtract(p1));
        assertEquals(p1s0, p1.subtract(p0));
        assertEquals(p2s1, p2.subtract(p1));
        assertEquals(p1s2, p1.subtract(p2));
        assertEquals(p3s2, p3.subtract(p2));
        assertEquals(p0s0, p0.subtract(p0));
        assertEquals(p3s3, p3.subtract(p3));

    }

    @Test
    void upperRight() {
        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(1, 1);
        Vector2d p2 = new Vector2d(2, 3);
        Vector2d p3 = new Vector2d(123, -10);
        Vector2d p4 = new Vector2d(-400, 2);

        Vector2d p0u1 = new Vector2d(1, 1);
        Vector2d p0u2 = new Vector2d(2, 3);
        Vector2d p0u3 = new Vector2d(123, 0);
        Vector2d p0u0 = new Vector2d(0, 0);
        Vector2d p3u3 = new Vector2d(123, -10);
        Vector2d p1u2 = new Vector2d(2, 3);
        Vector2d p2u3 = new Vector2d(123, 3);
        Vector2d p3u2 = new Vector2d(123, 3);
        Vector2d p3u4 = new Vector2d(123, 2);
        Vector2d p4u2 = new Vector2d(2, 3);
        Vector2d p4u1 = new Vector2d(1, 2);
        Vector2d p4u0 = new Vector2d(0, 2);

        assertEquals(p0u1, p0.upperRight(p1));
        assertEquals(p0u2, p0.upperRight(p2));
        assertEquals(p0u3, p0.upperRight(p3));
        assertEquals(p0u0, p0.upperRight(p0));
        assertEquals(p3u3, p3.upperRight(p3));
        assertEquals(p1u2, p1.upperRight(p2));
        assertEquals(p2u3, p2.upperRight(p3));
        assertEquals(p3u2, p3.upperRight(p2));
        assertEquals(p3u4, p3.upperRight(p4));
        assertEquals(p4u2, p4.upperRight(p2));
        assertEquals(p4u1, p4.upperRight(p1));
        assertEquals(p4u0, p4.upperRight(p0));

        assertNotEquals(p3u4, p4.lowerLeft(p1));
    }

    @Test
    void lowerLeft() {
        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(1, 1);
        Vector2d p2 = new Vector2d(2, 3);
        Vector2d p3 = new Vector2d(123, -10);
        Vector2d p4 = new Vector2d(-400, 2);

        Vector2d p0l1 = new Vector2d(0, 0);
        Vector2d p0l2 = new Vector2d(0, 0);
        Vector2d p0l3 = new Vector2d(0, -10);
        Vector2d p3l0 = new Vector2d(0, -10);
        Vector2d p0l4 = new Vector2d(-400, 0);
        Vector2d p1l2 = new Vector2d(1, 1);
        Vector2d p2l3 = new Vector2d(2, -10);
        Vector2d p2l4 = new Vector2d(-400, 2);
        Vector2d p3l4 = new Vector2d(-400, -10);
        Vector2d p1l4 = new Vector2d(-400, 1);
        Vector2d p3l3 = new Vector2d(123, -10);
        Vector2d p0l0 = new Vector2d(0, 0);

        assertEquals(p0l1, p0.lowerLeft(p1));
        assertEquals(p0l2, p0.lowerLeft(p2));
        assertEquals(p0l3, p0.lowerLeft(p3));
        assertEquals(p3l0, p3.lowerLeft(p0));
        assertEquals(p0l4, p0.lowerLeft(p4));
        assertEquals(p1l2, p1.lowerLeft(p2));
        assertEquals(p2l3, p2.lowerLeft(p3));
        assertEquals(p2l4, p2.lowerLeft(p4));
        assertEquals(p3l4, p3.lowerLeft(p4));
        assertEquals(p1l4, p1.lowerLeft(p4));
        assertEquals(p3l3, p3.lowerLeft(p3));
        assertEquals(p0l0, p0.lowerLeft(p0));

        assertNotEquals(p3l0, p1.lowerLeft(p4));
    }

    @Test
    void opposite() {
        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(1, 1);
        Vector2d p2 = new Vector2d(2, 3);
        Vector2d p3 = new Vector2d(123, -10);
        Vector2d p4 = new Vector2d(-400, 2);

        Vector2d p0x = new Vector2d(0, 0);
        Vector2d p1x = new Vector2d(-1, -1);
        Vector2d p2x = new Vector2d(-2, -3);
        Vector2d p3x = new Vector2d(-123, 10);
        Vector2d p4x = new Vector2d(400, -2);

        assertEquals(p0x, p0.opposite());
        assertEquals(p1x, p1.opposite());
        assertEquals(p2x, p2.opposite());
        assertEquals(p3x, p3.opposite());
        assertEquals(p4x, p4.opposite());

        assertNotEquals(p3x, p4.opposite());
    }

    @Test
    void testEquals() {
        Vector2d p1 = new Vector2d(-1, 1);
        Vector2d p2 = new Vector2d(-1, 1);
        Vector2d p3 = new Vector2d(2, 1);
        FakeClass pf = new FakeClass(-1, "ala");


        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
        assertFalse(p1.equals(pf));
    }
}
