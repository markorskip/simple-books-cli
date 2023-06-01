package io.efficientsoftware.simplebookscli.modules;

import java.util.Set;

public interface ModuleRepository<T> {

    /**
     * Gets all the events for a given module
     * @return
     */
    Set<T> getAll();

    void add(T event);

    void delete(T event);

    default void update(T oldEvent, T newEvent) {
        add(newEvent);
        delete(oldEvent);
    }
}
