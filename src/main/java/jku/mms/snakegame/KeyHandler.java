package jku.mms.snakegame;

import javafx.event.EventHandler;
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

        switch (keyEvent.getCode()) {
            case W:
                gameLoop.getGameController().moveSnakeUp();
                break;
            case S:
                gameLoop.getGameController().moveSnakeDown();
                break;
            case A:
                gameLoop.getGameController().moveSnakeLeft();
                break;
            case D:
                gameLoop.getGameController().moveSnakeRight();
                break;
        }
    }
}
