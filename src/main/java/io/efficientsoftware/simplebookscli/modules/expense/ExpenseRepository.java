package io.efficientsoftware.simplebookscli.modules.expense;

import io.efficientsoftware.simplebookscli.model.MoneyEvent;
import io.efficientsoftware.simplebookscli.persistence.CentralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ExpenseRepository extends CentralRepository {

    public Set<DirectExpenseEvent> getAllDirectExpenses() {
        return readEvents().stream()
                 .filter(x -> x instanceof DirectExpenseEvent)
                 .map(x-> (DirectExpenseEvent) x).collect(Collectors.toSet());
    }

    public void addExpense(MoneyEvent moneyRecord) {
        createOrUpdate(moneyRecord);
    }
}
