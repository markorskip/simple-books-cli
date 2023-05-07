package io.efficientsoftware.simplebookscli.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MileageRecord {
    private LocalDate date;
    private Double milesDriven;
    private String description;

}
