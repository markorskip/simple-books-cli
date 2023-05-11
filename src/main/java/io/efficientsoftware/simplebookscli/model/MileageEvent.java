package io.efficientsoftware.simplebookscli.model;

import io.efficientsoftware.simplebookscli.model.core.DateEvent;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@ToString
@EqualsAndHashCode
public class MileageEvent extends DateEvent {

    private String vehicleName;
    private Double milesDriven;
    private String description;

    public MileageEvent(String date, String vehicleName, String milesDriven, String description) {
        super(date);
        this.eventType = EVENT_TYPE.MILEAEGE;
        this.vehicleName = vehicleName;
        this.milesDriven = parseDouble(milesDriven);
        this.description = description;
    }

    @Override
    public String toLine() {
        return EVENT_TYPE.MILEAEGE.toString() + "," + date + "," +
                vehicleName + "," + milesDriven.toString() + "," + description;
    }
}
