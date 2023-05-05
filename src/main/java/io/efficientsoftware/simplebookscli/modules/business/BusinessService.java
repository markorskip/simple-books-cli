package io.efficientsoftware.simplebookscli.modules.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository repo;

    public void setBusinessName(String businessName) {
        this.repo.setBusinessName(businessName);
    }

    public void setOwnerName(String ownerName) {
        this.repo.setOwnerName(ownerName);
    }

    public void createNewBusiness(String businessName) {
        this.repo.createNewBusiness(businessName);
    }
}
