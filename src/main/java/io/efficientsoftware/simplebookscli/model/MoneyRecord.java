package io.efficientsoftware.simplebookscli.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class MoneyRecord extends BaseRecord {

    private double amount; // only positive number
    private String accountFrom;
    private String transactionDescription;
    private String accountTo; // ie BusinessChecking

    /**
     * For tracking money coming or going out.
     *
     * Example for revenue
     * log-money --date=1/1/2022 --amount=$10000 accountFrom=CustomerAbc accountTo=BusinessChecking
     *
     * Example for expense
     * log-money --date=1/1/2022 --amount=50.55 accountFrom=BusinessChecking accountTo=CellPhone, "Company cell Phones"
     *
     * Exmaple for returned item on expense
     * log-money --date=1/1/2022 --amount=50.55 accountFrom=OfficeFurniture accountTo=BusinessChecking, "Returned office furniture"
     *
     * @param date
     * @param amount Only positive numbers are allowed.  If it a return, still use direct expense but switch the accountFrom and accountTo arround
     * @param accountFrom
     * @param transactionDescription
     * @param accountTo
     */
    public MoneyRecord(String date, String amount, String accountFrom, String accountTo, String transactionDescription) {
        super(date);
        this.amount = parseDouble(amount);
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.transactionDescription = transactionDescription;
        if (this.amount < 0) throw new IllegalArgumentException("Only use positive numbers for amounts. IE a 50 dollar expense is 50 dollars from Checking to CellPhone");
    }
}
