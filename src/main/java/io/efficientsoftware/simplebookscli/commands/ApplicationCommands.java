package io.efficientsoftware.simplebookscli.commands;

import io.efficientsoftware.simplebookscli.model.Business;
import io.efficientsoftware.simplebookscli.repository.CentralRepository;
import io.efficientsoftware.simplebookscli.service.JacksonPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.IOException;

@ShellComponent
public class ApplicationCommands {


    @Autowired
    private JacksonPersistenceService jacksonPersistenceService;

    @Autowired
    private CentralRepository centralRepository;

    @Autowired
    private ComponentFlow.Builder componentFlowBuilder;

    @ShellMethod("Save changes")
    public void save(
            @ShellOption(defaultValue = ShellOption.NULL) String arg) throws IOException {
        if (arg == null) {
            arg = centralRepository.getFileName();
        } else {
            // if saving elsewhere
            this.centralRepository.setFileName(arg);
        }
        jacksonPersistenceService.save(arg);
    }

    @ShellMethod("Load business from file")
    public void load(
            @ShellOption(defaultValue = ShellOption.NULL) String arg
    ) throws Exception {
        if (arg == null) {arg = centralRepository.getFileName();}
        else { this.centralRepository.setFileName(arg); }
        jacksonPersistenceService.load(arg);
    }

    @ShellMethod
    public void createNewBusiness() {
        String FILE_PATH = "filePath";
        String NAME = "name";
        ComponentFlow flow = componentFlowBuilder.clone().reset()
                .withStringInput(NAME)
                .name("Business Name")
                .and()
                .withPathInput(FILE_PATH)
                .name("File To Save to")
                .and().build();

        ComponentFlow.ComponentFlowResult flowResult = flow.run();
        Business newBusiness = new Business(flowResult.getContext().get(NAME));

        this.centralRepository.setBusiness(newBusiness, flowResult.getContext().get(FILE_PATH));
    }


    //@ShellMethod
    public void discardChanges() {
        //TODO availability only when changes have been made
    }

    @ShellMethod
    public void view() {
        this.centralRepository.view();
    }

 }
