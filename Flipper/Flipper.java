package SAD.Flipper;

import java.util.Scanner;

public class Flipper {
    private FlipperState noCreditFlipperState;
    private FlipperState readyFlipperState;
    private FlipperState playingFlipperState;
    private FlipperState ballIsRollingFlipperState;
    private FlipperState endFlipperState;

    private FlipperState currentFlipperState;

    private int pinBallCount = 0;
    private int coinCount = 0;

    public Flipper() {
        noCreditFlipperState = new NoCreditFlipperState(this);
        readyFlipperState = new ReadyFlipperState(this);
        playingFlipperState = new PlayingFlipperState(this);
        ballIsRollingFlipperState = new BallIsRollingFlipperState(this);
        endFlipperState = new EndFlipperState(this);
        currentFlipperState = noCreditFlipperState;
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

        System.out.println("Flipper Simulation gestartet.");
        System.out.println("Verwende folgende Tasten: ");
        System.out.println("c - Coin einwerfen");
        System.out.println("s - Start drücken");
        System.out.println("b - Ball Shooter ziehen");
        System.out.println("f - Flipper drücken");
        System.out.println("t - Treten");
        System.out.println("e - Ende drücken");

        while (gameOn) {
            System.out.println("Eingabe: ");
            String input = scanner.nextLine().trim().toLowerCase();

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
                    System.out.println("e - Ende drücken");
                    System.out.println("t - Treten");
                    System.out.println("f - Flipper drücken\n");
            }
        }
        scanner.close();
    }
}
