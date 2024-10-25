package SAD.Flipper.FlipperElements;

import SAD.Flipper.ScoreManager;

public class SlingShot extends FlipperElement {
    private int score = 180;

    @Override
    public void hit() {
        System.out.println("Slingshot getroffen: " + score + " Punkte");
        ScoreManager.addScore(score);
    }

    @Override
    public void receiveMessage(String message) {

    }

    @Override
    public void reset() {
        // nothing to reset
    }
}