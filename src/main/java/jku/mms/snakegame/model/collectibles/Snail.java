package jku.mms.snakegame.model.collectibles;

import jku.mms.snakegame.model.tile.Tile;

public class Snail extends Collectible {
    public Snail(Tile tile) {
        super(tile, CollectibleImages.SNAIL, CollectibleType.SNAIL);
    }
}
