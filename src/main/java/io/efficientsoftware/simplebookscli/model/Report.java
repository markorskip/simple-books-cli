package io.efficientsoftware.simplebookscli.model;

import io.efficientsoftware.simplebookscli.model.event.Event;
import io.efficientsoftware.simplebookscli.modules.expense.DirectExpenseEvent;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private String reportName;
    private List<? extends Event> lines;

    public Report(String reportName, ArrayList<? extends Event> lines) {
        this.reportName = reportName;
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
