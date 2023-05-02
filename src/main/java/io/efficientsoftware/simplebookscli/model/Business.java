package io.efficientsoftware.simplebookscli.model;

import java.util.Set;
import java.io.Serializable;
import java.util.HashSet;

import lombok.Data;

// Serialize and deserialize for storage
@Data
public class Business implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String businessName;
	private String ownerName;
	
	private Set<WorkContracts> contracts = new HashSet<>(); // Work for hourly pay
	private Set<Product> products = new HashSet<>(); // Products the business owns and can sell directly
	
	private Set<TransactionLogEntry> directExpenses = new HashSet<>();
	private Set<TransactionLogEntry> directRevenue = new HashSet<>();
	private Set<Vehicle> vehiclesUsedForBusiness;
	private HomeOffice homeOffice;
	
	private CategorizationRules categorizationRules;
	
	public void addDirectExpense(TransactionLogEntry entry) {
		this.directExpenses.add(entry);
	}

	public String display(String arg) {
		arg = arg.toLowerCase();
		if (arg.contains("business")) {
			return this.toString();
		}
		if (arg.contains("owner")) {
			return this.ownerName;
		}
		if (arg.contains("contract")) {
			return this.contracts.toString();
		}
		if (arg.contains("product")) {
			return this.products.toString();
		}
		if (arg.contains("expense")) {
			return this.directExpenses.toString();
		}
		if (arg.contains("revenue") ) {
			return this.directRevenue.toString();
		}
		if (arg.contains("vehicle") || arg.contains("car")) {
			return this.vehiclesUsedForBusiness.toString();
		}
		if (arg.contains("home") || arg.contains("office")) {
			return this.homeOffice.toString();
		}
		if (arg.contains("rule")) {
			return this.categorizationRules.toString();
		}
		
		// Default value
		return this.businessName;
	}
	
}
