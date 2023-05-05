package io.efficientsoftware.simplebookscli.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MileageLogEntry {
    private LocalDate date;
    private Double milesDriven;
    private String description;

}
