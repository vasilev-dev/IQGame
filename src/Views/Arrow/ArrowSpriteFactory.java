package Views.Arrow;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import static Views.Settings.ARROW;

public class ArrowSpriteFactory {
    private static ArrowSpriteFactory instance;

    public static Image arrow;

    private ArrowSpriteFactory() throws SlickException {
        arrow = new Image(ARROW);
    }

    /**
     * Get instance of this class
     * @return instance
     * @throws SlickException if file of image cannot be opened
     */
    private static ArrowSpriteFactory getInstance() throws SlickException {
        if(instance == null) {
            instance = new ArrowSpriteFactory();
        }

        return instance;
    }

    /**
     * Get of image of arrow
     * @return image of arrow
     * @throws SlickException if file of image cannot be opened
     */
    public static Image getSprite() throws SlickException {
        return new Image(ARROW);
    }
}
