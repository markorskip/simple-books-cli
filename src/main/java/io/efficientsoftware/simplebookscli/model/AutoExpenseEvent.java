package io.efficientsoftware.simplebookscli.model;

import io.efficientsoftware.simplebookscli.model.MoneyEvent;

public class AutoExpenseEvent extends MoneyEvent {

    private String vehicleName;

    public AutoExpenseEvent(String date, String amount, String accountFrom, String accountTo, String description, String vehicleName) {
        super(date, amount, accountFrom, accountTo, description);
        this.transactionType = TRANSACTION_TYPE.AUTO;
        this.vehicleName = vehicleName;
    }
}
