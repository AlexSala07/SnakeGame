package jku.mms.snakegame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.net.URL;
import java.util.ResourceBundle;

public class SingleplayerController implements Initializable {
    @FXML
    private Canvas gameCanvas;

    static final int CANVAS_WIDTH = 700;
    static final int CANVAS_HEIGHT = 500;

    private GameLoop gameLoop;
    private GraphicsContext gc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeGameCanvas();
        gameLoop = new GameLoop(gc);
        (new Thread(gameLoop)).start(); //TODO: Important! close thread after the window has been closed!
    }

    private void initializeGameCanvas() {
        if(gameCanvas == null) {
            throw new NullPointerException("The game canvas is null.");
        }

        gameCanvas.setWidth(CANVAS_WIDTH);
        gameCanvas.setHeight(CANVAS_HEIGHT);
        gameCanvas.setFocusTraversable(true);
        gameCanvas.setOnKeyPressed(new KeyHandler());
        gc = gameCanvas.getGraphicsContext2D();
    }
}
