package SAD.Flipper.FlipperElements;

import SAD.Flipper.ScoreManager;

public class SlingShot implements CommandElement {
    private int score = 180;
    public int elementId = 5;

    @Override
    public void hit() {
        System.out.println("Slingshot getroffen: " + score + " Punkte");
        ScoreManager.addScore(score);
    }
}