package models.gameobjects.movement;

import models.Direction;

public interface Movable {
    void move(Direction.DirectionConstant direction);
}
