package views.widgets.gameobject;

import models.GameObject;
import models.Wall;
import views.AssetSettings;
import org.jetbrains.annotations.NotNull;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;

public class WallWidget extends GameObjectWidget {
    private final Image asset;

    public WallWidget(@NotNull GameObject gameObject) throws SlickException {
        super(gameObject);

        if(!(gameObject instanceof Wall)) {
            throw new IllegalArgumentException("Type of gameObject is not Wall");
        }

        asset = new Image(AssetSettings.WALL_FOLDER);
    }

    @Override
    public Renderable getAsset() throws SlickException {
        return asset;
    }
}
