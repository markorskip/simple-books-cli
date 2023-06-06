package io.efficientsoftware.simplebookscli.modules;

import io.efficientsoftware.simplebookscli.model.DateEvent;
import io.efficientsoftware.simplebookscli.model.Report;
import io.efficientsoftware.simplebookscli.model.SearchCriteria;

import java.util.ArrayList;
import java.util.List;

public interface IDateEventService<T extends DateEvent> {

    /**
     * Display a summary of that particular module
     */
    Report getSummaryReport();

    /**
     * Return an ordered list based on the search criteria
     */
     // TODO this can be default as well for date and sort order
     List<T> search(SearchCriteria searchCriteria);

    /**
     * Generate a report from all the events based on the search criteria
     */
    default Report getEventsReport(SearchCriteria searchCriteria) {
       return new Report(searchCriteria, search(searchCriteria));
    }

    IDateEventRepository<T> getRepository();

    default void add(T event) {
        getRepository().add(event);
    }

    default void delete(T event) {
        getRepository().add(event);
    }

    default void update(T oldEvent, T newEvent) {
        getRepository().update(oldEvent, newEvent);
    }
}
