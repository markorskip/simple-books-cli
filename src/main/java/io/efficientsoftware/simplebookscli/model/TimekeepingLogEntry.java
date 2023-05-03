package io.efficientsoftware.simplebookscli.model;

import lombok.Data;
import java.util.Date;

@Data
public class TimekeepingLogEntry {
	
	public Date date;
	public String descriptionOfWork;
	public int hours;

}
