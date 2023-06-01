package io.efficientsoftware.simplebookscli.modules.expense;

import io.efficientsoftware.simplebookscli.model.MoneyEvent;
import io.efficientsoftware.simplebookscli.modules.ModuleRepository;
import io.efficientsoftware.simplebookscli.persistence.CentralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ExpenseRepository extends CentralRepository implements ModuleRepository<DirectExpenseEvent> {

    @Override
    public Set<DirectExpenseEvent> viewAll() {
        return readEvents().stream()
                .filter(x -> x instanceof DirectExpenseEvent)
                .map(x-> (DirectExpenseEvent) x).collect(Collectors.toSet());
    }

    @Override
    public void add(DirectExpenseEvent event) {
        createOrUpdate(event);
    }

    @Override
    public void delete(DirectExpenseEvent event) {
        // TODO implement
    }

    @Override
    public void update(DirectExpenseEvent oldEvent, DirectExpenseEvent newEvent) {
        // TODO implement
    }
}
