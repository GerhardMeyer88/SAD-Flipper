package SAD.Flipper.FlipperElements;

import SAD.Flipper.Command.Command;

public abstract class FlipperElement implements Command {
    public abstract void receiveMessage(String message);
    public abstract void reset();
}
