package Views.Environment.Background;

import org.newdawn.slick.SlickException;

import static Views.Settings.SPRITE_RESOLUTION;

public class BackgroundDrawer {
    /**
     * Draw background
     * @param width screen width
     * @param height screen height
     * @throws SlickException if file of image cannot be opened
     */
    public static void drawBackground(int width, int height) throws SlickException {
        var animation = BackgroundSpriteFactory.getSprite();

        for(int x = 0; x < width; x += SPRITE_RESOLUTION) {
            for(int y = 0; y < height; y += SPRITE_RESOLUTION) {
                animation.draw(x, y);
            }
        }
    }
}
