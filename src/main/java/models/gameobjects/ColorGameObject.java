package models.gameobjects;

import models.Color;
import models.Position;

/**
 * Color game object
 */
public abstract class ColorGameObject extends GameObject {
    private Color color;

    public ColorGameObject(Position position, GameField field, Color color) {
        super(position, field);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color _color) {
        this.color = _color;
    }
}
