package io.efficientsoftware.simplebookscli.modules.expense;

import io.efficientsoftware.simplebookscli.model.Report;
import io.efficientsoftware.simplebookscli.model.SearchCriteria;
import io.efficientsoftware.simplebookscli.modules.ModuleRepository;
import io.efficientsoftware.simplebookscli.modules.ModuleService;
import io.efficientsoftware.simplebookscli.ui.PrintUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExpenseService implements ModuleService<DirectExpenseEvent> {

    @Autowired
    private ExpenseRepository expenseRepository;


    @Override
    public Report getSummaryReport() {
        return new Report("Summary Report", null);
    }

    @Override
    public Report getEventsReport(SearchCriteria searchCriteria) {
        return new Report(searchCriteria.printTitle(), null);
    }

    @Override
    public ModuleRepository<DirectExpenseEvent> getRepository() {
        return expenseRepository;
    }

}
