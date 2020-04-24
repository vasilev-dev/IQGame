package Levels;

import Models.*;

/**
 * Test level
 */
public class TestLevel extends LevelBuilder {
    @Override
    public LevelBuilder createWalls() {
        new Wall(new Position(8, 1), _field);
        new Wall(new Position(10, 1), _field);
        new Wall(new Position(11, 1), _field);
        new Wall(new Position(8, 2), _field);
        new Wall(new Position(8, 3), _field);
        new Wall(new Position(11, 2), _field);
        new Wall(new Position(11, 3), _field);
        new Wall(new Position(6, 3), _field);
        new Wall(new Position(7, 3), _field);
        new Wall(new Position(12, 3), _field);
        new Wall(new Position(13, 3), _field);
        new Wall(new Position(13, 4), _field);
        new Wall(new Position(13, 6), _field);
        new Wall(new Position(6, 5), _field);
        new Wall(new Position(6, 6), _field);
        new Wall(new Position(7, 6), _field);
        new Wall(new Position(8, 6), _field);
        new Wall(new Position(11, 6), _field);
        new Wall(new Position(12, 6), _field);
        new Wall(new Position(8, 7), _field);
        new Wall(new Position(8, 8), _field);
        new Wall(new Position(11, 7), _field);
        new Wall(new Position(11, 8), _field);
        new Wall(new Position(9, 8), _field);

        return this;
    }

    @Override
    public LevelBuilder createBalls() {
        new Ball(new Position(8, 4), _field, Color.GREEN);
        new Ball(new Position(10, 2), _field, Color.RED);
        new Ball(new Position(9, 5), _field, Color.BLUE);
        new Ball(new Position(10, 5), _field, Color.YELLOW);

        return this;
    }

    @Override
    public LevelBuilder createGoals() {
        new Goal(new Position(9, 1), _field, Color.BLUE);
        new Goal(new Position(6, 4), _field, Color.GREEN);
        new Goal(new Position(13, 5), _field, Color.YELLOW);
        new Goal(new Position(10, 8), _field, Color.RED);

        return this;
    }
}
