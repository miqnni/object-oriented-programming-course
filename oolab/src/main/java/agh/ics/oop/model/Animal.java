package agh.ics.oop.model;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.MapDirection;

import java.util.Map;

public class Animal {
    private MapDirection orientation;
    private Vector2d location;

    // Boundaries
    private static final int MIN_X = 0;
    private static final int MAX_X = 4;
    private static final int MIN_Y = 0;
    private static final int MAX_Y = 4;

    public Animal(Vector2d location) {
        this.orientation = MapDirection.NORTH;
        this.location = location;
    }

    public Animal() {
        this(new Vector2d (2,2));
    }

    public String toString() {
        return location.toString() + " " + orientation.toString();
    }

    public boolean isAt(Vector2d position) {
        return position.equals(location);
    }

    public Vector2d getLocation() {
        return location;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public boolean validateLocation(Vector2d locationToCheck) {
        return (MIN_X <= locationToCheck.getX()
                && locationToCheck.getX() <= MAX_X
                && MIN_Y <= locationToCheck.getY()
                && locationToCheck.getY() <= MAX_Y);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> orientation = MapDirection.next(orientation);
            case LEFT -> orientation = MapDirection.previous(orientation);
            case FORWARD, BACKWARD -> {
                Vector2d toAdd = MapDirection.toUnitVector(orientation);

                if (direction == MoveDirection.BACKWARD) {
                    toAdd = toAdd.opposite();
                }

                Vector2d newLocation = location.add(toAdd);
                if (validateLocation(newLocation)) {
                    location = newLocation;
                }
            }
        }
    }

}
