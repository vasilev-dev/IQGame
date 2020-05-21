package Levels;

import Models.*;

/**
 * First level of IQGame
 */
public class Level1 extends LevelBuilder {
    @Override
    public LevelBuilder createWalls() {
        new Wall(new Position(8, 1), field);
        new Wall(new Position(10, 1), field);
        new Wall(new Position(11, 1), field);
        new Wall(new Position(8, 2), field);
        new Wall(new Position(8, 3), field);
        new Wall(new Position(11, 2), field);
        new Wall(new Position(11, 3), field);
        new Wall(new Position(6, 3), field);
        new Wall(new Position(7, 3), field);
        new Wall(new Position(12, 3), field);
        new Wall(new Position(13, 3), field);
        new Wall(new Position(13, 4), field);
        new Wall(new Position(13, 6), field);
        new Wall(new Position(6, 5), field);
        new Wall(new Position(6, 6), field);
        new Wall(new Position(7, 6), field);
        new Wall(new Position(8, 6), field);
        new Wall(new Position(11, 6), field);
        new Wall(new Position(12, 6), field);
        new Wall(new Position(8, 7), field);
        new Wall(new Position(8, 8), field);
        new Wall(new Position(11, 7), field);
        new Wall(new Position(11, 8), field);
        new Wall(new Position(9, 8), field);

        return this;
    }

    @Override
    public LevelBuilder createBalls() {
        new Ball(new Position(8, 4), field, Color.GREEN);
        new Ball(new Position(10, 2), field, Color.RED);
        new Ball(new Position(9, 5), field, Color.BLUE);
        new Ball(new Position(10, 5), field, Color.YELLOW);

        return this;
    }

    @Override
    public LevelBuilder createGoals() {
        new Goal(new Position(9, 1), field, Color.BLUE);
        new Goal(new Position(6, 4), field, Color.GREEN);
        new Goal(new Position(13, 5), field, Color.YELLOW);
        new Goal(new Position(10, 8), field, Color.RED);

        return this;
    }
}