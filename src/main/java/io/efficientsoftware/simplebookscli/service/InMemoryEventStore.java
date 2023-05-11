package io.efficientsoftware.simplebookscli.service;

import io.efficientsoftware.simplebookscli.model.BusinessInfoEvent;
import io.efficientsoftware.simplebookscli.model.MileageEvent;
import io.efficientsoftware.simplebookscli.model.MoneyEvent;
import io.efficientsoftware.simplebookscli.model.TimeEvent;
import io.efficientsoftware.simplebookscli.model.core.Event;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InMemoryEventStore {

    private Set<Event> events = new HashSet<>();

    // Only services should be accessing the events
    protected Set<Event> getEvents() {
        return this.events;
    }

    protected Set<TimeEvent> getTimeEvents() {
        return this.events.stream()
                .filter(x -> x instanceof TimeEvent)
                .map(x-> (TimeEvent) x).collect(Collectors.toSet());
    }

    protected Set<MoneyEvent> getMoneyEvents() {
        return this.events.stream()
                .filter(x -> x instanceof MoneyEvent)
                .map(x-> (MoneyEvent) x).collect(Collectors.toSet());
    }

    protected Set<MileageEvent> getMileageEvents() {
        return this.events.stream()
                .filter(x -> x instanceof MileageEvent)
                .map(x-> (MileageEvent) x).collect(Collectors.toSet());
    }

    protected Set<BusinessInfoEvent> getBusinessInfoEvent() {
        return this.events.stream()
                .filter(x -> x instanceof BusinessInfoEvent)
                .map(x-> (BusinessInfoEvent) x).collect(Collectors.toSet());
    }

    // Used the Add Delete service
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
