package Views.Widgets;

import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;

public interface HasRenderableAsset {
    Renderable getAsset() throws SlickException;
}
