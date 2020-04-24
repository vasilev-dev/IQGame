package Views.Environment.Background;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import static Views.Settings.BACKGROUND_FOLDER;

public class BackgroundSpriteFactory {
    private static BackgroundSpriteFactory instance;

    public static Animation background;

    private BackgroundSpriteFactory() throws SlickException {
        background = new Animation(new SpriteSheet(BACKGROUND_FOLDER, 64, 64), 40);
    }

    /**
     * Get instance of this class
     * @return instance
     * @throws SlickException if file of image cannot be opened
     */
    private static BackgroundSpriteFactory getInstance() throws SlickException {
        if(instance == null) {
            instance = new BackgroundSpriteFactory();
        }

        return instance;
    }

    /**
     * Get animation of background
     * @return animation of background
     * @throws SlickException if file of image cannot be opened
     */
    public static Animation getSprite() throws SlickException {
        getInstance();
        return background;
    }
}
