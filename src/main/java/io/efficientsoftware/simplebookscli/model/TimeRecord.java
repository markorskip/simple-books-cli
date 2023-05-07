package io.efficientsoftware.simplebookscli.model;


import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.shell.component.context.ComponentContext;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
public class TimeRecord {
	
	private LocalDate date; // Todo change to actual date
	private String descriptionOfWork;
	private double hours;

	public TimeRecord(LocalDate date, String descriptionOfWork, double hours) {
		this.date = date;
		this.descriptionOfWork = descriptionOfWork;
		if (hours > 24) throw new IllegalArgumentException("Hours worked in a day cannot be greater then 24");
		this.hours = hours;
	}
 //unit test
	public TimeRecord(String descriptionOfWork, double hours) {
		this.date = LocalDate.now();
		this.descriptionOfWork = descriptionOfWork;
		if (hours > 24) throw new IllegalArgumentException("Hours worked in a day cannot be greater then 24");
		this.hours = hours;
	}

	// unit test
	public TimeRecord(String descriptionOfWork) {
		this.date = LocalDate.now();
		this.descriptionOfWork = descriptionOfWork;
		this.hours = 8.0;
	}

	public static TimeRecord buildFromContext(ComponentContext<?> ctx) {
		LocalDate  date = ctx.get("date", LocalDate.class);
		String desc = ctx.get("desc");
		Double hours = ctx.get("hoursWorked", Double.class);
		TimeRecord result = new TimeRecord(date, desc, hours);
		return result;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public String getDescriptionOfWork() {
		return descriptionOfWork;
	}

	public double getHours() {
		return hours;
	}
}
