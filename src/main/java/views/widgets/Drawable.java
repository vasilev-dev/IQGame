package views.widgets;

import org.newdawn.slick.SlickException;

/**
 * Object can be rendered when rendering
 */
public interface Drawable {
    /**
     * Draw object
     * @throws SlickException if could not draw asset
     */
    void draw() throws SlickException;
}
