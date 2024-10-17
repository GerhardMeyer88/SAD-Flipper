package SAD.Flipper;
import java.util.Random;

public class BallIsRollingFlipperState implements FlipperState {

    private final Flipper flipper;

    public BallIsRollingFlipperState(Flipper flipper) {
        this.flipper = flipper;
    }


    @Override
    public void insertCoin() {
        System.out.println("Der Coin wird nicht angenommen, während ein Pinball im Spielfeld ist!");
    }

    @Override
    public void start() {
        System.out.println("Passiert nichts!");
    }

    @Override
    public void pullPinBall() {
        System.out.println("Es ist ein Pinball bereits im Spiel!");
    }

    @Override
    public void pinBallOut() {
        System.out.println("Der Pinball landet im Aus.");

        if (flipper.getCoinCount() == 0 && flipper.getPinBallCount() == 0) {
            System.out.println("Das war der letzte Pinball und du hast keine Coins mehr.");
            System.out.println("Dein Score: 9999999"); //Hardcodet Score :D
            flipper.setState(flipper.getNoCreditFlipperState());
        }
        else {
            flipper.setState(flipper.getPlayingFlipperState());
        }

    }

    @Override
    public void flipIt() {
        Random rand = new Random();
        int diceRoll = rand.nextInt(5) + 1;

        switch (diceRoll) {
            case 1:
                System.out.println("Der Flipper trifft den Pinball perfekt!");
                break;
            case 2:
                pinBallOut();
                break;
            default:
                System.out.println("Der Flipper trifft den Pinball!");
        }
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
            System.out.println("Kick Event: Das Scenario, was am häufigsten eintreten soll.");
        }
    }

    @Override
    public void end() {

    }
}
