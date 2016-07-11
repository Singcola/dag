package model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Task> tasks;

    public Model() {
        tasks = new ArrayList<Task>();
    }

    public Task getTask(ID id) {
        for (Task t : tasks) {
            if (t.getID().equals(id)) { return t; }
        }
        return null;
    }

    public List<Task> getTasks() { return tasks; }

    public void addTask(Task task) { tasks.add(task); }

    public void removeTask(Task task) { tasks.remove(task); }

    @Override
    public String toString() {
        StringBuilder bob = new StringBuilder();
        for (Task t : tasks) {
            bob.append(t);
            bob.append("\n");
        }
        return bob.toString();
    }
}
