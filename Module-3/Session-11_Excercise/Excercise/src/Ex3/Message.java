package Ex3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Message {
    private String sender;
    private String content;
    private LocalDate timestamp;

    public Message(String sender, String content, LocalDate timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getSender() { return sender; }
    public LocalDate getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("[%s] %s: %s", timestamp.format(formatter), sender, content);
    }
}
