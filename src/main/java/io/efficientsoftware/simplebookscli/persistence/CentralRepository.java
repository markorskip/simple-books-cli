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
    public Set<Event> readEvents() {
        return this.inMemoryEventStore.getEvents();
    }

    public void add(Event event) {
        if (inMemoryEventStore.add(event)) {
            persistenceService.append(event,filePath);
            event.displayAdded();
        }
    }

    public void update(Event oldEvent, Event newEvent) {
        if (inMemoryEventStore.remove(oldEvent) || inMemoryEventStore.add(newEvent)) {
            persistenceService.rewrite(inMemoryEventStore.getEvents(), this.filePath);
        }
    }

    public void delete(Event event) {
       if (inMemoryEventStore.remove(event)) {
           //rewrite the whole file
           persistenceService.rewrite(inMemoryEventStore.getEvents(), this.filePath);
       }
    }

    private String filePath;

    protected void load(String path) {
        this.filePath = path;
        Set<Event> events = this.persistenceService.load(path);
        this.inMemoryEventStore.setEvents(events);
    }
}
