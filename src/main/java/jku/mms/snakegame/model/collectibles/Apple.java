package jku.mms.snakegame.model.collectibles;

import javafx.scene.paint.Color;
import jku.mms.snakegame.model.Tile;

public class Apple extends Collectible {
    public Apple(Tile tile) {
        super(tile, Color.RED, CollectibleType.APPLE);
    }
}
