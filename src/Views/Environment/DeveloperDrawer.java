package Views;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import static Views.Settings.SPRITE_RESOLUTION;

/**
 * Class for rendering auxiliary elements during development
 */
public class DeveloperDrawer {
    /**
     * Draw grid
     * @param isShow confirm
     * @param gameContainer game container
     * @param graphics graphics
     */
    public static void drawGrid(boolean isShow, GameContainer gameContainer, Graphics graphics) {
        if(!isShow) {
            return;
        }

        for(int x = 0; x < gameContainer.getWidth(); x += SPRITE_RESOLUTION) {
            for(int y = 0; y < gameContainer.getHeight(); y += SPRITE_RESOLUTION) {
                graphics.drawRect(x, y, SPRITE_RESOLUTION, SPRITE_RESOLUTION);
            }
        }
    }

    /**
     * Draw cell positions
     * @param isShow confirm
     * @param gameContainer game container
     * @param graphics graphics
     */
    public static void drawCellPosition(boolean isShow, GameContainer gameContainer, Graphics graphics) {
        if(!isShow) {
            return;
        }

        for(int x = 0; x < gameContainer.getWidth(); x += SPRITE_RESOLUTION) {
            for(int y = 0; y < gameContainer.getHeight(); y += SPRITE_RESOLUTION) {
                graphics.drawString(Integer.toString(x / SPRITE_RESOLUTION) + ";"
                        + Integer.toString(y / SPRITE_RESOLUTION), x, y );
            }
        }
    }
}
