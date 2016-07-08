package cli;

import args.ArgParser;
import command.ICommand;
import command.CommandManager;
import dag.DAG;
import java.util.Scanner;

public class CommandLineMain {
  public static void main(String[] args) {
    CommandLineMain.init();
    Scanner scan = new Scanner(System.in);
    String line = "";
    CommandManager m = CommandManager.getInstance();
    DAG dag = new DAG();
    do {
      System.out.print("$ ");
      line = scan.nextLine();
      String[] cargs = ArgParser.parse(line);
      m.get(cargs[0]).execute(dag, cargs);
    } while (!line.equals("exit"));
    scan.close();
  }

  public static void init() {
    CommandManager m = CommandManager.getInstance();
    m.registerCommand(new ICommand() {
      public void execute(DAG dag, String[] args) {
        System.out.println("These are the tasks...");
      }
      public String getName() { return "tasks"; }
    });
    m.registerCommand(new ICommand() {
      public void execute(DAG dag, String[] args) {
        System.out.println(CommandManager.getInstance().listCommands());
      }
      public String getName() { return "list"; }
    });
    m.registerCommand(new ICommand() {
      public void execute(DAG dag, String[] args) {
        System.out.println("Bubye!");
      }
      public String getName() { return "exit"; }
    });
    m.registerCommand(new ICommand() {
      public void execute(DAG dag, String[] args) {
        System.out.println("I am doing quite well, thank you!");
      }
      public String getName() { return "sup?"; }
    });
    m.registerCommand(new ICommand() {
      public void execute(DAG dag, String[] args) {
        ArgParser.main(args);
      }
      public String getName() { return "args"; }
    });
  }
}
