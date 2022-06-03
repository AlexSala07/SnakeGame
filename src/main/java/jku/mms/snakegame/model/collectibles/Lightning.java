package jku.mms.snakegame.model.collectibles;

import jku.mms.snakegame.model.tile.Tile;

public class Lightning extends Collectible {
    public Lightning(Tile tile) {
        super(tile, CollectibleImages.LIGHTNING, CollectibleType.LIGHTNING);
    }
}
