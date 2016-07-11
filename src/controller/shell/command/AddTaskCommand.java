package controller.shell.command;

import model.*;

public class AddTaskCommand implements ICommand {

    public void execute(Model model, String[] args) {
        controller.shell.ArgParser.main(args);
        System.out.println("args.length: " + args.length);
        ID id = new ID(args[1]);
        String description = "";
        if (args.length > 2) {
            description = args[3];
            System.out.println("description: " + description);
        }
        Task t = new Task(id, description);
        model.addTask(t);
        System.out.println("Added: " + t);
    }

    public String getName() { return "add"; }

    public String getDescription() { return "add [id] -d [description]"; }

}
