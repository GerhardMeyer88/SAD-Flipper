package SAD.Flipper.FlipperElements;

import SAD.Flipper.ScoreManager;

public class BumperRight implements CommandElement, FlipperElement {
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
        System.out.println("Rechten Bumper getroffen: " + score + " Punkte");
        ScoreManager.addScore(score);

    }
}
