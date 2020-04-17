package Views;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import static Views.Settings.SPRITE_RESOLUTION;

/**
 * Class for rendering elements of the environment
 */
public class EnvironmentDrawer {
    /**
     * Draw background
     * @param width screen width
     * @param height screen height
     * @throws SlickException if file of image cannot be opened
     */
    public static void drawBackground(int width, int height) throws SlickException {
        var animation = SpriteFactory.getBackground();

        for(int x = 0; x < width; x += SPRITE_RESOLUTION) {
            for(int y = 0; y < height; y += SPRITE_RESOLUTION) {
                animation.draw(x, y);
            }
        }
    }

    /**
     * Draw end screen
     * @param gameIsPassed confirm
     * @throws SlickException if file of image cannot be opened
     */
    public static void drawEndScreen(boolean gameIsPassed) throws SlickException {
        if(gameIsPassed) {
            var endScreen = new Image(Settings.END_SCREEN);
            endScreen.draw(0, 0);
            endScreen.draw(0, 0);
        }
    }
}
