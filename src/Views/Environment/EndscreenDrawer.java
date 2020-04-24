package Views.Environment;

import Views.Settings;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class EndscreenDrawer {
    /**
     * Draw end screen
     * @param gameIsPassed confirm
     * @throws SlickException if file of image cannot be opened
     */
    public static void drawEndScreen(boolean gameIsPassed) throws SlickException {
        if(gameIsPassed) {
            var endScreen = new Image(Settings.END_SCREEN);
            endScreen.draw(0, 0);
            endScreen.draw(0, 0);
        }
    }
}
