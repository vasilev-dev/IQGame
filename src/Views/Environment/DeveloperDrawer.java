package Views.Environment;

import org.newdawn.slick.Color;
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
     * @param color grid color
     */
    public static void drawGrid(boolean isShow, GameContainer gameContainer, Graphics graphics, Color color) {
        if(!isShow) {
            return;
        }

        graphics.setColor(color);

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
     * @param color text color
     */
    public static void drawCellPosition(boolean isShow, GameContainer gameContainer, Graphics graphics, Color color) {
        if(!isShow) {
            return;
        }

        graphics.setColor(color);

        for(int x = 0; x < gameContainer.getWidth(); x += SPRITE_RESOLUTION) {
            for(int y = 0; y < gameContainer.getHeight(); y += SPRITE_RESOLUTION) {
                graphics.drawString(x / SPRITE_RESOLUTION + ";"
                        + y / SPRITE_RESOLUTION, x, y );
            }
        }
    }
}
