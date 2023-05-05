package io.efficientsoftware.simplebookscli.model;

import lombok.Data;
import org.springframework.shell.component.context.ComponentContext;
import org.springframework.shell.component.flow.ComponentFlow;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class HourlyContract implements Serializable {
	
	private String contractName;
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
		hourlyContract.setContractName(ctx.get("customerName") != null ? ctx.get("customerName") : "NoName");
		return hourlyContract;
	}

    public void display() {
		System.out.println("Contract Name:" + this.contractName);
		System.out.println("Hourly Rate: " + this.hourlyRate);
		System.out.println("Active?" + this.isActive);
		System.out.println("Time Entries");
		for (TimekeepingLogEntry entry: this.timeKeepingLog) {
			entry.display();
		}
    }
}
