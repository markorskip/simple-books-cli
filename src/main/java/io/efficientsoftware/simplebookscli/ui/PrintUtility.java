package io.efficientsoftware.simplebookscli.ui;

import io.efficientsoftware.simplebookscli.model.Event;

public class PrintUtility {
    public static void printList(Iterable<? extends Event> events) {
        for (Event event: events) {
            System.out.println(event);
        }
    }
}
