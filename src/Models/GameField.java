package Models;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Game field
 */
public class GameField {
    private int _width, _height;
    private Collection<GameObject> _gameObjects;

    public GameField(int width, int height) {
        validateGameFieldSize(width, height);
        _width = width;
        _height = height;

        _gameObjects = new ArrayList<>();
    }

    /**
     * Validate width and height of game field
     * @param width width of game field
     * @param height height of game field
     * @exception IllegalArgumentException if width or(and) height is negative
     */
    private void validateGameFieldSize(int width, int height) {
        if(width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative size of game field!");
        }
    }

    /**
     * Get game object with input position
     * @param position position object
     * @return game object with input position or null if game object with input position is not exists
     */
    public GameObject getGameObject(Position position) {
        if(position == null) {
            throw new NullPointerException("You try to get game object in nullable position");
        }

        if(!hasPosition(position)) {
            throw new IllegalArgumentException("You try to get game object in off-field position " + position.toString());
        }

        for(GameObject obj : _gameObjects) {
            if(obj.getPosition().equals(position)) {
                return obj;
            }
        }

        return null;
    }

    /**
     * Is it free position?
     * @param position position
     * @return true if position is free
     */
    public boolean isFreePosition(Position position) {
        return getGameObject(position) == null;
    }

    /**
     * Add new game object to collection of game objects
     * @param obj new game object
     * @exception NullPointerException if input game object is null
     * @exception IllegalArgumentException if collection already contains input object
     */
    public void addGameObject(GameObject obj) {
        if(obj == null) {
            throw new NullPointerException("You are trying to add an nullable GameObject to collection!");
        }

        if(_gameObjects.contains(obj)) {
            throw new IllegalArgumentException("Collection of game objects already contains this object!");
        }

        _gameObjects.add(obj);
    }

    /**
     * Remove object from collection
     * @param obj removing object
     * @exception NullPointerException if input game object is null
     * @exception IllegalArgumentException if collection don't contains input object
     */
    public void destroyGameObject(GameObject obj) {
        if(obj == null) {
            throw new NullPointerException("You are trying to destroy an nullable GameObject!");
        }

        if(!_gameObjects.contains(obj)) {
            throw new IllegalArgumentException("Collection of game objects don't contains this object!");
        }

        _gameObjects.remove(obj);
    }

    public Collection<GameObject> getGameObjects() {
        return _gameObjects;
    }

    public Collection<Ball> getBalls() {
        var balls = new ArrayList<Ball>();

        for(var obj : _gameObjects) {
            if(obj instanceof Ball) {
                balls.add((Ball) obj);
            }
        }

        return balls;
    }

    /**
     * Check position on game field size limit
     * @param position checking position
     * @return false if position is outside the game field
     */
    public boolean hasPosition(Position position) {
        return position.getX() < _width && position.getY() < _height &&
                position.getX() >= 0 && position.getY() >= 0;
    }
}
