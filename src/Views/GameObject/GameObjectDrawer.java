package Views.GameObject;

import Models.Ball;
import Models.GameField;
import Models.Goal;
import Models.Position;
import Views.GameObject.Ball.BallDrawer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import static Views.Settings.SPRITE_RESOLUTION;

public class GameObjectDrawer {
    /**
     * Draw sprite
     * @param sprite image of sprite
     * @param position position of game object on field
     * @throws SlickException if file of image cannot be opened
     */
    protected static void draw(Image sprite, Position position) throws SlickException {
        sprite.draw(position.getX() * SPRITE_RESOLUTION, position.getY() * SPRITE_RESOLUTION);
    }
}
