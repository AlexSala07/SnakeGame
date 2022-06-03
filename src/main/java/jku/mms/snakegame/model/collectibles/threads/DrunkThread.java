package jku.mms.snakegame.model.collectibles.threads;

import jku.mms.snakegame.model.Snake;

public class DrunkThread implements Runnable {
    private Snake snake;
    private int durationInMs;

    public DrunkThread(Snake snake, int durationInMs) {
        this.snake = snake;
        this.durationInMs = durationInMs;
    }

    @Override
    public void run() {
        long end = System.currentTimeMillis() + durationInMs;
        while (System.currentTimeMillis() < end) {
            this.snake.setDrunk(true);
        }
        this.snake.setDrunk(false);
    }
}
