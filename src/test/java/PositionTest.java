import models.Direction;
import models.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    public void next_north() {
        Position position = new Position(0, 0);

        Position result = position.next(Direction.DirectionConstant.NORTH);
        Position expected = new Position(0 ,-1);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void next_south() {
        Position position = new Position(0, 0);

        Position result = position.next(Direction.DirectionConstant.SOUTH);
        Position expected = new Position(0 ,1);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void next_west() {
        Position position = new Position(0, 0);

        Position result = position.next(Direction.DirectionConstant.WEST);
        Position expected = new Position(-1 ,0);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void next_east() {
        Position position = new Position(0, 0);

        Position result = position.next(Direction.DirectionConstant.EAST);
        Position expected = new Position(1 ,0);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void distance_vertical() {
        Position position = new Position(0, 0);
        Position otherPosition = new Position(5, 0);

        int expected = 5;
        int result = position.distance(otherPosition);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void distance_horizontal() {
        Position position = new Position(0, 0);
        Position otherPosition = new Position(0, 5);

        int expected = 5;
        int result = position.distance(otherPosition);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void distance_notLyingOnLine() {
        Position position = new Position(0, 0);
        Position otherPosition = new Position(5, 5);

        Assertions.assertThrows(IllegalArgumentException.class, () -> position.distance(otherPosition));
    }
}
