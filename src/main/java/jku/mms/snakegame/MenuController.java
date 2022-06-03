package jku.mms.snakegame;

import javafx.fxml.FXML;

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
}
