package io.efficientsoftware.simplebookscli.commands;

import io.efficientsoftware.simplebookscli.flowcomponents.HourlyContractFlowBuilder;
import io.efficientsoftware.simplebookscli.model.HourlyContract;
import io.efficientsoftware.simplebookscli.model.TimekeepingLogEntry;
import io.efficientsoftware.simplebookscli.repository.DataCache;
import io.efficientsoftware.simplebookscli.repository.DataCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.time.Instant;
import java.util.Date;

@ShellComponent
public class HourlyContractCommands {

    @Autowired
    private DataCacheRepository repo;

    @Autowired
    private DataCache dataCache;

    @Autowired
    private HourlyContractFlowBuilder hourlyContractFlowBuilder;

    @ShellMethod(value = "Create an hourly work contract")
    public void createHourlyContract() {
        ComponentFlow flow = hourlyContractFlowBuilder.createHourlyContractFlow();
        HourlyContract hourlyContract = HourlyContract.buildFromResult(flow.run());
        this.repo.addHourlyContract(hourlyContract);
    }



    @ShellMethod
    public void logTime(String arg) {
        ComponentFlow flow = hourlyContractFlowBuilder.selectHourlyContractFlow();

        ComponentFlow.ComponentFlowResult result = flow.run();
        String contractName = result.getContext().get("selected");
        HourlyContract hourlyContract = this.repo.getContractByName(contractName);


        TimekeepingLogEntry logEntry = new TimekeepingLogEntry();
        logEntry.setDate(Date.from(Instant.now()));
        logEntry.setHours(8);
        logEntry.setDescriptionOfWork(arg);

        hourlyContract.getTimeKeepingLog().add(logEntry);
    }

    @ShellMethod
    public void viewTimeKeepingLogs() {
        for (HourlyContract hourlyContract : this.dataCache.getBusiness().getHourlyContracts()) {
            System.out.println(hourlyContract.getCustomerName());
        }
    }
}
