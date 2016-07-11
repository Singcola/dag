package model;

public class ID {
    private String id;

    public ID(String id) {
        this.setID(id);
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        // TODO Validation will go here!
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof ID)) {
            return false;
        } else {
            ID other = (ID) o;
            return this.id.equals(other.id);
        }
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
