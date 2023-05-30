package io.efficientsoftware.simplebookscli.modules.expense;

import io.efficientsoftware.simplebookscli.model.MoneyEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public void addExpense(MoneyEvent moneyRecord) {
        expenseRepository.addExpense(moneyRecord);
    }

    public Set<DirectExpenseEvent> getAllDirectExpenses() {
        return expenseRepository.getAllDirectExpenses();
    }
}
