package io.efficientsoftware.simplebookscli.reports;


public interface ReportGenerator {

    public void displayReportInTerminal();

    public void exportReportToFile(String filepath);

}
