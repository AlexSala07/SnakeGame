package jku.mms.snakegame.gameutils;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import jku.mms.snakegame.model.tile.Tile;
import jku.mms.snakegame.model.tile.TileType;
import jku.mms.snakegame.model.collectibles.Collectible;
import jku.mms.snakegame.model.GameBoard;

import static jku.mms.snakegame.model.collectibles.Collectible.COLLECTIBLE_SIZE;
import static jku.mms.snakegame.model.tile.Tile.TILE_SIZE;

/**
 * The Painter class takes care of drawing the GameBoard and making the game state visible to the player.
 */
public class Painter {
    private final GraphicsContext graphicsContext;

    public Painter(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public void paintGameBoard(GameBoard gameBoard) {
        if(graphicsContext == null) {
            throw new NullPointerException("The game canvas has not been initialized!");
        }

        for (int row = 0; row < gameBoard.getRows(); row++) {
            for (int col = 0; col < gameBoard.getColumns(); col++) {
                Tile tileToPaint = gameBoard.getTile(row, col);

                graphicsContext.setEffect(gameBoard.existsBlur() ? new GaussianBlur(30) : null);
                graphicsContext.setFill(tileToPaint.getColor());
                graphicsContext.fillRect(row * TILE_SIZE, col * TILE_SIZE, TILE_SIZE, TILE_SIZE);

                Collectible tileCollectible = tileToPaint.getCollectible();

                if (tileCollectible != null) {
                    graphicsContext.setFill(tileToPaint.getType().equals(TileType.FOG) ? Color.BLACK : tileCollectible.getColor());
                    graphicsContext.fillRect((row * TILE_SIZE) + (TILE_SIZE / 3), (col * TILE_SIZE) + (TILE_SIZE / 3), COLLECTIBLE_SIZE, COLLECTIBLE_SIZE);
                }
            }
        }
    }
}
