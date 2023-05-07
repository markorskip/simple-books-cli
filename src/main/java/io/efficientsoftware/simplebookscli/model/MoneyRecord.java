package io.efficientsoftware.simplebookscli.model;

import lombok.Data;

import java.util.Date;

@Data
public class MoneyRecord {

	// TODO double check these
	public Date date;
	public double amount;
	public String vendor;
	public String description;
	public String account;
	public String category; // This need to be an account
	
}
