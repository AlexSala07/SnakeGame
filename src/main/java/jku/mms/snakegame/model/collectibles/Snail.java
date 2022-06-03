package jku.mms.snakegame.model.collectibles;

import javafx.scene.paint.Color;
import jku.mms.snakegame.model.Tile;

public class Snail extends Collectible {
    public Snail(Tile tile) {
        super(tile, Color.DARKGREEN, CollectibleType.SNAIL);
    }
}
