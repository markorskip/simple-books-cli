package io.efficientsoftware.simplebookscli.model;

import lombok.Data;

import java.util.*;

@Data
public class Vehicle {

	private String name;
	private Map<Date, Double> odometerReadings = new HashMap<>();
	private Set<MileageRecord> mileageLog = new HashSet<>();

}
