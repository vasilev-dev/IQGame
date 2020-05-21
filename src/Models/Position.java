package Models;

import java.util.Objects;

/**
 * Position of game object on field
 */
public class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get next position
     * @param direction direction
     * @return next position
     */
    public Position next(Direction.DirectionConstant direction) {
        if(direction == Direction.DirectionConstant.NORTH) {
            return new Position(x, y - 1);
        }
        else if(direction == Direction.DirectionConstant.SOUTH) {
            return new Position(x, y + 1);
        }
        else if(direction == Direction.DirectionConstant.WEST) {
            return new Position(x - 1, y);
        }
        else {
            return new Position(x + 1, y);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + Integer.toString(x) + ";" + Integer.toString(y) + ")";
    }
}
