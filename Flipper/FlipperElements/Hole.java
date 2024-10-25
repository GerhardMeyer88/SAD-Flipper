package SAD.Flipper.FlipperElements;

import SAD.Flipper.ScoreManager;

public class Hole extends FlipperElement {
    private int score = 150;

    @Override
    public void hit() {
        System.out.println("Der Pinball verschwindet im Hole: " + score + " Punkte");
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
