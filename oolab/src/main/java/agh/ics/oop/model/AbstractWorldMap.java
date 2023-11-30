package agh.ics.oop.model;
import agh.ics.oop.exceptions.PositionAlreadyOccupiedException;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    private final List<MapChangeListener> observers = new LinkedList<>();

    public void addObserver(MapChangeListener newObserver) {
        observers.add(newObserver);
    }

    public void removeObserver(MapChangeListener toRemove) {
        observers.remove(toRemove);
    }

    public void mapChanged(String s) {
        for (MapChangeListener observer : observers)
            observer.mapChanged(this, s);
    }

    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        Vector2d animalPos = animal.getPosition();
        if (canMoveTo(animalPos)) {
            animals.put(animalPos, animal);
            mapChanged("Animal " + animal + " placed at " + animalPos + ".");
        }
        else throw new PositionAlreadyOccupiedException(animalPos);
    }

    public void move(Animal animal, MoveDirection direction) {
        Vector2d currPos = animal.getPosition();
        if (objectAt(currPos).equals(animal)){
            animal.move(direction, this);
            Vector2d nextPos = animal.getPosition();
            if (!currPos.equals(nextPos)) {
                animals.remove(currPos);
                animals.put(nextPos, animal);
                mapChanged("Animal " + animal + " moved " + direction +
                        " from " + currPos +
                        " to " + nextPos + ".");

            }
            else {
                mapChanged("Animal " + animal + " turned " + direction + " at " + currPos + ".");
            }
        }
    }

    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }

    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> allElements = new ArrayList<>();
        for (Map.Entry<Vector2d, Animal> entry : animals.entrySet()) {
            WorldElement currElement = entry.getValue();
            allElements.add(currElement);
        }
        return allElements;
    }

    public abstract Boundary getCurrentBounds();

    @Override
    public String toString() {
        MapVisualizer toVisualize = new MapVisualizer(this);
        Boundary boundary = getCurrentBounds();
        return toVisualize.draw(boundary.lowerLeft(), boundary.upperRight());
    }
}
