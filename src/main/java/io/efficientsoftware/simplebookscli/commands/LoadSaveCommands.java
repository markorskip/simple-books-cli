package io.efficientsoftware.simplebookscli.commands;

import io.efficientsoftware.simplebookscli.persistence.GsonPersistenceService;
import io.efficientsoftware.simplebookscli.persistence.JacksonPersistenceService;
import io.efficientsoftware.simplebookscli.persistence.PersistenceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.*;

@ShellComponent
public class LoadSaveCommands {

    @Autowired
    private JacksonPersistenceService gsonPersistenceService;

    private final String defaultFileName = "data.txt";

    @ShellMethod(key = "save", value = "Save all changes to file")
    public void saveChanges(
            @ShellOption(defaultValue = defaultFileName) String arg
    ) throws IOException {
        gsonPersistenceService.save(arg);
    }

    @ShellMethod(key = "load", value = "Load business from file")
    public void load(
            @ShellOption(defaultValue = defaultFileName) String arg
    ) throws Exception {
        gsonPersistenceService.load(arg);
    }
}
