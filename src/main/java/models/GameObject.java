package models;

/**
 * Game object
 */
public abstract class GameObject {
    private Position position;
    protected GameField field;

    public GameObject(Position position, GameField field) {
        if(field.isFreePosition(position)) {
            this.field = field;
            setPosition(position);
            field.addGameObject(this);
        }
        else {
            throw new IllegalArgumentException("Game object with position " + position.toString() +  " already exists!");
        }
    }

    public Position getPosition() {
        return position;
    }

    protected boolean setPosition(Position position) {
        if(position == null) {
            this.position = null;

            return true;
        }

        if(field.hasPosition(position) && field.isFreePosition(position)) {
            this.position = position;

            return true;
        }

        return false;
    }

    public GameField getGameField() {
        return field;
    }
}
