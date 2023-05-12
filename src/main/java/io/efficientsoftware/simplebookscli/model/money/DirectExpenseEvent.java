package io.efficientsoftware.simplebookscli.model.money;

public class DirectExpenseEvent extends MoneyEvent {

    public DirectExpenseEvent(String date, String amount, String accountFrom, String accountTo, String type) {
        super(date, amount, accountFrom, accountTo, type);
    }
}
