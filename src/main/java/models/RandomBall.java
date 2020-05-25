package models;

import java.util.Random;

public class RandomBall extends Ball {
    private Random random = new Random();

    public RandomBall(Position position, GameField field, Color color) {
        super(position, field, color);
    }

    private int getRandomNumberSteps(Direction.DirectionConstant directionConstant) {
        var position = getPosition();

        if(directionConstant == Direction.DirectionConstant.NORTH ||
                directionConstant == Direction.DirectionConstant.SOUTH) {
            return field.getHeight() - position.getY();
        }

        return field.getWidth() - position.getX();
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
