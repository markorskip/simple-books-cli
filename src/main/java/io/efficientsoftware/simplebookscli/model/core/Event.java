package io.efficientsoftware.simplebookscli.model.core;

import io.efficientsoftware.simplebookscli.model.MileageEvent;

public abstract class Event {

    public enum EVENT_TYPE {
        MILEAEGE,
        MONEY,
        TIME,
        BUSINESS_INFO,
        ODOMOTER_READING
    }

    protected EVENT_TYPE eventType;

    public static Event fromLine(String line) {
        String[] values = line.split(",");
        EVENT_TYPE transactionType = EVENT_TYPE.valueOf(values[0]);
        switch (transactionType) {
            case MILEAEGE -> {
                return new MileageEvent(values[1],values[2],values[3],values[4]);
            }


        };
        return null;
    }

    public abstract String toLine();

    // This method
    public void displayAdded() {
        System.out.println("Event added: " + toString());
    }

    public void displayAlreadyExists() {
        System.out.println("Event already exists: " + toString());
    }

    public void displayDeleted() {
        System.out.println("Event deleted: " + toString());
    }

    public void displayUnableToDelete() {
        System.out.println("Unable to delete because this event does not exist: " + toString());
    }
}
