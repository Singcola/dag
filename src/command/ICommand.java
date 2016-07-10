package command;

public interface ICommand {
    void execute(model.DAG dag, String[] args);
    String getName();
    String getDescription();
}
