package io.efficientsoftware.simplebookscli.modules;

import io.efficientsoftware.simplebookscli.model.Event;
import io.efficientsoftware.simplebookscli.model.MoneyEvent;

import java.util.Set;

public interface ModuleService<T> {

    /**
     * For adding a new event ie expense, mileage, etc...
     */
    void log(T event);

    /**
     * For all the events for the given module ie expenses
     */
    void viewAll();

    /**
     * Display a summary of that particular module
     */
    void displaySummary();
}
