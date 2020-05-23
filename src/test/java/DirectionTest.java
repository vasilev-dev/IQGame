import models.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DirectionTest {
    @Test
    public void getDirection_northCenterAngle() {
        Direction.DirectionConstant result = Direction.getDirection(90);
        Direction.DirectionConstant expected = Direction.DirectionConstant.NORTH;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void getDirection_southCenterAngle() {
        Direction.DirectionConstant result = Direction.getDirection(-90);
        Direction.DirectionConstant expected = Direction.DirectionConstant.SOUTH;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void getDirection_westCenterAngle() {
        Direction.DirectionConstant result = Direction.getDirection(90);
        Direction.DirectionConstant expected = Direction.DirectionConstant.NORTH;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void getDirection_eastCenterAngle() {
        Direction.DirectionConstant result = Direction.getDirection(0);
        Direction.DirectionConstant expected = Direction.DirectionConstant.EAST;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void getDirection_northExtremeAngle() {
        Direction.DirectionConstant result = Direction.getDirection(135);
        Direction.DirectionConstant expected = Direction.DirectionConstant.NORTH;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void getDirection_southExtremeAngle() {
        Direction.DirectionConstant result = Direction.getDirection(-45);
        Direction.DirectionConstant expected = Direction.DirectionConstant.SOUTH;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void getDirection_westExtremeAngle() {
        Direction.DirectionConstant result = Direction.getDirection(-135);
        Direction.DirectionConstant expected = Direction.DirectionConstant.WEST;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void getDirection_eastExtremeAngle() {
        Direction.DirectionConstant result = Direction.getDirection(45);
        Direction.DirectionConstant expected = Direction.DirectionConstant.EAST;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void getDirection_incorrectAngle() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Direction.getDirection(360));
    }
}
