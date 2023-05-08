package io.efficientsoftware.simplebookscli.commands;

import io.efficientsoftware.simplebookscli.DataCache;
import io.efficientsoftware.simplebookscli.model.Business;
import io.efficientsoftware.simplebookscli.model.MoneyRecord;
import io.efficientsoftware.simplebookscli.model.TimeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

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
        TimeRecord timeRecord = new TimeRecord(date, account, description, hoursToWorked);
        dataCache.business.getTimeRecords().add(timeRecord);
        System.out.println("Added: " + timeRecord.toString());
    }

    @ShellMethod
    public void logMoney(String date, String amount, String accountFrom, String accountTo, String description) {
        MoneyRecord moneyRecord = new MoneyRecord(date, amount, accountFrom, accountTo, description);
        dataCache.business.getMoneyRecords().add(moneyRecord);
        System.out.println("Added: " + moneyRecord.toString());
    }


}
