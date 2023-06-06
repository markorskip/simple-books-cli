package io.efficientsoftware.simplebookscli.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MileageEventTest {


    MileageEvent getMileageEvent() {
        return new MileageEvent("1/1/2022","Chevy","100","Costco business");
    }

    MileageEvent getMileageEvent2() {
        return new MileageEvent("1/2/2022","Chevy","100","Costco business");
    }

    @Test
    public void testToLine() {
        MileageEvent event = getMileageEvent();
        String line = event.toCSV();
        assertEquals("MILEAGE,1/1/2022,Chevy,100.0,Costco business",line);
    }

    @Test
    public void testFromLine() {
        String line = "MILEAGE,1/1/2022,Chevy,100.0,Costco business";
        MileageEvent event = new MileageEvent(line.split(","));
        assertNotNull(event);
    }

    @Test
    public void testEquals() {
        MileageEvent event1 = getMileageEvent();
        MileageEvent event2 = getMileageEvent();
        assertEquals(event1, event2);
        assertEquals(event1.hashCode(), event2.hashCode());
    }

    @Test
    public void testNotEquals() {
        MileageEvent event1 = getMileageEvent();
        MileageEvent event2 = getMileageEvent2();
        assertNotEquals(event1, event2);
        assertNotEquals(event1.hashCode(), event2.hashCode());
    }
}
