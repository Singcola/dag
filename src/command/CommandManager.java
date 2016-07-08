package command;

public class CommandManager {
  private static CommandManager instance;

  private CommandManager() {}

  public CommandManager getInstance() {
    if (instance == null) {
      instance = new CommandManager();
    }
    return instance;
  }
}
