package SAD.Flipper.FlipperElements;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements CommandElement {

    private List<CommandElement> commands = new ArrayList<>();

    public void addCommand(CommandElement command) {
        commands.add(command);
    }

    public void clearCommand() {
        commands.clear();
    }

    @Override
    public void hit() {
        for (CommandElement command : commands) {
            command.hit();
        }
    }
}
