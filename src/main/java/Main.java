import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
    public static void main(String[] args) throws SlickException {
        Settings settings = new Settings("IQGame", false, false, true);
        AppGameContainer app = new AppGameContainer(new IQGame(settings));
        app.setDisplayMode(1280,640,false);
        app.start();
    }
}

