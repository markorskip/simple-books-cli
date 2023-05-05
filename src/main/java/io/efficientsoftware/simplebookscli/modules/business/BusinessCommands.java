package io.efficientsoftware.simplebookscli.modules.business;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class BusinessCommands {

	@Autowired
	private BusinessService service;
	
	@ShellMethod(value = "Create a new business - pass in the name")
	public void setBusinessName(
		@ShellOption(defaultValue = "demo") String arg
	) {
		this.service.setBusinessName(arg);
	}
	
	@ShellMethod(value="Set or change the Business Owner Name")
	public void setOwnerName(
		@ShellOption(defaultValue = "Owner") String ownerName
	) {
		this.service.setOwnerName(ownerName);
		System.out.println("Owner name updated to: " + ownerName);
	}


//	@ShellMethod(key="log-mileage")
//	public void logMileage(){
//
//	}
//
//	@ShellMethod(key="log-auto-expense")
//	public void logAutoExpense() {
//
//	}
//
//	@ShellMethod(key="update-configuration")
//	public void updateConfiguration(){
//		// set business name
//		// set default year
//		// set mileage beginning and end
//		// create business categories and map to tax categories
//		// create tax categories and map to business categories
//	}
//
//	@ShellMethod(key="create-rule")
//	public void createRule() {
//		// Rules are used to automate some of the bookkeeping process
//		// such as always categorize something with "vendor a" description as "internet"
//
//
//	}
}