package SAD.Flipper.FlipperElements;

import SAD.Flipper.ScoreManager;

public class SlingShot implements CommandElement, FlipperElement {
    private int score = 180;

    @Override
    public void hit() {
        System.out.println("Slingshot getroffen: " + score + " Punkte");
        ScoreManager.addScore(score);
    }

    @Override
    public void receiveMessage(String message) {

    }
}