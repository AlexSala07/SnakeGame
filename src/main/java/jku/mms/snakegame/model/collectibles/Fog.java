package jku.mms.snakegame.model.collectibles;

import jku.mms.snakegame.model.tile.Tile;

public class Fog extends Collectible {
    public Fog(Tile tile) {
        super(tile, CollectibleImages.FOG, CollectibleType.FOG);
    }
}
