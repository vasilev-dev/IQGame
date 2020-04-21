package Models;

import java.util.Objects;

/**
 * Position of game object on field
 */
public class Position {
    private int _x, _y;

    public Position(int x, int y) {
        _x = x;
        _y = y;
    }

    /**
     * Get next position
     * @param direction direction
     * @return next position
     */
    public Position next(Direction.DirectionConstant direction) {
        switch (direction) {
            case NORTH:
                return new Position(_x, _y - 1);
            case SOUTH:
                return new Position(_x, _y + 1);
            case EAST:
                return new Position(_x + 1, _y);
            case WEST:
                return new Position(_x - 1, _y);
            default:
                throw new IllegalArgumentException("Unknown value of direction");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return _x == position._x &&
                _y == position._y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_x, _y);
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    @Override
    public String toString() {
        return "(" + Integer.toString(_x) + ";" + Integer.toString(_y) + ")";
    }
}
