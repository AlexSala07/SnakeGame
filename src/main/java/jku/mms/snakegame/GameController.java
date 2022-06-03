package jku.mms.snakegame;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jku.mms.snakegame.model.GameBoard;
import jku.mms.snakegame.model.Snake;
import jku.mms.snakegame.model.collectibles.CollectibleType;

import static jku.mms.snakegame.SingleplayerController.CANVAS_HEIGHT;
import static jku.mms.snakegame.SingleplayerController.CANVAS_WIDTH;

/**
 * The GameController is responsible for the game logic.
 */
public class GameController {
    public final IntegerProperty scoreProperty = new SimpleIntegerProperty();
    private final GameBoard gameBoard;
    private final Snake snake;

    public GameController() {
        scoreProperty.set(0);
        gameBoard = new GameBoard(CANVAS_WIDTH, CANVAS_HEIGHT);
        snake = new Snake(gameBoard);
        gameBoard.setSnake(snake);
        generateRandomCollectible(CollectibleType.APPLE);
    }

    public boolean collisionDetected() {
        return snake.hasCollidedWithWall() || snake.hasCollidedWithItself();
    }

    public void moveSnake() {
        snake.move();
        snakeEatIfPossible();
    }

    public void moveSnakeUp() {
        snake.moveUp();
        snakeEatIfPossible();
    }

    public void moveSnakeDown() {
        snake.moveDown();
        snakeEatIfPossible();
    }

    public void moveSnakeLeft() {
        snake.moveLeft();
        snakeEatIfPossible();
    }

    public void moveSnakeRight() {
        snake.moveRight();
        snakeEatIfPossible();
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void generateRandomCollectible(CollectibleType collectibleType) {
        if (this.gameBoard == null) {
            throw new NullPointerException("Random collectible generation failed because gameboard is null");
        }

        if (gameBoard.containsCollectible(collectibleType)) {
            return;
        }

        this.gameBoard.getTile(gameBoard.getRandomCol(), gameBoard.getRandomRow()).setCollectible(collectibleType);
    }

    private void snakeEatIfPossible() {
        if (snake.isHeadOnCollectible()) {
            snake.eat();
            Platform.runLater(() -> scoreProperty.set(scoreProperty.get() + 1 * snake.getPointsMultiplier()));
            generateRandomCollectible(CollectibleType.APPLE);
        }
    }

    public int getSnakeSpeed() {
        return snake.getSpeed();
    }

    public boolean isSnakeOnEffect() {
        return snake.isOnEffect();
    }

    public boolean snakeOnDoublePoints() {
        return snake.isOnDoublePoints();
    }
}
