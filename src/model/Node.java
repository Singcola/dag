package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Node {
    private ID id;
    private String description;
    private List<Node> dependencies;
    private List<Node> dependents;

    public Node(ID id) { this(id, ""); System.out.println ("basic cons"); }
    public Node(ID id, String description) {
        this.id = id;
        this.description = description;
        System.out.println("Node param desc: " + description);
        System.out.println("Node.description: " + this.description);
        this.dependencies = new ArrayList<Node>();
        this.dependents = new ArrayList<Node>();
    }

    public abstract List<Context> getContexts();
    public abstract boolean isComplete();

    public ID getID() { return id; }

    public String getDescription() { return description; }

    public List<Node> getDepencies() { return Collections.unmodifiableList(dependencies); }

    public List<Node> getDependents() { return Collections.unmodifiableList(dependents); }

    public void addDependcy(Node d) { dependencies.add(d); }

    public void removeDependcy(Node d) { dependencies.remove(d); }

    public void addDependent(Node d) { dependents.add(d); }

    public void removeDependent(Node d) { dependents.remove(d); }

    public void dependsOn(Node d) {
        this.addDependent(d);
        d.addDependcy(this);
    }

    public void dependsNotOn(Node d) {
        this.removeDependent(d);
        d.removeDependcy(this);
    }

    @Override
    public String toString() {
        StringBuilder bob = new StringBuilder();
        bob.append("needs:[");
        for (int i = 0; i < dependencies.size(); i++) {
            bob.append(dependencies.get(i).getID());
            if (i < dependencies.size() - 1) { bob.append(","); }
        }
        bob.append("], helps:[");
        for (int i = 0; i < dependents.size(); i++) {
            bob.append(dependents.get(i).getID());
            if (i < dependents.size() - 1) { bob.append(","); }
        }
        bob.append("]");
        return bob.toString();
    }
}
