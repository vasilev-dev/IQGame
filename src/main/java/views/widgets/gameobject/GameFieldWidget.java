package views.widgets.gameobject;

import controllers.BallMovementController;
import models.*;
import org.jetbrains.annotations.NotNull;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import views.widgets.Drawable;

import java.util.ArrayList;
import java.util.Collection;

public class GameFieldWidget implements Drawable {
    private GameField gameField;
    private BallMovementController ballMovementController;

    private Collection<GameObjectWidget> widgets = new ArrayList<>();

    public GameFieldWidget(@NotNull GameField gameField, @NotNull Input input) throws SlickException {
        this.gameField = gameField;

        ballMovementController = new BallMovementController(gameField);
        input.addMouseListener(ballMovementController);

        initializeWidgets();
    }

    /**
     * Create game object widgets in game field widget
     * @throws SlickException if could not open the file with asset
     */
    // TODO Вынести получение виджетов в новый класс WidgetFactory
    private void initializeWidgets() throws SlickException {
        for(var obj : gameField.getGameObjects()) {
            if(obj instanceof Ball) {
                widgets.add(new BallWidget(obj));
            }
            else if(obj instanceof Goal) {
                widgets.add(new GoalWidget(obj));
            }
            else if(obj instanceof Wall) {
                widgets.add(new WallWidget(obj));
            }
        }
    }

    /**
     * Update widgets if game objects has been changed
     */
    private void update() {
        for(var widget : widgets) {
            if(widget.getGameObject().getGameField() == null) {
                widgets.remove(widget);
                return;
            }
        }
    }

    @Override
    public void draw() throws SlickException {
        update();
        drawGameObjectWidgets();
        drawArrowWidget();
    }

    /**
     * Draw game object widgets
     * @throws SlickException if could not render widgets
     */
    private void drawGameObjectWidgets() throws SlickException {
        for(var widget : widgets) {
            widget.draw();
        }
    }

    /**
     * Draw arrow if user controls ball
     * @throws SlickException if could not render widget
     */
    private void drawArrowWidget() throws SlickException {
        var arrowWidget = ballMovementController.getArrowWidget();

        if(arrowWidget != null) {
            arrowWidget.draw();
        }
    }
}
