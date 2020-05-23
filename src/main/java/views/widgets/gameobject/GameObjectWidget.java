package views.Widgets.GameObjectWidgets;

import models.GameObject;
import views.Widgets.Drawable;
import views.Widgets.HasRenderableAsset;
import org.jetbrains.annotations.NotNull;
import org.newdawn.slick.SlickException;
import static views.AssetSettings.SPRITE_RESOLUTION;

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
