package controller.shell.command;

import controller.shell.Shell;
import model.DAG;

public class ShellCommand implements ICommand {
    private Shell shell;
    private CommandManager cmds;

    public ShellCommand(Shell shell) {
        this(shell, new CommandManager());
    }

    public ShellCommand(Shell shell, CommandManager cmds) {
        this.shell = shell;
        this.cmds = cmds;
    }

    public void execute(DAG dag, String[] args) {
        System.out.println("running execute for shell command");
        Shell child = (args.length > 1 ?
            new Shell(shell.getScanner(), cmds, shell, args[1]) :
            new Shell(shell.getScanner(), cmds, shell));
        child.run(dag);
    }
    public String getName() { return "repl"; }
    public String getDescription() { return "repl recursively!"; }
}
