package SAD.Flipper;

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
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
