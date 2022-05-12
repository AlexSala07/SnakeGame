package jku.mms.snakegame;

import javafx.scene.canvas.GraphicsContext;

/**
 * The GameLoop keeps the game going.
 * It is responsible for knowing if the game is running or is paused.
 * It should also refresh the Game UI with every loop.
 */
public class GameLoop implements Runnable {
    private static final int FRAMERATE = 20;
    private static final float INTERVAL = 1000.0f / FRAMERATE;
    private final GameController gameController;
    private final Painter painter;
    private boolean running;
    private boolean paused;

    public GameLoop(GraphicsContext graphicsContext) {
        this.running = true;
        this.paused = false;
        gameController = new GameController();
        painter = new Painter(graphicsContext);
        painter.paintGameBoard(gameController.getGameBoard());
    }

    @Override
    public void run() {
        while (running && !paused) {
            float time = System.currentTimeMillis();

            refreshUi();

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

    private void refreshUi() {
        if (painter == null || gameController == null) {
            throw new NullPointerException("UI Refreshing not possible as either Painter or GameController are null.");
        }
        painter.paintGameBoard(gameController.getGameBoard());
    }
}
