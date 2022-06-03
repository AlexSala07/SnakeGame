package jku.mms.snakegame.model.collectibles;

import javafx.scene.image.Image;
import jku.mms.snakegame.javafxutils.SceneController;

import static jku.mms.snakegame.model.collectibles.Collectible.COLLECTIBLE_SIZE;

public class CollectibleImages {
    static final Image APPLE = createImage("media/images/collectibles/apple.png");
    static final Image FOG = createImage("media/images/collectibles/fog.png");
    static final Image BLUR = createImage("media/images/collectibles/blur.png");
    static final Image DOUBLE_POINTS = createImage("media/images/collectibles/doublePoints.png");
    static final Image LIGHTNING = createImage("media/images/collectibles/lightning.png");
    static final Image SNAIL = createImage("media/images/collectibles/snail.png");
    static final Image WINE = createImage("media/images/collectibles/wine.png");

    private static Image createImage(String path) {
        return new Image(SceneController.class.getResourceAsStream(path), COLLECTIBLE_SIZE, COLLECTIBLE_SIZE, false, false);
    }
}
