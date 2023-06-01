package io.efficientsoftware.simplebookscli.model;

import java.util.List;

public class Report {

    private String reportName;
    private List<String> lines;

    public Report(String reportName, List<String> lines) {
        this.reportName = reportName;
        this.lines = lines;
    }

    void print() {
        System.out.println("******************");
        System.out.println(reportName);
        System.out.println("******************");
        for (String line: lines) {
            System.out.println(line);
        }
    }
}
