package io.efficientsoftware.simplebookscli.model;

import io.efficientsoftware.simplebookscli.model.core.DateEvent;
import io.efficientsoftware.simplebookscli.model.core.SequenceEvent;

import java.time.LocalDateTime;

public class UpdateBusinessInfoEvent extends SequenceEvent {

    private String businessName;
    private int sequence;

    public UpdateBusinessInfoEvent(LocalDateTime localDateTime, String businessName) {
        super(localDateTime);
        this.businessName = businessName;
    }
}
