package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<MoveDirection> directions;
    private final List<Animal> animals;

    public Simulation(List<Vector2d> positions, List<MoveDirection> directions) {
        List<Animal> animals = new ArrayList<>(positions.size());
        for (Vector2d position : positions) {
            animals.add(new Animal(position));
        }

        this.animals = animals;
        this.directions = directions;
    }

    // f f f b l r l l r b f l (size: 12)
    // a0 a1 a2 (size: 3)
    // a0 -> f b l b
    // a1 -> f l l f
    // a2 -> f r r l

    public void run() {
        for (int i = 0; i < directions.size(); i++) {
            int animalNum = i % animals.size();
            MoveDirection currentDir = directions.get(i);
            Animal currentAnimal = animals.get(animalNum);

            currentAnimal.move(currentDir);

            System.out.println("Zwierzę " + animalNum + " : " + currentAnimal.getLocation().toString());

        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
