package jku.mms.snakegame.model;

import javafx.scene.paint.Color;

/**
 * A Tile is the base element of which the GameBoard is made.
 * It can also retain information like for example if it is part of the Background or of the Snake or the Color it has.
 */
public class Tile {
    public static final int TILE_SIZE = 25;
    private final TyleType type;
    private final Color color;

    public Tile(TyleType tyleType, Color color) {
        this.type = tyleType;
        this.color = color;
    }

    public TyleType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}
