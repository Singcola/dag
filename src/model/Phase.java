package model;

import java.util.List;

public class Phase extends Node {
    public Phase(ID id) { super(id); }
    public List<Context> getContexts() { return null; }
    public boolean isComplete() { return false; }
}
