package io.efficientsoftware.simplebookscli.modules;

import io.efficientsoftware.simplebookscli.model.DateEvent;
import io.efficientsoftware.simplebookscli.persistence.CentralRepository;

import java.util.Set;

public interface IDateEventRepository<T extends DateEvent> {

    /**
     * Gets all the events for a given module
     * @return
     */
    Set<T> getAll();

    CentralRepository getCentralRepository();

    default void add(T event) {
        getCentralRepository().add(event);
    }

    default void delete(T event) {
        getCentralRepository().delete(event);
    }

    default void update(T oldEvent, T newEvent) {
        getCentralRepository().update(oldEvent, newEvent);
    }
}
