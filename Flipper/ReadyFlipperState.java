package SAD.Flipper;
import java.util.Random;

public class ReadyFlipperState implements FlipperState {

    private final Flipper flipper;
    public ReadyFlipperState(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        flipper.incrementCoinCount();
        System.out.println("Ein weiterer Coin eingeworfen.\n" +
                "Coin-Zähler: " + flipper.getCoinCount());
    }

    @Override
    public void start() {
        flipper.decrementCoinCount();
        flipper.incrementPinBallCount(3);
        System.out.println("Spiel gestartet!");
        System.out.println(" 1 Coin gegen 3 Bälle getauscht.\nCoin-Zähler: " + flipper.getCoinCount());
        System.out.println("Pinball-Zähler: " + flipper.getPinBallCount());
        System.out.println("Ziehe am Ball Shooter, um den Pinball ins Spielfeld zu schleudern!");
        flipper.setState(flipper.getPlayingFlipperState());
    }

    @Override
    public void pullPinBall() {
        System.out.println("Du musst das Spiel zuerst starten, du Anfänger!");
    }

    @Override
    public void pinBallOut() {
        // Kein Pinball im Spiel!
    }

    @Override
    public void flipIt() {
        System.out.println("Ohne Pinball, macht das keinen Spaß.\nDrücke Start und ziehe am Ball Shooter!");
    }

    @Override
    public void kickIt() {
        Random rand = new Random();
        int diceRoll = rand.nextInt(10) + 1;

        if (diceRoll == 2) {
            flipper.decrementCoinCount();
            if (flipper.getCoinCount() == 0) {
                System.out.println("Schade, du hast ein Coin verloren!\nCoin-Zähler: " + flipper.getCoinCount());
                flipper.setState(flipper.getNoCreditFlipperState());
            }
            else {
                System.out.println("Schade, du hast ein Coin verloren!\nCoin-Zähler: " + flipper.getCoinCount());
            }
        }
        else if (diceRoll == 5) {
            flipper.incrementCoinCount();
            System.out.println("Wow, du hast einen Coin dazugewonnen!\nCoin-Zähler: " + flipper.getCoinCount());
        }
        else if (diceRoll == 1) {
            flipper.setCoinCountZero();
            System.out.println("Oh nein, alle Coins sind weg, das Spiel wurde unterbrochen...\n" +
                    "Coin-Zähler: " + flipper.getCoinCount());
            flipper.setState(flipper.getNoCreditFlipperState());
        }
        else {
            System.out.println("Der Flipper wackelt von deinem Tritt!");
        }
    }

    @Override
    public void end() {
        flipper.setCoinCountZero();
        flipper.setPinBallCountZero();
        System.out.println("Spiel beendet! Ich behalte deine restlichen Coins! " +
                "Coin-Zähler: " + flipper.getCoinCount());
        flipper.setState(flipper.getNoCreditFlipperState());
    }
}
