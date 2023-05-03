package io.efficientsoftware.simplebookscli.repository;


import io.efficientsoftware.simplebookscli.model.HourlyContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handles all read and write operations to the DataCache
 */
@Component
public class DataCacheRepository {

    @Autowired
    private DataCache dataCache;

    public DataCacheRepository(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public void addHourlyContract(HourlyContract hourlyContract) {
        this.dataCache.getBusiness().getHourlyContracts().add(hourlyContract);
        System.out.println("Added hourly contract for: " + hourlyContract.getCustomerName());
    }
}
