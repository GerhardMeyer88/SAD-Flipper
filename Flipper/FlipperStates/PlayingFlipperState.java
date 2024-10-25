package SAD.Flipper.FlipperStates;

import SAD.Flipper.Flipper;
import SAD.Flipper.ScoreManager;
import SAD.Flipper.visitor.ResetVisitor;

public class PlayingFlipperState implements FlipperState {

    private final Flipper flipper;
    private int kickCounter = 0;

    public PlayingFlipperState(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin(){
        flipper.incrementCoinCount();
        flipper.insertCoinFont();
        System.out.println("Coin-Zähler: " + flipper.getCoinCount());
    }

    @Override
    public void start(){
        System.out.println("Chill mal, das Spiel läuft doch schon!");
    }

    @Override
    public void pullPinBall() {
        flipper.pinBallInFont();
        flipper.setState(flipper.getBallIsRollingFlipperState());
    }

    @Override
    public void flipIt() {
        System.out.println("Kein Pinball im Spielfeld.");
    }

    @Override
    public void pinBallOut() {
    }

    @Override
    public void kickIt() {
        kickCounter++;

        if (kickCounter == 3) {
            System.out.println("Der Flipperautomat flimmert, das schaut nicht gut aus!");
            flipper.setCoinCountZero();
            flipper.setPinBallCountZero();
            System.out.println("Neustart...");
            System.out.println("Coin-Zähler: " + flipper.getCoinCount());
            System.out.println("Pinball-Zähler: " + flipper.getPinBallCount());
            System.out.println("Highscore: " + ScoreManager.getTotalScore());
            ScoreManager.resetScore();
            flipper.setState(flipper.getNoCreditFlipperState());
        }
        else {
            System.out.println("Der Spieltisch wackelt.");
        }
    }

    @Override
    public void end() {
        flipper.setCoinCountZero();
        flipper.setPinBallCountZero();
        flipper.startGameFont();
        System.out.println("Pinball-Zähler: " + flipper.getPinBallCount());
        System.out.println("Coin-Zähler: " + flipper.getCoinCount());
        System.out.println("Highscore: " + ScoreManager.getTotalScore());
        ScoreManager.resetScore();
        System.out.println("Genug gespielt, ich gehe nach Hause.");
        //System.exit(0);
    }
}
