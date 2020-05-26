import models.Color;
import models.Direction;
import models.Position;
import models.gameobjects.GameField;
import models.gameobjects.RandomBall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomBallTest {
    @Test
    public void move_otherRandomBallSameColor() {
        var field = new GameField(5, 5);
        var ball = new RandomBall(new Position(0, 0), field, Color.GREEN);
        var otherBall = new RandomBall(new Position(0, 4), field, Color.GREEN);

        for(int i = 0; i < field.getHeight(); i++) {
            ball.move(Direction.DirectionConstant.SOUTH);
        }

        var expectPosition = new Position(0, 2);
        var resultPosition = ball.getPosition();

        Assertions.assertEquals(resultPosition, expectPosition);
    }

    @Test
    public void move_otherRandomBallDifferentColor() {
        var field = new GameField(5, 5);
        var ball = new RandomBall(new Position(0, 0), field, Color.GREEN);
        var otherBall = new RandomBall(new Position(0, 4), field, Color.BLUE);

        for(int i = 0; i < field.getHeight(); i++) {
            ball.move(Direction.DirectionConstant.SOUTH);
        }

        var expectPosition = new Position(0, 3);
        var resultPosition = ball.getPosition();

        Assertions.assertEquals(resultPosition, expectPosition);
    }
}
