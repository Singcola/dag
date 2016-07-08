package command;

public interface ICommand {
  void execute(dag.DAG dag, String[] args);
  String getName();
}
