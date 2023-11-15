package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {

    @Test
    void next() {
        assertEquals(MapDirection.EAST, MapDirection.next(MapDirection.NORTH));
        assertEquals(MapDirection.NORTH, MapDirection.next(MapDirection.WEST));
        assertEquals(MapDirection.WEST, MapDirection.next(MapDirection.SOUTH));
        assertEquals(MapDirection.SOUTH, MapDirection.next(MapDirection.EAST));
    }

    @Test
    void previous() {
        assertEquals(MapDirection.EAST, MapDirection.previous(MapDirection.SOUTH));
        assertEquals(MapDirection.NORTH, MapDirection.previous(MapDirection.EAST));
        assertEquals(MapDirection.WEST, MapDirection.previous(MapDirection.NORTH));
        assertEquals(MapDirection.SOUTH, MapDirection.previous(MapDirection.WEST));
    }

}
