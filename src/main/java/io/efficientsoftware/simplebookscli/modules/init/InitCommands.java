package io.efficientsoftware.simplebookscli.modules.init;


import io.efficientsoftware.simplebookscli.persistence.CentralRepository;
import io.efficientsoftware.simplebookscli.persistence.PersistenceService;
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
    private InitService initService;

    @ShellMethod(value = "Load Your SimpleBooksCLI Database")
    public void load(String path) {
        if (path == null) {
            ComponentFlow flow = componentFlowBuilder.clone().reset()
                    .withPathInput("path")
                    .name("path")
                    .and()
                    .build();

            path = flow.run().getContext().get("path").toString();
        }
        initService.load(path);
    }
}
