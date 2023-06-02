package io.efficientsoftware.simplebookscli.persistence;

import io.efficientsoftware.simplebookscli.MockDataCreator;
import io.efficientsoftware.simplebookscli.model.Event;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.Assert.assertTrue;

public class FilePersistenceTest {

    IFilePersistence persistence = new PersistenceService(TEST_FILE);

    static final String TEST_FILE = "test.csv";

    //@AfterAll
    public static void cleanUp() {
        IFilePersistence persistence = new PersistenceService(TEST_FILE);
        persistence.deleteFile();
    }

    @Test
    public void testLoad() {
        persistence.load();
    }

    @Test
    public void testRewrite() {
        persistence.rewrite(MockDataCreator.getSampleSet());
        Set<Event> events = persistence.load();
        assertTrue(events.size() > 0);
    }

    @Test
    public void testAppend() {
        persistence.rewrite(MockDataCreator.getSampleSet());
        int count = persistence.load().size();
        System.out.println("Size is: " + count);

        //add a new events
        System.out.println("Appending new event");
        persistence.append(MockDataCreator.getMileageEvent());

        // Load the new set
        int newCount = persistence.load().size();
        System.out.println("New count is: " + newCount);
        assertTrue(persistence.load().size() == count + 1);
    }

    @Test
    public void testDeleteFile() {
        persistence.deleteFile();
    }
}
