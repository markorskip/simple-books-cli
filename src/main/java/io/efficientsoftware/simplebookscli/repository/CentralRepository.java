package io.efficientsoftware.simplebookscli.repository;


import io.efficientsoftware.simplebookscli.modules.timekeeping.model.HourlyContract;
import io.efficientsoftware.simplebookscli.sharedmodel.Business;
import io.efficientsoftware.simplebookscli.modules.business.BusinessInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

/**
 * Handles all read and write operations to the DataCache.  The CentralRepository
 * should only be accessed by other repositories.  It should never be accessed directly
 * from a service.
 */
@Component
public class CentralRepository {

    @Autowired
    private DataCache dataCache;

    public CentralRepository(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public void setBusiness(Business business) {
        this.dataCache.setBusiness(business);
    }

    public BusinessInformation getBusinessInformation() {
        return this.dataCache.getBusiness().getBusinessInformation();
    }

    public Set<HourlyContract> getHourlyContracts() {
        return this.dataCache.getBusiness().getHourlyContracts();
    }
}
