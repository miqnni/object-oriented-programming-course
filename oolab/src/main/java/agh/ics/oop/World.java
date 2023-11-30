package agh.ics.oop;

import agh.ics.oop.exceptions.PositionAlreadyOccupiedException;
import agh.ics.oop.model.*;


public class World {

    public static void main(String[] args) throws PositionAlreadyOccupiedException {
        // LAB (prev.)
//        List<MoveDirection> directions = OptionsParser.parse(args);
//        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
//        RectangularMap simMap = new RectangularMap(5, 5);
//        Simulation simulation = new Simulation(positions, directions, simMap);
//        simulation.run();

        // LAB 6
        ConsoleMapDisplay testConsole = new ConsoleMapDisplay();

        GrassField testGrassField = new GrassField(5);
        testGrassField.addObserver(testConsole);
        Animal a1 = new Animal();
        Animal a2 = new Animal(new Vector2d(40,5));
        testGrassField.place(a1);
        testGrassField.place(a2);
        testGrassField.move(a1, MoveDirection.FORWARD);
        testGrassField.move(a2, MoveDirection.LEFT);
        testGrassField.move(a2, MoveDirection.BACKWARD);
        testGrassField.move(a2, MoveDirection.RIGHT);
        testGrassField.removeObserver(testConsole);
        testGrassField.move(a2, MoveDirection.RIGHT);
        testGrassField.move(a2, MoveDirection.FORWARD);
    }

//    public static void run(MoveDirection[] run_arr) {
//        for (MoveDirection d: run_arr) {
//            String msg = switch (d) {
//                case FORWARD -> "Zwierzak idzie do przodu";
//                case RIGHT -> "Zwierzak idzie w prawo";
//                case BACKWARD -> "Zwierzak idzie do tyłu";
//                case LEFT -> "Zwierzak idzie w lewo";
//            };
//            System.out.println(msg);
//        }
//    }
}
