package jku.mms.snakegame.model.collectibles;

import javafx.scene.paint.Color;
import jku.mms.snakegame.model.Tile;

public class Lightning extends Collectible {
    public Lightning(Tile tile) {
        super(tile, Color.YELLOW, CollectibleType.LIGHTNING);
    }
}
