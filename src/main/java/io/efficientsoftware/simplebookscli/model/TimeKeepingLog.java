package io.efficientsoftware.simplebookscli.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class TimeKeepingLog {
	
	public Set<TimekeepingLogEntry> log = new HashSet<>();
	public double hourlyRate;
	public String customerName;

}
