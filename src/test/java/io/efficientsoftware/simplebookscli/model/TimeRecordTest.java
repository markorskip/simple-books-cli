package io.efficientsoftware.simplebookscli.model;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeRecordTest {

    @Test
    public void testCreatingAnEntry() {
        TimeRecord entry = new TimeRecord(LocalDate.now(), "test", 8.0);
        assertNotNull(entry);
    }

    @Test
    public void testCreatingInvalidEntryHours() {
        assertThrows(IllegalArgumentException.class,
                () -> new TimeRecord(LocalDate.now(), "test", 25.0));
    }
}
