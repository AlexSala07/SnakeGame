package jku.mms.snakegame.model.collectibles;

import javafx.scene.image.Image;
import jku.mms.snakegame.model.tile.Tile;

public abstract class Collectible {
    public static final int COLLECTIBLE_SIZE = 20;
    public static final int SELF_DESTRUCT_TIME_MS = 10000;
    private Image image;
    private CollectibleType type;
    private Tile tile;

    public Collectible(Tile tile, Image image, CollectibleType type) {
        this.tile = tile;
        this.image = image;
        this.type = type;
    }

    public Image getImage() {
        return image;
    }

    public CollectibleType getType() { return type; }
}
