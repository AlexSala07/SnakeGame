package jku.mms.snakegame.model;

import javafx.scene.paint.Color;
import jku.mms.snakegame.model.collectibles.*;

import static jku.mms.snakegame.model.collectibles.Collectible.SELF_DESTRUCT_TIME_MS;

/**
 * A Tile is the base element of which the GameBoard is made.
 * It can also retain information like for example if it is part of the Background or of the Snake or the Color it has.
 */
public class Tile {
    public static final int TILE_SIZE = 25;
    private final int row;
    private final int column;
    private final TyleType startType;
    private TyleType type;
    private Collectible collectible;

    public Tile(TyleType tyleType, int row, int column) {
        this.startType = tyleType;
        this.type = tyleType;
        this.row = row;
        this.column = column;
    }

    public TyleType getType() {
        return type;
    }

    public Color getColor() {
        switch (type) {
            case SNAKE_HEAD: return Color.BROWN;
            case SNAKE_BODY: return Color.CHOCOLATE;
            case BACKGROUND_A: return Color.web("AAD751");
            case BACKGROUND_B: return Color.web("A2D149");
            case FOG: return Color.BLACK;
        }
        return Color.BLACK;
    }

    public int getRow() { return row; }

    public int getColumn() { return column; }

    public Collectible getCollectible() {
        return this.collectible;
    }

    public void setCollectible(CollectibleType collectibleType) {
        Collectible newCollectible = null;

        switch (collectibleType) {
            case APPLE:
                newCollectible = new Apple(this);
                break;
            case LIGHTNING:
                newCollectible = new Lightning(this);
                break;
            case SNAIL:
                newCollectible = new Snail(this);
                break;
            case DOUBLE_POINTS:
                newCollectible = new DoublePoints(this);
                break;
            case WINE:
                newCollectible = new Wine(this);
                break;
            case FOG:
                newCollectible = new Fog(this);
                break;
            case BLUR:
                newCollectible = new Blur(this);
                break;
        }

        this.collectible = newCollectible;
        new Thread(new RemoveCollectibleThread()).start();
    }

    public Tile convertToSnakeHead() {
        this.type = TyleType.SNAKE_HEAD;
        return this;
    }

    public Tile convertToSnakeBody() {
        this.type = TyleType.SNAKE_BODY;
        return this;
    }

    public Tile convertToStartType() {
        this.type = this.startType;
        return this;
    }

    public Tile convertToFog() {
        this.type = TyleType.FOG;
        return this;
    }

    public void removeCollectible() {
        this.collectible = null;
    }

    private class RemoveCollectibleThread implements Runnable {
        @Override
        public void run() {
            long end = System.currentTimeMillis() + SELF_DESTRUCT_TIME_MS;
            while (System.currentTimeMillis() < end) {}
            removeCollectible();
        }
    }
}
