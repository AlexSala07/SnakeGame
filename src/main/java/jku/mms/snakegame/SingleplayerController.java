package jku.mms.snakegame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import jku.mms.snakegame.model.GameBoard;

import java.net.URL;
import java.util.ResourceBundle;

import static jku.mms.snakegame.model.Tile.TILE_SIZE;

public class SingleplayerController implements Initializable {
    @FXML
    private Canvas gameCanvas;

    private static final int CANVAS_WIDTH = 700;
    private static final int CANVAS_HEIGHT = 500;

    private GraphicsContext gc;
    private final GameBoard gameBoard = new GameBoard(CANVAS_WIDTH, CANVAS_HEIGHT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeGameCanvas();
        drawGameBoard();
    }

    private void initializeGameCanvas() {
        if(gameCanvas == null) {
            throw new NullPointerException("The game canvas is null.");
        }

        gameCanvas.setWidth(CANVAS_WIDTH);
        gameCanvas.setHeight(CANVAS_HEIGHT);
        gc = gameCanvas.getGraphicsContext2D();
    }

    private void drawGameBoard() {
        if(gc == null) {
            throw new NullPointerException("The game canvas has not been initialized!");
        }

        for (int row = 0; row < gameBoard.getRows(); row++) {
            for (int col = 0; col < gameBoard.getColumns(); col++) {
                gc.setFill(gameBoard.getTile(row, col).getColor());
                gc.fillRect(row * TILE_SIZE, col * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

    }
}
