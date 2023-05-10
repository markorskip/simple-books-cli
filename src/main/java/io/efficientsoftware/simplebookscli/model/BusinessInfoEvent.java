package io.efficientsoftware.simplebookscli.model;

import io.efficientsoftware.simplebookscli.model.core.SequenceEvent;

import java.time.LocalDateTime;

public class BusinessInfoEvent extends SequenceEvent {

    private String businessName;
    private int sequence;

    public BusinessInfoEvent(LocalDateTime localDateTime, String businessName) {
        super(localDateTime);
        this.businessName = businessName;
    }

    public String getBusinessName() {
        return businessName;
    }
}
