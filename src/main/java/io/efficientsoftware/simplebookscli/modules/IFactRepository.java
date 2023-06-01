package io.efficientsoftware.simplebookscli.modules;

import io.efficientsoftware.simplebookscli.model.Event;
import io.efficientsoftware.simplebookscli.model.Fact;
import io.efficientsoftware.simplebookscli.persistence.CentralRepository;

public interface IFactRepository<KeyValueEvent> {

    CentralRepository getCentralRepository();

    default void add(Fact fact) {
        Fact existingFact = getFact(fact.getKey());
        if (existingFact != null) {
            getCentralRepository().update((Event) existingFact, (Event) fact);
        } else {
            getCentralRepository().add((Event) fact);
        }
    }

    Fact getFact(String key);

    default void delete(Fact event) {
        getCentralRepository().delete((Event) event);
    }
}
