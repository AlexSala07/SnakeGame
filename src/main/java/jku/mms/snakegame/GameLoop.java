package jku.mms.snakegame;

import javafx.animation.AnimationTimer;
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
    private boolean isKeyPressed = false;

    public GameLoop(GraphicsContext graphicsContext) {
        this.running.set(true);
        gameController = new GameController();
        painter = new Painter(graphicsContext);
        painter.paintGameBoard(gameController.getGameBoard());
    }

    @Override
    public void run() {
        new AnimationTimer() {
            long lastTick = 0;

            public void handle(long now) {
                if(!running.get()) {
                    stop();
                }

                if (lastTick == 0) {
                    lastTick = now;
                    tick();
                    return;
                }

                if (now - lastTick > 1000000000 / 10) {
                    lastTick = now;
                    tick();
                }
            }

        }.start();
    }

    private void tick() {
        if (!isKeyPressed) {
            gameController.moveSnake();
        }

        if (gameController.collisionDetected()) {
            running.set(false);
        }

        refreshUi();

        isKeyPressed = false;
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
