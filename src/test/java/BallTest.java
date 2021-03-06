import levels.TestLevel;
import models.*;
import models.gameobjects.balls.StandardBall;
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
        StandardBall ball = (StandardBall) testLevel.getGameObject(new Position(6, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();

        Assertions.assertNull(result);
    }

    @Test
    public void move_toGoalOfDifferentColor() {
        StandardBall ball = (StandardBall) testLevel.getGameObject(new Position(8, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();
        Position expected = new Position(8, 2);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void move_toOtherBall() {
        StandardBall ball = (StandardBall) testLevel.getGameObject(new Position(10, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();
        Position expected = new Position(10, 2);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void move_toWall() {
        StandardBall ball = (StandardBall) testLevel.getGameObject(new Position(12, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();
        Position expected = new Position(12, 2);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void move_toEdgeOfField() {
        StandardBall ball = (StandardBall) testLevel.getGameObject(new Position(14, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();
        Position expected = new Position(14, 0);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void destroy() {
        Position position = new Position(14, 4);

        StandardBall ball = (StandardBall) testLevel.getGameObject(position);
        ball.destroy();

        StandardBall result = (StandardBall) testLevel.getGameObject(position);

        Assertions.assertNull(result);
    }
}