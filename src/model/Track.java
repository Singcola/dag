package model;

import java.util.List;

public class Track extends Node {
    public Track(ID id) { super(id); }
    public List<Context> getContexts() { return null; }
    public boolean isComplete() { return false; }
}
