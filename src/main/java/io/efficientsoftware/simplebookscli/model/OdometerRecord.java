package io.efficientsoftware.simplebookscli.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.br.TituloEleitoral;

@EqualsAndHashCode
@ToString
public class OdometerRecord extends BaseRecord {

    private double mileageReading;
    private String vehicleName;

    /**
     * Records mileage, mainly at the beginning and end of the year to determine
     * business use of a vehicle.
     * @param date
     * @param mileageReading
     * @param vehicleName
     */
    public OdometerRecord(String date, String mileageReading, String vehicleName) {
        super(date);
        this.mileageReading = parseDouble(mileageReading);
        this.vehicleName = vehicleName;
    }
}
