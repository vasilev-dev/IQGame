package views.widgets.environment;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import views.widgets.Drawable;
import views.widgets.HasRenderableAsset;

import static views.AssetSettings.BACKGROUND_FOLDER;
import static views.AssetSettings.SPRITE_RESOLUTION;

public class BackgroundWidget implements Drawable, HasRenderableAsset {
    private Animation asset;
    private int width, height;

    public BackgroundWidget(int width, int height) throws SlickException {
        this.width = width;
        this.height = height;

        asset = (Animation) getAsset();
    }

    @Override
    public void draw() throws SlickException {
        for(int x = 0; x < width; x += SPRITE_RESOLUTION) {
            for(int y = 0; y < height; y += SPRITE_RESOLUTION) {
                asset.draw(x, y);
            }
        }
    }

    @Override
    public Renderable getAsset() throws SlickException {
        return new Animation(new SpriteSheet(BACKGROUND_FOLDER, 64, 64), 40);
    }
}
