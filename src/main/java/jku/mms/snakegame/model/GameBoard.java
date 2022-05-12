package jku.mms.snakegame.model;

import javafx.scene.paint.Color;

import static jku.mms.snakegame.model.Tile.TILE_SIZE;

/**
 * GameBoard is the class which represents the 2D map of the game grid.
 * Each element of the board is represented as a Tile.
 */
public class GameBoard {
    private final int width;
    private final int height;
    private final Tile[][] tileMap;

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        tileMap = new Tile[getRows()][getColumns()];
        setTileBackground();
    }

    public int getRows() {
        return width / TILE_SIZE;
    }

    public int getColumns() {
        return height / TILE_SIZE;
    }

    public Tile getTile(int row, int column) {
        Tile foundTile = tileMap[row][column];

        if (foundTile == null) {
            throw new NullPointerException("No Tile with the coordinates { row: " + row + " column: " + column + " } exist for this gameboard.");
        }

        return foundTile;
    }

    /**
     * Sets every Tile of the board to a green colour making up the background.
     * This method should be called when the GameBoard is created.
     */
    private void setTileBackground() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if ((i + j) % 2 == 0) {
                    tileMap[i][j] = new Tile(TyleType.BACKGROUND, Color.web("AAD751"));
                } else {
                    tileMap[i][j] = new Tile(TyleType.BACKGROUND, Color.web("A2D149"));
                }
            }
        }
    }
}
