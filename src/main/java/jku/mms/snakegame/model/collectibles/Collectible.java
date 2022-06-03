package jku.mms.snakegame.model.collectibles;

import javafx.scene.paint.Color;
import jku.mms.snakegame.model.Tile;

public abstract class Collectible {
    public static final int COLLECTIBLE_SIZE = 10;
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
