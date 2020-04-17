package Views;

import Models.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import static Views.Settings.SPRITE_RESOLUTION;

/**
 * Class for drawing all game objects on the field
 */
public class GameObjectDrawer {
    /**
     * Draw field
     * @param field game field
     * @throws SlickException if file of image cannot be opened
     */
    public static void draw(GameField field) throws SlickException {
        for(var obj : field.getGameObjects()) {
            draw(obj);
        }
    }

    /**
     * Draw game object
     * @param obj game object
     * @throws SlickException if file of image cannot be opened
     */
    public static void draw(GameObject obj) throws SlickException {
        if(obj instanceof Ball) {
            draw((Ball) obj);
        }
        else if(obj instanceof Wall) {
            draw((Wall) obj);
        }
        else if(obj instanceof Goal) {
            draw((Goal) obj);
        }
        else {
            throw new IllegalArgumentException("Unrealized drawing of input type of game object!");
        }
    }

    /**
     * Draw ball
     * @param ball ball
     * @throws SlickException if file of image cannot be opened
     */
    public static void draw(Ball ball) throws SlickException {
        var sprite = SpriteFactory.getBall(ball.getColor());
        draw(sprite, ball.getPosition());
    }

    /**
     * Draw goal
     * @param goal goal
     * @throws SlickException if file of image cannot be opened
     */
    public static void draw(Goal goal) throws SlickException {
        var sprite = SpriteFactory.getGoal(goal.getColor());
        draw(sprite, goal.getPosition());
    }

    /**
     * Draw wall
     * @param wall wall
     * @throws SlickException if file of image cannot be opened
     */
    public static void draw(Wall wall) throws SlickException {
        var sprite = SpriteFactory.getWall();
        draw(sprite, wall.getPosition());
    }

    /**
     * Draw sprite
     * @param sprite image of sprite
     * @param position position of game object on field
     * @throws SlickException if file of image cannot be opened
     */
    private static void draw(Image sprite, Position position) throws SlickException {
        sprite.draw(position.getX() * SPRITE_RESOLUTION, position.getY() * SPRITE_RESOLUTION);
    }
}
