package jku.mms.snakegame;

import javafx.animation.AnimationTimer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.canvas.GraphicsContext;
import jku.mms.snakegame.model.collectibles.CollectibleType;

import java.util.Random;

/**
 * The GameLoop keeps the game going.
 * It is responsible for knowing if the game is running or is paused.
 * It should also refresh the Game UI with every loop.
 */
public class GameLoop implements Runnable {
    public final BooleanProperty running = new SimpleBooleanProperty();
    public final BooleanProperty snakeOnDoublePoints = new SimpleBooleanProperty();
    public final BooleanProperty snakeDrunk = new SimpleBooleanProperty();
    public final BooleanProperty snakeFaster = new SimpleBooleanProperty();
    public final BooleanProperty snakeSlower = new SimpleBooleanProperty();
    private final GameController gameController;
    private final Painter painter;
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

                if (now - lastTick > 1000000000 / gameController.getSnakeSpeed()) {
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
            SoundEffectController.playDeadSound();
            running.set(false);
        }

        snakeOnDoublePoints.set(gameController.isSnakeOnDoublePoints());
        snakeDrunk.set(gameController.isSnakeDrunk());
        snakeFaster.set(gameController.isSnakeFaster());
        snakeSlower.set(gameController.isSnakeSlower());

        generateRandomExtraCollectibles();
        refreshUi();

        isKeyPressed = false;
    }

    private void generateRandomExtraCollectibles() {
        if (gameController.isSnakeOnSpeedEffect()) {
            return;
        }

        Random random = new Random();
        if (random.nextInt(225) == 10) {
            gameController.generateRandomCollectible(CollectibleType.LIGHTNING);
        }
        if (random.nextInt(250) == 10) {
            gameController.generateRandomCollectible(CollectibleType.SNAIL);
        }
        if (random.nextInt(325) == 10) {
            gameController.generateRandomCollectible(CollectibleType.DOUBLE_POINTS);
        }
        if (random.nextInt(250) == 10) {
            gameController.generateRandomCollectible(CollectibleType.WINE);
        }
    }

    public boolean getIsKeyPressed() { return this.isKeyPressed; }

    public void setIsKeyPressed(boolean state) { this.isKeyPressed = state; }

    public GameController getGameController() { return this.gameController; }

    public void setRunning(boolean flag) { this.running.set(flag); }

    private void refreshUi() {
        if (painter == null || gameController == null) {
            throw new NullPointerException("UI Refreshing not possible as either Painter or GameController are null.");
        }
        painter.paintGameBoard(gameController.getGameBoard());
    }

}
