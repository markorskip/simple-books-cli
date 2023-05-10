package io.efficientsoftware.simplebookscli.model.core;

import io.efficientsoftware.simplebookscli.model.MileageEvent;
import io.efficientsoftware.simplebookscli.model.MoneyEvent;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateEventTest {

    @Test
    public void testDateParsing() {
        String testDate;
        testDate ="01/01/2022";
        LocalDate expected = LocalDate.of(2022, 1, 1);
        assertEquals(expected, DateEvent.parseDate(testDate));
    }

    @Test
    public void testDateParsingSingleDigitMonthAndYear() {
        String testDate;
        testDate = "1/1/2022";
        LocalDate expected = LocalDate.of(2022, 1, 1);
        assertEquals(expected, DateEvent.parseDate(testDate));
    }

    String getTestDate() {
        return "1/1/2022";
    }

    MileageEvent getTestMileageEvent() {
        MileageEvent test1 = new MileageEvent(getTestDate(), "chevy", "100","desc");
        return test1;
    }

    MoneyEvent getMoneyEvent() {
        return new MoneyEvent(getTestDate(),
                "50",
                "Checking",
                "Spectrum",
                MoneyEvent.TRANSACTION_TYPE.DIRECT_EXPENSE.toString());
    }

    @Test
    public void testEventSet(){
        DateEvent base1 = getTestMileageEvent();
        DateEvent base2 = getTestMileageEvent();
        Set<DateEvent> set = new HashSet<>();
        set.add(base1);
        set.add(base2);
        assertEquals(1,set.size());

        DateEvent moneyDateEvent = getMoneyEvent();
        DateEvent moneyDateEvent2 = getMoneyEvent();

        set.add(moneyDateEvent);
        set.add(moneyDateEvent2);

        assertEquals(2,set.size());

        int moneyEventCount = 0;
        int mileageEventCount = 0;
        for (DateEvent dateEvent : set) {
            if (dateEvent instanceof MoneyEvent) {
                moneyEventCount++;

            }
            if (dateEvent instanceof MileageEvent) {
                mileageEventCount++;
            }
        }

        assertEquals(1, moneyEventCount);
        assertEquals(1, mileageEventCount);

        Set<MoneyEvent> moneyEvents = set.stream().filter(event -> event instanceof MoneyEvent).map(x-> (MoneyEvent) x).collect(Collectors.toSet());
        MoneyEvent event = moneyEvents.stream().findFirst().get();

        assertEquals("Checking",event.getAccountFrom());

    }


    // test having a single event stack
}
