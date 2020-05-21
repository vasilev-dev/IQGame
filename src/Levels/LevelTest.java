package Levels;

import Levels.LevelBuilder;
import Models.*;

public class LevelTest extends LevelBuilder {
    @Override
    public LevelBuilder createWalls() {
        new Wall(new Position(12, 1), field);
        return this;
    }

    @Override
    public LevelBuilder createBalls() {
        new Ball(new Position(6, 4), field, Color.BLUE);
        new Ball(new Position(8, 4), field, Color.BLUE);
        new Ball(new Position(10, 4), field, Color.BLUE);
        new Ball(new Position(12, 4), field, Color.BLUE);
        new Ball(new Position(14, 4), field, Color.BLUE);

        new Ball(new Position(10, 1), field, Color.RED);

        return this;
    }

    @Override
    public LevelBuilder createGoals() {
        new Goal(new Position(6, 1), field, Color.BLUE);
        new Goal(new Position(8, 1), field, Color.RED);

        return this;
    }

}
