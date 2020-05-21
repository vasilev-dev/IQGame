package Levels;

import Models.GameField;

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

    public GameField nextLevel() {
        currentLevel++;
        return levels.size() > currentLevel ? levels.get(currentLevel) : null;
    }

    public GameField getCurrentLevel() {
        return levels.get(currentLevel);
    }

    public boolean currentLevelIsPassed() {
        return getCurrentLevel().getBalls().isEmpty();
    }
}
