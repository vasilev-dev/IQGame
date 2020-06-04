package models;

import org.jetbrains.annotations.NotNull;

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

    /**
     * Get the distance between two positions that lie on the same straight line
     * @param position second position
     * @return distance between two positions
     */
    public int distance(@NotNull Position position) {
        if(x == position.x) {
            return Math.abs(y - position.y);
        }
        else if(y == position.y) {
            return Math.abs(x - position.x);
        }
        else {
            throw new IllegalArgumentException("Position don't lie on the same straight line");
        }
    }
}
