import levels.TestLevel;
import models.*;
import models.gameobjects.Ball;
import models.gameobjects.GameField;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

public class BallTest {
    private GameField testLevel;

    @BeforeEach
    public void setUp() {
        testLevel = new TestLevel().createField();
    }

    @Test
    public void move_toGoalOfItsColor() {
        Ball ball = (Ball) testLevel.getGameObject(new Position(6, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();

        Assertions.assertNull(result);
    }

    @Test
    public void move_toGoalOfDifferentColor() {
        Ball ball = (Ball) testLevel.getGameObject(new Position(8, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();
        Position expected = new Position(8, 2);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void move_toOtherBall() {
        Ball ball = (Ball) testLevel.getGameObject(new Position(10, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();
        Position expected = new Position(10, 2);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void move_toWall() {
        Ball ball = (Ball) testLevel.getGameObject(new Position(12, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();
        Position expected = new Position(12, 2);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void move_toEdgeOfField() {
        Ball ball = (Ball) testLevel.getGameObject(new Position(14, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();
        Position expected = new Position(14, 0);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void destroy() {
        Position position = new Position(14, 4);

        Ball ball = (Ball) testLevel.getGameObject(position);
        ball.destroy();

        Ball result = (Ball) testLevel.getGameObject(position);

        Assertions.assertNull(result);
    }
}