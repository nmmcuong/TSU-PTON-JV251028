package Ex5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Event {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Event(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return String.format("Event{name='%s', startDate=%s, endDate=%s}", 
                name, startDate.format(formatter), endDate.format(formatter));
    }
}
