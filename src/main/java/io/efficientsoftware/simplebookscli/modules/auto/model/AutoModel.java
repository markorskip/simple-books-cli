package io.efficientsoftware.simplebookscli.modules.auto.model;

import io.efficientsoftware.simplebookscli.modules.ledger.model.TransactionLogEntry;
import lombok.Data;

import java.util.Set;

@Data
public class AutoModel {

	public String label;
	public String description;
	public int startingYearMiles2023;
	public int endingYearMiles2023;
	
	public Set<TransactionLogEntry> autoExpenses;
	public Set<MileageLogEntry> mileageLog;
	
	// TODO
	// add in data to calculate depreciation

}
