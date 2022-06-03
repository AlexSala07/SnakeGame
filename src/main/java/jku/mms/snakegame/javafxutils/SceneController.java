package jku.mms.snakegame.javafxutils;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import jku.mms.snakegame.SnakeGameApplication;

import java.io.IOException;

public class SceneController {
    public static void showNewScene(Scene scene) {
        Parent fxmlLoader;
        try {
            fxmlLoader = FXMLLoader.load(SceneController.class.getResource(scene.getFilePath()));
            Stage primaryStage = SnakeGameApplication.getPrimaryStage();
            primaryStage.getScene().setRoot(fxmlLoader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exitGame() {
        Platform.exit();
        System.exit(0);
    }
}
