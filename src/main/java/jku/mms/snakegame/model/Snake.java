package jku.mms.snakegame.model;

import jku.mms.snakegame.javafxutils.SoundEffectController;
import jku.mms.snakegame.model.tile.Tile;
import jku.mms.snakegame.model.tile.TileType;
import jku.mms.snakegame.model.collectibles.Collectible;
import jku.mms.snakegame.model.collectibles.CollectibleType;
import jku.mms.snakegame.model.collectibles.threads.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Snake represents the snake object which moves through the GameBoard and can eat Collectibles.
 */
public class Snake {
    private enum Direction { UP, DOWN, RIGHT, LEFT }
    private static final int DEFAULT_SPEED = 10;
    private Tile head;
    private final LinkedList<Tile> body = new LinkedList<>();
    private Direction currentDirection = Direction.RIGHT;
    private final GameBoard gameBoard;
    private boolean collidedWithWall = false;
    private int speed = DEFAULT_SPEED;
    private int pointsMultiplier = 1;
    private boolean isOnSpeedEffect = false;
    private boolean isDrunk = false;

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
        if (head.getRow() - 1  <= -1 || gameBoard.getTile(head.getColumn(), head.getRow() - 1).getType().equals(TileType.WALL)){
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
        if (head.getRow() + 1 >= gameBoard.getColumns() || gameBoard.getTile(head.getColumn(), head.getRow() + 1).getType().equals(TileType.WALL)){
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
        if (head.getColumn() - 1 <= -1 || gameBoard.getTile(head.getColumn() - 1, head.getRow()).getType().equals(TileType.WALL)) {
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
        if (head.getColumn() + 1 >= gameBoard.getRows() || gameBoard.getTile(head.getColumn() + 1, head.getRow()).getType().equals(TileType.WALL)) {
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

    public void eat() {
        Collectible collectible = head.getCollectible();
        if (collectible.getType().equals(CollectibleType.LIGHTNING) && !isOnSpeedEffect) {
            SoundEffectController.playLightningSound();
            new Thread(new SpeedThread(this, speed + 15, 5000)).start();
        }

        if (collectible.getType().equals(CollectibleType.SNAIL) && !isOnSpeedEffect) {
            SoundEffectController.playSnailSound();
            new Thread(new SpeedThread(this, speed - 5, 5000)).start();
        }

        if (collectible.getType().equals(CollectibleType.DOUBLE_POINTS)) {
            SoundEffectController.playDoublePointsSound();
            new Thread(new DoublePointsThread(this, 5000)).start();
        }

        if (collectible.getType().equals(CollectibleType.WINE)) {
            SoundEffectController.playDrunkSound();
            new Thread(new DrunkThread(this, 5000)).start();
        }

        if (collectible.getType().equals(CollectibleType.FOG)) {
            SoundEffectController.playFogSound();
            new Thread(new FogThread(gameBoard, 10000)).start();
        }

        if (collectible.getType().equals(CollectibleType.BLUR)) {
            SoundEffectController.playBlurSound();
            new Thread(new BlurThread(gameBoard, 10000)).start();
        }

        if (collectible.getType().equals(CollectibleType.APPLE)) {
            SoundEffectController.playAppleSound();
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
        }

        head.removeCollectible();
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

    public int getSpeed() { return this.speed; }

    public boolean isOnSpeedEffect() { return this.isOnSpeedEffect; }

    public int getPointsMultiplier() {
        return this.pointsMultiplier;
    }

    public boolean isOnDoublePoints() {
        return pointsMultiplier == 2;
    }

    public boolean isDrunk() { return isDrunk; }

    public boolean isFaster() { return speed > DEFAULT_SPEED; }

    public boolean isSlower() { return speed < DEFAULT_SPEED; }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }

    public void setOnSpeedEffect(boolean state) {
        this.isOnSpeedEffect = state;
    }

    public void setPointsMultiplier(int multiplier) {
        this.pointsMultiplier = multiplier;
    }

    public void setDrunk(boolean state) {
        this.isDrunk = state;
    }

    public List<Tile> getSurroundingTiles() {
        List<Tile> tilesSurroundingSnake = new ArrayList<>();

        for(int i = head.getRow()-1; i <= head.getRow()+1; i++) {
            for(int j = head.getColumn()-1; j <= head.getColumn()+1; j++) {
                if(i != head.getRow() || j != head.getColumn()) { //ignore the center tile
                    // check tile is within boundaries
                    if(i < gameBoard.getColumns() && i > -1 && j < gameBoard.getRows() && j > -1) {
                        Tile surroundingTile = gameBoard.getTile(j, i);
                        if (surroundingTile.getType().equals(TileType.BACKGROUND_A) || surroundingTile.getType().equals(TileType.BACKGROUND_B))
                        {
                            tilesSurroundingSnake.add(surroundingTile);
                        }
                    }
                }
            }
        }

        body.forEach(t -> {
            for(int i = t.getRow()-1; i <= t.getRow()+1; i++) {
                for(int j = t.getColumn()-1; j <= t.getColumn()+1; j++) {
                    if(i != t.getRow() || j != t.getColumn()) { //ignore the center tile
                        // check tile is within boundaries
                        if(i < gameBoard.getColumns() && i > -1 && j < gameBoard.getRows() && j > -1) {
                            Tile surroundingTile = gameBoard.getTile(j, i);
                            if (surroundingTile.getType().equals(TileType.BACKGROUND_A) || surroundingTile.getType().equals(TileType.BACKGROUND_B))
                            {
                                tilesSurroundingSnake.add(surroundingTile);
                            }
                        }
                    }
                }
            }
        });

        return tilesSurroundingSnake;
    }
}
