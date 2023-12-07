package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {

    private int updateCount = 0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        System.out.println("Update count: " + ++updateCount);
        System.out.println("Map ID: " + worldMap.getId());
        System.out.println(message);
        System.out.println(worldMap);
        System.out.println("\n" + "================================" + "\n");
    }
}
