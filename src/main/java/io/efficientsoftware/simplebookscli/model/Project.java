package io.efficientsoftware.simplebookscli.model;

import lombok.Data;
import org.springframework.shell.component.context.ComponentContext;
import org.springframework.shell.component.flow.ComponentFlow;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class Project implements Serializable {
	
	private String name;
	private double hourlyRate;
	public Set<TimekeepingLogEntry> timeKeepingLog = new HashSet<>();

	public static Project buildFromResult(ComponentFlow.ComponentFlowResult result) {
		ComponentContext<?> ctx = result.getContext();
		Project project = new Project();
		project.setHourlyRate(Double.parseDouble(ctx.get("hourlyRate")));
		project.setName(ctx.get("name") != null ? ctx.get("name") : "NoName");
		return project;
	}

    public void display() {
		System.out.println("Contract Name:" + this.name);
		System.out.println("Hourly Rate: " + this.hourlyRate);
		System.out.println("Time Entries");
		for (TimekeepingLogEntry entry: this.timeKeepingLog) {
			entry.display();
		}
    }
}
