package io.efficientsoftware.simplebookscli.model;

import java.util.Set;
import java.util.HashSet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class Business {

	public Business() {
	}

	public Business(String name) {
		this.name = name;
	}

	private String name;
	private Set<Project> projects = new HashSet<>();

	//private Set<TransactionLogEntry> financialTransactions = new HashSet<>();
	//private Set<Vehicle> vehiclesUsedForBusiness = new HashSet<>();
	//private Set<Note> notes = new HashSet<>();

}
