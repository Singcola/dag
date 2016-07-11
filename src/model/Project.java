package model;

import java.util.List;

public class Project extends Node {
    public Project(ID id) { super(id); }
    public List<Context> getContexts() { return null; }
    public boolean isComplete() { return false; }
}
