package io.efficientsoftware.simplebookscli.persistence;

import io.efficientsoftware.simplebookscli.model.Event;

import java.util.Set;

//
public interface IFilePersistence {

    Set<Event> load(String filePath);

    void append(Event event);

    void rewrite(Set<Event> events);

}
