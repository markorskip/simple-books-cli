package io.efficientsoftware.simplebookscli.commands;

import io.efficientsoftware.simplebookscli.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class InquiryCommands {

    @Autowired
    private InquiryService inquiryService;

    @ShellMethod("View all time logs.")
    public void viewTimeLogs() {
        this.inquiryService.displayTimeLogs();
    }

    @ShellMethod("View a summary of the entire business")
    public void view() {
        this.inquiryService.displaySummary();
    }

    //@ShellMethod
    public void generateMoneyReport() {

    }

    //@ShellMethod
    public void generateAutoReport() {

    }

}
