package SAD.Flipper;
import java.util.Random;

public class PlayingFlipperState implements FlipperState {

    private final Flipper flipper;
    public boolean isBallAway = true;

    public PlayingFlipperState(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin(){
        flipper.incrementCoinCount();
        System.out.println("Coin eingeworfen. Coin-Zähler: " + flipper.getCoinCount());
    }

    @Override
    public void start(){
        System.out.println("Chill mal, das Spiel läuft doch schon!");
    }

    @Override
    public void pullPinBall() {
        if (isBallAway) {
            flipper.decrementPinBallCount();
            isBallAway = false;
            System.out.println("Der Pinball ist im Spiel! Pinball Zähler: " + flipper.getPinBallCount());
        }
        else {
            System.out.println("Es ist ein Pinball bereits im Spiel.");
        }
    }

    @Override
    public void flipIt() {
        System.out.println("Flippt komplett aus, hier kommt noch ne menge Code für Events dazu!!!");
    }

    public void ballLost() {
        isBallAway = true;
        System.out.println("Der Pinball landet im Aus!");
    }

    @Override
    public void kickIt() {
        Random rand = new Random();
        int diceRoll = rand.nextInt(5) + 1;

        if (diceRoll == 1) {
            System.out.println("Kick Event. Ball trifft diverses, weil der Tisch wackelt.");
        }
        else if (diceRoll == 5) {
            System.out.println("Ein weiteres Kick-Event, ein Pinball wird verloren oder so..");
        }
        else {
            System.out.println("Das Scenario, was am häufigsten eintreten soll.");
        }
    }

    @Override
    public void end() {
        flipper.setCoinCountZero();
        flipper.setPinBallCountZero();
        System.out.println("Spiel beendet! Pinball Zähler: " + flipper.getPinBallCount());
        System.out.println("Coin-Zähler: " + flipper.getCoinCount());
    }
}
