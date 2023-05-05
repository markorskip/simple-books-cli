package io.efficientsoftware.simplebookscli.modules.timekeeping.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TimekeepingLogEntry {
	
	public LocalDate date;
	public String descriptionOfWork;
	public int hours;

    public void display() {
		this.toString();
    }
}
