package jku.mms.snakegame.model;

import jku.mms.snakegame.model.tile.Tile;
import jku.mms.snakegame.model.tile.TileType;
import jku.mms.snakegame.model.collectibles.Collectible;
import jku.mms.snakegame.model.collectibles.CollectibleType;

import java.util.List;
import java.util.Random;

import static jku.mms.snakegame.model.tile.Tile.TILE_SIZE;

/**
 * GameBoard is the class which represents the 2D map of the game grid.
 * Each element of the board is represented as a Tile.
 */
public class GameBoard {
    private final int width;
    private final int height;
    private final Tile[][] tileMap;
    private Snake snake;
    private boolean existsFog = false;
    private boolean existsBlur = false;

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        tileMap = new Tile[getRows()][getColumns()];
        setTileBackground();
        generateRandomWall();
    }

    public int getRows() {
        return width / TILE_SIZE;
    }

    public int getColumns() {
        return height / TILE_SIZE;
    }

    public Tile getTile(int column, int row) {
        Tile foundTile = tileMap[column][row];

        if (foundTile == null) {
            throw new NullPointerException("No Tile with the coordinates { row: " + row + " column: " + column + " } exist for this gameboard.");
        }

        return foundTile;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public int getRandomCol() {
        return new Random().nextInt(getRows());
    }

    public int getRandomRow() {
        return new Random().nextInt(getColumns());
    }

    public boolean existsFog() { return this.existsFog; }

    public boolean existsBlur() { return this.existsBlur; }

    public void setBlur(boolean state) { this.existsBlur = state; }

    public boolean containsCollectible(CollectibleType collectibleType) {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                Collectible tileCollectible = tileMap[i][j].getCollectible();

                if(tileCollectible != null && tileCollectible.getType().equals(collectibleType)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void createFog() {
        this.existsFog = true;
        List<Tile> tilesSurroundingSnake = snake.getSurroundingTiles();

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                Tile tile = tileMap[i][j];
                if (!tilesSurroundingSnake.contains(tile) && !tile.getType().equals(TileType.WALL)) {
                    tile.convertToFog();
                }
            }
        }
    }

    public void clearFog() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                Tile tile = tileMap[i][j];
                if (tile.getType().equals(TileType.FOG)) {
                    tile.convertToStartType();
                }
            }
        }
        this.existsFog = false;
    }

    /**
     * Sets every Tile of the board to a green colour making up the background.
     * This method should be called when the GameBoard is created.
     */
    private void setTileBackground() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if ((i + j) % 2 == 0) {
                    tileMap[i][j] = new Tile(TileType.BACKGROUND_A, j, i);
                } else {
                    tileMap[i][j] = new Tile(TileType.BACKGROUND_B, j, i);
                }
            }
        }
    }

    private void generateRandomWall() {
        Random random = new Random();
        int rowVariation = random.nextInt(100) % 2 == 0 ? 1 : -1;
        int colVariation = random.nextInt(100) % 2 == 0 ? 1 : -1;

        Tile baseTile;
        do {
            baseTile = getTile(getRandomCol(), getRandomRow());
        } while(baseTile.getColumn() + 2 > getColumns() || baseTile.getRow() + 2 > getRows() ||
                baseTile.getColumn() - 2 <= -1 || baseTile.getRow() - 2 <= -1);

        baseTile.convertToWall();

        getTile(baseTile.getColumn(), baseTile.getRow() + 1 * rowVariation).convertToWall();
        getTile(baseTile.getColumn(), baseTile.getRow() + 2 * rowVariation).convertToWall();
        getTile(baseTile.getColumn() + 1 * colVariation, baseTile.getRow()).convertToWall();
        getTile(baseTile.getColumn() + 2 * colVariation, baseTile.getRow()).convertToWall();
    }
}
