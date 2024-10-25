package SAD.Flipper.Command;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {

    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void clearCommand() {
        commands.clear();
    }

    @Override
    public void hit() {
        for (Command command : commands) {
            command.hit();
        }
    }
}
