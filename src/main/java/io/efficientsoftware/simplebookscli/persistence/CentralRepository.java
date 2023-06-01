package io.efficientsoftware.simplebookscli.persistence;

import io.efficientsoftware.simplebookscli.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

/**
 * Ensures anything added in memory is also added to the event store.
 *
 * Ensures anything delete in memory is also deleted from the event store.
 *
 * All methods are protected, requiring a module to create its own repository
 * that extends the central repository.  The module repository is responsible
 * for filtering getEvents to only the data it needs access to.
 */
@Service
public class CentralRepository {

    @Autowired
    InMemoryEventStore inMemoryEventStore;

    @Autowired
    PersistenceService persistenceService;

    /**
     * @return All events.  Extenders of this class should override and filter.
     */
    protected Set<Event> readEvents() {
        return this.inMemoryEventStore.getEvents();
    }

    protected boolean createOrUpdate(Event event) {
        // Each event can only occur once in the data
        if (inMemoryEventStore.add(event)) { // uses equals to find if the event exists
            // append to event log
            try {
                persistenceService.append(event);
                event.displayAdded();
            } catch (Exception e) {
                System.out.println("Failed to append. Rolling back");
                inMemoryEventStore.remove(event);
            }
            return true;
        } else { // event already exists
            return update(event);
        }
    }

    private boolean update(Event event) {
        try {
            persistenceService.delete(event);
            persistenceService.append(event);
            inMemoryEventStore.remove(event);
            inMemoryEventStore.add(event);
            return true;
        } catch (Exception e) {
            System.out.println("Update Failed");
            return false;
        }
    }

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

    protected void load(String path) {
        Set<Event> events = null;
        try {
            events = this.persistenceService.load(path);
            this.inMemoryEventStore.setEvents(events);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
