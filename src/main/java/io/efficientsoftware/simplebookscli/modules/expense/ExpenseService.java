package io.efficientsoftware.simplebookscli.modules.expense;

import io.efficientsoftware.simplebookscli.model.MoneyEvent;
import io.efficientsoftware.simplebookscli.modules.ModuleService;
import io.efficientsoftware.simplebookscli.ui.PrintUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ExpenseService implements ModuleService<DirectExpenseEvent> {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public void log(DirectExpenseEvent directExpenseEvent) {
        expenseRepository.add(directExpenseEvent);
    }

    @Override
    public void viewAll() {
        PrintUtility.printList(expenseRepository.viewAll());
    }

    @Override
    public void displaySummary() {
        // TODO print
    }
}
