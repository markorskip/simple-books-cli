package io.efficientsoftware.simplebookscli.persistence;

import io.efficientsoftware.simplebookscli.model.Event;

import java.util.Set;

public interface IFilePersistence {

    void append(Event event);

    Set<Event> load();

    default void rewrite(Set<Event> events) {
        deleteFile();
        createFile();
        writeToFile(events);
    }

    void deleteFile();

    void createFile();

    void writeToFile(Set<Event> events);
}
