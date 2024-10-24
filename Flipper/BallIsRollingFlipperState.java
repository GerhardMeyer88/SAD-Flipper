package SAD.Flipper;
import java.util.Random;

public class BallIsRollingFlipperState implements FlipperState {

    private final Flipper flipper;

    public BallIsRollingFlipperState(Flipper flipper) {
        this.flipper = flipper;
    }

    CommandElement hitRamp = new Ramp();
    CommandElement hitBumper = new Bumper();
    CommandElement hitHole = new Hole();
    CommandElement hitKicker = new Kicker();
    CommandElement hitSlingShot = new SlingShot();

    MacroCommand macroCommand = new MacroCommand();


    @Override
    public void insertCoin() {
        System.out.println("Der Coin wird nicht angenommen, während ein Pinball im Spielfeld ist.\n" +
                "Konzentriere dich lieber auf das Spiel!");
    }

    @Override
    public void start() {
        System.out.println("Autoren: Gerhard Meyer");
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
        System.out.println("Dein Score: " + ScoreManager.getTotalScore());

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
        int guessNumber = rand.nextInt(3) + 1;

        switch (diceRoll) {
            case 1:
                macroCommand.addCommand(hitKicker);
                macroCommand.execute();
                macroCommand.clearCommand();
                break;
            case 2:
                System.out.println("Bonus Würfelspiel!");
                System.out.println("Eine Zahl zwischen 1 und 3 wird gewürfelt, 3 Gewinnt.");
                System.out.println("Der Würfel fällt: " + guessNumber);

                if (guessNumber == 3) {
                    System.out.println("BOUNSPUNKTE!!!!");
                    macroCommand.addCommand(hitRamp);
                    macroCommand.addCommand(hitHole);
                    macroCommand.execute();
                    macroCommand.clearCommand();
                }
                else {
                    System.out.println("Zu schlecht gewürfelt!");
                    macroCommand.addCommand(hitHole);
                    macroCommand.execute();
                    macroCommand.clearCommand();
                }
                break;
            case 3:
                macroCommand.addCommand(hitBumper);
                macroCommand.addCommand(hitKicker);
                macroCommand.addCommand(hitSlingShot);
                macroCommand.execute();
                macroCommand.clearCommand();
                break;
            case 4:
                macroCommand.addCommand(hitBumper);
                macroCommand.execute();
                macroCommand.clearCommand();
                break;
            case 5:
                macroCommand.addCommand(hitSlingShot);
                macroCommand.addCommand(hitKicker);
                macroCommand.execute();
                macroCommand.clearCommand();
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
                macroCommand.addCommand(hitKicker);
                macroCommand.execute();
                macroCommand.clearCommand();
                break;
            case 2:
                System.out.println("Ein gewaltiger Rums erschüttert den Spieltisch.");
                macroCommand.addCommand(hitBumper);
                macroCommand.execute();
                macroCommand.clearCommand();
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
        System.out.println("Highscore: " + ScoreManager.getTotalScore());
        ScoreManager.resetScore();
        System.exit(0);
    }
}
