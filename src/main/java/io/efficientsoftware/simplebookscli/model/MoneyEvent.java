package io.efficientsoftware.simplebookscli.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public abstract class MoneyEvent extends DateEvent {

    protected double amount; // only positive number
    protected String accountFrom;
    protected String accountTo; // ie BusinessChecking
    protected String transactionDescription;
    protected TRANSACTION_TYPE transactionType;

    @Override
    public String toCSV() {
        return null;
    }

    public enum TRANSACTION_TYPE { REVENUE, DIRECT_EXPENSE, AUTO, HOME_OFFICE};
    /**
     * @param date
     * @param amount Only positive numbers are allowed.  If it a return, still use direct expense but switch the accountFrom and accountTo arround
     * @param accountFrom
     * @param transactionDescription
     * @param accountTo
     */
    public MoneyEvent(String date, String amount, String accountFrom, String accountTo, String transactionDescription) {
        super(date);
        this.amount = parseDouble(amount);
        this.accountFrom = accountFrom; // For an expense put checking, for income put the customer / product
        this.accountTo = accountTo; // For an expense put the vendor name
        this.transactionDescription = transactionDescription;
        if (this.amount < 0) throw new IllegalArgumentException("Only use positive numbers for amounts. IE a 50 dollar expense is 50 dollars from Checking to CellPhone");
    }
}
