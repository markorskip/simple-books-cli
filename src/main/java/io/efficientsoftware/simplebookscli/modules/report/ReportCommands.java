package io.efficientsoftware.simplebookscli.modules.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import io.efficientsoftware.simplebookscli.repository.DataCache;

@ShellComponent
public class ReportCommands {
	
	@Autowired
	public DataCache dataCache;
	
	@ShellMethod(value="View data about your business.")
	public String report(@ShellOption(defaultValue = "business") String arg) {
		return dataCache.getBusiness().display(arg);
	}

}