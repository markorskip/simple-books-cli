package io.efficientsoftware.simplebookscli.model;

public abstract class Event {

    public enum EVENT_TYPE {
        MILEAGE,
        MONEY,
        TIME,
        KEY_VALUE
    }

    protected EVENT_TYPE eventType;

    // Create a single line of comma separated values
    public abstract String toCSV();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;

        return eventType == event.eventType;
    }

    @Override
    public int hashCode() {
        return eventType != null ? eventType.hashCode() : 0;
    }
}
