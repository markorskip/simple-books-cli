package io.efficientsoftware.simplebookscli.init;


import io.efficientsoftware.simplebookscli.persistence.PersistenceService;
import io.efficientsoftware.simplebookscli.report.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;
import java.net.URISyntaxException;

@ShellComponent
public class InitCommands {

    @Autowired
    private ComponentFlow.Builder componentFlowBuilder;

    @Autowired
    private PersistenceService persistenceService;

    @Autowired
    private InquiryService inquiryService;

    @ShellMethod(value = "Load Your SimpleBooksCLI Database")
    public void load(String path) throws IOException, URISyntaxException {
        if (path == null) {
            ComponentFlow flow = componentFlowBuilder.clone().reset()
                    .withPathInput("path")
                    .name("path")
                    .and()
                    .build();

            path = flow.run().getContext().get("path").toString();
        }
        System.out.println("Path Selected: " + path);
        persistenceService.load(path);
        System.out.println("******Load Complete: Here is the summary of your business*****");
       // inquiryService.displaySummary();
    }
}
