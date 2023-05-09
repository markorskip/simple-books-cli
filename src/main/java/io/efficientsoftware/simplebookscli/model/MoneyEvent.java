package io.efficientsoftware.simplebookscli.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
public class MoneyEvent extends BaseEvent {

    private double amount; // only positive number
    private String accountFrom;
    private String transactionDescription;
    private String accountTo; // ie BusinessChecking
    private TRANSACTION_TYPE transactionType;

    public enum TRANSACTION_TYPE { REVENUE, DIRECT_EXPENSE };
    /**
     * @param date
     * @param amount Only positive numbers are allowed.  If it a return, still use direct expense but switch the accountFrom and accountTo arround
     * @param accountFrom
     * @param transactionDescription
     * @param accountTo
     */
    public MoneyEvent(String date, String amount, String accountFrom, String accountTo, String transactionDescription, String type) {
        super(date);
        this.amount = parseDouble(amount);
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.transactionDescription = transactionDescription;
        this.transactionType = TRANSACTION_TYPE.valueOf(type);
        if (this.amount < 0) throw new IllegalArgumentException("Only use positive numbers for amounts. IE a 50 dollar expense is 50 dollars from Checking to CellPhone");
    }
}
