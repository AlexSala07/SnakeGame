package jku.mms.snakegame.javafxutils;

public enum Scene {
    MENU("menu.fxml"), SINGLE_PLAYER("single-player.fxml"), GAME_END("game-end.fxml");

    private String filePath;

    Scene(String path) {
        this.filePath = path;
    }

    public String getFilePath() {
        return "ui/" + filePath;
    }
}
