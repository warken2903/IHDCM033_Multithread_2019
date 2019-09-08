package be.unamur.ialtem.examen.thread;

public class Message {
    private final String id;
    private final String message;

    public Message(final String id, final String message) {
        this.id = id;
        this.message = message;
    }

    @Override
    public String toString() {
        return "<ID>: " + id + ", <MESSAGE>: " + message;
    }

    public String getId() {
        return id;
    }
}
