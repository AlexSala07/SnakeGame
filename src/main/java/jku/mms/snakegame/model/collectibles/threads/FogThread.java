package jku.mms.snakegame.model.collectibles.threads;

import jku.mms.snakegame.model.GameBoard;

public class FogThread implements Runnable {
    private GameBoard gameBoard;
    private int durationInMs;

    public FogThread(GameBoard gameBoard, int durationInMs) {
        this.gameBoard = gameBoard;
        this.durationInMs = durationInMs;
    }

    @Override
    public void run() {
        long end = System.currentTimeMillis() + durationInMs;
        while (System.currentTimeMillis() < end) {
            if(!gameBoard.existsFog()) {
                gameBoard.createFog();
            }
        }
        gameBoard.clearFog();
    }
}
