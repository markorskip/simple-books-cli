package io.efficientsoftware.simplebookscli.model.core;

import io.efficientsoftware.simplebookscli.model.DateEvent;
import io.efficientsoftware.simplebookscli.modules.mileage.MileageEvent;
import io.efficientsoftware.simplebookscli.modules.expense.DirectExpenseEvent;
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
}
