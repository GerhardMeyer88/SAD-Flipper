package SAD.Flipper;

public class NoCreditFlipperState implements FlipperState {

    private final Flipper flipper;

    public NoCreditFlipperState(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin(){
        flipper.setState(new ReadyState(flipper));
    }

    @Override
    public void start(){
        System.out.println("Kein Credit vorhanden, bitte Coins einwerfen!");
    }
}
