package io.efficientsoftware.simplebookscli.modules.expense;

import io.efficientsoftware.simplebookscli.model.MoneyEvent;
import io.efficientsoftware.simplebookscli.persistence.CentralRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

public class ExpenseRepository extends CentralRepository {

    @Autowired
    private CentralRepository centralRepository;

    public Set<DirectExpenseEvent> getAllDirectExpenses() {
        return getEvents().stream()
                 .filter(x -> x instanceof DirectExpenseEvent)
                 .map(x-> (DirectExpenseEvent) x).collect(Collectors.toSet());
    }

    public void addExpense(MoneyEvent moneyRecord) {
        add(moneyRecord);
    }
}
