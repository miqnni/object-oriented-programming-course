package agh.ics.oop.exceptions;

import agh.ics.oop.model.Vector2d;

public class PositionAlreadyOccupiedException extends Exception{
    public PositionAlreadyOccupiedException(Vector2d illegalPos) {
        super("Position " + illegalPos + " is already occupied");
    }
}
