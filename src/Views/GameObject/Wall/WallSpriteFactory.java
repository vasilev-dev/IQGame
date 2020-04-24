package Views.Wall;

import Views.SpriteFactory;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import static Views.Settings.WALL_FOLDER;

public class WallSpriteFactory {
    private static WallSpriteFactory instance;

    public static Image wall;

    private WallSpriteFactory() throws SlickException {
        wall = new Image(WALL_FOLDER);
    }

    /**
     * Get instance of this class
     * @return instance
     * @throws SlickException if file of image cannot be opened
     */
    private static WallSpriteFactory getInstance() throws SlickException {
        if(instance == null) {
            instance = new WallSpriteFactory();
        }

        return instance;
    }

    /**
     * Get image of wall
     * @return image of wall
     * @throws SlickException if file of image cannot be opened
     */
    public static Image getImage() throws SlickException {
        getInstance();
        return wall;
    }
}
