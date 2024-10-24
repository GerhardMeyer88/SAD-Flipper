package SAD.Flipper.FlipperStates;

public interface FlipperState {

    void insertCoin();
    void start();
    void pullPinBall();
    void pinBallOut();
    void flipIt();
    void kickIt();
    void end();
}
