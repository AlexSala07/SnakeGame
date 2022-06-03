package jku.mms.snakegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeGameApplication extends Application {
    public static final int WINDOW_WIDTH_PX = 850;
    public static final int WINDOW_HEIGHT_PX = 550;
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeGameApplication.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WINDOW_WIDTH_PX, WINDOW_HEIGHT_PX);
        scene.getStylesheets().add(getClass().getResource("gamestyle.css").toExternalForm());
        stage.setResizable(true);
        stage.setTitle("SnakeGame");
        stage.setScene(scene);
        setPrimaryStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Stage getPrimaryStage() {
        return mainStage;
    }

    private static void setPrimaryStage(Stage newStage) {
        SnakeGameApplication.mainStage = newStage;
    }
}
