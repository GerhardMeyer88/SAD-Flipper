package SAD.Flipper;

public class NoCreditFlipperState implements FlipperState {

    private final Flipper flipper;

    private int kickCounter = 0;

    public NoCreditFlipperState(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin(){
        System.out.println("Coin eingeworfen.\n" +
                "Coin-Zähler: " + flipper.getCoinCount());
        flipper.incrementCoinCount();
        flipper.setState(flipper.getReadyFlipperState());
    }

    @Override
    public void start() {
        System.out.println("Kein Credit vorhanden, bitte Coins einwerfen!");
    }

    @Override
    public void pullPinBall() {
        System.out.println("Ein lautes Schnalzen ertönt, aber es ist kein Pinball geladen. Wirf ein Coin rein!");
    }

    @Override
    public void pinBallOut() {
        // Kein Pinball im Spiel!
    }

    @Override
    public void flipIt() {
        System.out.println("Ohne Pinball, macht das keinen Spaß.");
    }

    @Override
    public void kickIt() {
        kickCounter++;

        if (kickCounter == 4) {
            System.out.println("Du hast deinen Frust rauseglassen, Zeit nach Hause zu gehen.");
            flipper.end();
        }
        else {
            System.out.println("Der Flippertisch wackelt von deinem Tritt!");
        }
    }

    @Override
    public void end() {
        System.out.println("Ich sollte nicht mein ganzes Geld für den Flipperautomat ausgeben! Ich gehe besser nach Hause.");
        System.exit(0);
    }
}
