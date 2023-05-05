package io.efficientsoftware.simplebookscli.commands;

import io.efficientsoftware.simplebookscli.service.JacksonPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.IOException;

@ShellComponent
public class ApplicationCommands {


    @Autowired
    private JacksonPersistenceService jacksonPersistenceService;

    private final String defaultFileName = "data.txt";

    @ShellMethod(key = "save", value = "Save all changes to file")
    public void saveAs(
            @ShellOption(defaultValue = defaultFileName) String arg
    ) throws IOException {
        jacksonPersistenceService.save(arg);
    }

    @ShellMethod(key = "load", value = "Load business from file")
    public void load(
            @ShellOption(defaultValue = defaultFileName) String arg
    ) throws Exception {
        jacksonPersistenceService.load(arg);
    }

    @ShellMethod
    public void createNewBusiness() {
        // Todo availability when nothing is loaded
    }

    @ShellMethod
    public void save() {
        //TODO availability only when changes have been made
    }

    @ShellMethod
    public void discardChanges() {
        //TODO availability only when changes have been made
    }




 }
