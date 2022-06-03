package jku.mms.snakegame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MenuController {
    @FXML
    protected void onStartSinglePlayerButtonClick() {
        SceneController.showNewScene(Scene.SINGLE_PLAYER);
    }

    @FXML
    protected void onStartMultiPlayerButtonClick() {
        //TODO handle start multiplayer game
    }

    @FXML
    protected void onOptionsButtonClick() {
        //TODO handle options menu
    }

    @FXML
    protected void onExitGameButtonClick() {
        SceneController.exitGame();
    }

    @FXML Button muteButton;

    @FXML
    protected void onMuteButtonClick() {
        SnakeGameApplication.getMediaPlayer().setMute(!SnakeGameApplication.getMediaPlayer().isMute());
        String imageFile = SnakeGameApplication.getMediaPlayer().isMute() ? "mute.png" : "volume.png";
        Image image = new Image(getClass().getResourceAsStream(imageFile));
        muteButton.setGraphic(new ImageView(image));
    }
}
