package Controllers;

import Models.Ball;
import Models.Direction.*;
import Models.GameField;
import Models.GameObject;
import Views.GameObjectView;
import Views.Widgets.EnvironmentWidgets.ArrowWidget;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

import static Models.Direction.getDirection;

/**
 * Controller of moving of ball
 * Pipeline: mousePressed -> mouseDragged -> mouseReleased
 */
public class BallMovementController implements MouseListener {
    private GameField field;

    private Ball ball;
    private int oldx, oldy; // UI coordinates of user's selected ball
    private DirectionConstant lastDirection; // last direction of user's selected
    private ArrowWidget arrowWidget;

    public BallMovementController(GameField field) {
        this.field = field;
    }

    /**
     * User select ball
     * @param i mouse button
     * @param i1 UI x
     * @param i2 UI y
     */
    @Override
    public void mousePressed(int i, int i1, int i2) {
        if(i != (int)Input.MOUSE_LEFT_BUTTON) {
            return;
        }

        oldx = i1;
        oldy = i2;

        GameObject clickedObject = GameObjectView.getObjectByView(i1, i2, field);

        if(clickedObject instanceof Ball) {
            ball = (Ball) clickedObject;
            oldx = i1;
            oldy = i2;

            arrowWidget = new ArrowWidget(ball.getPosition());
        }
    }

    /**
     * User selecting direction
     * @param i old UI x
     * @param i1 old UI y
     * @param i2 new UI x
     * @param i3 new UI y
     */
    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {
        if(ball != null) {
            // calc direction
            Vector2f start = new Vector2f(oldx, oldy);
            Vector2f dragged = new Vector2f(i2, i3);

            double angle = Math.atan2(-(dragged.y - start.y), dragged.x - start.x) * 180 / Math.PI;
            lastDirection = getDirection(angle);

            // set arrow direction by selected user's direction; render is done IGame.render()
            arrowWidget.setDirection(lastDirection);
        }
    }

    public ArrowWidget getArrowWidget() {
        return arrowWidget;
    }

    /**
     * User move ball
     * @param i mouse button
     * @param i1 UI x
     * @param i2 UI y
     */
    @Override
    public void mouseReleased(int i, int i1, int i2) {
        if(ball != null) {

            ball.move(lastDirection);
            ball = null;
            arrowWidget.destroy();
            arrowWidget = null;
        }
    }

    /**
     * Accept listening mouse event by this class
     * @return
     */
    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    //region Rudimentary methods
    @Override
    public void mouseWheelMoved(int i) {

    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {

    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {

    }

    @Override
    public void setInput(Input input) {

    }

    @Override
    public void inputEnded() {

    }

    @Override
    public void inputStarted() {

    }
    //endregion
}
