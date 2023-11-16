package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private Map<Vector2d, Animal> animals = new HashMap<>();
    private int width;
    private int height;
//    private Animal ;


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
        if (direction == MoveDirection.LEFT || direction == MoveDirection.RIGHT) {
            animal.move(direction);
        } else {
            Vector2d toAdd = MapDirection.toUnitVector(animal.getOrientation());
            if (direction == MoveDirection.BACKWARD) {
                toAdd = toAdd.opposite();
            }
            Vector2d currPos = animal.getLocation();
            Vector2d nextPos = currPos.add(toAdd);
            if (canMoveTo(nextPos)) {
                animal.move(direction);
                animals.remove(currPos);
                animals.put(nextPos, animal);
            }

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
        MapVisualizer toVisualize = new MapVisualizer((WorldMap) animals);
        return toVisualize.draw(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));

    }
}
