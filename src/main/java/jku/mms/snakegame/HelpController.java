package jku.mms.snakegame;

import javafx.fxml.FXML;
import jku.mms.snakegame.javafxutils.Scene;
import jku.mms.snakegame.javafxutils.SceneController;

public class HelpController {

    @FXML
    public void onBackToMenuButtonClick() {
        SceneController.showNewScene(Scene.MENU);
    }
}
