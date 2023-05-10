package io.efficientsoftware.simplebookscli.service;


import io.efficientsoftware.simplebookscli.model.core.Event;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Syncronizer {

    private String filePath;

    // You can only append events or delete them.

    public boolean append(Event event) {
        // appends an event to a file
        return true;
    }

    public boolean delete(Event event) {
        // deletes envent from the event log
        return true;
    }

    public Set<Event> load() {
        // Loads all the events from a file
        return null;

    }
}
