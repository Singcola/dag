package cli;

import args.ArgParser;
import command.CommandManager;
import command.ICommand;
import java.util.Scanner;

public class Repl {
    private static int idgen = 0;
    private CommandManager commands;
    private boolean proceed;
    private String name;

    public Repl(CommandManager commands, ICommand exit) {
        this.commands = commands;
        this.setExitCommand(exit);
        this.proceed = false;
    }

    public Repl(CommandManager commands) {
        this.commands = commands;
        this.setExitCommand(new DefaultExitCommand(this));
        this.proceed = false;
        this.name = "def" + idgen++;
    }

    public Repl(CommandManager commands, String name) {
        this(commands);
        this.name = name;
    }

    public void setExitCommand(ICommand exit) {
        commands.registerCommand(exit);
    }

    public void quit() { proceed = false; }

    public String getName() { return name; }

    public void run(Scanner scan, model.DAG dag, String[] args) {
        proceed = true;
        String line = "";
        do {
            System.out.printf("%s$ ", name);
            line = scan.nextLine();
            String[] cargs = ArgParser.parse(line);
            if (commands.containsKey(cargs[0]))
                commands.get(cargs[0]).execute(dag, cargs);
            else
                System.out.printf("uncognized command '%s'\n", cargs[0]);
        } while (proceed);
    }

    private class DefaultExitCommand implements ICommand {
        private Repl repl;

        public DefaultExitCommand(Repl repl) {
            this.repl = repl;
        }

        public void execute(model.DAG dag, String[] args) {
            repl.quit();
        }

        public String getName() { return "exit"; }
        public String getDescription() { return "default exit command"; }
    }
}
