package SAD.Flipper;

public class EndFlipperState implements FlipperState {
    private final Flipper flipper;

    public int kickCounter = 0;

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
        System.out.println("Dein letzer Highscore: " + ScoreManager.getTotalScore());
        ScoreManager.resetScore();

        if (flipper.getCoinCount() > 0) {
            flipper.decrementCoinCount();
            flipper.incrementPinBallCount(3);
            System.out.println("Neues Spiel gestartet!");
            System.out.println(" 1 Coin gegen 3 Bälle getauscht.\nCoin-Zähler: " + flipper.getCoinCount());
            System.out.println("Pinball-Zähler: " + flipper.getPinBallCount());
            System.out.println("Hau den Pinball ins Spielfeld!");
            flipper.setState(flipper.getBallIsRollingFlipperState());
        } else {
            System.out.println("Kein Credit Vorhanden, wirf bitte einen Coin rein!");
            flipper.setState(flipper.getNoCreditFlipperState());
        }
    }

    @Override
    public void pullPinBall() {
        System.out.println("Willst du ohne Pinball spielen, wie soll das klappen?");
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
        kickCounter++;

        if (kickCounter == 2) {
            flipper.setCoinCountZero();
            flipper.setPinBallCountZero();
            System.out.println("Das war einmal zu viel getreten! Spiel Beendet!");
            System.exit(0);
        } else {
            System.out.println("Gib nicht mir die Schuld, wenn du verloren hast!");
        }
    }

    @Override
    public void end() {
        flipper.setCoinCountZero();
        flipper.setPinBallCountZero();
        System.out.println("Pinball-Zähler: " + flipper.getPinBallCount());
        System.out.println("Coin-Zähler: " + flipper.getCoinCount());
        System.out.println("Highscore: " + ScoreManager.getTotalScore());
        ScoreManager.resetScore();
        System.out.println("Genug gespielt, good bye.");
        System.exit(0);
    }
}
