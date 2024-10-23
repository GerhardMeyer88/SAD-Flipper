package SAD.Flipper;
import java.util.Random;

public class BallIsRollingFlipperState implements FlipperState {

    private final Flipper flipper;

    public BallIsRollingFlipperState(Flipper flipper) {
        this.flipper = flipper;
    }

    FlipperElement ramp = new FlipperElement(new Ramp());
    FlipperElement bumper = new FlipperElement(new Bumper());
    FlipperElement hole = new FlipperElement(new Hole());
    FlipperElement kicker = new FlipperElement(new Kicker());
    FlipperElement slingShot = new FlipperElement(new SlingShot());


    @Override
    public void insertCoin() {
        System.out.println("Der Coin wird nicht angenommen, während ein Pinball im Spielfeld ist.\n" +
                "Konzentriere dich lieber auf das Spiel!");
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
        flipper.decrementPinBallCount();

        System.out.println("Coin-Zähler: " + flipper.getCoinCount());
        System.out.println("Pinball-Zähler: " + flipper.getPinBallCount());
        System.out.println("Dein Score: 99999999"); //Punktestandzähler kommt noch

        if (flipper.getPinBallCount() == 0) {
            System.out.println("Das war der letzte Pinball.");
            flipper.setState(flipper.getEndFlipperState());
        }
        else {
            flipper.setState(flipper.getPlayingFlipperState());
        }
    }

    @Override
    public void flipIt() {
        Random rand = new Random();
        int diceRoll = rand.nextInt(7) + 1;

        switch (diceRoll) {
            case 1:
                ramp.hit();
                break;
            case 2:
                hole.hit();
                break;
            case 3:
                bumper.hit();
                break;
            case 4:
                kicker.hit();
                break;
            case 5:
                slingShot.hit();
                break;
            default:
                pinBallOut();
        }
    }

    @Override
    public void kickIt() {
        Random rand = new Random();
        int diceRoll = rand.nextInt(5) + 1;

        switch (diceRoll) {
            case 1:
                System.out.println("Der Spieltisch wackelt.");
                bumper.hit();
                break;
            case 2:
                System.out.println("Ein gewaltiger Rums erschüttert den Spieltisch.");
                kicker.hit();
                break;
            default:
                pinBallOut();
        }
    }

    @Override
    public void end() {
        flipper.setCoinCountZero();
        flipper.setPinBallCountZero();
        System.out.println("Während des Spiels aufhören. Was kann wichtiger sein als dein Highscore?");
        System.out.println("Pinball-Zähler: " + flipper.getPinBallCount());
        System.out.println("Coin-Zähler: " + flipper.getCoinCount());
        System.out.println("Highscore: "); // + flipper.getHighScoreCount());
        System.exit(0);
    }
}
