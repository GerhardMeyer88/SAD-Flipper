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
        System.out.println("Coin eingeworfen.\n" +
                "Coin-Zähler: " + flipper.getCoinCount());
    }

    @Override
    public void start() {
        System.out.println("Zeigt später deinen aktuellen Score!");
        System.out.println("Dein Score: ");
    }

    @Override
    public void pullPinBall() {
        System.out.println("Der Pinball ist im Spiel!");
        flipper.setState(flipper.getPlayingFlipperState());
    }

    @Override
    public void pinBallOut() {
    }

    @Override
    public void flipIt() {
        System.out.println("Kein Pinball im Spiel!");
    }

    @Override
    public void kickIt() {
        Random rand = new Random();
        int diceRoll = rand.nextInt(20) + 1;

        if (diceRoll == 10) {
            flipper.incrementPinBallCount(1);
            System.out.println("So ein Glücksfall! Einen Pinball erhalten!");
            System.out.println("Pinball-Zähler: " + flipper.getPinBallCount());
            flipper.setState(flipper.getPlayingFlipperState());
        }
        else {
            System.out.println("Lass deinen Frust nicht an mir aus!");
        }
    }

    @Override
    public void end() {
        flipper.setCoinCountZero();
        flipper.setPinBallCountZero();
        System.out.println("Pinball-Zähler: " + flipper.getPinBallCount());
        System.out.println("Coin-Zähler: " + flipper.getCoinCount());
        System.out.println("Highscore: 999999999"); // + flipper.getHighScoreCount());
        System.out.println("Genug gespielt, good bye.");
        System.exit(0);
    }
}
