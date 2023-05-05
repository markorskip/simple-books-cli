package io.efficientsoftware.simplebookscli.modules.homeoffice.model;

import io.efficientsoftware.simplebookscli.modules.ledger.model.TransactionLogEntry;
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
