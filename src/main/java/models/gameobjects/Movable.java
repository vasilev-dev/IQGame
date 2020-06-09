package models.gameobjects;

import models.Direction;

public interface Movable {
    void move(Direction.DirectionConstant direction);
}
