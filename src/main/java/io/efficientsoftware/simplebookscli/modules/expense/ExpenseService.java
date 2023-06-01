package io.efficientsoftware.simplebookscli.modules.expense;

import io.efficientsoftware.simplebookscli.model.MoneyEvent;
import io.efficientsoftware.simplebookscli.modules.ModuleService;
import io.efficientsoftware.simplebookscli.ui.PrintUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ExpenseService implements ModuleService<MoneyEvent> {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public void log(MoneyEvent moneyRecord) {
        expenseRepository.addExpense(moneyRecord);
    }

    @Override
    public void viewAll() {
        PrintUtility.printList(expenseRepository.getAllDirectExpenses());
    }

    @Override
    public void displaySummary() {
        // TODO print
    }
}
