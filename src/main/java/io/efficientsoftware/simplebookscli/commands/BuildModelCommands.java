package io.efficientsoftware.simplebookscli.commands;

import io.efficientsoftware.simplebookscli.DataCache;
import io.efficientsoftware.simplebookscli.model.MoneyEvent;
import io.efficientsoftware.simplebookscli.model.TimeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class BuildModelCommands {

    @Autowired
    private DataCache dataCache;

    @ShellMethod
    public void createBusiness(String name) {
        this.dataCache.business.setName(name);
        System.out.println("Business name set to: " + name);
    }

    @ShellMethod("Log time to a project or customer")
    public void logTime(String date, String account, String description, String hoursToWorked) {
        TimeEvent timeRecord = new TimeEvent(date, account, description, hoursToWorked);
        dataCache.business.getTimeRecords().add(timeRecord);
        System.out.println("Added: " + timeRecord.toString());
    }

    @ShellMethod(key = "lt", value = "Log time to a project or customer")
    public void lt(String date, String account, String description, String hoursToWorked) {
        logTime(date, account, description, hoursToWorked);
    }

    @ShellMethod("Log a financial transaction")
    public void logRevenue(String date, String amount, String accountFrom, String accountTo, @ShellOption(defaultValue = ShellOption.NULL) String description) {
        MoneyEvent moneyRecord = new MoneyEvent(date, amount, accountFrom, accountTo, description,
                MoneyEvent.TRANSACTION_TYPE.REVENUE.toString());
        dataCache.business.getMoneyRecords().add(moneyRecord);
        System.out.println("Added: " + moneyRecord.toString());
    }

    @ShellMethod("Log a financial transaction")
    public void logDirectExpense(String date, String amount, String accountFrom, String accountTo, @ShellOption(defaultValue = ShellOption.NULL) String description) {
        MoneyEvent moneyRecord = new MoneyEvent(date, amount, accountFrom, accountTo, description, MoneyEvent.TRANSACTION_TYPE.DIRECT_EXPENSE.toString());
        dataCache.business.getMoneyRecords().add(moneyRecord);
        System.out.println("Added: " + moneyRecord.toString());
    }

}
