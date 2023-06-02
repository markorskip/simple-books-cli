package io.efficientsoftware.simplebookscli.persistence;

import io.efficientsoftware.simplebookscli.model.Event;
import io.efficientsoftware.simplebookscli.modules.auto.mileage.MileageEvent;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class InMemoryEventStoreTest {


    @Test
    public void testSetAndGetEvents() {
        InMemoryEventStore inMemoryEventStore = new InMemoryEventStore();
        inMemoryEventStore.setEvents(createEvents());
        assertEquals(1,inMemoryEventStore.getEvents().size());
    }

    @Test
    public void testAdd() {
        InMemoryEventStore inMemoryEventStore = new InMemoryEventStore();
        assertEquals(0,inMemoryEventStore.getEvents().size());
        inMemoryEventStore.add(getMileageEvent1());
        assertEquals(1,inMemoryEventStore.getEvents().size());
        inMemoryEventStore.add(getMileageEvent2());
        assertEquals(2,inMemoryEventStore.getEvents().size());

    }

    @Test
    public void testAddingDuplicate() {
        InMemoryEventStore inMemoryEventStore = new InMemoryEventStore();
        assertEquals(0,inMemoryEventStore.getEvents().size());
        inMemoryEventStore.add(getMileageEvent1());
        assertEquals(1,inMemoryEventStore.getEvents().size());
        // Add a duplicate event should not increase the size
        inMemoryEventStore.add(getMileageEvent1());
        assertEquals(1,inMemoryEventStore.getEvents().size());
    }

    @Test
    public void testRemove() {
        InMemoryEventStore inMemoryEventStore = new InMemoryEventStore();
        inMemoryEventStore.add(getMileageEvent1());
        assertEquals(1, inMemoryEventStore.getEvents().size());

        // Test remove
        inMemoryEventStore.remove(getMileageEvent1());
        assertEquals(0, inMemoryEventStore.getEvents().size());
    }

    @Test
    public void testRemoveSomethingThatDoesNotExist() {
        InMemoryEventStore inMemoryEventStore = new InMemoryEventStore();
        inMemoryEventStore.add(getMileageEvent1());
        assertEquals(1, inMemoryEventStore.getEvents().size());

        // Test removing something that doesn't exist
        inMemoryEventStore.remove(getMileageEvent2());
        assertEquals(1, inMemoryEventStore.getEvents().size());
    }

    MileageEvent getMileageEvent1() {
        return new MileageEvent("1/1/2023","Chevy","100","store");
    }

    MileageEvent getMileageEvent2() {
        return new MileageEvent("1/2/2023","Chevy","100","store");
    }

    Set<Event> createEvents() {
        return Set.of(new MileageEvent("1/1/2023","Chevy","100","store"));
    }
}
