package io.efficientsoftware.simplebookscli.commands;

import io.efficientsoftware.simplebookscli.model.BusinessInfoEvent;
import io.efficientsoftware.simplebookscli.model.MileageEvent;
import io.efficientsoftware.simplebookscli.service.AddDeleteService;
import io.efficientsoftware.simplebookscli.model.money.MoneyEvent;
import io.efficientsoftware.simplebookscli.model.TimeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class AddCommands {

    @Autowired
    private AddDeleteService addDeleteService;

    @ShellMethod
    public void setBusinessName(String name) {
        BusinessInfoEvent event = new BusinessInfoEvent(name);
        addDeleteService.add(event);
    }

    @ShellMethod(key = {"log-time","lt"}, value = "Log time to a project or customer.")
    public void logTime(String date, String account, String description, String hoursToWorked,
                    @ShellOption(defaultValue = ShellOption.NULL) String person
    ) {
        TimeEvent timeRecord = new TimeEvent(date, account, description, hoursToWorked, person);
        addDeleteService.add(timeRecord);
    }

    @ShellMethod(key = {"log-revenue","lr"}, value = "Log revenue.")
    public void logRevenue(String date, String amount, String accountFrom, String accountTo,
                           @ShellOption(defaultValue = ShellOption.NULL) String description,
                           @ShellOption(defaultValue = ShellOption.NULL) String category) {
        MoneyEvent moneyRecord =
                new MoneyEvent(date, amount, accountFrom, accountTo, MoneyEvent.TRANSACTION_TYPE.REVENUE.toString(), description, category);
        addDeleteService.add(moneyRecord);
    }

    @ShellMethod(key = {"log-expense", "le" }, value = "Log a direct expense.")
    public void logDirectExpense(String date, String amount, String accountFrom, String accountTo,
                                 @ShellOption(defaultValue = ShellOption.NULL) String description,
                                 @ShellOption(defaultValue = ShellOption.NULL) String category) {
        MoneyEvent moneyRecord = new MoneyEvent(date, amount,
                accountFrom, accountTo,
                MoneyEvent.TRANSACTION_TYPE.DIRECT_EXPENSE.toString(),
                description, category);
        addDeleteService.add(moneyRecord);
    }

    @ShellMethod(key = {"log-mileage", "lm" }, value = "Log a Mileage")
    public void logDirectExpense(String date, String vehicleName, String milesDriven,
                                 @ShellOption(defaultValue = ShellOption.NULL) String description
                                 ) {
        MileageEvent mileageEvent = new MileageEvent(date, vehicleName,
                milesDriven, description);
        addDeleteService.add(mileageEvent);
    }


}
