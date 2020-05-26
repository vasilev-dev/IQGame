package models.gameobjects;

import models.Color;
import models.Direction;
import models.Position;

import java.util.concurrent.ThreadLocalRandom;

public class RandomBall extends Ball {
    public RandomBall(Position position, GameField field, Color color) {
        super(position, field, color);
    }

    /**
     * Get random number of steps by which to move the ball
     * @param direction direction of moving
     * @return random number of step
     */
    private int getRandomNumberSteps(Direction.DirectionConstant direction) {
        var position = getPosition();
        var nextObjectPosition = field.getNearestObject(position, direction).getPosition();
        int distance; // distance between ball position and nearest object in direction

        // calc distance
        if(direction == Direction.DirectionConstant.NORTH || direction == Direction.DirectionConstant.SOUTH) {
            distance = Math.abs(nextObjectPosition.getY() - position.getY());
        }
        else {
            distance = Math.abs(nextObjectPosition.getX() - position.getX());
        }

        // ThreadLocalRandom calls throws if range = [1; 1]
        if(distance == 1) {
            return 1;
        }

        return ThreadLocalRandom.current().nextInt(1, distance);
    }

    @Override
    public void move(Direction.DirectionConstant direction) {
        Position nextPosition;
        GameObject nextObject;

        // for rule: random balls of the same color can't get close
        Position throughOneCellPosition; // position through one cell
        GameObject throughOneCellObject;

        int steps = getRandomNumberSteps(direction);

        while (steps > 0) {
            nextPosition = getPosition().next(direction);
            throughOneCellPosition = nextPosition.next(direction);

            if(!field.hasPosition(nextPosition)) {
                return;
            }

            nextObject = field.getGameObject(nextPosition);

            if(field.hasPosition(throughOneCellPosition)) {
                throughOneCellObject = field.getGameObject(throughOneCellPosition);
            }
            else {
                throughOneCellObject = null;
            }

            // random balls of the same color can't get close
            if(throughOneCellObject != null && isBallSameColor(throughOneCellObject)) {
                return;
            }
            else if(nextObject == null) {
                setPosition(nextPosition);
            }
            else if(isBallColorGoal(nextObject)) {
                destroy();
                return;
            }
            else {
                return;
            }

            steps--;
        }
    }

    private boolean isBallSameColor(GameObject object) {
        return object instanceof Ball && (((Ball) object).getColor() == getColor());
    }
}
