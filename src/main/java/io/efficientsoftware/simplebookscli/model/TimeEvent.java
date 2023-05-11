package io.efficientsoftware.simplebookscli.model;


import io.efficientsoftware.simplebookscli.model.core.DateEvent;
import io.efficientsoftware.simplebookscli.model.core.Event;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
public class TimeEvent extends DateEvent {

	private String account;
	private String description;
	private double hours;
	private String person; // Optionally, if keeping track of more then one person on a task

	/**
	 * A time record can be used for invoicing, or tracking time on a project.
	 *
	 * Use command log-time --account "customer" --date "01/31/2022" --description "desc" --hours "8"
	 * or short hand log-time "customer,01/31/2022,description,8"
	 * @param account Can be a customer, project, or anything you want to track time on
	 * @param date the Date the time was worked
	 * @param description description Of the Work
	 * @param hours Number of hours
	 */
	public TimeEvent(String date, String account, String description, String hours, String person) {
		super(date);
		this.account = account;
		this.description = description;
		this.hours = parseDouble(hours);
		this.person = person;
		if (this.hours > 24) throw new IllegalArgumentException("Hours worked in a day cannot be greater then 24");
	}

	public TimeEvent(String date, String account, String description, String hours) {
		this(date, account, description, hours, null);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("TimeRecord").append('\n');
		sb.append(" Date: ").append(date).append(SPACER);
		sb.append(" Account: ").append(account).append(SPACER);
		sb.append(" Hours: ").append(hours).append('\n');
		sb.append(" Description: ").append(description).append('\n');
		return sb.toString();
	}

	@Override
	public String toCSV() {
		return null;
	}
}
