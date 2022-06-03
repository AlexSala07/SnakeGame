package jku.mms.snakegame;

import javafx.fxml.FXML;
import jku.mms.snakegame.javafxutils.Scene;
import jku.mms.snakegame.javafxutils.SceneController;

public class GameEndController {
    @FXML
    protected void onRestartButtonClick() {
        SceneController.showNewScene(Scene.SINGLE_PLAYER);
    }

    @FXML
    protected void onBackToMenuButtonClick() {
        SceneController.showNewScene(Scene.MENU);
    }

    @FXML
    protected void onExitGameButtonClick() {
        SceneController.exitGame();
    }
}
