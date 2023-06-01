package io.efficientsoftware.simplebookscli.model;

import java.time.LocalDate;

public class SearchCriteria {

    public static SearchCriteria defaults() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.sortOrder = SORT_ORDER.OLDEST_FIRST;
        return searchCriteria;
    }

    public String printTitle() {
        final StringBuilder sb = new StringBuilder("SearchCriteria: ");
        if (sortOrder != null) {
            sb.append("Sort Order = " + sortOrder.toString());
        }
        if (dateMin != null) {
            sb.append("Date Min = " + dateMin.toString());
        }
        if (dateMax != null) {
            sb.append("Date Max = " + dateMax.toString());
        }

        return sb.toString();
    }

    // Sort Order
    public enum SORT_ORDER {
        OLDEST_FIRST,
        NEWEST_FIRST,
        HIGHEST_AMOUNT_FIRST,
        LOWEST_AMOUNT_FIRST
    }

    public SORT_ORDER sortOrder;

    // Date Range
    public LocalDate dateMin;
    public LocalDate dateMax;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SearchCriteria{");
        sb.append("dateMin=").append(dateMin);
        sb.append(", dateMax=").append(dateMax);
        sb.append('}');
        return sb.toString();
    }
}
