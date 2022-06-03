package jku.mms.snakegame.model.collectibles.threads;

import jku.mms.snakegame.model.Snake;

public class SpeedThread implements Runnable {
    private Snake snake;
    private int oldSpeed;
    private int newSpeed;
    private int durationInMs;

    public SpeedThread(Snake snake, int newSpeed, int durationInMs) {
        this.snake = snake;
        this.oldSpeed = snake.getSpeed();
        this.newSpeed = newSpeed;
        this.durationInMs = durationInMs;
    }

    @Override
    public void run() {
        long end = System.currentTimeMillis() + durationInMs;
        while (System.currentTimeMillis() < end) {
            this.snake.setSpeed(newSpeed);
            this.snake.setOnSpeedEffect(true);
        }
        this.snake.setSpeed(oldSpeed);
        this.snake.setOnSpeedEffect(false);
    }
}
