package model.command;

import model.Model;

public interface ICommand {
    void execute(Model dag, DataTransfer data) throws BadDataTransferException;
    String getName();
    String getDesc();
    DocData getDocs();
}
