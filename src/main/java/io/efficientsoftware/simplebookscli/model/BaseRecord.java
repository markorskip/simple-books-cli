package io.efficientsoftware.simplebookscli.model;

import java.time.LocalDate;

public abstract class BaseRecord {

    LocalDate date;

    static final String SPACER = "  |  ";

    public BaseRecord(String date) {
        this.date = parseDate(date);
    }

    private LocalDate parseDate(String date) {
        // TODO test and make sure this work
        //return LocalDate.parse(date);
        return LocalDate.now();
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
