/**
 * Settings of game
 */
public class Settings {
    private String gameName;
    private boolean showGrid;
    private boolean showCellPosition;
    private boolean showFPS;

    public Settings(String gameName, boolean showGrid, boolean showCellPosition, boolean showFPS) {
        this.gameName = gameName;
        this.showGrid = showGrid;
        this.showCellPosition = showCellPosition;
        this.showFPS = showFPS;
    }

    public String getGameName() {
        return this.gameName;
    }

    public boolean showGrid() {
        return this.showGrid;
    }

    public boolean showCellPosition() {
        return this.showCellPosition;
    }

    public boolean showFPS() {
        return  this.showFPS;
    }
}
