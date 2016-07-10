package controller.shell.command;

import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class CommandManager extends TreeMap<String, ICommand> {

    public void registerCommand(ICommand command) {
        this.put(command.getName(), command);
    }

    public String listCommands() {
        StringBuilder out = new StringBuilder();
        for (String e : this.keySet()) {
            out.append(e);
            out.append("\n");
        }
        return out.toString();
    }
}
