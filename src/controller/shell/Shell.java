package controller.shell;

import java.util.Scanner;

import controller.shell.command.AddTaskCommand;
import controller.shell.command.CommandManager;
import controller.shell.command.DefaultExitCommand;
import controller.shell.command.DisplayTasksCommand;
import controller.shell.command.ListCommand;
import controller.shell.command.ShellCommand;
import model.Model;

public class Shell {
    private static int idgen = 0;

    private Scanner scan;
    private Shell parent;
    private CommandManager cmds;
    private boolean proceed;
    private String name;

    private void initDefCmds() {
        cmds.registerCommand(new ListCommand(cmds));
        cmds.registerCommand(new ArgParser());
        cmds.registerCommand(new ShellCommand(this));
        cmds.registerCommand(new DefaultExitCommand(this));
    }

    public Shell(Scanner scan) { this(scan, new CommandManager()); }
    public Shell(Scanner scan, String name) { this(scan, new CommandManager(), null, name); }
    public Shell(Scanner scan, CommandManager extras) { this(scan, extras, null); }
    public Shell(Scanner scan, CommandManager extras, Shell parent) { this(scan, extras, parent, "def:0x" + Integer.toHexString(idgen++).toUpperCase()); }
    public Shell(Scanner scan, CommandManager extras, Shell parent, String name) {
        this.scan = scan;
        this.parent = parent;
        this.cmds = new CommandManager();
        this.proceed = false;
        this.name = "";

        initDefCmds();
        addCmds(extras);
        setName(name);
    }

    public void quit() { proceed = false; }

    public void run(Model dag) {
        proceed = true;
        String line = "";
        do {
            System.out.printf("%s$ ", name);
            line = scan.nextLine();
            String[] cargs = ArgParser.parse(line);
            if (cmds.containsKey(cargs[0]))
                cmds.get(cargs[0]).execute(dag, cargs);
            else
                System.out.printf("uncognized command '%s'\n", cargs[0]);
        } while (proceed);
    }

    public Scanner getScanner() { return scan; }

    public String getName() { return name; }
    public void setName(String name) {
        String pname = (parent != null ? parent.getName() : "");
        this.name = pname + name + "|";
    }

    public void addCmds(CommandManager extras) {
        extras.forEach(cmds::putIfAbsent);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CommandManager cmds = new CommandManager();
        cmds.registerCommand(new AddTaskCommand());
        cmds.registerCommand(new DisplayTasksCommand());
        new Shell(scan, cmds, null, "main").run(new Model());
        scan.close();
    }
}
