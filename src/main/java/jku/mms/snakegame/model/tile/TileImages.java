package jku.mms.snakegame.model.tile;

import javafx.scene.image.Image;
import jku.mms.snakegame.javafxutils.SceneController;

import static jku.mms.snakegame.model.tile.Tile.TILE_SIZE;

public class TileImages {
    public static final Image WALL = createImage("media/images/tiles/wall.png");

    private static Image createImage(String path) {
        return new Image(SceneController.class.getResourceAsStream(path), TILE_SIZE, TILE_SIZE, false, false);
    }
}
