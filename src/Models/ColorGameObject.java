package Models;

/**
 * Color game object
 */
public abstract class ColorGameObject extends GameObject {
    private Color _color;

    public ColorGameObject(Position position, GameField field, Color color) {
        super(position, field);
        _color = color;
    }

    public Color getColor() {
        return _color;
    }

    public void setColor(Color _color) {
        this._color = _color;
    }
}
