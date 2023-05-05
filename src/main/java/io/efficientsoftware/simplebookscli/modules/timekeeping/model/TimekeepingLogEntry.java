package io.efficientsoftware.simplebookscli.modules.timekeeping.model;

import lombok.Data;
import java.util.Date;

@Data
public class TimekeepingLogEntry {
	
	public Date date;
	public String descriptionOfWork;
	public int hours;

    public void display() {
		this.toString();
    }
}
