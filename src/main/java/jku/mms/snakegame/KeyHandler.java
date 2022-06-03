package jku.mms.snakegame;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * The KeyHandler handles the player input and should define which key does what.
 */
public class KeyHandler implements EventHandler<KeyEvent> {
    private GameLoop gameLoop;

    public KeyHandler(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(gameLoop.getIsKeyPressed()) {
            return;
        }
        gameLoop.setIsKeyPressed(true);
        boolean isSnakeDrunk = gameLoop.snakeDrunk.get();

        switch (keyEvent.getCode()) {
            case W:
                if (isSnakeDrunk) {
                    gameLoop.getGameController().moveSnakeDown();
                } else {
                    gameLoop.getGameController().moveSnakeUp();
                }
                break;
            case S:
                if (isSnakeDrunk) {
                    gameLoop.getGameController().moveSnakeUp();
                }
                else {
                    gameLoop.getGameController().moveSnakeDown();
                }
                break;
            case A:
                if (isSnakeDrunk) {
                    gameLoop.getGameController().moveSnakeRight();
                }
                else {
                    gameLoop.getGameController().moveSnakeLeft();
                }
                break;
            case D:
                if (isSnakeDrunk) {
                    gameLoop.getGameController().moveSnakeLeft();
                }
                else {
                    gameLoop.getGameController().moveSnakeRight();
                }
                break;
        }
    }
}
