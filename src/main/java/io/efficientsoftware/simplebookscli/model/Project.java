package io.efficientsoftware.simplebookscli.model;

import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
public class Project {
	
	private String name;
	private Double hourlyRate;
	public Set<TimeRecord> timeTrackingLog = new HashSet<>();

	// Only other model classes can directly create projects
	Project(String name, double hourlyRate) {
		if (hourlyRate < 0) throw new IllegalArgumentException("Hourly Rate must be greater than 0");
		this.hourlyRate = hourlyRate;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Double getHourlyRate() {
		return this.hourlyRate;
	}

	public Set<TimeRecord> getTimeTrackingLog() {
		return Set.copyOf(timeTrackingLog); // Don't return the original or the getter becomes a setter
	}

	public void addTimeTrackingEntry(TimeRecord entry) {
		this.timeTrackingLog.add(entry);
	}

	public void display() {
		System.out.println();
		System.out.println("Project Name: " + this.name);
		System.out.println("Hourly Rate: " + this.hourlyRate);
		System.out.println("Time Entries");
		System.out.println("    Date,   Description,  				Hours Worked");
		for (TimeRecord entry: this.timeTrackingLog) {
			System.out.print("    " +entry.getDate() + ", ");
			System.out.print(entry.getDescriptionOfWork() + ", ");
			System.out.print(entry.getHours());
			System.out.println();
		}
    }

	public void deleteTimeTrackingEntry(TimeRecord entry) {
		this.timeTrackingLog.remove(entry);
	}
}
