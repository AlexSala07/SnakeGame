package jku.mms.snakegame.model.collectibles.threads;

import jku.mms.snakegame.model.GameBoard;

public class BlurThread implements Runnable {
    private GameBoard gameBoard;
    private int durationInMs;

    public BlurThread(GameBoard gameBoard, int durationInMs) {
        this.gameBoard = gameBoard;
        this.durationInMs = durationInMs;
    }

    @Override
    public void run() {
        long end = System.currentTimeMillis() + durationInMs;
        while (System.currentTimeMillis() < end) {
            gameBoard.setBlur(true);
        }
        gameBoard.setBlur(false);
    }
}
