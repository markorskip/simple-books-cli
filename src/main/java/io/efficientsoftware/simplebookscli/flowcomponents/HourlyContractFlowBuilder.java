package io.efficientsoftware.simplebookscli.flowcomponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.stereotype.Component;

@Component
public class HourlyContractFlowBuilder {

    @Autowired
    private ComponentFlow.Builder componentFlowBuilder;

    public ComponentFlow createHourlyContractFlow() {
        return componentFlowBuilder.clone().reset()
                .withStringInput("customerName")
                .name("Customer Name")
                .and()
                .withStringInput("hourlyRate")
                .name("HourlyRate")
                .and().build();
    }
}
