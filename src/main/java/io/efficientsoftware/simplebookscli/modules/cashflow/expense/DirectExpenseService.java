package io.efficientsoftware.simplebookscli.modules.cashflow.expense;

import io.efficientsoftware.simplebookscli.model.Report;
import io.efficientsoftware.simplebookscli.model.SearchCriteria;
import io.efficientsoftware.simplebookscli.modules.IDateEventRepository;
import io.efficientsoftware.simplebookscli.modules.IDateEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectExpenseService implements IDateEventService<DirectExpenseEvent> {

    @Autowired
    private DirectExpenseRepository expenseRepository;


    @Override
    public Report getSummaryReport() {
        return new Report("Summary Report", null);
    }

    @Override
    public Report getEventsReport(SearchCriteria searchCriteria) {
        return new Report(searchCriteria.printTitle(), search(searchCriteria));
    }

    @Override
    public List<DirectExpenseEvent> search(SearchCriteria searchCriteria) {
        //TODO
        return expenseRepository.getAll().stream().collect(Collectors.toList());
    }

    @Override
    public IDateEventRepository<DirectExpenseEvent> getRepository() {
        return expenseRepository;
    }

}
