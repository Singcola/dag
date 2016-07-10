package model.command;

public class BadDataTransferException extends Exception {
    private DataTransfer data;
    private String message;

    public BadDataTransferException() {
        this(null, "");
    }

    public BadDataTransferException(String message) {
        this(null, message);
    }

    public BadDataTransferException(DataTransfer data) {
        this(data, "");
    }

    public BadDataTransferException(DataTransfer data, String message) {
        this.data = data;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.getClass() + ": " + message + (data != null ? ": " + data.toString() : "");
    }
}
