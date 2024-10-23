package SAD.Flipper;

public class Bumper implements Command {

    @Override
    public void execute() {
        System.out.println("Bumper getroffen: ");
    }
}
