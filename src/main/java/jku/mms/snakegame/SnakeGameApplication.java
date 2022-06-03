package jku.mms.snakegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import jku.mms.snakegame.javafxutils.SceneController;

import java.io.IOException;

public class SnakeGameApplication extends Application {
    public static final int WINDOW_WIDTH_PX = 850;
    public static final int WINDOW_HEIGHT_PX = 550;
    private static Stage mainStage;
    private static MediaPlayer mediaPlayer;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource("ui/menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WINDOW_WIDTH_PX, WINDOW_HEIGHT_PX);
        scene.getStylesheets().add(SceneController.class.getResource("ui/gamestyle.css").toExternalForm());
        stage.setResizable(true);
        stage.setTitle("SnakeGame");
        stage.setScene(scene);
        setPrimaryStage(stage);
        Media backgroundSong = new Media(SnakeGameApplication.class.getResource("javafxutils/media/audio/gameMusic.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(backgroundSong);
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.play();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Stage getPrimaryStage() {
        return mainStage;
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    private static void setPrimaryStage(Stage newStage) {
        SnakeGameApplication.mainStage = newStage;
    }
}
