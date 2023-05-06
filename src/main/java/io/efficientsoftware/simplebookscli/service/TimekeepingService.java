package io.efficientsoftware.simplebookscli.service;

import io.efficientsoftware.simplebookscli.repository.TimekeepingRepository;
import io.efficientsoftware.simplebookscli.model.Project;
import io.efficientsoftware.simplebookscli.model.TimekeepingLogEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class TimekeepingService {

    @Autowired
    private ComponentFlow.Builder componentFlowBuilder;

    @Autowired
    private TimekeepingRepository repo;

    private ComponentFlow createProjectFlow() {
        return componentFlowBuilder.clone().reset()
                .withStringInput("name")
                .name("Project Name")
                .and()
                .withStringInput("hourlyRate")
                .name("Hourly Rate")
                .and().build();
    }

    public Project selectProject() {
        Project result;
        ComponentFlow selectProjectFlow = selectProjectFlow();
        ComponentFlow.ComponentFlowResult selectProjectFlowResult = selectProjectFlow.run();
        String selected = selectProjectFlowResult.getContext().get("selected");

        if (Objects.equals(selected, NEW_PROJECT)) {
            ComponentFlow createProjectFlow = createProjectFlow();
            ComponentFlow.ComponentFlowResult createProjectFlowResult = createProjectFlow.run();
            result = Project.buildFromResult(createProjectFlowResult);
            this.repo.addHourlyContract(result);
        } else {
            result = this.repo.getProjectByName(selected);
        }

        System.out.println("Selected contract:" + result.getName());
        return result;
    }

    private static final String NEW_PROJECT = "NEW PROJECT";

    private ComponentFlow selectProjectFlow() {
        Map<String, String> items = new HashMap<>();

        for (Project project : this.repo.getAllContracts()) {
            items.put(project.getName(), project.getName());
        }
        items.put(NEW_PROJECT,NEW_PROJECT);

        ComponentFlow flow = componentFlowBuilder.clone().reset()
                .withSingleItemSelector("selected")
                .name("Hourly Contracts")
                .selectItems(items)
                .and()
                .build();
        return flow;
    }

    public void logTime(int hoursWorked, String description, String date , String contractName) {
        Project project = this.repo.getProjectByName(contractName);
        TimekeepingLogEntry entry = TimekeepingLogEntry.builder()
                .hours(hoursWorked)
                .date(date != null ? LocalDate.parse(date) : LocalDate.now())
                .descriptionOfWork(description)
                .build();
        project.timeKeepingLog.add(entry);
        System.out.println("Entry added to contract:" + contractName);
    }
}
