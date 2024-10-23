package SAD.Flipper;

public class FlipperElement {
    private Command hitCommand;

    public FlipperElement(Command hitCommand) {
        this.hitCommand = hitCommand;
    }

    public void hit() {
        hitCommand.execute();
    }
}
