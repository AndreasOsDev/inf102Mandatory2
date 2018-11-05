package no.uib.ii.inf102.f18.mandatory2;

import java.util.Objects;

/**
 * @author You
 */
public class Event {
    final Date date;
    final String title;
    String description;

    public Event(Date date, String title) {
        this.date = date;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(date, event.date) &&
                Objects.equals(title, event.title) &&
                Objects.equals(description, event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, title, description);
    }
}
