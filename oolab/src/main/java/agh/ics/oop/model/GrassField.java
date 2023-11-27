package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField implements WorldMap {

    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final Map<Vector2d, Grass> grassList = new HashMap<>();


    public GrassField(int n) {
//        final int LOWER_LIMIT = 0;
        final int UPPER_LIMIT = (int) sqrt(n*10);



        for (int i = 0; i < n; i++) {
            Random rand = new Random();
            int randX = rand.nextInt(UPPER_LIMIT + 1);
            int randY = rand.nextInt(UPPER_LIMIT + 1);
            Vector2d toCheck = new Vector2d(randX, randY);
            System.out.println("Random vector: " + toCheck);

//            if (grassList.get(toCheck) == null) {
//                Grass newGrass = new Grass(toCheck);
//                grassList.put(toCheck, newGrass);
//            }
//            else i--;

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
        Vector2d animalPos = animal.getPosition();
        if (canMoveTo(animalPos)) {
            animals.put(animalPos, animal);
            return true;
        }
        return false;
    }

    public boolean placeGrass(Grass newGrass) {
        Vector2d grassPos = newGrass.getPosition();
        if (grassList.get(grassPos) == null) {
            grassList.put(grassPos, newGrass);
            System.out.println("GRASS SUCCESSFULLY PLACED AT " + grassPos);
            return true;
        }
        return false;
    }

    @Override
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

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null || grassList.get(position) != null;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.get(position) != null )
            return animals.get(position);
        return grassList.get(position);
    }

    private Vector2d calculateMapCorner() {
        Vector2d maxUpperRight = new Vector2d(0,0);
        for (Map.Entry<Vector2d, Animal> entry : animals.entrySet()) {
            Vector2d currVector = entry.getKey();
            maxUpperRight = maxUpperRight.upperRight(currVector);
        }
        for (Map.Entry<Vector2d, Grass> entry : grassList.entrySet()) {
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
        int width = mapCorner.getX() + 1; // EDIT!!! -- moze wykorzystac upperRight dla wszystkich wektorow?
        int height = mapCorner.getY() + 1; // EDIT!!!
        MapVisualizer toVisualize = new MapVisualizer(this);
        return toVisualize.draw(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));

    }

    // debug

    public Map<Vector2d, Grass> getGrassList() {
        return grassList;
    }

    public Map<Vector2d, Animal> getAnimals() {
        return animals;
    }
}
