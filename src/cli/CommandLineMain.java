package cli;

import args.ArgParser;
import command.ICommand;
import command.CommandManager;
import command.ListCommand;
import model.DAG;
import java.util.Scanner;

public class CommandLineMain {
    private static Scanner scan;

    public static void main(String[] args) {
        Repl mainRepl = new Repl(initCommands(), "main");
        DAG dag = new DAG();
        scan = new Scanner(System.in);
        mainRepl.run(scan, dag, args);
        scan.close();
    }

    public static CommandManager initCommands() {
        CommandManager m = new CommandManager();
        m.registerCommand(new ListCommand(m));
        m.registerCommand(new ICommand() {
            public void execute(DAG dag, String[] args) {
                System.out.println("I am doing quite well, thank you!");
            }
            public String getName() { return "sup?"; }
            public String getDescription() { return "gives a pleasant greeting"; }
        });
        m.registerCommand(new ICommand() {
            public void execute(DAG dag, String[] args) {
                ArgParser.main(args);
            }
            public String getName() { return "args"; }
            public String getDescription() { return "echoes the arguments given in the command"; }
        });
        m.registerCommand(new ReplCommand());
        return m;
    }

    private static class ReplCommand implements ICommand {
        public void execute(DAG dag, String[] args) {
            CommandManager cs = new CommandManager();
            cs.registerCommand(new ListCommand(cs));
            cs.registerCommand(this);
            Repl repl    = (args.length > 1 ? new Repl(cs, args[1]) : new Repl(cs));
            repl.run(scan, dag, args);
        }
        public String getName() { return "repl"; }
        public String getDescription() { return "repl recursively!"; }
    }
}
