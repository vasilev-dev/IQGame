package Views.Wall;

import Models.Wall;
import Views.SpriteFactory;
import org.newdawn.slick.SlickException;

public class WallDrawer {
    /**
     * Draw wall
     * @param wall wall
     * @throws SlickException if file of image cannot be opened
     */
    public static void draw(Wall wall) throws SlickException {
        var sprite = WallSpriteFactory.getImage();
        draw(sprite, wall.getPosition());
    }
}
