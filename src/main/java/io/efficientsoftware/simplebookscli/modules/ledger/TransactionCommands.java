package io.efficientsoftware.simplebookscli.modules.ledger;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class TransactionCommands {

    @ShellMethod
    public void logAnExpense() {

    }

    @ShellMethod
    public void logRevenue(){

    }

    @ShellMethod
    public void editExpense() {

    }

    @ShellMethod
    public void editRevenue() {

    }


    //@ShellMethod(key="log-transaction")
    //public void logTransacation() {
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

    //}

    // TODO addExpenseCategory
    // TODO

//	@ShellMethod(key="bulk-import")
//	public void bulkImport(@ShellOption(defaultValue = "transaction") String arg ) {
//		// import to transactions, auto, or mileage
//	}
//
}
