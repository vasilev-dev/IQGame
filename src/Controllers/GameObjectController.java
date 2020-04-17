package Controllers;

import Models.GameField;
import Models.GameObject;
import Models.Position;

import static Views.Settings.SPRITE_RESOLUTION;

/**
 * Class for interacting game object's model and UI
 */
public class GameObjectController {
    /**
     * Get position by UI coordinates
     * @param x UI x
     * @param y UI y
     * @return position by UI coordinates
     */
    public static Position getPositionByUI(int x, int y) {
        return new Position(x / SPRITE_RESOLUTION, y / SPRITE_RESOLUTION);
    }

    /**
     * Get game object by UI coordinates
     * @param x UI x
     * @param y UI y
     * @param field game field for searching
     * @return game object if field has game object in this position; null id has not
     */
    public static GameObject getObjectByUI(int x, int y, GameField field) {
        return field.getGameObject(getPositionByUI(x, y));
    }
}
