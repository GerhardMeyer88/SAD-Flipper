package SAD.Flipper.FlipperElements;

import SAD.Flipper.Command.Command;
import SAD.Flipper.ScoreManager;

public class BumperLeft extends FlipperElement {

    @Override
    public void receiveMessage(String message) {

    }

    private int score = 100;
    private boolean hitTwice = false;

    @Override
    public void hit() {
        if (!hitTwice) {
            score *= 2;
            hitTwice = true;
        }
        System.out.println("Linken Bumper getroffen: " + score + " Punkte");
        ScoreManager.addScore(score);
    }

    @Override
    public void reset() {
        hitTwice = false;
    }
}
