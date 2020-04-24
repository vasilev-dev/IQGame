package Views;

import Models.Direction.*;
import Models.Position;
import org.newdawn.slick.SlickException;

import static Views.Settings.SPRITE_RESOLUTION;


/**
 * Class for drawing the direction of movement of the game object
 */
public class ArrowDrawer {
    private static Position _arrowPosition;
    private static DirectionConstant _arrowDirection;

    /**
     * Draw arrow
     * @throws SlickException
     */
    public static void drawArrow() throws SlickException {
        drawArrow(_arrowPosition, _arrowDirection);
    }

    /**
     * Draw arrow
     * @param position position on field for drawing
     * @param direction direction
     * @throws SlickException if file of image cannot be opened
     */
    public static void drawArrow(Position position, DirectionConstant direction) throws SlickException {
        if(position == null) {
            return;
        }

        int x = position.getX() * SPRITE_RESOLUTION;
        int y = position.getY() * SPRITE_RESOLUTION;

        var arrow = SpriteFactory.getArrow();

        if(direction == DirectionConstant.SOUTH) {
            arrow.rotate(180);
        }
        else if(direction == DirectionConstant.WEST) {
            arrow.rotate(-90);
        }
        else if(direction == DirectionConstant.EAST) {
            arrow.rotate(90);
        }

        arrow.draw(x, y);
    }

    /**
     * Set position and direction of arrow for render function
     * @param position
     * @param direction
     */
    public static void setArrow(Position position, DirectionConstant direction) {
        _arrowPosition = position;
        _arrowDirection = direction;
    }

    public static Position getArrowPosition() {
        return _arrowPosition;
    }

    public static DirectionConstant getArrowDirection() {
        return _arrowDirection;
    }

    /**
     * Destroy image of arrow from UI
     */
    public static void destroy() {
        _arrowPosition = null;
    }
}
