package command;

import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class CommandManager {
  private static CommandManager instance;

  private Map<String, ICommand> commands;

  private CommandManager() {
    commands = new TreeMap<String, ICommand>();
  }

  public static CommandManager getInstance() {
    if (instance == null) {
      instance = new CommandManager();
    }
    return instance;
  }

  public void registerCommand(ICommand command) {
    commands.put(command.getName(), command);
    System.out.printf("%s registered!\n", command.getName());
  }

  public ICommand get(String key) {
    return commands.get(key);
  }

  public String listCommands() {
    StringBuilder out = new StringBuilder();
    for (String e : commands.keySet()) {
      out.append(e);
      out.append("\n");
    }
    return out.toString();
  }
}
