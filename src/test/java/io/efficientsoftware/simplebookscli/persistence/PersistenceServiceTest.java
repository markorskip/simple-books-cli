package io.efficientsoftware.simplebookscli.persistence;

import io.efficientsoftware.simplebookscli.MockDataCreator;
import io.efficientsoftware.simplebookscli.model.Event;
import io.efficientsoftware.simplebookscli.modules.cashflow.expense.DirectExpenseEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersistenceServiceTest {

    PersistenceService persistence = new PersistenceService();

    static final String TEST_FILE = "test.csv";

    @Test
    public void testLoad() {
        persistence.load(TEST_FILE);
    }

    @Test
    public void testRewrite() {
        persistence.load(TEST_FILE);
        persistence.rewrite(MockDataCreator.getSampleSet());
        Set<Event> events = persistence.load(TEST_FILE);
        assertTrue(events.size() > 0);
    }

    @Test
    public void testAppend() {
        persistence.load(TEST_FILE);
        persistence.rewrite(MockDataCreator.getSampleSet());
        int count = persistence.load(TEST_FILE).size();
        System.out.println("Size is: " + count);

        //add a new events
        System.out.println("Appending new event");
        persistence.append(MockDataCreator.getMileageEvent());

        // Load the new set
        int newCount = persistence.load(TEST_FILE).size();
        System.out.println("New count is: " + newCount);
        assertTrue(persistence.load(TEST_FILE).size() == count + 1);
    }

    @Test
    public void testDeleteFile() {
        // Create the file first to ensure it actually deleted a file
        persistence.load(TEST_FILE);
        persistence.createFile();
        assertTrue(Files.exists(Path.of(TEST_FILE)));

        // Then delete this file
        persistence.deleteFile();
        assertFalse(Files.exists(Path.of(TEST_FILE)));
    }

    @Test
    public void testCreate() {
        // Delete the file first to ensure it didn't already exist
        persistence.load(TEST_FILE);
        persistence.deleteFile();
        assertFalse(Files.exists(Path.of(TEST_FILE)));

        // Then create the file
        persistence.createFile();
        assertTrue(Files.exists(Path.of(TEST_FILE)));
    }

    @Test
    public void testWriteToFile() {
        // TODO move to a BeforeEach
        persistence.load(TEST_FILE);
        persistence.deleteFile();
        persistence.createFile();

        assertTrue(persistence.load(TEST_FILE).size() == 0);
        persistence.rewrite(MockDataCreator.getSampleSet());
        assertTrue(persistence.load(TEST_FILE).size() > 1);
    }
}
