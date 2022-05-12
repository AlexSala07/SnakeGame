package jku.mms.snakegame;

import jku.mms.snakegame.model.GameBoard;
import jku.mms.snakegame.model.Snake;

import static jku.mms.snakegame.SingleplayerController.CANVAS_HEIGHT;
import static jku.mms.snakegame.SingleplayerController.CANVAS_WIDTH;

/**
 * The GameController is responsible for the game logic.
 */
public class GameController {
    private final GameBoard gameBoard;
    private Snake snake;

    public GameController() {
        gameBoard = new GameBoard(CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }
}
