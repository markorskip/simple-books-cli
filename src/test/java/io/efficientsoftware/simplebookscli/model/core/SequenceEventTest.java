package io.efficientsoftware.simplebookscli.model.core;

import io.efficientsoftware.simplebookscli.model.BusinessInfoEvent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequenceEventTest {

    @Test
    public void testComparable() {
        List<BusinessInfoEvent> list = new ArrayList<>();
        BusinessInfoEvent sequenceEvent2 = new BusinessInfoEvent("name2");
        BusinessInfoEvent sequenceEvent = new BusinessInfoEvent("name1");
        BusinessInfoEvent sequenceEvent3 = new BusinessInfoEvent("name3"); // last one created should be the first one when sorted
        list.add(sequenceEvent);
        list.add(sequenceEvent2);
        list.add(sequenceEvent3);
        String latestName = list.stream().sorted().findFirst().get().getBusinessName();
        assertEquals("name3",latestName); // most recent first
    }


}
