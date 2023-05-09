package io.efficientsoftware.simplebookscli.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class BaseEvent {

    LocalDate date;

    static final String SPACER = "  |  ";

    public BaseEvent(String date) {
        this.date = parseDate(date);
    }

    public static LocalDate parseDate(String date) {
        DateTimeFormatter formatter =
                 DateTimeFormatter.ofPattern("M/d/y");
        return LocalDate.parse(date,formatter);
    }

    Double parseDouble(String number) {
        return Double.parseDouble(number);
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "BaseRecord{" +
                "date=" + date +
                '}';
    }
}
