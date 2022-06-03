package jku.mms.snakegame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class SingleplayerController implements Initializable {
    @FXML private Canvas gameCanvas;
    @FXML private Label scoreLabel;
    @FXML private Label timeLabel;
    @FXML private HBox currentEffectsList;

    static final int CANVAS_WIDTH = 700;
    static final int CANVAS_HEIGHT = 500;

    private GameLoop gameLoop;
    private GraphicsContext gc;
    private int secondsRunning = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeGameCanvas();
        gameLoop = new GameLoop(gc);
        gameCanvas.setOnKeyPressed(new KeyHandler(gameLoop));

        Thread gameLoopThread = new Thread(gameLoop);
        gameLoopThread.start();

        addGameRunningCheck();
        addSnakeOnDoublePointsCheck();
        addSnakeDrunkCheck();
        addSnakeFasterCheck();
        addSnakeSlowerCheck();

        SnakeGameApplication.getPrimaryStage().setOnCloseRequest((we -> {
            gameLoop.setRunning(false);
            SceneController.exitGame();
        }));
        scoreLabel.textProperty().bind(gameLoop.getGameController().scoreProperty.asString());

        startTimer();
    }

    private void addGameRunningCheck() {
        gameLoop.running.addListener((observableValue, oldValue, gameCurrentlyRunning) -> {
            if (!gameCurrentlyRunning) {
                SceneController.showNewScene(Scene.GAME_END);
            }
        });
    }

    private void addSnakeOnDoublePointsCheck() {
        Label doublePointsLabel = createLabelWithColor("DOUBLE POINTS", Color.GOLDENROD);
        gameLoop.snakeOnDoublePoints.addListener((observableValue, oldValue, snakeOnDoublePoints) -> {
            if (snakeOnDoublePoints) {
                currentEffectsList.getChildren().add(doublePointsLabel);
            }
            else {
                currentEffectsList.getChildren().remove(doublePointsLabel);
            }
        });
    }

    private void addSnakeDrunkCheck() {
        Label drunkLabel = createLabelWithColor("DRUNK", Color.PURPLE);
        gameLoop.snakeDrunk.addListener((observableValue, oldValue, snakeDrunk) -> {
            if (snakeDrunk) {
                currentEffectsList.getChildren().add(drunkLabel);
            }
            else {
                currentEffectsList.getChildren().remove(drunkLabel);
            }
        });
    }

    private void addSnakeFasterCheck() {
        Label snakeFasterLabel = createLabelWithColor("SPEED++", Color.YELLOW);
        gameLoop.snakeFaster.addListener((observableValue, oldValue, snakeFaster) -> {
            if (snakeFaster) {
                currentEffectsList.getChildren().add(snakeFasterLabel);
            }
            else {
                currentEffectsList.getChildren().remove(snakeFasterLabel);
            }
        });
    }

    private void addSnakeSlowerCheck() {
        Label snakeSlowerLabel = createLabelWithColor("SPEED--", Color.DARKGREEN);
        gameLoop.snakeSlower.addListener((observableValue, oldValue, snakeSlower) -> {
            if (snakeSlower) {
                currentEffectsList.getChildren().add(snakeSlowerLabel);
            }
            else {
                currentEffectsList.getChildren().remove(snakeSlowerLabel);
            }
        });
    }

    private void startTimer() {
        Timeline timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            secondsRunning++;
            timeLabel.setText(formatSeconds(secondsRunning));
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    private void initializeGameCanvas() {
        if (gameCanvas == null) {
            throw new NullPointerException("The game canvas is null.");
        }

        gameCanvas.setWidth(CANVAS_WIDTH);
        gameCanvas.setHeight(CANVAS_HEIGHT);
        gameCanvas.setFocusTraversable(true);
        gc = gameCanvas.getGraphicsContext2D();
    }

    private String formatSeconds(int timeInSeconds) {
        int hours = timeInSeconds / 3600;
        int secondsLeft = timeInSeconds - hours * 3600;
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String formattedTime = "";
        if (hours < 10) {
            formattedTime += "0";
        }
        formattedTime += hours + ":";

        if (minutes < 10) {
            formattedTime += "0";
        }
        formattedTime += minutes + ":";

        if (seconds < 10) {
            formattedTime += "0";
        }
        formattedTime += seconds;

        return formattedTime;
    }

    private Label createLabelWithColor(String textValue, Color color) {
        Label label = new Label();
        label.setText(textValue);
        label.setTextFill(color);
        return label;
    }
}
