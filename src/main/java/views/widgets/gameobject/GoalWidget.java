package views.widgets.gameobject;

import models.Color;
import models.ColorGameObject;
import models.GameObject;
import models.Goal;
import views.AssetSettings;
import org.jetbrains.annotations.NotNull;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;

import java.util.HashMap;

public class GoalWidget extends GameObjectWidget {
    private final HashMap<Color, Image> assets = new HashMap<>();

    public GoalWidget(@NotNull GameObject gameObject) throws SlickException {
        super(gameObject);

        if(!(gameObject instanceof Goal)) {
            throw new IllegalArgumentException("Type of gameObject is not Goal");
        }

        initializeAssets();
    }

    private void initializeAssets() throws SlickException {
        assets.put(Color.YELLOW, new Image(AssetSettings.YELLOW_GOAL_FOLDER));
        assets.put(Color.GREEN, new Image(AssetSettings.GREEN_GOAL_FOLDER));
        assets.put(Color.BLUE, new Image(AssetSettings.BLUE_GOAL_FOLDER));
        assets.put(Color.RED, new Image(AssetSettings.RED_GOAL_FOLDER));
    }

    @Override
    public Renderable getAsset() throws SlickException {
        var color = ((ColorGameObject) gameObject).getColor();
        return assets.get(color);
    }
}
