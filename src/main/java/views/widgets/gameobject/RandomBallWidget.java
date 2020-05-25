package views.widgets.gameobject;

import models.*;
import org.jetbrains.annotations.NotNull;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;
import views.AssetSettings;

import java.util.HashMap;

public class RandomBallWidget extends GameObjectWidget {
    private final HashMap<Color, Image> assets = new HashMap<>();

    public RandomBallWidget(@NotNull GameObject gameObject) throws SlickException {
        super(gameObject);

        if(!(gameObject instanceof RandomBall)) {
            throw new IllegalArgumentException("Type of gameObject is not RandomBall");
        }

        initializeAssets();
    }

    private void initializeAssets() throws SlickException {
        assets.put(Color.YELLOW, new Image(AssetSettings.YELLOW_RANDOM_BALL_FOLDER));
        assets.put(Color.GREEN, new Image(AssetSettings.GREEN_RANDOM_BALL_FOLDER));
        assets.put(Color.BLUE, new Image(AssetSettings.BLUE_RANDOM_BALL_FOLDER));
        assets.put(Color.RED, new Image(AssetSettings.RED_RANDOM_BALL_FOLDER));
    }

    @Override
    public Renderable getAsset() {
        var color = ((ColorGameObject) gameObject).getColor();
        return assets.get(color);
    }
}
