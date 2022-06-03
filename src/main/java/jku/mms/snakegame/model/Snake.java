package jku.mms.snakegame.model;

import java.util.LinkedList;

/**
 * Snake represents the snake object which moves through the GameBoard and can eat Collectibles.
 */
public class Snake {
    private Tile head;
    private final LinkedList<Tile> body = new LinkedList<>();
    private Direction currentDirection = Direction.RIGHT;
    private final GameBoard gameBoard;
    private boolean collidedWithWall = false;

    public Snake(GameBoard gameBoard) {
        this.gameBoard = gameBoard;

        head = gameBoard.getTile(5, 5).convertToSnakeHead();
        body.add(gameBoard.getTile(4, 5).convertToSnakeBody());
        body.add(gameBoard.getTile(3, 5).convertToSnakeBody());
    }

    public void move() {
        switch (currentDirection) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }
    }

    public void moveUp() {
        if (this.currentDirection == Direction.DOWN) {
            return;
        }
        if (head.getRow() - 1  <= -1){
            collidedWithWall = true;
            return;
        }

        head.convertToStartType();
        head = gameBoard.getTile(head.getColumn(), head.getRow() - 1).convertToSnakeHead();

        body.getFirst().convertToStartType();
        body.removeFirst();
        body.add(gameBoard.getTile(head.getColumn(), head.getRow() + 1).convertToSnakeBody());

        this.currentDirection = Direction.UP;
    }

    public void moveDown() {
        if (this.currentDirection == Direction.UP) {
            return;
        }
        if (head.getRow() + 1 >= gameBoard.getColumns()){
            collidedWithWall = true;
            return;
        }

        head.convertToStartType();
        head = gameBoard.getTile(head.getColumn(), head.getRow() + 1).convertToSnakeHead();

        body.getFirst().convertToStartType();
        body.removeFirst();
        body.add(gameBoard.getTile(head.getColumn(), head.getRow() - 1).convertToSnakeBody());

        this.currentDirection = Direction.DOWN;
    }

    public void moveLeft() {
        if (this.currentDirection == Direction.RIGHT) {
            return;
        }
        if (head.getColumn() - 1 <= -1){
            collidedWithWall = true;
            return;
        }

        head.convertToStartType();
        head = gameBoard.getTile(head.getColumn() - 1, head.getRow()).convertToSnakeHead();

        body.getFirst().convertToStartType();
        body.removeFirst();
        body.add(gameBoard.getTile(head.getColumn() + 1, head.getRow()).convertToSnakeBody());

        this.currentDirection = Direction.LEFT;
    }

    public void moveRight() {
        if (this.currentDirection == Direction.LEFT) {
            return;
        }
        if (head.getColumn() + 1 >= gameBoard.getRows()){
            collidedWithWall = true;
            return;
        }

        head.convertToStartType();
        head = gameBoard.getTile(head.getColumn() + 1, head.getRow()).convertToSnakeHead();

        body.getFirst().convertToStartType();
        body.removeFirst();
        body.add(gameBoard.getTile(head.getColumn() - 1, head.getRow()).convertToSnakeBody());

        this.currentDirection = Direction.RIGHT;
    }

    public boolean hasCollidedWithWall() {
        return collidedWithWall;
    }

    public boolean hasCollidedWithItself() {
        return body.stream().anyMatch(tile -> head.getColumn() == tile.getColumn() && head.getRow() == tile.getRow());
    }

    public boolean isHeadOnCollectible() {
        return head.getCollectible() != null;
    }

    public void eat() {
        switch (this.currentDirection) {
            case UP:
                body.add(gameBoard.getTile(head.getColumn(), head.getRow() + 1));
                break;
            case DOWN:
                body.add(gameBoard.getTile(head.getColumn(), head.getRow() - 1));
                break;
            case LEFT:
                body.add(gameBoard.getTile(head.getColumn() + 1, head.getRow()));
                break;
            case RIGHT:
                body.add(gameBoard.getTile(head.getColumn() - 1, head.getRow()));
                break;
        }

        head.removeCollectible();
    }
}
