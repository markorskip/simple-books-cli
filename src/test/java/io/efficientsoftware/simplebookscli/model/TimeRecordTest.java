package io.efficientsoftware.simplebookscli.model;


import io.efficientsoftware.simplebookscli.modules.time.TimeEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeRecordTest {

    @Test
    public void testCreatingAnEntry() {
        TimeEvent entry = new TimeEvent("1/1/2022", "CusomterABC","test", "8.0");
        assertNotNull(entry);
    }

    @Test
    public void testCreatingInvalidEntryHours() {
        assertThrows(IllegalArgumentException.class,
                () -> new TimeEvent("1/1/2022", "CusomterABC", "desc","25.0"));
    }
}
