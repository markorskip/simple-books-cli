package io.efficientsoftware.simplebookscli.repository;

import io.efficientsoftware.simplebookscli.model.DirectExpenseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class DirectExpenseRepository {

    @Autowired
    private CentralRepository centralRepository;

    public Set<DirectExpenseEvent> getAllDirectExpenses() {
        return centralRepository.readEvents().stream()
                .filter(x -> x instanceof DirectExpenseEvent)
                .map(x-> (DirectExpenseEvent) x).collect(Collectors.toSet());
    }

    public void addDirectExpense(DirectExpenseEvent directExpenseEvent) {
        this.centralRepository.add(directExpenseEvent);
    }
}
