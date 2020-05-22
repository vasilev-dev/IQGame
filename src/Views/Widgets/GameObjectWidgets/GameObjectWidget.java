package Views.Widgets.GameObjectWidgets;

import Models.GameObject;
import Views.Widgets.Drawable;
import Views.Widgets.HasRenderableAsset;
import org.jetbrains.annotations.NotNull;
import org.newdawn.slick.SlickException;
import static Views.AssetSettings.SPRITE_RESOLUTION;

public abstract class GameObjectWidget implements Drawable, HasRenderableAsset {
    protected GameObject gameObject;

    public GameObjectWidget(@NotNull GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @Override
    public void draw() throws SlickException {
        var position = gameObject.getPosition();
        getAsset().draw(position.getX() * SPRITE_RESOLUTION, position.getY() * SPRITE_RESOLUTION);
    }

    public GameObject getGameObject() {
        return gameObject;
    }
}
