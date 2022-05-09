module jku.mms.snakegame {
    requires javafx.controls;
    requires javafx.fxml;

    opens jku.mms.snakegame to javafx.fxml;
    exports jku.mms.snakegame;
}
