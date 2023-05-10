package io.efficientsoftware.simplebookscli.model.core;

import io.efficientsoftware.simplebookscli.model.core.Event;
import lombok.Builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class DateEvent extends Event {

    public LocalDate date;

    public static final String SPACER = "  |  ";

    public DateEvent(String date) {
        this.date = parseDate(date);
    }

    public static LocalDate parseDate(String date) {
        DateTimeFormatter formatter =
                 DateTimeFormatter.ofPattern("M/d/y");
        return LocalDate.parse(date,formatter);
    }

    public Double parseDouble(String number) {
        return Double.parseDouble(number);
    }

    public LocalDate getDate() {
        return date;
    }

    public static String getTodaysDate() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("M/d/y");
        return formatter.format(LocalDate.now());
    }

    @Override
    public String toString() {
        return "BaseRecord{" +
                "date=" + date +
                '}';
    }
}
