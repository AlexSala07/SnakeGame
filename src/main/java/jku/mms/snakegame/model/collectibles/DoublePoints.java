package jku.mms.snakegame.model.collectibles;

import jku.mms.snakegame.model.tile.Tile;

public class DoublePoints extends Collectible {
    public DoublePoints(Tile tile) {
        super(tile, CollectibleImages.DOUBLE_POINTS, CollectibleType.DOUBLE_POINTS);
    }
}
