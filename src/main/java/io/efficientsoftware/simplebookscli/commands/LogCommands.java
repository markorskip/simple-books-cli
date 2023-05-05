package io.efficientsoftware.simplebookscli.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
// all only avialbe if a business is loaded
public class LogCommands {

    @ShellMethod
    public void logTime() {
        // options:
            // show project list - select existing project, new project, or edit/delete a project
                // new entry or edit existing
    }

    @ShellMethod
    public void logMoney() {
        // options: log auto expense, log income, log direct expense, (eventually log home office expense), edit log entry
        // log auto expense -> select vehicle
        // log income -> select project/income source
        // log direct expense -> select expense category, optionally associate with a project
        // eventually log home office expense -> //TODO

        // edit or delete existing transaction
    }

    @ShellMethod
    public void logMiles() {
        // show list of vehicles, plus option to add a new vehicle, plus option to edit or delete a vehicle
            // one vehicle is selected - option to create new entry or edit existing
    }


    // You are unable to delete a vehicle that is tied to any transactions or mileage log without
    // first deleting those items

    // You can rename
}
