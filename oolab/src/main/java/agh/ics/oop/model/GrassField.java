package agh.ics.oop.model;

import agh.ics.oop.exceptions.PositionAlreadyOccupiedException;
import java.util.*;
import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grassPieces = new HashMap<>();


    public GrassField(int n) throws PositionAlreadyOccupiedException {
        super();

        final int UPPER_LIMIT = (int) sqrt(n*10);

        for (int i = 0; i < n; i++) {
            Random rand = new Random();
            int randX = rand.nextInt(UPPER_LIMIT + 1);
            int randY = rand.nextInt(UPPER_LIMIT + 1);
            Vector2d toCheck = new Vector2d(randX, randY);

            Grass newGrass = new Grass(toCheck);
            if (grassPieces.get(toCheck) != null) i--;
            else this.placeGrass(newGrass);

        }

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.getX() >= 0
                && position.getY() >= 0
                && animals.get(position) == null;
    }

    @Override
    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        super.place(animal);
    }

    public void placeGrass(Grass newGrass) throws PositionAlreadyOccupiedException {
        Vector2d grassPos = newGrass.getPosition();
        if (grassPieces.get(grassPos) == null) {
            grassPieces.put(grassPos, newGrass);
        }
        else throw new PositionAlreadyOccupiedException(grassPos);
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        super.move(animal, direction);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grassPieces.get(position) != null;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.get(position) != null )
            return super.objectAt(position);
        return grassPieces.get(position);
    }

    @Override
    public String toString() {
        return super.toString();

    }

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> allElements = super.getElements();
        for (Map.Entry<Vector2d, Grass> entry : grassPieces.entrySet()) {
            WorldElement currElement = entry.getValue();
            allElements.add(currElement);
        }
        return allElements;
    }

    @Override
    public Boundary getCurrentBounds() {
        Vector2d maxUpperRight = new Vector2d(0,0);
        for (Map.Entry<Vector2d, Animal> entry : animals.entrySet()) {
            Vector2d currVector = entry.getKey();
            maxUpperRight = maxUpperRight.upperRight(currVector);
        }
        for (Map.Entry<Vector2d, Grass> entry : grassPieces.entrySet()) {
            Vector2d currVector = entry.getKey();
            maxUpperRight = maxUpperRight.upperRight(currVector);
        }
        return new Boundary(new Vector2d(0, 0), maxUpperRight);
    }

    // debug

    public Map<Vector2d, Grass> getGrassPieces() {
        return grassPieces;
    }

    public Map<Vector2d, Animal> getAnimals() {
        return animals;
    }
}
