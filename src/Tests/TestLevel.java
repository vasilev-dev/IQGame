package Tests;

import Levels.LevelBuilder;
import Models.*;

public class TestLevel extends LevelBuilder {
    @Override
    public LevelBuilder createWalls() {
        new Wall(new Position(12, 1), _field);
        return this;
    }

    @Override
    public LevelBuilder createBalls() {
        new Ball(new Position(6, 4), _field, Color.BLUE);
        new Ball(new Position(8, 4), _field, Color.BLUE);
        new Ball(new Position(10, 4), _field, Color.BLUE);
        new Ball(new Position(12, 4), _field, Color.BLUE);
        new Ball(new Position(14, 4), _field, Color.BLUE);

        new Ball(new Position(10, 1), _field, Color.RED);

        return this;
    }

    @Override
    public LevelBuilder createGoals() {
        new Goal(new Position(6, 1), _field, Color.BLUE);
        new Goal(new Position(8, 1), _field, Color.RED);

        return this;
    }

}
