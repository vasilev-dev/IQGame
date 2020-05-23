package views.Widgets.DeveloperWidgets;

import views.Widgets.Drawable;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;

import static views.AssetSettings.SPRITE_RESOLUTION;

public class CellPositionWidget implements Drawable {
    private GameContainer gameContainer;
    private Color color;

    public CellPositionWidget(GameContainer gameContainer, Color color) {
        this.gameContainer = gameContainer;
        this.color = color;
    }

    /**
     * Draw cell positions
     */
    @Override
    public void draw() {
        var graphics = gameContainer.getGraphics();
        graphics.setColor(color);

        for(int x = 0; x < gameContainer.getWidth(); x += SPRITE_RESOLUTION) {
            for(int y = 0; y < gameContainer.getHeight(); y += SPRITE_RESOLUTION) {
                graphics.drawString(x / SPRITE_RESOLUTION + ";"
                        + y / SPRITE_RESOLUTION, x, y );
            }
        }
    }
}
