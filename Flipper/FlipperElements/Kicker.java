package SAD.Flipper.FlipperElements;

import SAD.Flipper.ScoreManager;

public class Kicker implements CommandElement {
    private int score = 70;

    @Override
    public void hit() {
        System.out.println("Kicker getroffen: " + score + " Punkte");
        ScoreManager.addScore(score);
    }
}
