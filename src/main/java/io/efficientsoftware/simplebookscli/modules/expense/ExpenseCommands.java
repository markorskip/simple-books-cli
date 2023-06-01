package io.efficientsoftware.simplebookscli.modules.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ExpenseCommands {

    @Autowired
    ExpenseService expenseService;

    @ShellMethod(key = {"log-expense" }, value = "Log a direct expense.")
    public void logDirectExpense(String date, String amount, String accountFrom, String accountTo,
                                 @ShellOption(defaultValue = ShellOption.NULL) String description,
                                 @ShellOption(defaultValue = ShellOption.NULL) String category) {
        DirectExpenseEvent directExpenseEvent = new DirectExpenseEvent(date, amount,
                accountFrom, accountTo,
                description, category);
        expenseService.add(directExpenseEvent);
    }

    @ShellMethod(key = {"display-all-expenses" }, value = "Display All Direct Expenses.")
    public void displayAllDirectExpenses() {
       expenseService.getAll();
    }


    public void deleteDirectExpense() {
        // TODO - display list first to allow user to select event to delete?
        // TODO - find pattern for deleting
    }

    public void editDirectExpense() {
        // TODO - display list to find event to edit
        // TODO = find edit pattern
    }


}
