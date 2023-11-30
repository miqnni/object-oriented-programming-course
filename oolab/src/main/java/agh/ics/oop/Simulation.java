package agh.ics.oop;

import agh.ics.oop.exceptions.PositionAlreadyOccupiedException;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<MoveDirection> directions;
    private final List<Animal> animals;

    private final WorldMap animalMap;

    public Simulation(List<Vector2d> positions, List<MoveDirection> directions, WorldMap animalMap) {
        List<Animal> animals = new ArrayList<>(positions.size());
        for (Vector2d position : positions) {
            animals.add(new Animal(position));
        }

        this.animals = animals;
        this.directions = directions;
        this.animalMap = animalMap;

    }

    public void run() {
        // place the animals
        for (Animal animal : animals) {
            try {

                animalMap.place(animal);
            }
            catch(PositionAlreadyOccupiedException e){
                e.printStackTrace();
            }
        }

        // move the animals
        for (int i = 0; i < directions.size(); i++) {
            int animalNum = i % animals.size();
            MoveDirection currentDir = directions.get(i);
            Animal currentAnimal = animals.get(animalNum);

            animalMap.move(currentAnimal, currentDir);

//            System.out.println("Zwierzę " + animalNum + " : " + currentAnimal.getLocation().toString());
//            System.out.println(animalMap);

        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
