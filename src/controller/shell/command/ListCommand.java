package controller.shell.command;

import model.Model;

public class ListCommand implements ICommand {
    private CommandManager manager;

    public ListCommand(CommandManager manager) {
        this.manager = manager;
    }

    public void execute(Model dag, String[] args) {
        System.out.println("eligible commands");
        for (ICommand c : manager.values()) {
            System.out.printf("    %s -- %s\n", c.getName(), c.getDescription());
        }
    }

    public String getName() { return "list"; }
    public String getDescription() { return "lists the commands of the current repl"; }
}
