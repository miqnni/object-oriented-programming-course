package agh.ics.oop;
//import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;

public class World {

    public static void main(String[] args) {
        System.out.println("system wystartował");

        MoveDirection[] run_arr;
        run_arr = OptionsParser.parse(args);

        run(run_arr);
        System.out.println("system zakończył działanie");
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
