package Tests;

import Levels.LevelBuilder;
import Models.*;

public class TestLevel extends LevelBuilder {
    @Override
    protected void createWalls(GameField field) {
        new Wall(new Position(12, 1), field);
    }

    @Override
    protected void createBalls(GameField field) {
        new Ball(new Position(6, 4), field, Color.BLUE);
        new Ball(new Position(8, 4), field, Color.BLUE);
        new Ball(new Position(10, 4), field, Color.BLUE);
        new Ball(new Position(12, 4), field, Color.BLUE);
        new Ball(new Position(14, 4), field, Color.BLUE);

        new Ball(new Position(10, 1), field, Color.RED);
    }

    @Override
    protected void createGoals(GameField field) {
        new Goal(new Position(6, 1), field, Color.BLUE);
        new Goal(new Position(8, 1), field, Color.RED);
    }

}
