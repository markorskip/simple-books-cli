package io.efficientsoftware.simplebookscli.commands;

import io.efficientsoftware.simplebookscli.model.Project;
import io.efficientsoftware.simplebookscli.model.TimeRecord;
import io.efficientsoftware.simplebookscli.repository.TimekeepingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.component.context.ComponentContext;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.time.LocalDate;
import java.util.*;

@ShellComponent("Log")
// TODO all only available if a business is loaded
public class LogTimeCommands {

    @Autowired
    private TimekeepingRepository repo;

    @Autowired
    private ComponentFlow.Builder componentFlowBuilder;

    public enum ACTIONS {NEW, EDIT, DELETE_ENTRY, DELETE_PROJECT }

    @ShellMethod("Log Time Worked To A Specific Project")
    public void logTime() {
        // show project list - select existing project, new project
        Project project = selectProject(); // select existing or create new
        // Open the project, allow adding entry, edit/deleting entries. If no entries exist, allow deleting the project
        ACTIONS action = selectAction(project);

        switch(action) {
            case NEW -> {
                TimeRecord logEntry = createTimeKeepingLogEntry();
                project.getTimeTrackingLog().add(logEntry);
                System.out.println(logEntry);
                System.out.println("Added new log entry to project: " + project.getName());
            }
            case EDIT -> {
                // select a log entry
                System.out.println("Edit a log entry TODO");
                // fill out a flow with the values as the default
                // add to project
            }

            case DELETE_ENTRY -> {
                //select a log entry

                // confirm deletion

                // delete
                System.out.println("Delete a log entry TODO");
            }

            case DELETE_PROJECT -> {
                Boolean confirm =
                        componentFlowBuilder.clone().reset().withConfirmationInput("confirm").and().build().run().getContext().get("confirm", Boolean.class);
                if (confirm) {
                    this.repo.deleteProject(project);
                    System.out.println("Deleted project: " + project.getName());
                }
            }
        }
    }

    @ShellMethod("View All Projects and the Time Worked on Them")
    public void viewProjects() {
        for (Project project: this.repo.getProjects()) {
            project.display();
        }
    }

    private ACTIONS selectAction(Project project) {
        LinkedHashMap<String, String> availableActions =
                new LinkedHashMap<>();

        // Always able to add new actions
        availableActions.put(ACTIONS.NEW.toString(), ACTIONS.NEW.toString());

        if (project.getTimeTrackingLog().size() > 0) {
            availableActions.put(ACTIONS.EDIT.toString(), ACTIONS.EDIT.toString());
            availableActions.put(ACTIONS.DELETE_ENTRY.toString(), ACTIONS.DELETE_ENTRY.toString());
        }

        // You can only delete a project if there are no more time logs associated with it
        if (project.getTimeTrackingLog().isEmpty()) {
            // TODO also check there are no incomes associated with it
            availableActions.put(ACTIONS.DELETE_PROJECT.toString(),
                    ACTIONS.DELETE_PROJECT.toString());
        }

        String selected = componentFlowBuilder.clone().reset()
                .withSingleItemSelector("selected")
                .name("Available Actions")
                .selectItems(availableActions)
                .and()
                .build().run().getContext()
                .get("selected");

        ACTIONS result = ACTIONS.valueOf(selected);
        System.out.println("Selected action: " + result);
        return result;
    }

    private static final String NEW_PROJECT = "NEW PROJECT";

    public Project selectProject() {
        Project result;
        String selected = selectProjectFlow();

        if (Objects.equals(selected, NEW_PROJECT)) {
            result = createProject();
            this.repo.addHourlyContract(result);
        } else {
            result = this.repo.getProjectByName(selected);
        }

        System.out.println("Selected contract:" + result.getName());
        return result;
    }

    private String selectProjectFlow() {
        Map<String, String> items = new LinkedHashMap<>();

        for (Project project : this.repo.getProjects()) {
            items.put(project.getName(), project.getName());
        }
        items.put(NEW_PROJECT,NEW_PROJECT);

        ComponentFlow flow = componentFlowBuilder.clone().reset()
                .withSingleItemSelector("selected")
                .name("Hourly Contracts")
                .selectItems(items)
                .and()
                .build();
        return flow.run().getContext().get("selected");
    }

    public TimeRecord createTimeKeepingLogEntry() {
        ComponentContext<?> ctx =
                componentFlowBuilder.clone().reset()
                        .withStringInput("date")
                        .name("Date")
                        .defaultValue(LocalDate.now().toString())
                        .and()
                        .withStringInput("hoursWorked")
                        .name("Hours Worked")
                        .defaultValue("0")
                        .and()
                        .withStringInput("desc")
                        .name("Description")
                        .defaultValue("")
                        .and()
                        .build().run().getContext();

        TimeRecord entry = TimeRecord.buildFromContext(ctx);

        return entry;
    }

    private String get(String key, ComponentContext<?> ctx) {
        try {
            return ctx.get(key);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public Project createProject() {
        ComponentContext<?> ctx =
                componentFlowBuilder.clone().reset()
                        .withStringInput("name")
                        .name("Name")
                        .and()
                        .withStringInput("rate")
                        .name("Hourly Pay Rate")
                        .and()
                        .build().run().getContext();
        Project project = new Project(ctx.get("name"),ctx.get("rate", Double.class));

        return project;
    }


}
