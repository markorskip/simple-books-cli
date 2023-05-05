package io.efficientsoftware.simplebookscli.modules.timekeeping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class TimekeepingCommands {

    @Autowired
    private TimekeepingService service;

    @ShellMethod(value = "Create An Hourly Work Contract")
    public void createHourlyContract(String customerName, double hourlyRate) {
        service.createHourlyContract(customerName,hourlyRate);
    }
    
    @ShellMethod(value = "Edit or Delete an Hourly Contract")
    public void editContract(){
        service.editContract();
    }

    @ShellMethod(value = "Log Time To A Specific Hourly Contract")
    public void logTime(int hoursWorked,
                        String description,
                        @ShellOption(defaultValue = ShellOption.NULL) String date,
                        @ShellOption(defaultValue = ShellOption.NULL) String contractName
                        ) { service.logTime(hoursWorked, description, date, contractName); }

    @ShellMethod(value = "Edit or Delete a Time Log Entry")
    public void editTimeLog() { service.editLog(); }

    @ShellMethod(value = "View All Time Keeping Logs For All Contracts")
    public void viewTimeLogs() {
        service.viewTimeLogs();
    }

    @ShellMethod(value = "Generate An Invoice For Time Worked")
    public void generateAnInvoice() { service.generateAnInvoice(); }
}
