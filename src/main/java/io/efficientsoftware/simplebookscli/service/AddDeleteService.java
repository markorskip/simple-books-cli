package io.efficientsoftware.simplebookscli.service;

import io.efficientsoftware.simplebookscli.model.core.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Ensures anything added in memory is also added to the event store.
 *
 * Ensures anything delete in memory is also deleted from the event store.
 *
 * TOOD write unit tests to prove this
 */
@Service
public class AddDeleteService {

    @Autowired
    InMemoryEventStore inMemoryEventStore;

    @Autowired
    PersistenceService persistenceService;

    // adding any event goes through
    // anything can add an event
    public boolean add(Event event) {
        // Each event can only occur once in the
        if (inMemoryEventStore.add(event)) {
            // append to event log
            try {
                persistenceService.append(event);
                event.displayAdded();
            } catch (Exception e) {
                System.out.println("Failed to append. Rolling back");
                inMemoryEventStore.remove(event);
            }
            return true;
        }
        return false;
    }

    // deleting any event goes through here
    // anything can delete an event
    public boolean delete(Event event) {
        if (inMemoryEventStore.remove(event)) {
            // remove from event log
            try {
                persistenceService.delete(event);
            } catch (Exception e) {
                System.out.println("Failed to delete: " + event);
                inMemoryEventStore.add(event);
            }

            return true;
        }
        return false;
    }
}
