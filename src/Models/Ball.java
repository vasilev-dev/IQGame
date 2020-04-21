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

            if(!_field.hasPosition(nextPosition)) {
                return;
            }

            nextObject = _field.getGameObject(nextPosition);

            if(nextObject == null) {
                setPosition(nextPosition);
            }
            else {
                if(isBallColorGoal(nextObject))
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
        _field.destroyGameObject(this);
        setPosition(null);
        setColor(null);
    }

    /**
     * GameObject is this ball color goal?
     * @param gameObject
     * @return true, if gameObject is this ball color goal
     */
    private boolean isBallColorGoal(GameObject gameObject) {
        return gameObject instanceof Goal &&
            ((Goal) gameObject).getColor() == getColor();
    }
}
