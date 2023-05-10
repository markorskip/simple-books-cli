package io.efficientsoftware.simplebookscli.model;

import io.efficientsoftware.simplebookscli.model.core.DateEvent;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class OdometerEvent extends DateEvent {

    private String vehicleName;
    private double mileageReading;

    /**
     * Records mileage, mainly at the beginning and end of the year to determine
     * business use of a vehicle.
     * @param date
     * @param mileageReading
     * @param vehicleName
     */
    public OdometerEvent(String date, String mileageReading, String vehicleName) {
        super(date);
        this.mileageReading = parseDouble(mileageReading);
        this.vehicleName = vehicleName;
    }
}
