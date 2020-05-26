package levels;

import models.*;
import models.gameobjects.Ball;
import models.gameobjects.Goal;
import models.gameobjects.RandomBall;
import models.gameobjects.Wall;

public class Level3 extends LevelBuilder{
    @Override
    public LevelBuilder createWalls() {
        for(int x = 5; x <= 14; x++) {
            new Wall(new Position(x, 1), field);
            new Wall(new Position(x, 8), field);
        }
        for(int y = 2; y <= 7; y++) {
            new Wall(new Position(4, y), field);
            new Wall(new Position(15, y), field);
        }

        return this;
    }

    @Override
    public LevelBuilder createBalls() {
        new Ball(new Position(13, 7), field, Color.RED);
        new Ball(new Position(10, 4), field, Color.GREEN);

        new RandomBall(new Position(14, 3), field, Color.BLUE);
        new RandomBall(new Position(5, 4), field, Color.YELLOW);
        new RandomBall(new Position(14, 5), field, Color.BLUE);

        return this;
    }

    @Override
    public LevelBuilder createGoals() {
        new Goal(new Position(14, 2), field, Color.RED);
        new Goal(new Position(12, 7), field, Color.GREEN);

        new Goal(new Position(5, 3), field, Color.BLUE);
        new Goal(new Position(14, 4), field, Color.YELLOW);
        new Goal(new Position(5, 5), field, Color.BLUE);

        return this;
    }
}
