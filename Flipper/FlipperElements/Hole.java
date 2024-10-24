package SAD.Flipper.FlipperElements;

import SAD.Flipper.ScoreManager;

public class Hole implements CommandElement {
    private int score = 150;

    @Override
    public void hit() {
        System.out.println("Der Pinball verschwindet im Hole: " + score + " Punkte");
        ScoreManager.addScore(score);
    }
}
