package io.efficientsoftware.simplebookscli.model;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private String reportName;
    private List<? extends Event> lines;

    public Report(String reportName, List<? extends Event> lines) {
        this.reportName = reportName;
        this.lines = lines;
    }

    public Report(SearchCriteria searchCriteria, List<? extends Event> lines) {
        this.reportName = searchCriteria.toString();
        this.lines = lines;
    }

    public void print() {
        System.out.println("******************");
        System.out.println(reportName);
        System.out.println("******************");
        for (Event event: lines) {
            System.out.println(event.toString());
        }
    }
}
