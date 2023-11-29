package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;


    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.getX() >= 0
                && position.getX() <= width - 1
                && position.getY() >= 0
                && position.getY() <= height - 1
                && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        super.move(animal, direction);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return super.objectAt(position);
    }

    @Override
    public String toString() {
        MapVisualizer toVisualize = new MapVisualizer(this);
        return toVisualize.draw(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));

    }

    @Override
    public List<WorldElement> getElements() {
        return super.getElements();
    }
}
