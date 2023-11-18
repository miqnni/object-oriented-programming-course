package agh.ics.oop.model;

public class Animal {
    private MapDirection orientation;
    private Vector2d location;

    // Boundaries

    public Animal(Vector2d location) {
        this.orientation = MapDirection.NORTH;
        this.location = location;
    }

    public Animal() {
        this(new Vector2d (2,2));
    }

    public String toString() {
//        return location.toString() + " " + orientation.toString();
        return switch(orientation) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
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

    public void move(MoveDirection direction, MoveValidator mValid) {
        switch (direction) {
            case RIGHT -> orientation = MapDirection.next(orientation);
            case LEFT -> orientation = MapDirection.previous(orientation);
            case FORWARD, BACKWARD -> {
                Vector2d toAdd = MapDirection.toUnitVector(orientation);

                if (direction == MoveDirection.BACKWARD) {
                    toAdd = toAdd.opposite();
                }

                Vector2d newLocation = location.add(toAdd);
                if (mValid.canMoveTo(newLocation)) {
                    location = newLocation;
                }
            }
        }
    }

}
