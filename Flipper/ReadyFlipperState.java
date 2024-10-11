package SAD.Flipper;

public class ReadyFlipperState implements FlipperState {

    private final Flipper flipper;

    public ReadyFlipperState(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin(){

    }

    @Override
    public void start(){
        flipper.setState(new PlayingFlipperState(flipper));
        System.out.println("Spiel gestartet!");

    }
}
