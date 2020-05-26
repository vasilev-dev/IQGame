package levels;

import models.GameField;

import java.util.ArrayList;

/**
 * Guides the creations of levels
 */
public class LevelDirector {
    private ArrayList<GameField> levels = new ArrayList<>();
    private int currentLevel = 0;

    public LevelDirector() {
        levels.add(new Level1().createField());
        levels.add(new Level2().createField());
    }

    /**
     * Get next level of game
     * @return
     */
    public GameField nextLevel() {
        currentLevel++;
        return levels.size() > currentLevel ? levels.get(currentLevel) : null;
    }

    public GameField getCurrentLevel() {
        return levels.get(currentLevel);
    }

    /**
     * Current level is passed ?
     * @return true if current level is passed
     */
    public boolean currentLevelIsPassed() {
        return getCurrentLevel().getBalls().isEmpty();
    }
}
