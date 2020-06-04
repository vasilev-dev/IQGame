package models.gameobjects.balls.movement;

import models.Direction;
import models.Position;
import models.gameobjects.GameObject;
import models.gameobjects.balls.Ball;
import org.jetbrains.annotations.NotNull;

public class StandardMovementStrategy implements MovementStrategy {
    private Ball ball;

    public StandardMovementStrategy(@NotNull Ball ball) {
        this.ball = ball;
    }

    @Override
    public void move(Direction.DirectionConstant direction) {
        Position nextPosition;
        GameObject nextObject;

        // for rule: random balls of the same color can't get close
        Position throughOneCellPosition; // position through one cell
        GameObject throughOneCellObject;

        while (true) {
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
        }
    }
}
