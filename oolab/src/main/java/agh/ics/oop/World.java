package agh.ics.oop;

import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;

import java.util.List;


public class World {

    public static void main(String[] args) {

        // LAB 4
        RectangularMap testMap1 = new RectangularMap(5, 5);

        List<Vector2d> startPos = List.of(
                new Vector2d(2,2),
                new Vector2d(0,0),
                new Vector2d(4,4),
                new Vector2d(3,1)
        );
        String[] moves1 = {
                "f", "f", "f", "f",
                "r", "r", "r", "r",
                "b", "b", "b", "b"
        };
        Simulation testSim = new Simulation(startPos, OptionsParser.parse(moves1), testMap1);
        testSim.run();
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
