package jku.mms.snakegame.model.collectibles;

import javafx.scene.paint.Color;
import jku.mms.snakegame.model.Tile;

public class Fog extends Collectible {
    public Fog(Tile tile) {
        super(tile, Color.BLACK, CollectibleType.FOG);
    }
}
