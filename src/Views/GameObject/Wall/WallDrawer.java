package Views.GameObject.Wall;

import Models.Goal;
import Models.Wall;
import Views.GameObject.GameObjectDrawer;
import org.newdawn.slick.SlickException;

import java.util.Collection;

public class WallDrawer extends GameObjectDrawer {
    /**
     * Draw walls
     * @param walls walls
     * @throws SlickException if file of image cannot be opened
     */
    public static void draw(Collection<Wall> walls) throws SlickException {
        for (var wall: walls) {
            draw(wall);
        }
    }

    /**
     * Draw wall
     * @param wall wall
     * @throws SlickException if file of image cannot be opened
     */
    public static void draw(Wall wall) throws SlickException {
        var sprite = WallSpriteFactory.getSprite();
        draw(sprite, wall.getPosition());
    }
}
