package io.efficientsoftware.simplebookscli.modules;

import java.util.Set;

public interface ModuleRepository<T> {

    Set<T> viewAll();

    void add(T event);

    void delete(T event);

    void update(T oldEvent, T newEvent);

}
