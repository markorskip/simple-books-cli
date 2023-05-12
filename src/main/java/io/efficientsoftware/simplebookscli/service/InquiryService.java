package io.efficientsoftware.simplebookscli.service;

import io.efficientsoftware.simplebookscli.model.MoneyEvent;
import io.efficientsoftware.simplebookscli.model.BusinessInfoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InquiryService {

    @Autowired
    private InMemoryEventStore store;

    public void displaySummary() {
        System.out.println("**********************");
        System.out.println(getBusinessName());
        System.out.println();

        System.out.println("Time Records");
        System.out.println("Total no: " + store.getTimeEvents().size());
        System.out.println("Total no of hours worked: " + TimeRecordCalc.getTotalNoOfHoursWorked(store.getTimeEvents()));
        System.out.println("No of hours worked this month: " + TimeRecordCalc.getHoursWorkedThisMonth(store.getTimeEvents()));
        System.out.println();

        System.out.println("Money Records");
        System.out.println("Total no: " + store.getMoneyEvents().size());
        System.out.println();

        System.out.println("Mileage Records");
        System.out.println("Total no: " + store.getMileageEvents().size());
        System.out.println();

        System.out.print("Projects Summary");
        for (String project : getAllProjects()) {
            displayProjectSummary(project);
        }
    }

    private Set<BusinessInfoEvent> getBusinessInfoEvents() {
        return store.getEvents().stream().filter(x->x instanceof BusinessInfoEvent).map(x -> (BusinessInfoEvent) x).collect(Collectors.toSet());
    }

    private String getBusinessName() {
        Optional<BusinessInfoEvent> opt = getBusinessInfoEvents().stream().sorted().findFirst();
        if (opt.isPresent()) {
            if (opt.get().getBusinessName() != null || opt.get().getBusinessName() != "") {
                return opt.get().getBusinessName();
            }
        }
        return "Business";
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
        return store.getTimeEvents().stream()
                .filter(x->x.getAccount().equals(project))
                .mapToDouble(x->x.getHours()).sum();
    }

    private double getTotalRevenueForProject(String project) {
        return store.getMoneyEvents().stream()
                .filter(x->x.getTransactionType() == MoneyEvent.TRANSACTION_TYPE.REVENUE)
                .filter(x->x.getAccountFrom().equals(project))
                .mapToDouble(x->x.getAmount()).sum();
    }

    Set<String> getAllProjects() {
        Set<String> result = new HashSet<>();
        // Get every account time has worked on
        result.addAll(store.getTimeEvents().stream().map(x->x.getAccount()).collect(Collectors.toSet()));
        // Get every account that has brought in revenue
        result.addAll(store.getMoneyEvents().stream()
                .filter(x->x.getTransactionType() == MoneyEvent.TRANSACTION_TYPE.REVENUE).map(x->x.getAccountFrom())
                .collect(Collectors.toSet()));
        return result;

    }

    public void displayTimeLogs() {
        store.getTimeEvents().forEach(System.out::println);
    }

    public void displayExpenseLogs() {
        store.getMoneyEvents().stream().filter(x->x.getTransactionType() == MoneyEvent.TRANSACTION_TYPE.DIRECT_EXPENSE)
                .forEach(System.out::println);
    }
    public void displayRevenueLogs() {
        store.getMoneyEvents().stream().filter(x->x.getTransactionType() == MoneyEvent.TRANSACTION_TYPE.REVENUE)
                .forEach(System.out::println);
    }

    public void displayMileageLogs() {
        store.getMileageEvents().stream().forEach(System.out::println);
    }
}
