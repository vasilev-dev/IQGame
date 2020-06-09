package models.gameobjects;

import models.Color;
import models.Position;

/**
 * Goal for balls
 */
public class Goal extends ColorGameObject {
    public Goal(Position position, GameField field, Color color) {
        super(position, field, color);
    }
}
