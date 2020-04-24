import Controllers.BallController;
import Levels.LevelDirector;
import Models.*;
import Views.Arrow.ArrowDrawer;
import Views.Environment.DeveloperDrawer;
import Views.Environment.Background.BackgroundDrawer;
import Views.Environment.EndscreenDrawer;
import Views.GameObject.Ball.BallDrawer;
import Views.GameObject.Goal.GoalDrawer;
import Views.GameObject.Wall.WallDrawer;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;

public class IQGame extends BasicGame {
    // TODO одинаковый код для синглтонов в GameObject ***Drawer
    // TODO одинаковый код в GameObject ***Drawer.draw(Collection<***>)

    private boolean _showGrid;
    private boolean _showCellPositions;
    private Sound _endGameSound;

    private GameField _field;

    private Input _input;
    private BallController _ballController;

    public IQGame(boolean showGrid, boolean showCellPositions) throws SlickException {
        super("IQGame");
        _showGrid = showGrid;
        _showCellPositions = showCellPositions;
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        gameContainer.setShowFPS(true);

        _field = LevelDirector.getLevel(0);

        _ballController = new BallController(_field);

        _input = gameContainer.getInput();
        _input.addMouseListener(_ballController);

        _endGameSound = new Sound("files/sounds/endgame.wav");
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        // play sound if game is passed
        if(isPassed() && !_endGameSound.playing()) {
            _endGameSound.play(1, 0.3f);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        BackgroundDrawer.drawBackground(gameContainer.getWidth(), gameContainer.getHeight());
        BallDrawer.draw(_field.getBalls());
        GoalDrawer.draw(_field.getGoals());
        WallDrawer.draw(_field.getWalls());
        ArrowDrawer.drawArrow();
        DeveloperDrawer.drawGrid(_showGrid, gameContainer, graphics, Color.lightGray);
        DeveloperDrawer.drawCellPosition(_showCellPositions, gameContainer, graphics, Color.lightGray);
        EndscreenDrawer.drawEndScreen(isPassed());
    }

    /**
     * Game is passed ?
     * @return true, if all balls are gone
     */
    private boolean isPassed() {
        return _field.getBalls().isEmpty();
    }

}
