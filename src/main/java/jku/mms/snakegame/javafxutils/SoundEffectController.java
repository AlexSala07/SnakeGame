package jku.mms.snakegame.javafxutils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import jku.mms.snakegame.SnakeGameApplication;

public class SoundEffectController {
    private static final Media appleClip = new Media(SoundEffectController.class.getResource("media/audio/apple.wav").toExternalForm());
    private static final Media doublePointsClip = new Media(SoundEffectController.class.getResource("media/audio/doublePoints.wav").toExternalForm());
    private static final Media lightningClip = new Media(SoundEffectController.class.getResource("media/audio/lightning.wav").toExternalForm());
    private static final Media snailClip = new Media(SoundEffectController.class.getResource("media/audio/snail.wav").toExternalForm());
    private static final Media deadClip = new Media(SoundEffectController.class.getResource("media/audio/dead.wav").toExternalForm());
    private static final Media drunkClip = new Media(SoundEffectController.class.getResource("media/audio/drunk.wav").toExternalForm());
    private static final Media fogClip = new Media(SoundEffectController.class.getResource("media/audio/fog.wav").toExternalForm());
    private static final Media blurClip = new Media(SoundEffectController.class.getResource("media/audio/blur.wav").toExternalForm());

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
