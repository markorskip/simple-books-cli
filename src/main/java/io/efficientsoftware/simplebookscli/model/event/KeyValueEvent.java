package io.efficientsoftware.simplebookscli.model.event;

import java.util.Objects;

public class KeyValueEvent extends Event {

    private final String key;
    private final String value;

    public KeyValueEvent(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toCSV() {
        return EVENT_TYPE.KEY_VALUE.toString() + "," + key+ "," +
                value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyValueEvent that = (KeyValueEvent) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
