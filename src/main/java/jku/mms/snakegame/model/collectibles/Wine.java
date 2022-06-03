package jku.mms.snakegame.model.collectibles;

import jku.mms.snakegame.model.tile.Tile;

public class Wine extends Collectible {
    public Wine(Tile tile) {
        super(tile, CollectibleImages.WINE, CollectibleType.WINE);
    }
}
