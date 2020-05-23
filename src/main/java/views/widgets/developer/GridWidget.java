package views.widgets.developer;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import views.widgets.Drawable;

import static views.AssetSettings.SPRITE_RESOLUTION;

public class GridWidget implements Drawable {
    private GameContainer gameContainer;
    private Color color;

    public GridWidget(GameContainer gameContainer, Color color) {
        this.gameContainer = gameContainer;
        this.color = color;
    }

    /**
     * Draw grid
     */
    @Override
    public void draw() {
        var graphics = gameContainer.getGraphics();
        graphics.setColor(color);

        for(int x = 0; x < gameContainer.getWidth(); x += SPRITE_RESOLUTION) {
            for(int y = 0; y < gameContainer.getHeight(); y += SPRITE_RESOLUTION) {
                graphics.drawRect(x, y, SPRITE_RESOLUTION, SPRITE_RESOLUTION);
            }
        }
    }
}
