package io.efficientsoftware.simplebookscli.model;

import lombok.Data;
import org.springframework.shell.component.context.ComponentContext;
import org.springframework.shell.component.flow.ComponentFlow;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class Project {
	
	private String name;
	private String hourlyRate;
	public Set<TimekeepingLogEntry> timeKeepingLog = new HashSet<>();

    public void display() {
		System.out.println();
		System.out.println("Project Name: " + this.name);
		System.out.println("Hourly Rate: " + this.hourlyRate);
		System.out.println("Time Entries");
		System.out.println("    Date,   Description,  				Hours Worked");
		for (TimekeepingLogEntry entry: this.timeKeepingLog) {
			System.out.print("    " +entry.getDate() + ", ");
			System.out.print(entry.getDescriptionOfWork()+ ", ");
			System.out.print(entry.getHours());
			System.out.println();
		}
    }
}
