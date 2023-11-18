package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;


    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.getX() >= 0
                && position.getX() <= width - 1
                && position.getY() >= 0
                && position.getY() <= height - 1
                && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPos = animal.getLocation();
        if (canMoveTo(animalPos)) {
            animals.put(animalPos, animal);
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d currPos = animal.getLocation();
        animal.move(direction, this);
        Vector2d nextPos = animal.getLocation();
        if (!currPos.equals(nextPos)) {
            animals.remove(currPos);
            animals.put(nextPos, animal);
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString() {
        MapVisualizer toVisualize = new MapVisualizer(this);
        return toVisualize.draw(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));

    }
}
