package SAD.Flipper;

public class Flipper {
    private FlipperState flipperState;

    public Flipper() {
        flipperState = new flipperState;
    }

    public void play() {
        flipperState.start();
        flipperState.insertCoin();
        flipperState.start();
    }

    public static void main(String[] args) {
        Flipper flipper = new Flipper();
        flipper.play();
    }

    public void setState(FlipperState) {

    }
}
