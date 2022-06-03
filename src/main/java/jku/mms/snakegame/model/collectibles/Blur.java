package jku.mms.snakegame.model.collectibles;

import jku.mms.snakegame.model.tile.Tile;

public class Blur extends Collectible {
    public Blur(Tile tile) {
        super(tile, CollectibleImages.BLUR, CollectibleType.BLUR);
    }
}
