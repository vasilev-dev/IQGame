package Models;

/**
 * Ball
 */
public class Ball extends ColorGameObject {
    public Ball(Position position, GameField field, Color color) {
        super(position, field, color);
    }

    /**
     * move ball
     * Ball will move until an obstacle or goal is encountered
     * @param direction direction
     */
    public void move(Direction.DirectionConstant direction) {
        Position nextPosition;
        GameObject nextObject;

        while (true) {
            nextPosition = getPosition().next(direction);

            if(!field.hasPosition(nextPosition)) {
                return;
            }

            nextObject = field.getGameObject(nextPosition);

            if(nextObject == null) {
                setPosition(nextPosition);
            }
            else {
                if(nextObject instanceof Goal &&
                        ((Goal) nextObject).getColor() == getColor())
                {
                    destroy();
                }

                return;
            }
        }
    }

    /**
     * Destroy ball
     */
    public void destroy() {
        field.destroyGameObject(this);
        field = null;
        setPosition(null);
        setColor(null);
    }
}
