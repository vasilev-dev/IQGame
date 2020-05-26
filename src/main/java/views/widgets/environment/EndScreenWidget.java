package views.widgets.environment;

import views.AssetSettings;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;
import views.widgets.Drawable;
import views.widgets.HasRenderableAsset;

/**
 * Rendered when game is passed
 */
public class EndScreenWidget implements Drawable, HasRenderableAsset {
    private Image asset;

    public EndScreenWidget() throws SlickException {
        asset = (Image) getAsset();
    }

    @Override
    public void draw() throws SlickException {
        asset.draw(0, 0);
    }

    @Override
    public Renderable getAsset() throws SlickException {
        return new Image(AssetSettings.END_SCREEN);
    }
}
