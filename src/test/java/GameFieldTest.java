import levels.TestLevel;
import models.*;
import models.gameobjects.balls.StandardBall;
import models.gameobjects.GameField;
import models.gameobjects.GameObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameFieldTest {
    private GameField testLevel;

    @BeforeEach
    public void setUp() {
        testLevel = new TestLevel().createField();
    }

    //region testing of getGameObject()
    @Test
    public void getGameObject_default() {
        GameObject object = testLevel.getGameObject(new Position(6, 4));

        boolean expected = object.getPosition().equals(new Position(6, 4)) &&
                object instanceof StandardBall &&
                ((StandardBall) object).getColor() == Color.BLUE;

        Assertions.assertTrue(expected);
    }

    @Test
    public void getGameObject_emptyPosition() {
        GameObject object = testLevel.getGameObject(new Position(0, 0));

        Assertions.assertNull(object);
    }

    @Test
    public void getGameObject_offFieldPosition() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testLevel.getGameObject(new Position(100, 100)));
    }

    @Test
    public void getGameObject_nullablePosition() {
        Assertions.assertThrows(NullPointerException.class, () -> testLevel.getGameObject(null));
    }
    //endregion

    //region testing of isFreePosition()
    @Test
    public void isFreePosition_busy() {
        boolean isFree = testLevel.isFreePosition(new Position(6, 4));

        Assertions.assertFalse(isFree);
    }

    @Test
    public void isFreePosition_free() {
        boolean isFree = testLevel.isFreePosition(new Position(0, 0));

        Assertions.assertTrue(isFree);
    }

    @Test
    public void isFreePosition_offFieldPosition() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testLevel.isFreePosition(new Position(100, 100)));
    }

    @Test
    public void isFreePosition_nullablePosition() {
        Assertions.assertThrows(NullPointerException.class, () -> testLevel.getGameObject(null));
    }
    //endregion

    //region testing of addGameObject()
    @Test
    public void addGameObject_default() {
        StandardBall ball = new StandardBall(new Position(0, 0), testLevel, Color.BLUE);

        // white-box test: getGameObject() checks game objects container
        StandardBall result = (StandardBall) testLevel.getGameObject(new Position(0, 0));

        Assertions.assertEquals(ball, result);
    }

    @Test
    public void addGameObject_busyPosition() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new StandardBall(new Position(6, 4), testLevel, Color.BLUE));
    }

    @Test
    public void addGameObject_nullableGameObject() {
        Assertions.assertThrows(NullPointerException.class, () -> testLevel.addGameObject(null));
    }
    //endregion

    //region testing of destroyGameObject()
    @Test
    public void destroyGameObject_existing() {
        Position position = new Position(6, 4);

        StandardBall deleting = (StandardBall) testLevel.getGameObject(position);
        testLevel.destroyGameObject(deleting);

        GameObject deleted = testLevel.getGameObject(position);

        Assertions.assertNull(deleted);
    }

    @Test
    public void destroyGameObject_notExisting() {
        Position position = new Position(6, 4);

        StandardBall deleted = (StandardBall) testLevel.getGameObject(position);
        testLevel.destroyGameObject(deleted);

        Assertions.assertThrows(IllegalArgumentException.class, () -> testLevel.destroyGameObject(deleted));
    }

    @Test
    public void destroyGameObject_null() {
        Assertions.assertThrows(NullPointerException.class, () -> testLevel.destroyGameObject(null));
    }
    //endregion

    //region testing of hasPosition()
    @Test
    public void hasPosition_has() {
        GameField field = new GameField(10, 10);

        boolean hasPosition = field.hasPosition(new Position(5 , 5));

        Assertions.assertTrue(hasPosition);
    }

    @Test
    public void hasPosition_offField() {
        GameField field = new GameField(10, 10);

        boolean hasPosition = field.hasPosition(new Position(100, 100));

        Assertions.assertFalse(hasPosition);
    }

    @Test
    public void hasPosition_offFieldExtreme() {
        GameField field = new GameField(10, 10);

        boolean hasPosition = field.hasPosition(new Position(10, 10));

        Assertions.assertFalse(hasPosition);
    }

    @Test
    public void hasPosition_negativePosition() {
        GameField field = new GameField(10, 10);

        boolean hasPosition = field.hasPosition(new Position(-1 , -1));

        Assertions.assertFalse(hasPosition);
    }
    //endregion

    //region testing of getNearestObject()
    @Test
    public void getNearestObject_north() {
        var position = new Position(6,4);

        var result = testLevel.getNearestObject(position, Direction.DirectionConstant.NORTH);
        var expected = testLevel.getGameObject(new Position(6, 1));

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void getNearestObject_south() {
        var position = new Position(6,2);

        var result = testLevel.getNearestObject(position, Direction.DirectionConstant.SOUTH);
        var expected = testLevel.getGameObject(new Position(6, 4));

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void getNearestObject_west() {
        var position = new Position(18,1);

        var result = testLevel.getNearestObject(position, Direction.DirectionConstant.WEST);
        var expected = testLevel.getGameObject(new Position(12, 1));

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void getNearestObject_east() {
        var position = new Position(1,1);

        var result = testLevel.getNearestObject(position, Direction.DirectionConstant.EAST);
        var expected = testLevel.getGameObject(new Position(6, 1));

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void getNearestObject_twoTowards() {
        var position = new Position(6,7);

        var result = testLevel.getNearestObject(position, Direction.DirectionConstant.NORTH);
        var expected = testLevel.getGameObject(new Position(6, 4));

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void getNearestObject_notExistingPosition() {
        var position = new Position(100, 100);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testLevel.getNearestObject(position, Direction.DirectionConstant.NORTH));
    }

    @Test
    public void getNearestObject_notNearest() {
        var position = new Position(6,4);

        var result = testLevel.getNearestObject(position, Direction.DirectionConstant.WEST);

        Assertions.assertNull(result);
    }
    //endregion
}
