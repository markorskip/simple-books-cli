package io.efficientsoftware.simplebookscli.model.core;

public class Event {

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
