package models.gameobjects;

import models.Color;
import models.Direction;
import models.Position;

import java.util.concurrent.ThreadLocalRandom;

public class RandomBall extends Ball {
    public RandomBall(Position position, GameField field, Color color) {
        super(position, field, color);
    }

    private int getRandomNumberSteps(Direction.DirectionConstant direction) {
        var position = getPosition();
        var nextObjectPosition = field.getNearestObject(position, direction).getPosition();
        int distance;

        if(direction == Direction.DirectionConstant.NORTH || direction == Direction.DirectionConstant.SOUTH) {
            distance = Math.abs(nextObjectPosition.getY() - position.getY());
        }
        else {
            distance = Math.abs(nextObjectPosition.getX() - position.getX());
        }

        if(distance == 1) {
            return 1;
        }

        return ThreadLocalRandom.current().nextInt(1, distance);
    }

    @Override
    public void move(Direction.DirectionConstant direction) {
        Position nextPosition;
        GameObject nextObject;
        Position throughOneCellPosition;
        GameObject throughOneCellObject;

        int steps = getRandomNumberSteps(direction);

        while (steps > 0) {
            nextPosition = getPosition().next(direction);
            throughOneCellPosition = nextPosition.next(direction);

            if(!field.hasPosition(nextPosition)) {
                return;
            }

            nextObject = field.getGameObject(nextPosition);
            throughOneCellObject = field.getGameObject(throughOneCellPosition);

            if(isBallSameColor(throughOneCellObject)) {
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
