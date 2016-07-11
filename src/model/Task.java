package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task extends Node {
    private List<Context> contexts;
    private boolean completed;

    public Task(ID id) { this (id, ""); }
    public Task(ID id, String desc) {
        super(id, desc);
        System.out.println("Task param desc: " + desc);
        this.contexts = new ArrayList<Context>();
        this.completed = false;
    }

    public List<Context> getContexts() { return Collections.unmodifiableList(contexts); }

    public boolean isComplete() { return completed; }

    public void toggle() { completed = !completed; }

    public void checkOff() { completed = true; }

    public void unCheck() { completed = false; }

    public void addContext(Context c) { contexts.add(c); }

    public void removeContext(Context c) { contexts.remove(c); }

    @Override
    public String toString() {
        String deps = super.toString();
        StringBuilder bob = new StringBuilder();
        bob.append(String.format(
            "[%c] %s: %s \n    %s",
            (completed ? 'X' : ' '),
            getID().toString(),
            getDescription(),
            deps
        ));
        if (contexts.size() > 0) { bob.append("\n    "); }
        for (Context c : contexts) {
            bob.append("#" + c);
        }
        return bob.toString();
    }
}
