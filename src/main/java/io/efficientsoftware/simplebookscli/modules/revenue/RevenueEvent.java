package io.efficientsoftware.simplebookscli.modules.revenue;

import io.efficientsoftware.simplebookscli.model.event.MoneyEvent;

public class RevenueEvent extends MoneyEvent {

    private String revenueSource;

    public RevenueEvent(String date, String amount, String accountFrom, String accountTo, String description, String revenueSource) {
        super(date, amount, accountFrom, accountTo, description);
        this.transactionType = TRANSACTION_TYPE.REVENUE;
        this.revenueSource = revenueSource;
    }
}
