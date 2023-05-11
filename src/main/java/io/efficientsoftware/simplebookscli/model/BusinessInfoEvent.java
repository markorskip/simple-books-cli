package io.efficientsoftware.simplebookscli.model;

import io.efficientsoftware.simplebookscli.model.core.SequenceEvent;
import lombok.ToString;

import java.time.LocalDateTime;

public class BusinessInfoEvent extends SequenceEvent {

    private String businessName;

    public BusinessInfoEvent(LocalDateTime localDateTime, String businessName) {
        super(localDateTime);
        this.businessName = businessName;
    }

    public BusinessInfoEvent(String businessName) {
        super(LocalDateTime.now());
        this.businessName = businessName;
        displayAdded();
    }

    public String getBusinessName() {
        return businessName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BusinessInfoEvent{");
        sb.append("businessName='").append(businessName).append('\'');
        sb.append(", localDateTime=").append(localDateTime);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public String toLine() {
        return null;
    }
}
