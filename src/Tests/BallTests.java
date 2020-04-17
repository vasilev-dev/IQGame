package Tests;

import Models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallTests {
    private GameField testLevel;

    @BeforeEach
    public void setUp() {
        testLevel = new TestLevel().createField();
    }

    @Test
    void move_toGoalOfItsColor() {
        Ball ball = (Ball) testLevel.getGameObject(new Position(6, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();

        Assertions.assertNull(result);
    }

    @Test
    void move_toGoalOfDifferentColor() {
        Ball ball = (Ball) testLevel.getGameObject(new Position(8, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();
        Position expected = new Position(8, 2);

        Assertions.assertEquals(result, expected);
    }

    @Test
    void move_toOtherBall() {
        Ball ball = (Ball) testLevel.getGameObject(new Position(10, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();
        Position expected = new Position(10, 2);

        Assertions.assertEquals(result, expected);
    }

    @Test
    void move_toWall() {
        Ball ball = (Ball) testLevel.getGameObject(new Position(12, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();
        Position expected = new Position(12, 2);

        Assertions.assertEquals(result, expected);
    }

    @Test
    void move_toEdgeOfField() {
        Ball ball = (Ball) testLevel.getGameObject(new Position(14, 4));
        ball.move(Direction.DirectionConstant.NORTH);

        Position result = ball.getPosition();
        Position expected = new Position(14, 0);

        Assertions.assertEquals(result, expected);
    }

    @Test
    void destroy() {
        Position position = new Position(14, 4);

        Ball ball = (Ball) testLevel.getGameObject(position);
        ball.destroy();

        Ball result = (Ball) testLevel.getGameObject(position);

        Assertions.assertNull(result);
    }
}