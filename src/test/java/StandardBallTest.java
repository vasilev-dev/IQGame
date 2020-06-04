import levels.TestLevel;
import models.*;
import models.gameobjects.balls.StandardBall;
import models.gameobjects.GameField;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

public class StandardBallTest {
    private GameField testLevel;

    @BeforeEach
    public void setUp() {
        testLevel = new TestLevel().createField();
    }

    @Test
    public void move_toGoalOfItsColor() {
        StandardBall standardBall = (StandardBall) testLevel.getGameObject(new Position(6, 4));
        standardBall.move(Direction.DirectionConstant.NORTH);

        Position result = standardBall.getPosition();

        Assertions.assertNull(result);
    }

    @Test
    public void move_toGoalOfDifferentColor() {
        StandardBall standardBall = (StandardBall) testLevel.getGameObject(new Position(8, 4));
        standardBall.move(Direction.DirectionConstant.NORTH);

        Position result = standardBall.getPosition();
        Position expected = new Position(8, 2);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void move_toOtherBall() {
        StandardBall standardBall = (StandardBall) testLevel.getGameObject(new Position(10, 4));
        standardBall.move(Direction.DirectionConstant.NORTH);

        Position result = standardBall.getPosition();
        Position expected = new Position(10, 2);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void move_toWall() {
        StandardBall standardBall = (StandardBall) testLevel.getGameObject(new Position(12, 4));
        standardBall.move(Direction.DirectionConstant.NORTH);

        Position result = standardBall.getPosition();
        Position expected = new Position(12, 2);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void move_toEdgeOfField() {
        StandardBall standardBall = (StandardBall) testLevel.getGameObject(new Position(14, 4));
        standardBall.move(Direction.DirectionConstant.NORTH);

        Position result = standardBall.getPosition();
        Position expected = new Position(14, 0);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void destroy() {
        Position position = new Position(14, 4);

        StandardBall standardBall = (StandardBall) testLevel.getGameObject(position);
        standardBall.destroy();

        StandardBall result = (StandardBall) testLevel.getGameObject(position);

        Assertions.assertNull(result);
    }
}