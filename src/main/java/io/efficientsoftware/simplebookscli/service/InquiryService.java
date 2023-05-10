package io.efficientsoftware.simplebookscli.service;

import io.efficientsoftware.simplebookscli.model.MoneyEvent;
import io.efficientsoftware.simplebookscli.model.TimeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InquiryService {

    @Autowired
    private DataCache dataCache;

    public Set<TimeEvent> getTimeEvents() {
        return this.dataCache.getEvents().stream().filter(x->x instanceof TimeEvent).map(x-> (TimeEvent) x).collect(Collectors.toSet());
    }

    public Set<MoneyEvent> getMoneyEvents() {
        return this.dataCache.getEvents().stream().filter(x->x instanceof MoneyEvent).map(x-> (MoneyEvent) x).collect(Collectors.toSet());
    }

    public void displaySummary() {
        System.out.println("**********************");
        //System.out.println(this.name);
        System.out.println();

        System.out.println("Time Records");
        System.out.println("Total no: " + getTimeEvents().size());
        System.out.println("Total no of hours worked: " + TimeRecordCalc.getTotalNoOfHoursWorked(this.getTimeEvents()));
        System.out.println("No of hours worked this month: " + TimeRecordCalc.getHoursWorkedThisMonth(this.getTimeEvents()));
        System.out.println();

        System.out.println("Money Records");
        System.out.println("Total no: " + getMoneyEvents().size());
        System.out.println();

        System.out.println("Mileage Records");
       // System.out.println("Total no: " + mileageRecords.size());
        System.out.println();

        System.out.print("Projects Summary");
        for (String project : getAllProjects()) {
            displayProjectSummary(project);
        }
    }

    void displayProjectSummary(String project) {
        System.out.println("  **********");
        System.out.println("  Project Name: " + project);
        double revenue = getTotalRevenueForProject(project);
        System.out.println("  Total Revenue: $"  + revenue);
        double  hoursWorked = getTotalHoursWorkedForProject(project);
        System.out.println();
        System.out.println("  Total Hours Worked: " + hoursWorked);
        System.out.println("  Average hourly pay: $" + revenue/ hoursWorked);
        System.out.println();
    }

    private double getTotalHoursWorkedForProject(String project) {
        return getTimeEvents().stream()
                .filter(x->x.getAccount().equals(project))
                .mapToDouble(x->x.getHours()).sum();
    }

    private double getTotalRevenueForProject(String project) {
        return this.getMoneyEvents().stream()
                .filter(x->x.getTransactionType() == MoneyEvent.TRANSACTION_TYPE.REVENUE)
                .filter(x->x.getAccountFrom().equals(project))
                .mapToDouble(x->x.getAmount()).sum();
    }

    Set<String> getAllProjects() {
        Set<String> result = new HashSet<>();
        // Get every account time has worked on
        result.addAll(getTimeEvents().stream().map(x->x.getAccount()).collect(Collectors.toSet()));
        // Get every account that has brought in revenue
        result.addAll(this.getMoneyEvents().stream()
                .filter(x->x.getTransactionType() == MoneyEvent.TRANSACTION_TYPE.REVENUE).map(x->x.getAccountFrom())
                .collect(Collectors.toSet()));
        return result;

    }
}
