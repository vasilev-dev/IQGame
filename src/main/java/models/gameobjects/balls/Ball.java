package models.gameobjects.balls;

import models.Color;
import models.Direction;
import models.Position;
import models.gameobjects.ColorGameObject;
import models.gameobjects.GameField;
import models.gameobjects.GameObject;
import models.gameobjects.Goal;
import models.gameobjects.Movable;
import org.jetbrains.annotations.NotNull;

public abstract class Ball extends ColorGameObject implements Movable {
    public Ball(Position position, GameField field, Color color) {
        super(position, field, color);
    }

    /**
     * move ball
     * Ball will move until an obstacle or goal is encountered
     * @param direction direction
     */
    public abstract void move(Direction.DirectionConstant direction);

    /**
     * Destroy ball
     */
    public void destroy() {
        field.destroyGameObject(this);
        field = null;
        setPosition(null);
        setColor(null);
    }

    /**
     * Checks that the object is color game object of the same color as the ball
     * @param gameObject
     * @return
     */
    private boolean isSameColorObject(GameObject gameObject) {
        return gameObject instanceof ColorGameObject && ((ColorGameObject) gameObject).getColor() == getColor();
    }

    /**
     * Checks that the object is a goal of the same color as the ball
     * @param gameObject game object
     * @return true if it's goal of the same color as the ball
     */
    public boolean isBallColorGoal(@NotNull GameObject gameObject) {
        return gameObject instanceof Goal && isSameColorObject(gameObject);
    }

    /**
     * Checks that the object is a goal of the same color as the ball
     * @param gameObject game object
     * @return true if it's goal of the same color as the ball
     */
    public boolean isSameColorBall(@NotNull GameObject gameObject) {
        return gameObject instanceof Ball && isSameColorObject(gameObject);
    }
}
