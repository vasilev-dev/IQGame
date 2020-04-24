package Views.GameObject.Goal;

import org.jetbrains.annotations.NotNull;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import static Views.Settings.*;
import static Views.Settings.YELLOW_GOAL_FOLDER;

public class GoalSpriteFactory {
    private static GoalSpriteFactory instance;

    public static Image redGoal;
    public static Image blueGoal;
    public static Image greenGoal;
    public static Image yellowGoal;

    private GoalSpriteFactory() throws SlickException {
        redGoal = new Image(RED_GOAL_FOLDER);
        blueGoal = new Image(BLUE_GOAL_FOLDER);
        greenGoal = new Image(GREEN_GOAL_FOLDER);
        yellowGoal = new Image(YELLOW_GOAL_FOLDER);
    }

    /**
     * Get instance of this class
     *
     * @return instance
     * @throws SlickException if file of image cannot be opened
     */
    private static GoalSpriteFactory getInstance() throws SlickException {
        if (instance == null) {
            instance = new GoalSpriteFactory();
        }

        return instance;
    }

    /**
     * Get image of goals
     *
     * @param color goal color
     * @return image of goal
     * @throws SlickException if file of image cannot be opened
     */
    public static Image getSprite(@NotNull Models.Color color) throws SlickException {
        getInstance();

        switch (color) {
            case RED:
                return redGoal;
            case BLUE:
                return blueGoal;
            case GREEN:
                return greenGoal;
            case YELLOW:
                return yellowGoal;
            default:
                throw new IllegalArgumentException("Not supported color!");
        }

    }
}
