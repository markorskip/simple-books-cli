package io.efficientsoftware.simplebookscli.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import io.efficientsoftware.simplebookscli.repository.DataCache;

@ShellComponent
public class ViewBusinessCommands {
	
	@Autowired
	public DataCache dataCache;
	
	@ShellMethod(key = "view", value="View data about your business.")
	public String viewBusiness(@ShellOption(defaultValue = "business") String arg) {
		return dataCache.getBusiness().display(arg);
	}

}