package io.efficientsoftware.simplebookscli.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseRecordTest {

    @Test
    public void testDateParsing() {
        String testDate;
        testDate ="01/01/2022";
        LocalDate expected = LocalDate.of(2022, 1, 1);
        assertEquals(expected, BaseEvent.parseDate(testDate));
    }

    @Test
    public void testDateParsingSingleDigitMonthAndYear() {
        String testDate;
        testDate = "1/1/2022";
        LocalDate expected = LocalDate.of(2022, 1, 1);
        assertEquals(expected, BaseEvent.parseDate(testDate));
    }
}
