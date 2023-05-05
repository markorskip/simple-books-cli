package io.efficientsoftware.simplebookscli.model;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionLogEntry {
	
	public Date date;
	public double amount;
	public String vendor;
	public String description;
	public String account;
	public String category; // This need to be an account
	
}
