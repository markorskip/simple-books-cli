package io.efficientsoftware.simplebookscli.model;

import io.efficientsoftware.simplebookscli.model.core.DateEvent;
import io.efficientsoftware.simplebookscli.model.core.Event;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
public class OdometerEvent extends DateEvent {

    private String vehicleName;
    private double mileageReading;
    private boolean estimate = false;

    // If an odometer event has a date in the future, set estimate to true
    public OdometerEvent(String date, String mileageReading, String vehicleName) {
        super(date);
        boolean estimate = false;
        this.mileageReading = parseDouble(mileageReading);
        this.vehicleName = vehicleName;
        this.estimate = estimate;
        if (parseDate(date).isAfter(LocalDate.now())) estimate = true;
    }

    /**
     * Records mileage, mainly at the beginning and end of the year to determine
     * business use of a vehicle.
     * @param date
     * @param mileageReading
     * @param vehicleName
     * @parm estimate - sometimes estimates are recorded in the future
     */
    public OdometerEvent(String date, String vehicleName, String mileageReading, boolean estimate) {
        super(date);
        this.mileageReading = parseDouble(mileageReading);
        this.vehicleName = vehicleName;
        this.estimate = estimate;
    }

    @Override
    public String toCSV() {
        return null;
    }

}
