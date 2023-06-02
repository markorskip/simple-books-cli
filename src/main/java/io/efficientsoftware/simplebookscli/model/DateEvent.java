package io.efficientsoftware.simplebookscli.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public abstract class DateEvent extends Event {

    public LocalDate date;

    public static final String SPACER = "  |  ";

    public DateEvent(String date) {
        this.date = parseDate(date);
    }

    private static final String datePattern = "M/d/y";
    public static LocalDate parseDate(String date) {
        DateTimeFormatter formatter =
                 DateTimeFormatter.ofPattern(datePattern);
        return LocalDate.parse(date,formatter);
    }

    public static String dateToString(LocalDate localDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(datePattern, Locale.US);
        return localDate.format(dtf);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateEvent dateEvent)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(date, dateEvent.date);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
