package io.efficientsoftware.simplebookscli.sharedmodel;

import java.util.Set;
import java.util.HashSet;

import io.efficientsoftware.simplebookscli.modules.auto.model.AutoModel;
import io.efficientsoftware.simplebookscli.modules.business.BusinessInformation;
import io.efficientsoftware.simplebookscli.modules.homeoffice.model.HomeOffice;
import io.efficientsoftware.simplebookscli.modules.ledger.model.CategorizationRules;
import io.efficientsoftware.simplebookscli.modules.ledger.model.TransactionLogEntry;
import io.efficientsoftware.simplebookscli.modules.product.model.Product;
import io.efficientsoftware.simplebookscli.modules.timekeeping.model.HourlyContract;
import lombok.Data;

@Data
public class Business {

	private BusinessInformation businessInformation = new BusinessInformation();

	private Set<HourlyContract> hourlyContracts = new HashSet<>(); // Work for hourly pay
	private Set<Product> products = new HashSet<>(); // Products the business owns and can sell directly

	private Set<TransactionLogEntry> directExpenses = new HashSet<>();
	private Set<TransactionLogEntry> directRevenue = new HashSet<>();
	private Set<AutoModel> vehiclesUsedForBusiness = new HashSet<>();
	private HomeOffice homeOffice = new HomeOffice();
	private CategorizationRules categorizationRules = new CategorizationRules();


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
		return this.getBusinessInformation().getBusinessName();
	}
	
}
