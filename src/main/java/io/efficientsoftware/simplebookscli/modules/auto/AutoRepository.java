package io.efficientsoftware.simplebookscli.modules.auto;

import io.efficientsoftware.simplebookscli.repository.CentralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutoRepository {

    @Autowired
    private CentralRepository centralRepository;


}
