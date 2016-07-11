package controller.shell.command;

import model.Model;

public interface ICommand {
    void execute(Model dag, String[] args);
    String getName();
    String getDescription();
}
