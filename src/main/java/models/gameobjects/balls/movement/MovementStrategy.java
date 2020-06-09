package models.gameobjects.balls.movement;

import models.Direction;

public interface MovementStrategy {
    void move(Direction.DirectionConstant direction);
}
