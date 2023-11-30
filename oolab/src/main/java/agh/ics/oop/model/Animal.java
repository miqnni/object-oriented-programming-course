package agh.ics.oop.model;

public class Animal implements WorldElement {
    private MapDirection orientation;
    private Vector2d position;

    public Animal(Vector2d position) {
        this.orientation = MapDirection.NORTH;
        this.position = position;
    }

    public Animal() {
        this(new Vector2d (2,2));
    }

    @Override
    public String toString() {
        return switch(orientation) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    public boolean isAt(Vector2d position) {
        return position.equals(this.position);
    }

    public Vector2d getPosition() {
        return position;
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

                Vector2d newLocation = position.add(toAdd);
                if (mValid.canMoveTo(newLocation)) {
                    position = newLocation;
                }
            }
        }
    }

}
