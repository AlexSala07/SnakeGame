package jku.mms.snakegame.model.collectibles;

import jku.mms.snakegame.model.tile.Tile;

public class Apple extends Collectible {
    public Apple(Tile tile) {
        super(tile, CollectibleImages.APPLE, CollectibleType.APPLE);
    }
}
