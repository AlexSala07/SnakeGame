package jku.mms.snakegame.model.collectibles;

import javafx.scene.paint.Color;
import jku.mms.snakegame.model.tile.Tile;

public abstract class Collectible {
    public static final int COLLECTIBLE_SIZE = 10;
    public static final int SELF_DESTRUCT_TIME_MS = 10000;
    private Color color;
    private CollectibleType type;
    private Tile tile;

    public Collectible(Tile tile, Color color, CollectibleType type) {
        this.tile = tile;
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public CollectibleType getType() { return type; }
}
