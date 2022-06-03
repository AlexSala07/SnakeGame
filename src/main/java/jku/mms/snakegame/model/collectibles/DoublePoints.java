package jku.mms.snakegame.model.collectibles;

import javafx.scene.paint.Color;
import jku.mms.snakegame.model.Tile;

public class DoublePoints extends Collectible {
    public DoublePoints(Tile tile) {
        super(tile, Color.GOLDENROD, CollectibleType.DOUBLE_POINTS);
    }
}
