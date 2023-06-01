package io.efficientsoftware.simplebookscli.modules;

import io.efficientsoftware.simplebookscli.model.event.Event;
import io.efficientsoftware.simplebookscli.model.event.KeyValueEvent;
import io.efficientsoftware.simplebookscli.persistence.CentralRepository;

public interface IKeyValueRepository<KeyValueEvent> {

    CentralRepository getCentralRepository();

    default void add(io.efficientsoftware.simplebookscli.model.event.KeyValueEvent keyValueEvent) {
        // first check if the event occurs with the same KEY
        // if it does, do an update

        KeyValueEvent existingEvent = getKeyValueEvent(keyValueEvent.getKey());
        if (existingEvent != null) {
            getCentralRepository().update((Event) existingEvent, (Event) keyValueEvent);
        } else {
            getCentralRepository().add((Event) keyValueEvent);
        }
    }

    KeyValueEvent getKeyValueEvent(String key);

    default void delete(KeyValueEvent event) {
        getCentralRepository().delete((Event) event);
    }
}
