package SAD.Flipper;

import SAD.Flipper.FlipperDesign.FlipperDesign;
import SAD.Flipper.FlipperDesign.FlipperFireDesign;
import SAD.Flipper.FlipperDesign.FlipperHyperDesign;
import SAD.Flipper.FlipperDesign.Greeting;
import SAD.Flipper.FlipperStates.*;
import java.util.Scanner;

public class Flipper {
    private FlipperDesign flipperFireDesign;
    private FlipperDesign flipperHyperDesign;

    private FlipperDesign currentFlipperDesign;

    private FlipperState noCreditFlipperState;
    private FlipperState readyFlipperState;
    private FlipperState playingFlipperState;
    private FlipperState ballIsRollingFlipperState;
    private FlipperState endFlipperState;

    private FlipperState currentFlipperState;

    private int pinBallCount = 0;
    private int coinCount = 0;

    public Flipper() {
        flipperFireDesign = new FlipperFireDesign(this);
        flipperHyperDesign = new FlipperHyperDesign(this);

        currentFlipperDesign = flipperFireDesign;

        noCreditFlipperState = new NoCreditFlipperState(this);
        readyFlipperState = new ReadyFlipperState(this);
        playingFlipperState = new PlayingFlipperState(this);
        ballIsRollingFlipperState = new BallIsRollingFlipperState(this);
        endFlipperState = new EndFlipperState(this);

        currentFlipperState = noCreditFlipperState;
    }

    public void startGameFont() {
        currentFlipperDesign.startGameFont();
    }

    public void stopGameFont() {
        currentFlipperDesign.stopGameFont();
    }

    public void bonusGameFont() {
        currentFlipperDesign.bonusGameFont();
    }

    public void pinBallInFont() {
        currentFlipperDesign.pinBallInFont();
    }

    public void pinBallOutFont() {
        currentFlipperDesign.pinBallOutFont();
    }

    public void insertCoinFont() {
        currentFlipperDesign.insertCoinFont();
    }

    public void showAutorsFont() {
        currentFlipperDesign.showAutorsFont();
    }

    public void eventFont() {
        currentFlipperDesign.eventFont();
    }

    public void insertCoin() {
        currentFlipperState.insertCoin();
    }

    public void start() {
        currentFlipperState.start();
    }

    public void pullBall() {
        currentFlipperState.pullPinBall();
    }

    public void flipIt() {
        currentFlipperState.flipIt();
    }

    public void kickIt() {
        currentFlipperState.kickIt();
    }

    public void end() {
        currentFlipperState.end();
    }

    public void setState(FlipperState state) {
        this.currentFlipperState = state;
    }

    public FlipperDesign getCurrentFlipperDesign() {
        return currentFlipperDesign;
    }

    public void setCurrentFlipperDesign(FlipperDesign currentFlipperDesign) {
        this.currentFlipperDesign = currentFlipperDesign;
    }

    public void setFlipperDesign(FlipperDesign flipperDesign) {
        this.currentFlipperDesign = flipperDesign;
    }

    public FlipperDesign getFlipperFireDesign() {
        return flipperFireDesign;
    }

    public FlipperDesign getFlipperHyperDesign() {
        return flipperHyperDesign;
    }

    public FlipperState getNoCreditFlipperState() {
        return noCreditFlipperState;
    }

    public FlipperState getReadyFlipperState() {
        return readyFlipperState;
    }

    public FlipperState getPlayingFlipperState() {
        return playingFlipperState;
    }

    public FlipperState getBallIsRollingFlipperState() {
        return ballIsRollingFlipperState;
    }

    public FlipperState getEndFlipperState() {
        return endFlipperState;
    }

    public int getPinBallCount() {
        return pinBallCount;
    }

    public void incrementPinBallCount(int count) {
        pinBallCount += count;
    }

    public void decrementPinBallCount() {
        if (pinBallCount > 0) {
            pinBallCount--;
        }
    }

    public void setPinBallCountZero() {
        pinBallCount = 0;
    }

    public int getCoinCount() {
        return coinCount;
    }

    public void incrementCoinCount() {
        coinCount++;
    }

    public void decrementCoinCount() {
        if (coinCount > 0) {
            coinCount--;
        }
    }

    public void setCoinCountZero() {
        coinCount = 0;
    }

    public static void main(String[] args) {
        Flipper flipper = new Flipper();
        Scanner scanner = new Scanner(System.in);
        boolean gameOn = true;

        Greeting.greeting();
        String desingnInput = FlipperInput.readInput(scanner);

        if (desingnInput.equalsIgnoreCase("h")) {
            System.out.println("Du hast HYPER gewählt!");
            flipper.setFlipperDesign(flipper.getFlipperHyperDesign());
        }
        else if (desingnInput.equalsIgnoreCase("f")) {
            System.out.println("Du hast FIRE gewählt!");
            flipper.setFlipperDesign(flipper.getFlipperFireDesign());
        }
        else {
            System.out.println("Ungültige Eingabe, HYPER gewählt!");
            flipper.setFlipperDesign(flipper.getFlipperHyperDesign());
        }

        System.out.println("Verwende folgende Tasten: ");
        System.out.println("c - Coin einwerfen");
        System.out.println("s - Start drücken");
        System.out.println("b - Ball Shooter ziehen");
        System.out.println("f - Flipper drücken");
        System.out.println("t - Treten");
        System.out.println("e - Ende drücken");

        while (gameOn) {
            System.out.println("Eingabe: ");
            String input = FlipperInput.readInput(scanner);
            switch (input) {
                case "c":
                    flipper.insertCoin();
                    break;
                case "s":
                    flipper.start();
                    break;
                case "b":
                    flipper.pullBall();
                    break;
                case "f":
                    flipper.flipIt();
                    break;
                case "t":
                    flipper.kickIt();
                    break;
                case "e":
                    flipper.end();
                    break;
                default:
                    System.out.println("Ungültige Eingabe.\n");
                    System.out.println("Verwende folgende Tasten: ");
                    System.out.println("c - Coin einwerfen");
                    System.out.println("s - Start drücken");
                    System.out.println("b - Ball Shooter ziehen");
                    System.out.println("f - Flipper drücken");
                    System.out.println("t - Treten");
                    System.out.println("e - Ende drücken");
            }
        }
    }
}
