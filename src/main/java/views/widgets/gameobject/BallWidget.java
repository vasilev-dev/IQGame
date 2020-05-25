package views.widgets.gameobject;

import models.Ball;
import models.Color;
import models.ColorGameObject;
import models.GameObject;
import views.AssetSettings;
import org.jetbrains.annotations.NotNull;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;

import java.util.HashMap;


public class BallWidget extends GameObjectWidget {
    private final HashMap<Color, Image> assets = new HashMap<>();

    public BallWidget(@NotNull GameObject gameObject) throws SlickException {
        super(gameObject);

        if(!(gameObject instanceof Ball)) {
            throw new IllegalArgumentException("Type of gameObject is not Ball");
        }

        initializeAssets();
    }

    private void initializeAssets() throws SlickException {
        assets.put(Color.YELLOW, new Image(AssetSettings.YELLOW_BALL_FOLDER));
        assets.put(Color.GREEN, new Image(AssetSettings.GREEN_BALL_FOLDER));
        assets.put(Color.BLUE, new Image(AssetSettings.BLUE_BALL_FOLDER));
        assets.put(Color.RED, new Image(AssetSettings.RED_BALL_FOLDER));
    }

    @Override
    public Renderable getAsset() {
        var color = ((ColorGameObject) gameObject).getColor();
        return assets.get(color);
    }
}
