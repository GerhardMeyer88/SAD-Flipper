package SAD.Flipper.FlipperElements;

import SAD.Flipper.Mediator.FlipperMediator;
import SAD.Flipper.ScoreManager;

public class Kicker extends FlipperElement {
    private FlipperMediator mediator;
    private int score = 70;

    public void loadUp() {
        System.out.println("Der Kicker ist jetzt aufgeladen!");
    }

    @Override
    public void hit() {
        System.out.println("Kicker getroffen: " + score + " Punkte");
        ScoreManager.addScore(score);
    }

    @Override
    public void receiveMessage(String message) {

        if (message.equals("Slinghot getroffen")) {
            loadUp();
        }

    }

    @Override
    public void reset() {
        // Nothing to reset
    }
}
