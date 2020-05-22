import Levels.LevelDirector;
import Models.GameField;
import Views.Widgets.Drawable;
import Views.Widgets.EnvironmentWidgets.BackgroundWidget;
import Views.Widgets.DeveloperWidgets.CellPositionWidget;
import Views.Widgets.DeveloperWidgets.GridWidget;
import Views.Widgets.EnvironmentWidgets.EndscreenWidget;
import Views.Widgets.GameObjectWidgets.GameFieldWidget;
import org.jetbrains.annotations.NotNull;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;

import java.util.LinkedList;

public class IQGame extends BasicGame {
    private @NotNull Settings settings;
    private LinkedList<Drawable> widgets = new LinkedList<>();
    private LevelDirector levelDirector = new LevelDirector();
    private GameFieldWidget gameFieldWidget;
    private boolean gameIsPassed = false;

    public IQGame(@NotNull Settings settings) throws SlickException {
        super(settings.getGameName());
        this.settings = settings;
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        gameContainer.setShowFPS(settings.showFPS());
        gameFieldWidget = new GameFieldWidget(levelDirector.getCurrentLevel(), gameContainer.getInput());
        initializeWidgets(gameContainer);
    }

    private void initializeWidgets(GameContainer gameContainer) throws SlickException {
        widgets.add(new BackgroundWidget(gameContainer.getWidth(), gameContainer.getHeight()));
        if(settings.showGrid()) widgets.add(new GridWidget(gameContainer, Color.lightGray));
        if(settings.showCellPosition()) widgets.add(new CellPositionWidget(gameContainer, Color.lightGray));
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        if(!gameIsPassed && levelDirector.currentLevelIsPassed()) {
            var nextLevel = levelDirector.nextLevel();
            if(nextLevel != null) {
                gameFieldWidget = new GameFieldWidget(nextLevel, gameContainer.getInput());
            }
            else {
                gameIsPassed = true;
            }
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        if(!gameIsPassed) {
            for (var widget : widgets) {
                widget.draw();
            }
            gameFieldWidget.draw();
        }
        else {
            new EndscreenWidget().draw();
        }
    }
}
