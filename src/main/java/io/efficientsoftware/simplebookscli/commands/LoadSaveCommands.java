package io.efficientsoftware.simplebookscli.commands;

import io.efficientsoftware.simplebookscli.model.Business;
import io.efficientsoftware.simplebookscli.repository.DataCache;
import io.efficientsoftware.simplebookscli.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.*;

@ShellComponent
public class LoadSaveCommands {

    @Autowired
    private PersistenceService persistenceService;

    private final String defaultFileName = "data.txt";

    @ShellMethod(key = "save", value = "Save all changes to file")
    public void saveChanges(
            @ShellOption(defaultValue = defaultFileName) String arg
    ) throws IOException {
        persistenceService.save(arg);
    }

    @ShellMethod(key = "load", value = "Load business from file")
    public void load(
            @ShellOption(defaultValue = defaultFileName) String arg
    ) throws IOException, ClassNotFoundException {
        persistenceService.load(arg);
    }
}
