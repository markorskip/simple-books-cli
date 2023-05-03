package io.efficientsoftware.simplebookscli.model;

import lombok.Data;
import org.springframework.shell.component.context.ComponentContext;
import org.springframework.shell.component.flow.ComponentFlow;

import java.io.Serializable;
import java.util.Date;

@Data
public class HourlyContract implements Serializable {
	
	private String customerName;
	private boolean isActive;
	private double hourlyRate;
	private Date startOfContract;
	private Date endOfContract;
	private TimeKeepingLog timeKeepingLog;

	public static HourlyContract buildFromResult(ComponentFlow.ComponentFlowResult result) {
		ComponentContext<?> ctx = result.getContext();
		HourlyContract hourlyContract = new HourlyContract();
		hourlyContract.setActive(true);
		hourlyContract.setHourlyRate(Double.parseDouble(ctx.get("hourlyRate")));
		hourlyContract.setCustomerName(ctx.get("customerName") != null ? ctx.get("customerName") : "NoName");
		return hourlyContract;
	}

}
