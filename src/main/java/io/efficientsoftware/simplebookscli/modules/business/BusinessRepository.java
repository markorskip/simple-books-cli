package io.efficientsoftware.simplebookscli.modules.business;

import io.efficientsoftware.simplebookscli.repository.CentralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessRepository {

    @Autowired
    private CentralRepository centralRepository;

    public void setOwnerName(String arg) {
        this.centralRepository.getBusinessInformation().setOwnerName(arg);
    }

    public void setBusinessName(String arg) {
        this.centralRepository.getBusinessInformation().setBusinessName(arg);
    }
}
