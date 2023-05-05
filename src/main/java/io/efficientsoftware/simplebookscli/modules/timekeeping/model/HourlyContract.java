package io.efficientsoftware.simplebookscli.modules.timekeeping.model;

import lombok.Data;
import org.springframework.shell.component.context.ComponentContext;
import org.springframework.shell.component.flow.ComponentFlow;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class HourlyContract implements Serializable {
	
	private String customerName;
	private boolean isActive;
	private double hourlyRate;
	private Date startOfContract;
	private Date endOfContract;
	public Set<TimekeepingLogEntry> timeKeepingLog = new HashSet<>();

	public static HourlyContract buildFromResult(ComponentFlow.ComponentFlowResult result) {
		ComponentContext<?> ctx = result.getContext();
		HourlyContract hourlyContract = new HourlyContract();
		hourlyContract.setActive(true);
		hourlyContract.setHourlyRate(Double.parseDouble(ctx.get("hourlyRate")));
		hourlyContract.setCustomerName(ctx.get("customerName") != null ? ctx.get("customerName") : "NoName");
		return hourlyContract;
	}

    public void display() {
		System.out.println("Customer Name:" + this.customerName);
		System.out.println("Hourly Rate: " + this.hourlyRate);
		System.out.println("Active?" + this.isActive);
		System.out.println("Time Entries");
		for (TimekeepingLogEntry entry: this.timeKeepingLog) {
			entry.display();
		}
    }
}
