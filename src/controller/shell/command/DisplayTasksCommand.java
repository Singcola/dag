package controller.shell.command;

import model.*;

public class DisplayTasksCommand implements ICommand {
    public void execute(Model model, String[] args) {
        System.out.println(model);
    }

    public String getName() { return "tasks"; }
    public String getDescription() { return "Displays the tasks"; }
}
