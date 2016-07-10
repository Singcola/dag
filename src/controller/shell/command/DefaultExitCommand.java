package controller.shell.command;

import controller.shell.Shell;

public class DefaultExitCommand implements ICommand {
    private Shell shell;

    public DefaultExitCommand(Shell shell) {
        this.shell = shell;
    }

    public void execute(model.DAG dag, String[] args) {
        shell.quit();
    }

    public String getName() { return "exit"; }
    public String getDescription() { return "default exit command"; }
}
