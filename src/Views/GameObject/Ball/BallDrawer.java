package Views.GameObject.Ball;

import Models.Ball;
import Views.GameObject.GameObjectDrawer;
import org.newdawn.slick.SlickException;

import java.util.Collection;

public class BallDrawer extends GameObjectDrawer {
    /**
     * Draw balls
     * @param balls balls
     * @throws SlickException if file of image cannot be opened
     */
    public static void draw(Collection<Ball> balls) throws SlickException {
        for (var ball: balls) {
            draw(ball);
        }
    }

    /**
     * Draw ball
     * @param ball ball
     * @throws SlickException if file of image cannot be opened
     */
    public static void draw(Ball ball) throws SlickException {
        var sprite = BallSpriteFactory.getSprite(ball.getColor());
        draw(sprite, ball.getPosition());
    }
}
