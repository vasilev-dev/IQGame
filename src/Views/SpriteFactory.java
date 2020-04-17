package Views;

import org.newdawn.slick.*;

import static Views.Settings.*;

/**
 * Sprite factory
 */
public class SpriteFactory {
    private static SpriteFactory instance;

    public static Image redBall;
    public static Image blueBall;
    public static Image greenBall;
    public static Image yellowBall;

    public static Image redGoal;
    public static Image blueGoal;
    public static Image greenGoal;
    public static Image yellowGoal;

    public static Image wall;
    public static Image arrow;

    public static Animation background;


    private SpriteFactory() throws SlickException {
        redBall    = new Image(RED_BALL_FOLDER);
        blueBall   = new Image(BLUE_BALL_FOLDER);
        greenBall  = new Image(GREEN_BALL_FOLDER);
        yellowBall = new Image(YELLOW_BALL_FOLDER);

        redGoal    = new Image(RED_GOAL_FOLDER);
        blueGoal   = new Image(BLUE_GOAL_FOLDER);
        greenGoal  = new Image(GREEN_GOAL_FOLDER);
        yellowGoal = new Image(YELLOW_GOAL_FOLDER);

        wall       = new Image(WALL_FOLDER);
        arrow      = new Image(ARROW);

        background = new Animation(new SpriteSheet(BACKGROUND_FOLDER, 64, 64), 40);
    }

    /**
     * Get instance of this class
     * @return instance
     * @throws SlickException if file of image cannot be opened
     */
    private static SpriteFactory getInstance() throws SlickException {
        if(instance == null) {
            instance = new SpriteFactory();
        }

        return instance;
    }

    /**
     * Get image of wall
     * @return image of wall
     * @throws SlickException if file of image cannot be opened
     */
    public static Image getWall() throws SlickException {
        getInstance();
        return wall;
    }

    /**
     * Get image of ball
     * @param color ball color
     * @return image of ball
     * @throws SlickException if file of image cannot be opened
     */
    public static Image getBall(Models.Color color) throws SlickException {
        validateColor(color);
        getInstance();

        if(color == Models.Color.RED) {
            return redBall;
        }
        else if(color == Models.Color.BLUE) {
            return blueBall;
        }
        else if(color == Models.Color.GREEN) {
            return greenBall;
        }
        else {
            return yellowBall;
        }
    }

    /**
     * Get image of goals
     * @param color goal color
     * @return image of goal
     * @throws SlickException if file of image cannot be opened
     */
    public static Image getGoal(Models.Color color) throws SlickException {
        validateColor(color);
        getInstance();

        if(color == Models.Color.RED) {
            return redGoal;
        }
        else if(color == Models.Color.BLUE) {
            return blueGoal;
        }
        else if(color == Models.Color.GREEN) {
            return greenGoal;
        }
        else {
            return yellowGoal;
        }
    }

    /**
     * Get of image of arrow
     * @return image of arrow
     * @throws SlickException if file of image cannot be opened
     */
    public static Image getArrow() throws SlickException {
        return new Image(ARROW);
    }

    /**
     * Get animation of background
     * @return animation of background
     * @throws SlickException if file of image cannot be opened
     */
    public static Animation getBackground() throws SlickException {
        getInstance();
        return background;
    }

    /**
     * Validate color
     * @param color color
     * @exception NullPointerException if input color is null
     */
    private static void validateColor(Models.Color color) {
        if(color == null) {
            throw new NullPointerException("Input color is null!");
        }
    }

}
