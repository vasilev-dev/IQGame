/**
 * Settings of game
 */
public class Settings {
    private String _gameName;
    private boolean _showGrid;
    private boolean _showCellPosition;
    private boolean _showFPS;

    public Settings(String gameName, boolean showGrid, boolean showCellPosition, boolean showFPS) {
        _gameName = gameName;
        _showGrid = showGrid;
        _showCellPosition = showCellPosition;
        _showFPS = showFPS;
    }

    public String getGameName() {
        return _gameName;
    }

    public boolean showGrid() {
        return _showGrid;
    }

    public boolean showCellPosition() {
        return _showCellPosition;
    }

    public boolean showFPS() {
        return  _showFPS;
    }
}
