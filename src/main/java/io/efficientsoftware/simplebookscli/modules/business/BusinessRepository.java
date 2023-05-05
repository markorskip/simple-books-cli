package io.efficientsoftware.simplebookscli.modules.business;

import io.efficientsoftware.simplebookscli.repository.CentralRepository;
import io.efficientsoftware.simplebookscli.sharedmodel.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessRepository {

    @Autowired
    private CentralRepository centralRepository;

    public BusinessRepository(CentralRepository centralRepository) {
        this.centralRepository = centralRepository;
    }

    public void setOwnerName(String arg) {
        this.centralRepository.getBusinessInformation().setOwnerName(arg);
    }

    public void setBusinessName(String arg) {
        this.centralRepository.getBusinessInformation().setBusinessName(arg);
    }

    public void createNewBusiness(String businessName) {
        Business business = new Business();
        BusinessInformation businessInformation = new BusinessInformation();
        businessInformation.setBusinessName(businessName);
        business.setBusinessInformation(businessInformation);
        this.centralRepository.setBusiness(business);
    }
}
