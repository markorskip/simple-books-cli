package io.efficientsoftware.simplebookscli.persistence;

import io.efficientsoftware.simplebookscli.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Ensures anything added in memory is also added to the event store.
 *
 * Ensures anything delete in memory is also deleted from the event store.
 *
 * TOOD write unit tests to prove this
 */
@Service
public class CentralRepository {

    @Autowired
    InMemoryEventStore inMemoryEventStore;

    @Autowired
    PersistenceService persistenceService;

    protected Set<Event> getEvents() {
        return this.inMemoryEventStore.getEvents();
    }

    // adding any event goes through
    // anything can add an event
    protected boolean add(Event event) {
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
    protected boolean delete(Event event) {
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
