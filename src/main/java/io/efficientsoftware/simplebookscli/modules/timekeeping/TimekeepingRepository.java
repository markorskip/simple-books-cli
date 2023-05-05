package io.efficientsoftware.simplebookscli.modules.timekeeping;


import io.efficientsoftware.simplebookscli.modules.timekeeping.model.HourlyContract;
import io.efficientsoftware.simplebookscli.repository.CentralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimekeepingRepository {

    @Autowired
    private CentralRepository centralRepository;

    public void addHourlyContract(HourlyContract hourlyContract) {
        this.centralRepository.getHourlyContracts().add(hourlyContract);
    }

    public HourlyContract getContractByName(String customerName) {
        return this.centralRepository
                .getHourlyContracts().stream()
                .filter(x-> x.getCustomerName().equals(customerName)).findFirst().get();
    }

    public java.util.Collection<HourlyContract> getAllContracts() {
        return this.centralRepository.getHourlyContracts();
    }
}
