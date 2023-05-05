package io.efficientsoftware.simplebookscli.model;

import lombok.Data;

import java.util.Set;

@Data
public class HomeOffice {
	
	public String label;
	public int sqftHome;
	public int sqftOffice;
	
	public int noOfMonthsUsedForBusinessIn2023;
	
	public Set<TransactionLogEntry> homeExpenses;
	

}
