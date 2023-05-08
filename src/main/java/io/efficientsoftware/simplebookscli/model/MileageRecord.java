package io.efficientsoftware.simplebookscli.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;


@ToString
@EqualsAndHashCode
public class MileageRecord extends BaseRecord {

    private String vehicleName;
    private Double milesDriven;
    private String description;

    public MileageRecord(String date, String vehicleName,  String milesDriven, String description) {
        super(date);
        this.vehicleName = vehicleName;
        this.milesDriven = parseDouble(milesDriven);
        this.description = description;
    }
}
