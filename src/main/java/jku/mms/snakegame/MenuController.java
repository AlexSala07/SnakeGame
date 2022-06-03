package jku.mms.snakegame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
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
        setMuteButtonImage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setMuteButtonImage();
    }

    private void setMuteButtonImage() {
        String imageFile;

        if (SnakeGameApplication.getMediaPlayer() == null) {
            imageFile = "volume.png";
        }
        else {
            imageFile = SnakeGameApplication.getMediaPlayer().isMute() ? "mute.png" : "volume.png";
        }
        
        Image image = new Image(getClass().getResourceAsStream(imageFile));
        muteButton.setGraphic(new ImageView(image));
    }
}
