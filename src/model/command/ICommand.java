package model.command;

import model.DAG;

public interface ICommand {
    void execute(DAG dag, DataTransfer data) throws BadDataTransferException;
    String getName();
    String getDesc();
    DocData getDocs();
}
