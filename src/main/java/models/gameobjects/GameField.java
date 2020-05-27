package models.gameobjects;

import models.Direction;
import models.Position;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Game field
 */
public class GameField {
    private int width, height;
    private Collection<GameObject> gameObjects;

    public GameField(int width, int height) {
        validateGameFieldSize(width, height);
        this.width = width;
        this.height = height;

        gameObjects = new ArrayList<>();
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

        for(GameObject obj : gameObjects) {
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

        if(gameObjects.contains(obj)) {
            throw new IllegalArgumentException("Collection of game objects already contains this object!");
        }

        gameObjects.add(obj);
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

        if(!gameObjects.contains(obj)) {
            throw new IllegalArgumentException("Collection of game objects don't contains this object!");
        }

        gameObjects.remove(obj);
    }

    public Collection<GameObject> getGameObjects() {
        return gameObjects;
    }

    public Collection<Ball> getBalls() {
        var balls = new ArrayList<Ball>();

        for(var obj : gameObjects) {
            if(obj instanceof Ball) {
                balls.add((Ball) obj);
            }
        }

        return balls;
    }

    public Collection<Goal> getGoals() {
        var goals = new ArrayList<Goal>();

        for(var obj : gameObjects) {
            if(obj instanceof Goal) {
                goals.add((Goal) obj);
            }
        }

        return goals;
    }

    public Collection<Wall> getWalls() {
        var walls = new ArrayList<Wall>();

        for(var obj : gameObjects) {
            if(obj instanceof Wall) {
                walls.add((Wall) obj);
            }
        }

        return walls;
    }

    /**
     * Check position on game field size limit
     * @param position checking position
     * @return false if position is outside the game field
     */
    public boolean hasPosition(Position position) {
        return position.getX() < width && position.getY() < height &&
                position.getX() >= 0 && position.getY() >= 0;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Get nearest object on field in direction
     * @param position position on field
     * @param direction direction for searching nearest object
     * @return nearest object; null if nearest object is not exists
     */
    public GameObject getNearestObject(@NotNull Position position, @NotNull Direction.DirectionConstant direction) {
        if(!hasPosition(position)) {
            throw new IllegalArgumentException("GameField hasn't Position" + position.toString());
        }

        // get predicate for filtering object from game object container that has position in direction
        Predicate<GameObject> towardPredicate = getTowardPredicate(position, direction);
        Collection<GameObject> towards;

        // filtering
        towards = gameObjects.parallelStream().filter(towardPredicate).collect(Collectors.toList());

        if(towards.isEmpty()) {
            return null;
        }

        // get nearest object from towards
        switch (direction) {
            case NORTH:
                return Collections.max(towards, Comparator.comparing(gameObject -> gameObject.getPosition().getY()));
            case SOUTH:
                return Collections.min(towards, Comparator.comparing(gameObject -> gameObject.getPosition().getY()));
            case WEST:
                return Collections.max(towards, Comparator.comparing(gameObject -> gameObject.getPosition().getX()));
            default:
                return Collections.min(towards, Comparator.comparing(gameObject -> gameObject.getPosition().getX()));
        }
    }

    /**
     * Get predicate for getting of toward objects
     * @param position position
     * @param direction direction
     * @return predicate for getting of toward objects
     */
    private Predicate<GameObject> getTowardPredicate(@NotNull Position position,
                                                     @NotNull Direction.DirectionConstant direction) {
        switch (direction) {
            case SOUTH:
                return object -> {
                    var objectPosition = object.getPosition();
                    return objectPosition.getX() == position.getX() &&
                            objectPosition.getY() > position.getY();
                };
            case NORTH:
                return object -> {
                    var objectPosition = object.getPosition();
                    return objectPosition.getX() == position.getX() &&
                            objectPosition.getY() < position.getY();
                };
            case WEST:
                return object -> {
                    var objectPosition = object.getPosition();
                    return objectPosition.getX() < position.getX() &&
                            objectPosition.getY() == position.getY();
                };
            default:
                return object -> {
                    var objectPosition = object.getPosition();
                    return objectPosition.getX() > position.getX() &&
                            objectPosition.getY() == position.getY();
                };
        }
    }
}
