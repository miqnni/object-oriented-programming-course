package agh.ics.oop.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animals = new HashMap<>();

    public boolean place(Animal animal) {
        Vector2d animalPos = animal.getPosition();
        if (canMoveTo(animalPos)) {
            animals.put(animalPos, animal);
            return true;
        }
        return false;
    }

    public void move(Animal animal, MoveDirection direction) {
        Vector2d currPos = animal.getPosition();
        if (objectAt(currPos).equals(animal)){
            animal.move(direction, this);
            Vector2d nextPos = animal.getPosition();
            if (!currPos.equals(nextPos)) {
                animals.remove(currPos);
                animals.put(nextPos, animal);
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
}
