package io.efficientsoftware.simplebookscli;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MyCommands {

	@ShellMethod(key = "hello-world")
	public String helloWorld(
		@ShellOption(defaultValue = "spring") String arg
	) {
		return "Hello world " + arg;
	}
	
	@ShellMethod(key = "display-expense-report")
	public String displayExpenseReport(
		@ShellOption(defaultValue = "data") String arg 
	) {
		//Report = new ReportService();

		//return reportService.generateExpenseReport(null).toString();
		return "null";
	}
	
	@ShellMethod(key="log-transaction")
	public void logTransacation() {
		// account, date, description, comments, amount
		
		// account is a drop down, you have to creat accounts upfront
		// date is Date
		// desription is a string
		// comments is a string
		// amount is a number (positive or negative)
		// category is a drop down, you have to create additional categories
		
		// category is recommended but not selected
		//
		
		
	}
	
	@ShellMethod(key="bulk-import")
	public void bulkImport(@ShellOption(defaultValue = "transaction") String arg ) {
		// import to transactions, auto, or mileage
		
		
	}
	
	@ShellMethod(key="log-mileage") 
	public void logMileage(){

	}
	
	@ShellMethod(key="log-auto-expense")
	public void logAutoExpense() {
		
	}
	
	@ShellMethod(key="update-configuration")
	public void updateConfiguration(){
		// set business name
		// set default year
		// set mileage beginning and end
		// create business categories and map to tax categories
		// create tax categories and map to business categories
		
	}
	
	@ShellMethod(key="create-rule")
	public void createRule() {
		// Rules are used to automate some of the bookkeeping process
		// such as always categorize something with "vendor a" description as "internet"
		
		
	}
	
	
	
	
	
}