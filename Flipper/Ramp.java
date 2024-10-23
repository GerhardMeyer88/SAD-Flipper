package SAD.Flipper;

public class Ramp implements Command {

    @Override
    public void execute() {
        System.out.println("Der Pinball durchläuft die Rampe: ");
    }
}
