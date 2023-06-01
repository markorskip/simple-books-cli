package io.efficientsoftware.simplebookscli.modules.expense;

import io.efficientsoftware.simplebookscli.modules.IDateEventRepository;
import io.efficientsoftware.simplebookscli.persistence.CentralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class DirectExpenseRepository implements IDateEventRepository<DirectExpenseEvent> {

    @Autowired
    private CentralRepository centralRepository;

    @Override
    public Set<DirectExpenseEvent> getAll() {
        return centralRepository.readEvents().stream()
                .filter(x -> x instanceof DirectExpenseEvent)
                .map(x-> (DirectExpenseEvent) x).collect(Collectors.toSet());
    }

    @Override
    public CentralRepository getCentralRepository() {
        return centralRepository;
    }
}
