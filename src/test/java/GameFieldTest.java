import levels.LevelTest;
import models.*;
import models.gameobjects.Ball;
import models.gameobjects.GameField;
import models.gameobjects.GameObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameFieldTest {
    private GameField testLevel;

    @BeforeEach
    public void setUp() {
        testLevel = new LevelTest().createField();
    }

    //region testing of getGameObject()
    @Test
    public void getGameObject_default() {
        GameObject object = testLevel.getGameObject(new Position(6, 4));

        boolean expected = object.getPosition().equals(new Position(6, 4)) &&
                object instanceof Ball &&
                ((Ball) object).getColor() == Color.BLUE;

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
        Ball ball = new Ball(new Position(0, 0), testLevel, Color.BLUE);

        // white-box test: getGameObject() checks game objects container
        Ball result = (Ball) testLevel.getGameObject(new Position(0, 0));

        Assertions.assertEquals(ball, result);
    }

    @Test
    public void addGameObject_busyPosition() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ball(new Position(6, 4), testLevel, Color.BLUE));
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

        Ball deleting = (Ball) testLevel.getGameObject(position);
        testLevel.destroyGameObject(deleting);

        GameObject deleted = testLevel.getGameObject(position);

        Assertions.assertNull(deleted);
    }

    @Test
    public void destroyGameObject_notExisting() {
        Position position = new Position(6, 4);

        Ball deleted = (Ball) testLevel.getGameObject(position);
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
}
