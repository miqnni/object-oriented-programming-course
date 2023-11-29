package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grassPieces = new HashMap<>();


    public GrassField(int n) {
        final int UPPER_LIMIT = (int) sqrt(n*10);



        for (int i = 0; i < n; i++) {
            Random rand = new Random();
            int randX = rand.nextInt(UPPER_LIMIT + 1);
            int randY = rand.nextInt(UPPER_LIMIT + 1);
            Vector2d toCheck = new Vector2d(randX, randY);

            Grass newGrass = new Grass(toCheck);
            if (!placeGrass(newGrass)) i--;

        }

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.getX() >= 0
                && position.getY() >= 0
                && animals.get(position) == null;
    }

    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
    }

    public boolean placeGrass(Grass newGrass) {
        Vector2d grassPos = newGrass.getPosition();
        if (grassPieces.get(grassPos) == null) {
            grassPieces.put(grassPos, newGrass);
            return true;
        }
        return false;
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

    private Vector2d calculateMapCorner() {
        Vector2d maxUpperRight = new Vector2d(0,0);
        for (Map.Entry<Vector2d, Animal> entry : animals.entrySet()) {
            Vector2d currVector = entry.getKey();
            maxUpperRight = maxUpperRight.upperRight(currVector);
        }
        for (Map.Entry<Vector2d, Grass> entry : grassPieces.entrySet()) {
            Vector2d currVector = entry.getKey();
            maxUpperRight = maxUpperRight.upperRight(currVector);
        }
        return maxUpperRight;
    }

    /*
    * rysuje fragment mapy, na którym znajdują się wszystkie elementy (zwierzęta oraz trawa)
    * W celu jej implementacji wykorzystaj klasę MapVisualizer z poprzedniego laboratorium
    * dynamicznie oblicz skrajne punkty, które powinny zostać wyświetlone
    * Obecność zwierząt ma priorytet nad obecnością kępki trawy na danym polu (ZALATWIONE: objectAt())
    * */
    @Override
    public String toString() {
        Vector2d mapCorner = calculateMapCorner();
        int width = mapCorner.getX() + 1;
        int height = mapCorner.getY() + 1;
        MapVisualizer toVisualize = new MapVisualizer(this);
        return toVisualize.draw(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));

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

    // debug

    public Map<Vector2d, Grass> getGrassPieces() {
        return grassPieces;
    }

    public Map<Vector2d, Animal> getAnimals() {
        return animals;
    }
}
