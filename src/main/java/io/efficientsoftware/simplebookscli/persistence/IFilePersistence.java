package io.efficientsoftware.simplebookscli.persistence;

import io.efficientsoftware.simplebookscli.model.Event;

import java.util.Set;

public interface IFilePersistence {

    void append(Event event, String filePath);

    Set<Event> load(String filePath);

    default void rewrite(Set<Event> events, String filePath) {
        deleteFile(filePath);
        createFile(filePath);
        writeToFile(events, filePath);
    }

    void deleteFile(String filePath);

    void createFile(String filePath);

    void writeToFile(Set<Event> events, String filePath);


}
