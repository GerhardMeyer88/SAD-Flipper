package SAD.Flipper.FlipperElements;

import SAD.Flipper.Mediator.FlipperMediator;
import SAD.Flipper.ScoreManager;

public class Ramp extends FlipperElement {
    private FlipperMediator mediator;
    private int score = 200;
    private int rampCounter = 0;

    public Ramp(FlipperMediator mediator) {
        this.mediator = mediator;
    }

    public void rampTurn() {
        System.out.println("Die Rampe dreht sich!");
    }

    @Override
    public void receiveMessage(String message) {

        if (message.equals("Alle Targets getroffen")) {
            rampTurn();
        }
    }

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

    @Override
    public void reset() {
        rampCounter = 0;
    }
}
