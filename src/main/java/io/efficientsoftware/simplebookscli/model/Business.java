package io.efficientsoftware.simplebookscli.model;

import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

import lombok.*;

import javax.swing.text.html.Option;

@Getter
public class Business {

	public Business(String name) {
		this.name = name;
	}

	private String name;
	private Set<Project> projects = new HashSet<>();
	//	private Set<MoneyTrackingEntry> moneyTrackingEntries = new HashSet<>();

	public Optional<Project> getProjectByName(String name) {
		return this.projects.stream().filter(x->x.getName().toLowerCase().equals(name)).findFirst();
	}

	public void deleteAProject(String projectName) {
		Optional<Project> optionalProject = getProjectByName(projectName);
		if (optionalProject.isEmpty()) {
			throw new IllegalArgumentException("Project does not exist by that name");
		}

		if (optionalProject.isPresent()) {
			Project project = optionalProject.get();
			if (project.getTimeTrackingLog().size() > 0) {
				throw new IllegalArgumentException("Unable to delete a project that has time entries.  Delete time entries first");
			}
			// TODO add a check to see if any MoneyTrackingEntries are tied to the project, if so don't allow delete

			this.projects.remove(project);
		}

	}

	public Project addAProject(String projectName, Double hourlyRate) {
		Project project = new Project(projectName, hourlyRate);
		this.projects.add(project);
		return project;
	}


	//private Set<TransactionLogEntry> financialTransactions = new HashSet<>();
	//private Set<Vehicle> vehiclesUsedForBusiness = new HashSet<>();
	//private Set<Note> notes = new HashSet<>();

}
