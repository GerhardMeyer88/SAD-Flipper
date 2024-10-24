package SAD.Flipper.FlipperElements;

import SAD.Flipper.ScoreManager;

public class Ramp implements CommandElement {
    private int score = 200;
    private int rampCounter = 0;

    @Override
    public void hit() {
        rampCounter++;

        if (rampCounter == 3) {
            System.out.println("Rampe 3 mal getroffen, sie öffnet sich!");
            System.out.println("Bonuspunkte: " + 1000 + "Punkte");
            rampCounter = 0;
            System.out.println("Die Rampe schließt sich.");
            ScoreManager.addScore(score);
        }
        else {
            System.out.println("Rampe getroffen: " + score + " Punkte");
            ScoreManager.addScore(score);
        }
    }
}
