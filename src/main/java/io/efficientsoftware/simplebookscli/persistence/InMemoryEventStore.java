package io.efficientsoftware.simplebookscli.persistence;

import io.efficientsoftware.simplebookscli.model.Event;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Only the Central Repository should communicate with InMemoryEventStore
 */
@Component
public class InMemoryEventStore {

    private Set<Event> events = new HashSet<>();

    protected Set<Event> getEvents() {
        return this.events;
    }

    protected boolean add(Event event) {
        return this.events.add(event);
    }

    protected boolean remove(Event event) {
        return this.events.remove(event);
    }

    protected void setEvents(Set<Event> events) {
        this.events = events;
    }


}
