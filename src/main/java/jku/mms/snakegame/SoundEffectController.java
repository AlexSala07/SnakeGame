package jku.mms.snakegame;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class SoundEffectController {
    private static Media appleClip = new Media(SoundEffectController.class.getResource("apple.wav").toExternalForm());
    private static Media doublePointsClip = new Media(SoundEffectController.class.getResource("doublePoints.wav").toExternalForm());
    private static Media lightningClip = new Media(SoundEffectController.class.getResource("lightning.wav").toExternalForm());
    private static Media snailClip = new Media(SoundEffectController.class.getResource("snail.wav").toExternalForm());
    private static Media deadClip = new Media(SoundEffectController.class.getResource("dead.wav").toExternalForm());
    private static Media drunkClip = new Media(SoundEffectController.class.getResource("drunk.wav").toExternalForm());
    private static Media fogClip = new Media(SoundEffectController.class.getResource("fog.wav").toExternalForm());
    private static Media blurClip = new Media(SoundEffectController.class.getResource("blur.wav").toExternalForm());

    public static void playAppleSound() {
        if (SnakeGameApplication.getMediaPlayer().isMute()) {
            return;
        }

        createMediaPlayer(appleClip).play();
    }

    public static void playDoublePointsSound() {
        if (SnakeGameApplication.getMediaPlayer().isMute()) {
            return;
        }

        createMediaPlayer(doublePointsClip).play();
    }

    public static void playLightningSound() {
        if (SnakeGameApplication.getMediaPlayer().isMute()) {
            return;
        }

        createMediaPlayer(lightningClip).play();
    }

    public static void playSnailSound() {
        if (SnakeGameApplication.getMediaPlayer().isMute()) {
            return;
        }

        createMediaPlayer(snailClip).play();
    }

    public static void playDeadSound() {
        if (SnakeGameApplication.getMediaPlayer().isMute()) {
            return;
        }

        createMediaPlayer(deadClip).play();
    }

    public static void playDrunkSound() {
        if (SnakeGameApplication.getMediaPlayer().isMute()) {
            return;
        }

        createMediaPlayer(drunkClip).play();
    }

    public static void playFogSound() {
        if (SnakeGameApplication.getMediaPlayer().isMute()) {
            return;
        }

        createMediaPlayer(fogClip).play();
    }

    public static void playBlurSound() {
        if (SnakeGameApplication.getMediaPlayer().isMute()) {
            return;
        }

        createMediaPlayer(blurClip).play();
    }

    private static MediaPlayer createMediaPlayer(Media clipToPlay) {
        return new MediaPlayer(clipToPlay);
    }
}
