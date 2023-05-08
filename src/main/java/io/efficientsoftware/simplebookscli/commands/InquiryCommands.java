package io.efficientsoftware.simplebookscli.commands;

import io.efficientsoftware.simplebookscli.DataCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class InquiryCommands {

    @Autowired
    private DataCache dateCache;

    @ShellMethod
    public void viewTimeLogs() {
        this.dateCache.business.getTimeRecords().forEach(System.out::println);
    }

    @ShellMethod
    public void view() {
        this.dateCache.business.displaySummary();
    }

    //@ShellMethod
    public void generateMoneyReport() {

    }

    //@ShellMethod
    public void generateAutoReport() {

    }


}
