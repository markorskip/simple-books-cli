package io.efficientsoftware.simplebookscli.modules.timekeeping;

import io.efficientsoftware.simplebookscli.modules.timekeeping.model.HourlyContract;
import io.efficientsoftware.simplebookscli.modules.timekeeping.model.TimekeepingLogEntry;
import io.efficientsoftware.simplebookscli.repository.DataCache;
import io.efficientsoftware.simplebookscli.repository.CentralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TimekeepingService {

    @Autowired
    private TimekeepingFlowBuilder hourlyContractFlowBuilder;

    @Autowired
    private ComponentFlow.Builder componentFlowBuilder;

    @Autowired
    private TimekeepingRepository repo;

    public HourlyContract createHourlyContract() {
        ComponentFlow flow = createHourlyContractFlow();
        HourlyContract hourlyContract = HourlyContract.buildFromResult(flow.run());
        this.repo.addHourlyContract(hourlyContract);
        return hourlyContract;
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

    public void logTime() {
        HourlyContract hourlyContract = selectHourlyContract();
        TimekeepingLogEntry entry = createTimekeepingLogEntry(); // remove arg and build flow
        hourlyContract.getTimeKeepingLog().add(entry);
    }

    public TimekeepingLogEntry createTimekeepingLogEntry() {
        // Flowbuilder
        TimekeepingLogEntry logEntry = new TimekeepingLogEntry();
        logEntry.setDate(Date.from(Instant.now()));
        logEntry.setHours(8);
        logEntry.setDescriptionOfWork("");
        return  logEntry;
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
        return hourlyContract;
    }

    public void editLog() {
    }

    public void generateAnInvoice() {
    }

    private ComponentFlow selectHourlyContractFlow() {
        Map<String, String> items = new HashMap<>();

        for (HourlyContract hourlyContract : this.repo.getAllContracts()) {
            items.put(hourlyContract.getCustomerName(), hourlyContract.getCustomerName());
        }

        ComponentFlow flow = componentFlowBuilder.clone().reset()
                .withSingleItemSelector("selected")
                .name("Hourly Contracts")
                .selectItems(items)
                .and()
                .build();
        return flow;
    }
}
