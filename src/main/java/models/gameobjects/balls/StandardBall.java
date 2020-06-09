package models.gameobjects.balls;

import models.Color;
import models.Direction;
import models.Position;
import models.gameobjects.GameField;
import models.gameobjects.balls.movement.MovementStrategy;
import models.gameobjects.balls.movement.StandardMovementStrategy;
import org.jetbrains.annotations.NotNull;


/**
 * Ball
 */
public class StandardBall extends Ball {
    private @NotNull MovementStrategy movementStrategy = new StandardMovementStrategy(this);

    public StandardBall(Position position, GameField field, Color color) {
        super(position, field, color);
    }

    /**
     * move ball
     * Ball will move until an obstacle or goal is encountered
     * @param direction direction
     */
    public void move(Direction.DirectionConstant direction) {
        movementStrategy.move(direction);
    }
}
