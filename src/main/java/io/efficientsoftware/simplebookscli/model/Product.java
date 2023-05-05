package io.efficientsoftware.simplebookscli.model;

import java.util.List;

import lombok.Data;

@Data
public class Product {
	
	private String name;
	private String description;
	private boolean isActive;
	private List<String> monetizationStrategies;

}
