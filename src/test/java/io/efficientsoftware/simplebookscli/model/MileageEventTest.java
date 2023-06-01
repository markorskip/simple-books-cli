package io.efficientsoftware.simplebookscli.model;

import io.efficientsoftware.simplebookscli.modules.auto.mileage.MileageEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MileageEventTest {


    MileageEvent getMileageEvent() {
        return new MileageEvent("1/1/2022","Chevy","100","Costco business");
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
}
