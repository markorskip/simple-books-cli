package io.efficientsoftware.simplebookscli.modules.expense;

import io.efficientsoftware.simplebookscli.model.MoneyEvent;

public class DirectExpenseEvent extends MoneyEvent {

    private String expenseCategory;

    public DirectExpenseEvent(String date, String amount, String accountFrom, String accountTo, String transactionDescription, String expenseCategory) {
        super(date, amount, accountFrom, accountTo, transactionDescription);
        this.expenseCategory = expenseCategory;
        this.transactionType = TRANSACTION_TYPE.DIRECT_EXPENSE;
    }
}
