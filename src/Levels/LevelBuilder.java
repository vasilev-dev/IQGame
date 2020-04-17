package Levels;

import Models.GameField;

/**
 * Create game objects
 */
public abstract class LevelBuilder {
    /**
     * Create field
     * @return
     */
    public GameField createField() {
        GameField field = new GameField(20, 10);

        createBalls(field);
        createWalls(field);
        createGoals(field);

        return field;
    }

    /**
     * Create walls on field
     * @param field field
     */
    protected abstract void createWalls(GameField field);

    /**
     * Create balls on field
     * @param field field
     */
    protected abstract void createBalls(GameField field);

    /**
     * Create goals on field
     * @param field field
     */
    protected abstract void createGoals(GameField field);
}
