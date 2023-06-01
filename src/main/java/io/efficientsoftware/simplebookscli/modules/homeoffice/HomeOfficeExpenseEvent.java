package io.efficientsoftware.simplebookscli.modules.homeoffice;


import io.efficientsoftware.simplebookscli.model.event.MoneyEvent;

public class HomeOfficeExpenseEvent extends MoneyEvent {

    private String homeOffice;

    public HomeOfficeExpenseEvent(String date, String amount, String accountFrom, String accountTo, String description, String homeOffice) {
        super(date, amount, accountFrom, accountTo, description);
        this.homeOffice = homeOffice;
    }
}
