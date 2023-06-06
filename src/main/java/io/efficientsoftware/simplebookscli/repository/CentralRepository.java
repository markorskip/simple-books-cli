package io.efficientsoftware.simplebookscli.repository;

import io.efficientsoftware.simplebookscli.model.Event;
import io.efficientsoftware.simplebookscli.repository.persistence.FilePersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
class CentralRepository {

    @Autowired
    FilePersistenceService persistenceService;

    /**
     * @return All events.  Extenders of this class should override and filter.
     */
    protected Set<Event> readEvents() {
        return getEventsFromMemory();
    }

    protected void add(Event event) {
        if (addToInMemory(event)) {
            persistenceService.append(event);
            event.displayAdded();
        }
        print();
    }

    protected void update(Event oldEvent, Event newEvent) {
        boolean removeOccurred = removeFromMemory(oldEvent);
        boolean addOccurred = addToInMemory(newEvent);
        if (removeOccurred || addOccurred) {
            persistenceService.rewrite(getEventsFromMemory());
        }
        print();
    }

    protected void delete(Event event) {
       if (removeFromMemory(event)) {
           //rewrite the whole file
           persistenceService.rewrite(getEventsFromMemory());
       }
        print();
    }

    protected void load(String path) {
        setInMemoryEvents(this.persistenceService.load(path));
        print();
    }

    private Set<Event> inMemoryEvents = new HashSet<>();

    private Set<Event> getEventsFromMemory() {
        return this.inMemoryEvents;
    }

    private boolean addToInMemory(Event event) {
        return this.inMemoryEvents.add(event);
    }

    protected boolean removeFromMemory(Event event) {
        return this.inMemoryEvents.remove(event);
    }

    protected void setInMemoryEvents(Set<Event> inMemoryEvents) {
        this.inMemoryEvents = inMemoryEvents;
    }

    void print() {
        System.out.println("Print Mode - disable later");
        for (Event event: inMemoryEvents) {
            System.out.println(event.toCSV());
            System.out.println(event);
        }
    }
}
