package models.gameobjects.movement;

import models.Direction;
import models.Position;
import models.gameobjects.GameObject;
import models.gameobjects.balls.Ball;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMovementStrategy implements MovementStrategy {
    private Ball ball;

    public RandomMovementStrategy(@NotNull Ball ball) {
        this.ball = ball;
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
            nextPosition = ball.getPosition().next(direction);
            throughOneCellPosition = nextPosition.next(direction);

            if(!ball.getGameField().hasPosition(nextPosition)) {
                return;
            }

            nextObject = ball.getGameField().getGameObject(nextPosition);

            if(ball.getGameField().hasPosition(throughOneCellPosition)) {
                throughOneCellObject = ball.getGameField().getGameObject(throughOneCellPosition);
            }
            else {
                throughOneCellObject = null;
            }

            // random balls of the same color can't get close
            if(throughOneCellObject != null && ball.isSameColorBall(throughOneCellObject)) {
                return;
            }
            else if(nextObject == null) {
                ball.setPosition(nextPosition);
            }
            else if(ball.isBallColorGoal(nextObject)) {
                ball.destroy();
                return;
            }
            else {
                return;
            }

            steps--;
        }
    }

    /**
     * Get random number of steps by which to move the ball
     * @param direction direction of moving
     * @return random number of step
     */
    private int getRandomNumberSteps(Direction.DirectionConstant direction) {
        var position = ball.getPosition();
        var nextObjectPosition = ball.getGameField().getNearestObject(position, direction).getPosition();
        int distance = position.distance(nextObjectPosition);

        // ThreadLocalRandom calls throws if range = [1; 1]
        if(distance == 1) {
            return 1;
        }

        return ThreadLocalRandom.current().nextInt(1, distance + 1);
    }
}
