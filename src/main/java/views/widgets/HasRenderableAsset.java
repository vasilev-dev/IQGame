package views.widgets;

import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;

/**
 * Object has Slick2d.Renderable asset
 */
public interface HasRenderableAsset {
    /**
     * Get Slick2d.Renderable asset
     * @return asset
     * @throws SlickException if could not open the file with asset
     */
    Renderable getAsset() throws SlickException;
}
