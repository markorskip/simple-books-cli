package io.efficientsoftware.simplebookscli.service;

import io.efficientsoftware.simplebookscli.model.core.DateEvent;
import io.efficientsoftware.simplebookscli.model.core.Event;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DataCache {

    private Set<Event> dateEvents = new HashSet<>();

    // Only services should be accessing the events
    protected Set<Event> getEvents() {
        return this.dateEvents;
    }



    // adding any event goes through
    // anything can add an event
    public boolean add(Event event) {
        // Each event can only occur once in the
        if (dateEvents.add(event)) {
            // append to event log

            event.displayAdded();
            return true;
        }
        return false;
    }

    // deleting any event goes through here
    // anything can delete an event
    public boolean delete(Event event) {
        if (dateEvents.remove(event)) {
            // remove from event log
            return true;
        }
        return false;
    }
}
