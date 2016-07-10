package controller.shell;

import com.google.gson.Gson;
import controller.shell.command.ICommand;
import controller.shell.command.CommandManager;
import controller.shell.command.ListCommand;
import java.util.Scanner;
import model.DAG;

public class CommandLineMain {
    private static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        new Shell(scan, "main").run(new DAG());
        scan.close();
    }
}
