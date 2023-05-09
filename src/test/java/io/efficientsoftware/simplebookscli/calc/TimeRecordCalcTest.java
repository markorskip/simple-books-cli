package io.efficientsoftware.simplebookscli.calc;

import io.efficientsoftware.simplebookscli.model.TimeEvent;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TimeRecordCalcTest {

    private static final String DATE = "1/1/2023";
    private static final String ACCOUNT = "CustomerABC";
    private static final String DESC = "Description of work";

    @Test
    void testGetTotalNoOfHoursWorked() {
        Set<TimeEvent> testSet  = new HashSet<>();

        testSet.add(new TimeEvent(DATE, ACCOUNT, DESC, "5"));
        testSet.add(new TimeEvent(DATE, ACCOUNT, DESC, "3.5"));
        testSet.add(new TimeEvent(DATE, ACCOUNT, DESC, "4.5"));
        testSet.add(new TimeEvent(DATE, ACCOUNT, DESC, "3"));

        double result = TimeRecordCalc.getTotalNoOfHoursWorked(testSet);
        assertEquals(result, 16.0);

        // Duplicate records won't change the total
        testSet.add(new TimeEvent(DATE, ACCOUNT, DESC, "3.5"));
        testSet.add(new TimeEvent(DATE, ACCOUNT, DESC, "3.5"));
        result = TimeRecordCalc.getTotalNoOfHoursWorked(testSet);
        assertEquals(result, 16.0);
    }
}
