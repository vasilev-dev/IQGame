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
        switch (level) {
            case 0:
                return new TestLevel();
            case 1:
                return new Level1();
            default:
                return null;
        }
    }
}
