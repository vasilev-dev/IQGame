package Models;

import org.newdawn.slick.SlickException;

/**
 * Game object
 */
public abstract class GameObject {
    private Position _position;
    protected GameField _field;

    public GameObject(Position position, GameField field) {
        if(field.isFreePosition(position)) {
            _field = field;
            setPosition(position);
            _field.addGameObject(this);
        }
        else {
            throw new IllegalArgumentException("Game object with position " + position.toString() +  " already exists!");
        }
    }

    public Position getPosition() {
        return _position;
    }

    protected boolean setPosition(Position position) {
        if(position == null) {
            _position = null;

            return true;
        }

        if(_field.hasPosition(position) && _field.isFreePosition(position)) {
            _position = position;

            return true;
        }

        return false;
    }
}
