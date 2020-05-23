package levels;

import models.GameField;

/**
 * Create game objects
 */
public abstract class LevelBuilder {
    protected GameField field = new GameField(20, 10);;

    /**
     * Create field
     * @return
     */
    public GameField createField() {
        createBalls().createWalls().createGoals();
        return field;
    }

    /**
     * Create walls on field
     */
    public abstract LevelBuilder createWalls();

    /**
     * Create balls on field
     */
    public abstract LevelBuilder createBalls();

    /**
     * Create goals on field
     */
    public abstract LevelBuilder createGoals();
}
