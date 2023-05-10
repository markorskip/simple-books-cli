package io.efficientsoftware.simplebookscli.service;

import io.efficientsoftware.simplebookscli.model.core.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddDeleteService {

    @Autowired
    InMemoryEventStore inMemoryEventStore;

    // adding any event goes through
    // anything can add an event
    public boolean add(Event event) {
        // Each event can only occur once in the
        if (inMemoryEventStore.add(event)) {
            // append to event log

            event.displayAdded();
            return true;
        }
        return false;
    }

    // deleting any event goes through here
    // anything can delete an event
    public boolean delete(Event event) {
        if (inMemoryEventStore.remove(event)) {
            // remove from event log
            return true;
        }
        return false;
    }
}
