package Views.GameObject.Ball;

import org.jetbrains.annotations.NotNull;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import static Views.Settings.*;
import static Views.Settings.YELLOW_BALL_FOLDER;

public class BallSpriteFactory {
    private static BallSpriteFactory instance;

    public static Image redBall;
    public static Image blueBall;
    public static Image greenBall;
    public static Image yellowBall;

    private BallSpriteFactory() throws SlickException {
        redBall    = new Image(RED_BALL_FOLDER);
        blueBall   = new Image(BLUE_BALL_FOLDER);
        greenBall  = new Image(GREEN_BALL_FOLDER);
        yellowBall = new Image(YELLOW_BALL_FOLDER);
    }

    /**
     * Get instance of this class
     * @return instance
     * @throws SlickException if file of image cannot be opened
     */
    private static BallSpriteFactory getInstance() throws SlickException {
        if(instance == null) {
            instance = new BallSpriteFactory();
        }

        return instance;
    }

    /**
     * Get image of ball
     * @param color ball color
     * @return image of ball
     * @throws SlickException if file of image cannot be opened
     */
    public static Image getSprite(@NotNull Models.Color color) throws SlickException {
        getInstance();

        switch (color) {
            case RED:
                return redBall;
            case BLUE:
                return blueBall;
            case GREEN:
                return greenBall;
            case YELLOW:
                return yellowBall;
            default:
                throw new IllegalArgumentException("Not supported color!");
        }
    }
}
