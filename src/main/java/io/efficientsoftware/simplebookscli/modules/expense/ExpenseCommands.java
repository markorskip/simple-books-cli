package io.efficientsoftware.simplebookscli.modules.expense;

import io.efficientsoftware.simplebookscli.model.MoneyEvent;
import io.efficientsoftware.simplebookscli.ui.PrintUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Set;

@ShellComponent
public class ExpenseCommands {

    @Autowired
    ExpenseService expenseService;

    @ShellMethod(key = {"log-expense", "le" }, value = "Log a direct expense.")
    public void logDirectExpense(String date, String amount, String accountFrom, String accountTo,
                                 @ShellOption(defaultValue = ShellOption.NULL) String description,
                                 @ShellOption(defaultValue = ShellOption.NULL) String category) {
        MoneyEvent moneyRecord = new DirectExpenseEvent(date, amount,
                accountFrom, accountTo,
                description, category);
        expenseService.log(moneyRecord);
    }

    public void displayAllDirectExpenses() {
       expenseService.viewAll();
    }


    public void deleteDirectExpense() {
        // TODO
    }

    public void editDirectExpense() {
        // TODO
    }


}
