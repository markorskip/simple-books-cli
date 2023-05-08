package io.efficientsoftware.simplebookscli.model;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;
import java.util.Set;
import java.util.HashSet;

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
	private Set<TimeRecord> timeRecords = new HashSet<>();
	private Set<MileageRecord> mileageRecords = new HashSet<>();
	private Set<MoneyRecord> moneyRecords = new HashSet<>();

	// Other
	private Set<OdometerRecord> odometerRecords = new HashSet<>();

	private double getTotalNoOfHoursWorked() {
		return this.timeRecords.stream().mapToDouble(TimeRecord::getHours).sum();
	}

	private double getHoursWorkedThisMonth() {
		Month thisMonth = LocalDate.now().getMonth();
		return this.timeRecords.stream()
				.filter(x->x.getDate().getMonth() == thisMonth)
				.mapToDouble(TimeRecord::getHours).sum();
	}

	public void displaySummary() {
		System.out.println("**********************");
		System.out.println(this.name);
		System.out.println();

		System.out.println("Time Records");
		System.out.println("Total no: " + timeRecords.size());
		System.out.println("Total no of hours worked: " + getTotalNoOfHoursWorked());
		System.out.println("No of hours worked this month: " + getHoursWorkedThisMonth());
		System.out.println();

		System.out.println("Money Records");
		System.out.println("Total no: " + moneyRecords.size());
		System.out.println();

		System.out.print("Mileage Records");
		System.out.println("Total no: " + mileageRecords.size());
		System.out.println();
	}

}
