package jku.mms.snakegame;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.canvas.GraphicsContext;

/**
 * The GameLoop keeps the game going.
 * It is responsible for knowing if the game is running or is paused.
 * It should also refresh the Game UI with every loop.
 */
public class GameLoop implements Runnable {
    private static final int FRAMERATE = 10;
    private static final float INTERVAL = 1000.0f / FRAMERATE;
    private final GameController gameController;
    private final Painter painter;
    public final BooleanProperty running = new SimpleBooleanProperty();
    private boolean paused;
    private boolean isKeyPressed = false;

    public GameLoop(GraphicsContext graphicsContext) {
        this.running.set(true);
        this.paused = false;
        gameController = new GameController();
        painter = new Painter(graphicsContext);
        painter.paintGameBoard(gameController.getGameBoard());
    }

    @Override
    public void run() {
        while (running.get() && !paused) {
            float time = System.currentTimeMillis();

            // in order to avoid moving the snake twice in the same direction, thus skipping one tile
            if (!isKeyPressed) {
                gameController.moveSnake();
            }

            if (gameController.collisionDetected()) {
               running.set(false);
            }

            refreshUi();

            isKeyPressed = false;

            time = System.currentTimeMillis() - time;

            if (time < INTERVAL) {
                try {
                    // Make frame rate consistent
                    Thread.sleep((long) (INTERVAL - time));
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }

    public boolean getIsKeyPressed() { return this.isKeyPressed; }

    public void setIsKeyPressed(boolean state) { this.isKeyPressed = state; }

    public GameController getGameController() { return this.gameController; }

    public boolean isRunning() { return this.running.get(); }

    public void setRunning(boolean flag) { this.running.set(flag); }

    private void refreshUi() {
        if (painter == null || gameController == null) {
            throw new NullPointerException("UI Refreshing not possible as either Painter or GameController are null.");
        }
        painter.paintGameBoard(gameController.getGameBoard());
    }

}
