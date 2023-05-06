package io.efficientsoftware.simplebookscli.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.shell.component.context.ComponentContext;

import java.sql.Time;
import java.time.LocalDate;

@Data
@ToString
public class TimekeepingLogEntry {
	
	private String date; // Todo change to actual date
	private String descriptionOfWork;
	private String hours;

	public static TimekeepingLogEntry buildFromContext(ComponentContext<?> ctx) {
		TimekeepingLogEntry result = new TimekeepingLogEntry();
		result.date = ctx.get("date");
		result.descriptionOfWork = ctx.get("desc");
		result.hours = ctx.get("hoursWorked");
		return result;
	}
}
