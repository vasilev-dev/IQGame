package views.Widgets.EnvironmentWidgets;

import views.AssetSettings;
import views.Widgets.Drawable;
import views.Widgets.HasRenderableAsset;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;

public class EndscreenWidget implements Drawable, HasRenderableAsset {
    private Image asset;

    public EndscreenWidget() throws SlickException {
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
