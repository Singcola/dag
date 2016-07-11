package model;

public class Context {
    private String context;

    public Context(String context) {
        this.setContext(context);
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        // TODO ValContextation will go here!
        this.context = context;
    }

    @Override
    public String toString() {
        return context;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Context)) {
            return false;
        } else {
            Context other = (Context) o;
            return this.context.equals(other.context);
        }
    }

    @Override
    public int hashCode() {
        return context.hashCode();
    }
}
