package agh.ics.oop;

import agh.ics.oop.exceptions.PositionAlreadyOccupiedException;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;


public class World {

    public static void main(String[] args) throws PositionAlreadyOccupiedException {
        // LAB (prev.)
//        List<MoveDirection> directions = OptionsParser.parse(args);
//        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
//        RectangularMap simMap = new RectangularMap(5, 5);
//        Simulation simulation = new Simulation(positions, directions, simMap);
//        simulation.run();

        // LAB 6
//        ConsoleMapDisplay testConsole = new ConsoleMapDisplay();
//        GrassField testGrassField = new GrassField(5);
//        testGrassField.addObserver(testConsole);
//        Animal a1 = new Animal();
//        Animal a2 = new Animal(new Vector2d(40,5));
//        testGrassField.place(a1);
//        testGrassField.place(a2);
//        testGrassField.move(a1, MoveDirection.FORWARD);
//        testGrassField.move(a2, MoveDirection.LEFT);
//        testGrassField.move(a2, MoveDirection.BACKWARD);
//        testGrassField.move(a2, MoveDirection.RIGHT);
//        testGrassField.removeObserver(testConsole);
//        testGrassField.move(a2, MoveDirection.RIGHT);
//        testGrassField.move(a2, MoveDirection.FORWARD);

        // LAB 7

        RectangularMap rMap0 = new RectangularMap(5, 5);
        String[] rMoves0 = {
                "b", "f", "b", "f",
                "l", "r", "b", "f",
                "f", "f", "b", "l",
                "r", "l", "b", "f",
                "f", "f", "b", "f",
                "f", "r", "b", "f",
                "l", "f", "b", "r",
                "f", "l", "b", "f",
                "l", "f", "b", "r",
                "f", "r", "b", "f",
                "r", "f", "b", "r",
        };
        List<Vector2d> startPos = List.of(
                new Vector2d(2,2),
                new Vector2d(0,0),
                new Vector2d(4,4),
                new Vector2d(3,1)
        );

        GrassField gField0 = new GrassField(15);

        Simulation sim0 = new Simulation(startPos, OptionsParser.parse(rMoves0), rMap0);
        Simulation sim1 = new Simulation(startPos, OptionsParser.parse(rMoves0), gField0);

        ConsoleMapDisplay testConsole = new ConsoleMapDisplay();
        rMap0.addObserver(testConsole);
        gField0.addObserver(testConsole);

        List<Simulation> testSimList = new ArrayList<>();
        testSimList.add(sim0);
        testSimList.add(sim1);
        SimulationEngine e1 = new SimulationEngine(testSimList);
        e1.runSync();

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
