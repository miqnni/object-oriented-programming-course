package agh.ics.oop;

import agh.ics.oop.exceptions.PositionAlreadyOccupiedException;
import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void run() {

        final int ANIMAL_COUNT = 4;
//        final int SIM_COUNT = 5;

        // Starting positions for all tests
        List<Vector2d> startPos = List.of(
                new Vector2d(2,2),
                new Vector2d(0,0),
                new Vector2d(4,4),
                new Vector2d(3,1)
        );

        // How the animals will move
        String[] moves0 = {};
        String[] moves1 = {
                "f", "f", "f", "f",
                "r", "r", "r", "r",
                "b", "b", "b", "b"
        };
        String[] moves2 = {
                "r", "f", "l", "f",
                "f", "f", "f", "l",
                "b", "r", "f", "f",
                "b", "f", "l", "l",
                "f", "f", "f", "r",
                "l", "r", "f"
        };
//        String[] movesErr = {
//                "-", "f", "r", "f", "l",
//                "r", "f", "r", "f", "-",
//                "l", "r", "f", "r", "---", "-", "--",
//                "f", "l", "r", "f", "-"
//        };
        String[] moves3 = {
                "f", "r", "f", "l",
                "r", "f", "r", "f",
                "l", "r", "f", "r",
                "f", "l", "r", "f",
        };
        String[] moves4 = {
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

        // Rectangular maps
        RectangularMap testMap0 = new RectangularMap(5, 5);
        RectangularMap testMap1 = new RectangularMap(5, 5);
        RectangularMap testMap2 = new RectangularMap(5, 5);
        RectangularMap testMap3 = new RectangularMap(5, 5);
        RectangularMap testMap4 = new RectangularMap(5, 5);


        // Where the animals will be after the moves
        List<Vector2d> endPos0 = List.of(
                new Vector2d(2,2),
                new Vector2d(0,0),
                new Vector2d(4,4),
                new Vector2d(3,1)
        );
        List<Vector2d> endPos1 = List.of(
                new Vector2d(1,3),
                new Vector2d(0,1),
                new Vector2d(3,4),
                new Vector2d(2,2)
        );
        List<Vector2d> endPos2 = List.of(
                new Vector2d(1,2),
                new Vector2d(0,2),
                new Vector2d(2,3),
                new Vector2d(2,2)
        );
        List<Vector2d> endPos3 = List.of(
                new Vector2d(2,4),
                new Vector2d(1,0),
                new Vector2d(4,4),
                new Vector2d(2,2)
        );
        List<Vector2d> endPos4 = List.of(
                new Vector2d(1,1),
                new Vector2d(1,3),
                new Vector2d(4,0),
                new Vector2d(1,4)
        );

        // What orientation the animals will have after the moves
        List<MapDirection> endOri0 = List.of(
                MapDirection.NORTH,
                MapDirection.NORTH,
                MapDirection.NORTH,
                MapDirection.NORTH
        );
        List<MapDirection> endOri1 = List.of(
                MapDirection.EAST,
                MapDirection.EAST,
                MapDirection.EAST,
                MapDirection.EAST
        );
        List<MapDirection> endOri2 = List.of(
                MapDirection.NORTH,
                MapDirection.SOUTH,
                MapDirection.SOUTH,
                MapDirection.WEST
        );
        List<MapDirection> endOri3 = List.of(
                MapDirection.NORTH,
                MapDirection.EAST,
                MapDirection.SOUTH,
                MapDirection.NORTH
        );
        List<MapDirection> endOri4 = List.of(
                MapDirection.WEST,
                MapDirection.EAST,
                MapDirection.NORTH,
                MapDirection.SOUTH
        );

        // Prepare and run the simulations
        Simulation sim0 = new Simulation(startPos, OptionsParser.parse(moves0), testMap0);
        Simulation sim1 = new Simulation(startPos, OptionsParser.parse(moves1), testMap1);
        Simulation sim2 = new Simulation(startPos, OptionsParser.parse(moves2), testMap2);
        Simulation sim3 = new Simulation(startPos, OptionsParser.parse(moves3), testMap3);
        Simulation sim4 = new Simulation(startPos, OptionsParser.parse(moves4), testMap4);
        sim0.run();
        sim1.run();
        sim2.run();
        sim3.run();
        sim4.run();

        // Check if the animals have the correct *positions* after the moves
        for (int i = 0; i < ANIMAL_COUNT; i++) {
            // assertEquals(expected, actual);
            assertEquals(endPos0.get(i), sim0.getAnimals().get(i).getPosition());
            assertEquals(endPos1.get(i), sim1.getAnimals().get(i).getPosition());
            assertEquals(endPos2.get(i), sim2.getAnimals().get(i).getPosition());
            assertEquals(endPos3.get(i), sim3.getAnimals().get(i).getPosition());
            assertEquals(endPos4.get(i), sim4.getAnimals().get(i).getPosition());
        }

        // Check if the animals have the correct *orientations* after the moves
        for (int i = 0; i < ANIMAL_COUNT; i++) {
            // assertEquals(expected, actual);
            assertEquals(endOri0.get(i), sim0.getAnimals().get(i).getOrientation());
            assertEquals(endOri1.get(i), sim1.getAnimals().get(i).getOrientation());
            assertEquals(endOri2.get(i), sim2.getAnimals().get(i).getOrientation());
            assertEquals(endOri3.get(i), sim3.getAnimals().get(i).getOrientation());
            assertEquals(endOri4.get(i), sim4.getAnimals().get(i).getOrientation());
        }

    }
}
