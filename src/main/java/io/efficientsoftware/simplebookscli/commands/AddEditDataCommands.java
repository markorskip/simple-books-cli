package io.efficientsoftware.simplebookscli.commands;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import io.efficientsoftware.simplebookscli.model.Business;
import io.efficientsoftware.simplebookscli.service.DataCache;

@ShellComponent
public class AddEditDataCommands {
	
	@Autowired
	private DataCache dataCache;
	
	@ShellMethod(key = "create", group = "init")
	public String createBusiness(
		@ShellOption(defaultValue = "demo") String arg
	) {
		Business business = new Business();
		business.setBusinessName(arg);
		this.dataCache.setBusiness(business);
		return business.toString();
	}
	
	@ShellMethod(key = "owner-name", group = "init")
	public String setBusinessOwnerName(
		@ShellOption(defaultValue = "Owner") String arg
	) {
		this.dataCache.getBusiness().setOwnerName(arg);
		return "Owner name updated to: " + arg;
	}
	
	private final String defaultFileName = "data.txt";
	
	@ShellMethod(key = "save", group = "init")
	public String saveChanges(
		@ShellOption(defaultValue = defaultFileName) String arg
	) throws IOException {
		FileOutputStream fileOutputStream
	      = new FileOutputStream(arg);
	    ObjectOutputStream objectOutputStream
	      = new ObjectOutputStream(fileOutputStream);
	    objectOutputStream.writeObject(this.dataCache.getBusiness());
	    objectOutputStream.flush();
	    objectOutputStream.close();
	    
		return "All data saved to file: " + arg;
	}
	
	@ShellMethod(key = "load", group = "init")
	public String load(
		@ShellOption(defaultValue = defaultFileName) String arg
	) throws IOException, ClassNotFoundException {
		 FileInputStream fileInputStream
	      = new FileInputStream(arg);
	    ObjectInputStream objectInputStream
	      = new ObjectInputStream(fileInputStream);
	    Business business = (Business) objectInputStream.readObject();
	    objectInputStream.close(); 
	    this.dataCache.setBusiness(business);
		return "Loaded data from file: " + arg;
	}
	
	
	@ShellMethod(key="log-transaction")
	public void logTransacation() {
		// Create a flow for logging transactions
		
		// account, date, description, comments, amount
		
		// account is a drop down, you have to creat accounts upfront
		// date is Date
		// description is a string
		// comments is a string
		// amount is a number (positive or negative)
		// category is a drop down, you have to create additional categories
		// category is recommended but not selected
		
		
		// What does log a transaction do different then a spreadsheet?
		// 1st it checks the format and makes sure it's the right format - spreadsheets can't do this
		// 2nd it recommends a category using the rules-engine
		// 3rd it ensures you are never adding a duplicate, if it detects a duplicate it will not add it
		// By doing all that, you can ensure your reports are accurate
		
	}
	
	// TODO addExpenseCategory
	// TODO 
	
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