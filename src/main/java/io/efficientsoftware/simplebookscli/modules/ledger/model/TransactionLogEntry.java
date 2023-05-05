package io.efficientsoftware.simplebookscli.modules.ledger.model;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionLogEntry {
	
	public Date date;
	public double amount;
	public String vendor;
	public String description;
	public String account;
	public String category;
	
}
