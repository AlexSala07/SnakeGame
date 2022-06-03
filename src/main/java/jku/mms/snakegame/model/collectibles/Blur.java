package jku.mms.snakegame.model.collectibles;

import javafx.scene.paint.Color;
import jku.mms.snakegame.model.Tile;

public class Blur extends Collectible {
    public Blur(Tile tile) {
        super(tile, Color.LIGHTBLUE, CollectibleType.BLUR);
    }
}
