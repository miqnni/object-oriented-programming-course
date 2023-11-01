package agh.ics.oop;
//import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MapDirection;

import java.util.Map;

public class World {

    public static void main(String[] args) {

        // LAB 1

//        System.out.println("system wystartował");
//
//        MoveDirection[] run_arr;
//        run_arr = OptionsParser.parse(args);
//
//        run(run_arr);
//        System.out.println("system zakończył działanie");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println(MapDirection.toUnitVector(MapDirection.NORTH));
        System.out.println(MapDirection.toUnitVector(MapDirection.SOUTH));
        System.out.println(MapDirection.toUnitVector(MapDirection.WEST));
        System.out.println(MapDirection.toUnitVector(MapDirection.EAST));

    }

    public static void run(MoveDirection[] run_arr) {

        // pierwsza wersja
//        System.out.println("zwierzak idzie do przodu");
//        for (int i = 0; i < tab.length - 1; i++) {
//            System.out.print(tab[i] + ", ");
//        }
//        if (tab.length > 0) {
//            System.out.println(tab[tab.length - 1]);
//        }

//        for (String s: tab) {
//            String msg = switch (s) {
//                case "f" -> "Zwierzak idzie do przodu";
//                case "r" -> "Zwierzak idzie w prawo";
//                case "b" -> "Zwierzak idzie do tyłu";
//                case "l" -> "Zwierzak idzie w lewo";
//                default -> "Nieznana komenda";
//            };
//            System.out.println(msg);
//        }



        for (MoveDirection d: run_arr) {
            String msg = switch (d) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case RIGHT -> "Zwierzak idzie w prawo";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak idzie w lewo";
//                default -> "Nieznana komenda";
            };
            System.out.println(msg);
        }


    }
}
