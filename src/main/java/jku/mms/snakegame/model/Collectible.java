package jku.mms.snakegame.model;

import javafx.scene.paint.Color;

public class Collectible {
    public static final int COLLECTIBLE_SIZE = 10;
    private Color color;
    private Tile tile;

    public Collectible(Tile tile) {
        this.tile = tile;
        this.color = Color.RED;
    }

    public Color getColor() {
        return color;
    }
}
