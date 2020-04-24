package Views.GameObject.Goal;

import Models.Ball;
import Models.Goal;
import Views.GameObject.GameObjectDrawer;
import org.newdawn.slick.SlickException;

import java.util.Collection;

public class GoalDrawer extends GameObjectDrawer {
    /**
     * Draw goals
     * @param goals goals
     * @throws SlickException if file of image cannot be opened
     */
    public static void draw(Collection<Goal> goals) throws SlickException {
        for (var goal: goals) {
            draw(goal);
        }
    }

    /**
     * Draw goal
     * @param goal goal
     * @throws SlickException if file of image cannot be opened
     */
    public static void draw(Goal goal) throws SlickException {
        var sprite = GoalSpriteFactory.getSprite(goal.getColor());
        draw(sprite, goal.getPosition());
    }
}
