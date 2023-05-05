package io.efficientsoftware.simplebookscli.modules.timekeeping;


import io.efficientsoftware.simplebookscli.modules.timekeeping.model.HourlyContract;
import io.efficientsoftware.simplebookscli.repository.CentralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimekeepingRepository {

    @Autowired
    private CentralRepository centralRepository;

    public TimekeepingRepository(CentralRepository centralRepository) {
        this.centralRepository = centralRepository;
    }

    public void addHourlyContract(HourlyContract hourlyContract) {
        this.centralRepository.getHourlyContracts().add(hourlyContract);
    }

    public HourlyContract getContractByName(String contractName) {
        if (contractName == null) {
            return this.centralRepository.getHourlyContracts().stream().findFirst().get();
        }
        return this.centralRepository
                .getHourlyContracts().stream()
                .filter(x-> x.getContractName().toLowerCase().equals(contractName.toLowerCase())).findFirst().get();
    }

    public java.util.Collection<HourlyContract> getAllContracts() {
        return this.centralRepository.getHourlyContracts();
    }
}
