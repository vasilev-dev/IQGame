package models.gameobjects.movement;

import models.Direction;

public interface MovementStrategy {
    void move(Direction.DirectionConstant direction);
}
