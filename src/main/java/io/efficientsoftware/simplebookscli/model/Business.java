package io.efficientsoftware.simplebookscli.model;

import io.efficientsoftware.simplebookscli.calc.TimeRecordCalc;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class Business {

	/**
	 * Rules of the system
	 *
	 * 1. Store absolutely nothing the can be derived
	 * 2. Each valid log entry is standalone and can be run in any order with the same report results
	 *
	 */
	public Business(){}

	private String name = "Business";
	// Core records
	private Set<TimeEvent> timeRecords = new HashSet<>();
	private Set<MileageEvent> mileageRecords = new HashSet<>();
	private Set<MoneyEvent> moneyRecords = new HashSet<>();

	// Other
	private Set<OdometerEvent> odometerRecords = new HashSet<>();





	public void displaySummary() {
		System.out.println("**********************");
		System.out.println(this.name);
		System.out.println();

		System.out.println("Time Records");
		System.out.println("Total no: " + timeRecords.size());
		System.out.println("Total no of hours worked: " + TimeRecordCalc.getTotalNoOfHoursWorked(this.timeRecords));
		System.out.println("No of hours worked this month: " + TimeRecordCalc.getHoursWorkedThisMonth(this.timeRecords));
		System.out.println();

		System.out.println("Money Records");
		System.out.println("Total no: " + moneyRecords.size());
		System.out.println();

		System.out.println("Mileage Records");
		System.out.println("Total no: " + mileageRecords.size());
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
		return this.timeRecords.stream()
				.filter(x->x.getAccount().equals(project))
				.mapToDouble(x->x.getHours()).sum();
	}

	private double getTotalRevenueForProject(String project) {
		return this.moneyRecords.stream()
				.filter(x->x.getTransactionType() == MoneyEvent.TRANSACTION_TYPE.REVENUE)
				.filter(x->x.getAccountFrom().equals(project))
				.mapToDouble(x->x.getAmount()).sum();
	}

	Set<String> getAllProjects() {
		Set<String> result = new HashSet<>();
		// Get every account time has worked on
		result.addAll(this.timeRecords.stream().map(x->x.getAccount()).collect(Collectors.toSet()));
		// Get every account that has brought in revenue
		result.addAll(this.moneyRecords.stream()
				.filter(x->x.getTransactionType() == MoneyEvent.TRANSACTION_TYPE.REVENUE).map(x->x.getAccountFrom())
				.collect(Collectors.toSet()));
		return result;

	}
}
