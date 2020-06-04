package models.gameobjects.balls;

import models.Color;
import models.Direction;
import models.Position;
import models.gameobjects.GameField;
import models.gameobjects.balls.movement.MovementStrategy;
import models.gameobjects.balls.movement.RandomMovementStrategy;
import org.jetbrains.annotations.NotNull;

public class RandomBall extends Ball {
    private @NotNull MovementStrategy movementStrategy = new RandomMovementStrategy(this);

    public RandomBall(Position position, GameField field, Color color) {
        super(position, field, color);
    }

    @Override
    public void move(Direction.DirectionConstant direction) {
        movementStrategy.move(direction);
    }
}
