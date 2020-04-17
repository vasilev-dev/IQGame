package Levels;

import Models.GameField;

/**
 * Guides the creations of levels
 */
public class LevelDirector {

    /**
     * Get level
     * @param level level number
     * @return field by input level number
     */
    public static GameField getLevel(int level) {
        LevelBuilder builder = getBuilder(level);

        if(builder == null) {
            throw new UnsupportedOperationException("Requested level is not implemented!");
        }
        else {
            return builder.createField();
        }
    }

    /**
     * Get builder for creating of level
     * @param level level number
     * @return level builder
     */
    private static LevelBuilder getBuilder(int level) {
        LevelBuilder builder = null;

        if(level == 0) {
            builder = new TestLevel();
        }
        else if(level == 1) {
            builder = new Level1();
        }

        return builder;
    }
}
