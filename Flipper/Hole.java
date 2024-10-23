package SAD.Flipper;

public class Hole implements Command {

    @Override
    public void execute() {
        System.out.println("Der Pinball verschwindet im Hole: ");
    }
}
