package io.efficientsoftware.simplebookscli.repository;


import io.efficientsoftware.simplebookscli.model.Business;
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

    public Business getBusiness() {
        return this.dataCache.getBusiness();
    }

    public DataCacheRepository(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public void addHourlyContract(HourlyContract hourlyContract) {
        this.dataCache.getBusiness().getHourlyContracts().add(hourlyContract);
        System.out.println("Added hourly contract for: " + hourlyContract.getCustomerName());
    }

    public void setBusiness(Business business) {
        this.dataCache.setBusiness(business);
    }

    public void setOwnerName(String arg) {
        this.dataCache.getBusiness().getBusinessInformation().setOwnerName(arg);
    }

    public HourlyContract getContractByName(String customerName) {
        return this.dataCache.getBusiness()
                .getHourlyContracts().stream()
                .filter(x-> x.getCustomerName().equals(customerName)).findFirst().get();
    }
}
