package io.efficientsoftware.simplebookscli.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;


@ToString
@Getter
public class MileageEvent extends DateEvent {

    public enum MileageType { BUSINESS, PERSONAL, CHARITABLE }

    private String vehicleName;
    private Double milesDriven;
    private String description;
    private MileageType mileageType;

    public MileageEvent(String date, String vehicleName, String milesDriven, String description) {
        super(date);
        this.vehicleName = vehicleName;
        this.milesDriven = parseDouble(milesDriven);
        this.description = description;
        this.eventType = EVENT_TYPE.MILEAGE;
        this.mileageType= MileageType.BUSINESS;
        // TODO create constructor later
    }

    public MileageEvent(String[] csv) {
        this(csv[1],csv[2],csv[3],csv[4]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MileageEvent that)) return false;
        if (!super.equals(o)) return false;

        if (!Objects.equals(vehicleName, that.vehicleName)) return false;
        if (!Objects.equals(milesDriven, that.milesDriven)) return false;
        if (!Objects.equals(description, that.description)) return false;
        return mileageType == that.mileageType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (vehicleName != null ? vehicleName.hashCode() : 0);
        result = 31 * result + (milesDriven != null ? milesDriven.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (mileageType != null ? mileageType.hashCode() : 0);
        return result;
    }

    @Override
    public String toCSV() {
        return EVENT_TYPE.MILEAGE.toString() + "," + dateToString(date) + "," +
                vehicleName + "," + milesDriven.toString() + "," + description;
    }

}
