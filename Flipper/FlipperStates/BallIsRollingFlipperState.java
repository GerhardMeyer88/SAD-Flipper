package SAD.Flipper.FlipperStates;

import SAD.Flipper.*;
import SAD.Flipper.Command.MacroCommand;
import SAD.Flipper.FlipperElements.*;
import SAD.Flipper.Mediator.FlipperMediator;
import SAD.Flipper.visitor.ResetVisitor;

import java.util.Random;

public class BallIsRollingFlipperState implements FlipperState {

    private final Flipper flipper;

    public BallIsRollingFlipperState(Flipper flipper) {
        this.flipper = flipper;
    }

    FlipperMediator mediator = new FlipperMediator();

    Ramp hitRamp = new Ramp(mediator);
    BumperRight hitBumperRight = new BumperRight();
    BumperLeft hitBumperLeft = new BumperLeft();
    Hole hitHole = new Hole();
    Kicker hitKicker = new Kicker();
    SlingShot hitSlingShot = new SlingShot();

    MacroCommand macroCommand = new MacroCommand();


    @Override
    public void insertCoin() {
        System.out.println("Der Coin wird nicht angenommen, während ein Pinball im Spielfeld ist.\n" +
                "Konzentriere dich lieber auf das Spiel!");
    }

    @Override
    public void start() {
        flipper.showAutorsFont();
    }

    @Override
    public void pullPinBall() {
        System.out.println("Es ist ein Pinball bereits im Spiel!");
    }

    @Override
    public void pinBallOut() {
        flipper.pinBallOutFont();
        flipper.decrementPinBallCount();

        System.out.println("Coin-Zähler: " + flipper.getCoinCount());
        System.out.println("Pinball-Zähler: " + flipper.getPinBallCount());
        System.out.println("Dein Score: " + ScoreManager.getTotalScore());

        if (flipper.getPinBallCount() == 0) {
            System.out.println("Das war der letzte Pinball.");
            flipper.setState(flipper.getEndFlipperState());
        } else {
            flipper.setState(flipper.getPlayingFlipperState());
        }
    }

    @Override
    public void flipIt() {
        Random rand = new Random();
        int diceRoll = rand.nextInt(7) + 1;

        switch (diceRoll) {
            case 1:
                flipper.eventFont();
                InputEvent.letterGame();
                break;
            case 2:
                int randomNumber = rand.nextInt(3) + 1;
                flipper.bonusGameFont();
                System.out.println("Bonus Würfelspiel!");
                System.out.println("Eine Zahl zwischen 1 und 3 wird gewürfelt, 3 Gewinnt.");
                System.out.println("Der Würfel fällt: " + randomNumber);

                if (randomNumber == 3) {
                    flipper.bonusGameFont();
                    macroCommand.addCommand(hitRamp);
                    macroCommand.addCommand(hitHole);
                    macroCommand.hit();
                    macroCommand.clearCommand();
                } else {
                    System.out.println("Schlecht gewürfelt!");
                    macroCommand.addCommand(hitHole);
                    macroCommand.hit();
                    macroCommand.clearCommand();
                }
                break;
            case 3:
                macroCommand.addCommand(hitBumperLeft);
                macroCommand.addCommand(hitKicker);
                macroCommand.addCommand(hitSlingShot);
                macroCommand.hit();
                macroCommand.clearCommand();
                break;
            case 4:
                macroCommand.addCommand(hitBumperRight);
                macroCommand.hit();
                macroCommand.clearCommand();
                break;
            case 5:
                macroCommand.addCommand(hitSlingShot);
                macroCommand.addCommand(hitKicker);
                macroCommand.hit();
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
                macroCommand.hit();
                macroCommand.clearCommand();
                break;
            case 2:
                System.out.println("Ein gewaltiger Rums erschüttert den Spieltisch.");
                macroCommand.addCommand(hitRamp);
                macroCommand.hit();
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
        flipper.stopGameFont();
        System.out.println("Während des Spiels aufhören. Was kann wichtiger als dein Highscore sein?");
        System.out.println("Pinball-Zähler: " + flipper.getPinBallCount());
        System.out.println("Coin-Zähler: " + flipper.getCoinCount());
        System.out.println("Highscore: " + ScoreManager.getTotalScore());
        ScoreManager.resetScore();

        ResetVisitor resetVisitor = new ResetVisitor();
        resetVisitor.visit(hitRamp);
        resetVisitor.visit(hitBumperLeft);
        resetVisitor.visit(hitBumperRight);
        resetVisitor.visit(hitKicker);
        resetVisitor.visit(hitHole);
        resetVisitor.visit(hitSlingShot);
        flipper.setState(flipper.getNoCreditFlipperState());
    }
}
