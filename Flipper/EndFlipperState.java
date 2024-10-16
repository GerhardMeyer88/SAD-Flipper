package SAD.Flipper;
import java.util.Random;

public class EndFlipperState implements FlipperState {
    private final Flipper flipper;

    public EndFlipperState(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        flipper.incrementCoinCount();
        System.out.println("Coin eingeworfen. Coin-Zähler: " + flipper.getCoinCount());
    }

    @Override
    public void start() {
        System.out.println("Starte ein weiteres Spiel!");
        flipper.setState(flipper.getPlayingFlipperState());
    }

    @Override
    public void pullPinBall() {
        System.out.println("Der Pinball ist im Spiel!");
    }

    @Override
    public void flipIt() {
        System.out.println("Kein Pinball im Spiel, hau einen neuen Pinball rein!");
    }

    @Override
    public void kickIt() {
        Random rand = new Random();
        int diceRoll = rand.nextInt(20) + 1;

        if (diceRoll == 10) {
            flipper.incrementPinBallCount(1);
            System.out.println("So ein Glücksfall, ein weiterer Pinball ist im Spiel!");
            flipper.setState(flipper.getPlayingFlipperState());
        }
        System.out.println("Bitte nicht treten!");
    }

    public void winTheGame() {
        System.out.println("Spiel Vorbei. Dein Score ist "); //scoreCounter einbauen!
    }

    @Override
    public void end() {

        if (flipper.getCoinCount() == 0) {
            System.out.println("Du hast keine Coins mehr. Spiel zu Ende.");
            flipper.setState(flipper.getNoCreditFlipperState());
        }
        else {
            System.out.println("Du hast noch " + flipper.getCoinCount() + " Coins. Auf zur nächsten Runde!");
            flipper.setState(flipper.getReadyFlipperState());
        }
    }
}
