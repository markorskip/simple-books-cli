package io.efficientsoftware.simplebookscli.model;

import io.efficientsoftware.simplebookscli.model.core.DateEvent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
public class MoneyEvent extends DateEvent {

    private double amount; // only positive number
    private String accountFrom;
    private String transactionDescription;
    private String accountTo; // ie BusinessChecking
    private TRANSACTION_TYPE transactionType;
    private String category;

    public enum TRANSACTION_TYPE { REVENUE, DIRECT_EXPENSE, AUTO };
    /**
     * @param date
     * @param amount Only positive numbers are allowed.  If it a return, still use direct expense but switch the accountFrom and accountTo arround
     * @param accountFrom
     * @param transactionDescription
     * @param accountTo
     */
    public MoneyEvent(String date, String amount, String accountFrom, String accountTo, String type, String transactionDescription, String category) {
        super(date);
        this.amount = parseDouble(amount);
        this.accountFrom = accountFrom; // For an expense put checking, for income put the customer / product
        this.accountTo = accountTo; // For an expense put the vendor name
        this.transactionType = TRANSACTION_TYPE.valueOf(type);
        this.transactionDescription = transactionDescription;
        this.category = category;
        if (this.amount < 0) throw new IllegalArgumentException("Only use positive numbers for amounts. IE a 50 dollar expense is 50 dollars from Checking to CellPhone");
    }

    public MoneyEvent(String date, String amount, String accountFrom, String accountTo, String type) {
        this(date, amount, accountFrom, accountTo, type, null, null);
    }
}
