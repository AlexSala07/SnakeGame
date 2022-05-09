package jku.mms.snakegame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    protected void onStartSinglePlayerButtonClick() {
        showNewScene("single-player.fxml");
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
        //TODO handle exit game
    }

    private void showNewScene(String fxmlFileName) {
        Parent fxmlLoader;
        try {
            fxmlLoader = FXMLLoader.load(getClass().getResource(fxmlFileName));
            Stage primaryStage = SnakeGameApplication.getPrimaryStage();
            primaryStage.getScene().setRoot(fxmlLoader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
