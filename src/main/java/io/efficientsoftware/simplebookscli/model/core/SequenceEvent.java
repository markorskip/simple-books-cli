package io.efficientsoftware.simplebookscli.model.core;

import io.efficientsoftware.simplebookscli.model.core.Event;

import java.time.LocalDateTime;

/**
 * A sequence event is something the user changes over time.  We need to record the timestamp so when all
 * the events are replayed, the most current one can be used.  This maintains the rule that events can be replayed
 * in any order.  Also, we need to make things simple for the user, so we don't make them keep track of the sequence.
 * Also, an event CANNOT know about other events, it must be created in isolation.  So it cannot check the last sequence and increment.
 * It just uses a timestamp. Then they can all be compared.
 */
public abstract class SequenceEvent extends Event {

    private LocalDateTime localDateTime;

    public SequenceEvent(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
