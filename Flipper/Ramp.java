package SAD.Flipper;

public class Ramp implements CommandElement {
    private int score = 180;
    private int rampCounter = 0;

    @Override
    public void execute() {
        rampCounter++;

        if (rampCounter == 3) {
            System.out.println("Rampe 3 mal getroffen, sie öffnet sich!");
            System.out.println("10x Multiplikator: " + 10 * score + "Punkte");
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
