package io.efficientsoftware.simplebookscli.commands;

import io.efficientsoftware.simplebookscli.flowcomponents.HourlyContractFlowBuilder;
import io.efficientsoftware.simplebookscli.model.HourlyContract;
import io.efficientsoftware.simplebookscli.repository.DataCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class HourlyContractCommands {

    @Autowired
    private DataCacheRepository repo;

    @Autowired
    private HourlyContractFlowBuilder hourlyContractFlowBuilder;

    @ShellMethod(value = "Create an hourly work contract")
    public void createHourlyContract() {
        ComponentFlow flow = hourlyContractFlowBuilder.createHourlyContractFlow();
        HourlyContract hourlyContract = HourlyContract.buildFromResult(flow.run());
        this.repo.addHourlyContract(hourlyContract);
    }

//    @ShellMethod
//    public String logTime() {
//        // Select a work contract
//        Map<String, String> single1SelectItems = new HashMap<>();
//
//        for (HourlyContract hourlyContract : this.dataCache.getBusiness().getContracts()) {
//            single1SelectItems.put(hourlyContract.getCustomerName(), hourlyContract.getCustomerName());
//            single1SelectItems.put(hourlyContract.getCustomerName(), hourlyContract.getCustomerName());
//        }
//
//        ComponentFlow flow = componentFlowBuilder.clone().reset()
//                .withSingleItemSelector("single1")
//                .name("Single1")
//                .selectItems(single1SelectItems)
//                .and()
//                .build();
//        flow.run();
//
//
//
//        TimeKeepingLog log =
//                this.dataCache.getBusiness().getContracts().stream().findFirst().get().getTimeKeepingLog();
//        // Log Time
//
//        TimekeepingLogEntry logEntry = new TimekeepingLogEntry();
//        logEntry.setDate(Date.from(Instant.now()));
//        logEntry.setHours(8);
//        logEntry.setDescriptionOfWork("Test Logging");
//
//        log.getLog().add(logEntry);
//
//        return "Time Logged";
//    }

}
