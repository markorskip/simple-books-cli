package io.efficientsoftware.simplebookscli.model;

import java.util.Set;
import java.util.HashSet;

import lombok.Data;

@Data
public class Business {

	private boolean unsavedChanges = true;

	//update when save as
	private String saveLocation;

	private BusinessInformation businessInformation = new BusinessInformation();
	private Set<HourlyContract> hourlyContracts = new HashSet<>();
	private Set<TransactionLogEntry> financialTransactions = new HashSet<>();
	private Set<Vehicle> vehiclesUsedForBusiness = new HashSet<>();
	private Set<Note> notes = new HashSet<>();
//
	public String display(String arg) {
		arg = arg.toLowerCase();
		if (arg.contains("business")) {
			return this.toString();
		}
		if (arg.contains("owner")) {
			return this.businessInformation.getOwnerName();
		}
		if (arg.contains("contract")) {
			return this.hourlyContracts.toString();
		}
//		if (arg.contains("product")) {
//			return this.products.toString();
//		}
//		if (arg.contains("expense")) {
//			return this.directExpenses.toString();
//		}
//		if (arg.contains("revenue") ) {
//			return this.directRevenue.toString();
//		}
//		if (arg.contains("vehicle") || arg.contains("car")) {
//			return this.vehiclesUsedForBusiness.toString();
//		}
//		if (arg.contains("home") || arg.contains("office")) {
//			return this.homeOffice.toString();
//		}
//		if (arg.contains("rule")) {
//			return this.categorizationRules.toString();
//		}
		
		// Default value
		return this.getBusinessInformation().getBusinessName();
	}

	public Vehicle findOrCreateNewVehicle(String autoName) {

		return null; // TODO
	}
}
