package io.efficientsoftware.simplebookscli.model;

import lombok.Data;

@Data
public class WorkContracts {
	
	private String customerName;
	private boolean isActive;
	private double hourlyRate;
	private TimeKeepingLog timeKeepingLog;

}
