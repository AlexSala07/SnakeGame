package jku.mms.snakegame.model.collectibles;

import javafx.scene.paint.Color;
import jku.mms.snakegame.model.Tile;

public class Wine extends Collectible {
    public Wine(Tile tile) {
        super(tile, Color.PURPLE, CollectibleType.WINE);
    }
}
