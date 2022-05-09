package jku.mms.snakegame.model;

import javafx.scene.paint.Color;

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
