package io.efficientsoftware.simplebookscli.modules.timekeeping;

import io.efficientsoftware.simplebookscli.modules.timekeeping.model.HourlyContract;
import io.efficientsoftware.simplebookscli.modules.timekeeping.model.TimekeepingLogEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TimekeepingService {

    @Autowired
    private ComponentFlow.Builder componentFlowBuilder;

    @Autowired
    private TimekeepingRepository repo;

    public HourlyContract createHourlyContract2() {
        ComponentFlow flow = createHourlyContractFlow();
        HourlyContract hourlyContract = HourlyContract.buildFromResult(flow.run());
        this.repo.addHourlyContract(hourlyContract);
        return hourlyContract;
    }

    public void createHourlyContract(String customerName, double hourlyRate) {
        HourlyContract contract = new HourlyContract();
        contract.setContractName(customerName);
        contract.setHourlyRate(hourlyRate);
        this.repo.addHourlyContract(contract);
    }

    private ComponentFlow createHourlyContractFlow() {
        return componentFlowBuilder.clone().reset()
                .withStringInput("customerName")
                .name("Customer Name")
                .and()
                .withStringInput("hourlyRate")
                .name("HourlyRate")
                .and().build();
    }


    public void editContract() {

    }

    public void viewTimeLogs() {
        for (HourlyContract hourlyContract : this.repo.getAllContracts()) {
            hourlyContract.display();
        }
    }

    private ComponentFlow createTimekeepingLogEntryFlow() {
        return componentFlowBuilder.clone().reset()
                .withStringInput("date")
                .name("Date")
                .defaultValue(Date.from(Instant.now()).toString())
                .and()
                .withStringInput("hourlyRate")
                .name("HourlyRate")
                .and().build();
    }

    public HourlyContract selectHourlyContract() {
        ComponentFlow flow = selectHourlyContractFlow();
        ComponentFlow.ComponentFlowResult result = flow.run();
        String contractName = result.getContext().get("selected");
        HourlyContract hourlyContract = this.repo.getContractByName(contractName);
        System.out.println("Selected contract:" + hourlyContract.getContractName());
        return hourlyContract;
    }

    public void editLog() {
    }

    public void generateAnInvoice() {
    }

    private ComponentFlow selectHourlyContractFlow() {
        Map<String, String> items = new HashMap<>();

        for (HourlyContract hourlyContract : this.repo.getAllContracts()) {
            items.put(hourlyContract.getContractName(), hourlyContract.getContractName());
        }

        ComponentFlow flow = componentFlowBuilder.clone().reset()
                .withSingleItemSelector("selected")
                .name("Hourly Contracts")
                .selectItems(items)
                .and()
                .build();
        return flow;
    }

    public void logTime(int hoursWorked, String description, String date , String contractName) {
        HourlyContract hourlyContract = this.repo.getContractByName(contractName);
        TimekeepingLogEntry entry = TimekeepingLogEntry.builder()
                .hours(hoursWorked)
                .date(date != null ? LocalDate.parse(date) : LocalDate.now())
                .descriptionOfWork(description)
                .build();
        hourlyContract.timeKeepingLog.add(entry);
        System.out.println("Entry added to contract:" + contractName);
    }
}
