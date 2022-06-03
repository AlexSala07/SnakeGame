module jku.mms.snakegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens jku.mms.snakegame to javafx.fxml;
    exports jku.mms.snakegame;
    exports jku.mms.snakegame.gameutils;
    opens jku.mms.snakegame.gameutils to javafx.fxml;
    exports jku.mms.snakegame.javafxutils;
    opens jku.mms.snakegame.javafxutils to javafx.fxml;
}
