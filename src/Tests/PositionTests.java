package Tests;

import Models.Direction;
import Models.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTests {
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
}
