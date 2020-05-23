package views;

import models.GameField;
import models.GameObject;
import models.Position;

import static views.AssetSettings.SPRITE_RESOLUTION;

/**
 * Class for interacting game object's model and view
 */
public class GameObjectView {
    /**
     * Get position by view coordinates
     * @param x view x
     * @param y view y
     * @return position by view coordinates
     */
    private static Position getPositionByView(int x, int y) {
        return new Position(x / SPRITE_RESOLUTION, y / SPRITE_RESOLUTION);
    }

    /**
     * Get game object by view coordinates
     * @param x view x
     * @param y view y
     * @param field game field for searching
     * @return game object if field has game object in this position; null id has not
     */
    public static GameObject getObjectByView(int x, int y, GameField field) {
        return field.getGameObject(getPositionByView(x, y));
    }
}
