package io.efficientsoftware.simplebookscli.flowcomponents;

import io.efficientsoftware.simplebookscli.model.HourlyContract;
import io.efficientsoftware.simplebookscli.repository.DataCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

@Component
public class HourlyContractFlowBuilder {

    @Autowired
    private ComponentFlow.Builder componentFlowBuilder;

    @Autowired
    private DataCache dataCache;

    public ComponentFlow createHourlyContractFlow() {
        return componentFlowBuilder.clone().reset()
                .withStringInput("customerName")
                .name("Customer Name")
                .and()
                .withStringInput("hourlyRate")
                .name("HourlyRate")
                .and().build();
    }

    public ComponentFlow selectHourlyContractFlow() {
        Map<String, String> items = new HashMap<>();

        for (HourlyContract hourlyContract : this.dataCache.getBusiness().getHourlyContracts()) {
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
