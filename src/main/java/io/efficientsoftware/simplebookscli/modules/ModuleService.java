package io.efficientsoftware.simplebookscli.modules;

import io.efficientsoftware.simplebookscli.model.Report;
import io.efficientsoftware.simplebookscli.model.SearchCriteria;

public interface ModuleService<T> {

    /**
     * Display a summary of that particular module
     */
    Report getSummaryReport();

    /**
     * Generate a report from all the events based on the search criteria
     */
    Report getEventsReport(SearchCriteria searchCriteria);

    ModuleRepository<T> getRepository();

    default void add(T event) {
        getRepository().add(event);
    }

    default void delete(T event) {
        getRepository().add(event);
    }

    default void update(T oldEvent, T newEvent) {
        add(newEvent);
        delete(oldEvent);
    }

}
