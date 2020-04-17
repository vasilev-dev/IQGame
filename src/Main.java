import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new IQGame(true, true));
        app.setDisplayMode(1280,640,false);
        app.start();
    }
}

