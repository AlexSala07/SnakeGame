module jku.mms.snakegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens jku.mms.snakegame to javafx.fxml;
    exports jku.mms.snakegame;
}
