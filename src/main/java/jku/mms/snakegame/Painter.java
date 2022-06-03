package jku.mms.snakegame;

import javafx.scene.canvas.GraphicsContext;
import jku.mms.snakegame.model.Collectible;
import jku.mms.snakegame.model.GameBoard;

import static jku.mms.snakegame.model.Collectible.COLLECTIBLE_SIZE;
import static jku.mms.snakegame.model.Tile.TILE_SIZE;

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
                graphicsContext.setFill(gameBoard.getTile(row, col).getColor());
                graphicsContext.fillRect(row * TILE_SIZE, col * TILE_SIZE, TILE_SIZE, TILE_SIZE);

                Collectible tileCollectible = gameBoard.getTile(row, col).getCollectible();

                if (tileCollectible != null) {
                    graphicsContext.setFill(tileCollectible.getColor());
                    graphicsContext.fillRect((row * TILE_SIZE) + (TILE_SIZE / 3), (col * TILE_SIZE) + (TILE_SIZE / 3), COLLECTIBLE_SIZE, COLLECTIBLE_SIZE);
                }
            }
        }
    }
}
